package oap.application.plugin.psi.impl

import com.intellij.lang.jvm.JvmParameter
import com.intellij.openapi.util.text.Strings
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.findPsiFile
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.*
import oap.application.plugin.psi.IModuleName
import oap.application.plugin.psi.IServiceName
import oap.application.plugin.psi.ModuleUtils
import oap.application.plugin.psi.OapClassValueMixin
import oap.application.plugin.stub.OapModuleNameIndex

class GrammarPsiImplUtil {
    companion object {
        val pattern = Regex("""<modules\.(?<module>[^.]+)\.(?<service>[^>]+)>""")

        @JvmStatic
        fun getReferenceServiceName(ref: OapReferenceModulesValue): String? {
            return pattern.matchEntire(ref.text)?.groups["service"]?.value
        }

        @JvmStatic
        fun getReferenceModuleName(ref: OapReferenceModulesValue): String? {
            return pattern.matchEntire(ref.text)?.groups["module"]?.value
        }

        @JvmStatic
        fun getBooleanValue(ref: OapBoolValue): Boolean {
            return "true" == ref.text
        }

        @JvmStatic
        fun getScalarText(ref: OapBlockScalarValue): String {
            val raw = ref.text
            val folded = raw.isNotEmpty() && raw[0] == '>'
            val chomp = if (raw.length > 1 && (raw[1] == '-' || raw[1] == '+')) raw[1] else ' '

            val bodyStart = raw.indexOf('\n')
            if (bodyStart < 0) return ""

            val rawLines = raw.substring(bodyStart + 1).split("\n")
            // A trailing element from the final split is either an unterminated last line (EOF
            // with no trailing newline) or an artifact of a trailing '\n' - either way it carries
            // no content of its own once chomping is applied below, so drop it here.
            val lines = if (rawLines.isNotEmpty()) rawLines.dropLast(1) else rawLines

            val baseIndent = lines.firstOrNull { it.isNotBlank() }
                ?.let { it.length - it.trimStart(' ', '\t').length } ?: 0
            val stripped = lines.map { if (it.length >= baseIndent) it.substring(baseIndent) else "" }

            val lastNonBlank = stripped.indexOfLast { it.isNotBlank() }
            val effectiveLines = if (chomp == '+') stripped else stripped.take(maxOf(lastNonBlank + 1, 0))

            if (folded) {
                val body = foldLines(effectiveLines)
                return when (chomp) {
                    '-', '+' -> body
                    else -> if (body.isEmpty()) "" else body + "\n"
                }
            }

            // Every captured line - blank or not - was newline-terminated in the source, so
            // reconstructing literal text as "each line + '\n'" (rather than joining with '\n' as
            // a separator) is what keeps chomping exact: clip's single trailing '\n' just falls
            // out of effectiveLines already excluding trailing blanks, strip removes that one
            // trailing '\n', and keep's precise trailing-blank-line count survives untouched.
            val body = effectiveLines.joinToString("") { "$it\n" }
            return when (chomp) {
                '-' -> body.removeSuffix("\n")
                else -> body
            }
        }

        // Full YAML block-folding: consecutive non-blank, base-indented lines join with a single
        // space; a blank line becomes a '\n' (paragraph break); a "more-indented" line (one that
        // still has leading whitespace after the base indent was stripped) is kept literal - never
        // folded into a neighboring line - matching strict YAML block-scalar folding rules.
        private fun foldLines(lines: List<String>): String {
            val sb = StringBuilder()
            var previousWasMoreIndented = false
            var previousWasBlank = true
            for (line in lines) {
                val moreIndented = line.isNotEmpty() && (line[0] == ' ' || line[0] == '\t')
                if (line.isBlank()) {
                    sb.append('\n')
                    previousWasBlank = true
                    continue
                }
                if (sb.isNotEmpty() && !previousWasBlank) {
                    sb.append(if (moreIndented || previousWasMoreIndented) '\n' else ' ')
                }
                sb.append(line)
                previousWasMoreIndented = moreIndented
                previousWasBlank = false
            }
            return sb.toString()
        }

        @JvmStatic
        fun getServices(m: OapModuleServices): List<OapModuleServicesService> {
            val includes: Collection<OapModuleInclude> = PsiTreeUtil.findChildrenOfType(m.containingFile, OapModuleInclude::class.java)

            val iServices: List<OapModuleServicesService> =
                includes.flatMap { i -> i.reference?.resolve()?.let { r -> PsiTreeUtil.findChildOfType(r.containingFile, OapModuleServices::class.java)?.services ?: emptyList() } ?: emptyList() }

            return m.moduleServicesServiceList + iServices
        }

        @JvmStatic
        fun getReferences(m: IModuleName): Array<PsiReference> {
            if ("this".equals(m.text)) {
                val oapModuleName: OapModuleNamePair? = PsiTreeUtil.findChildOfType(m.containingFile, OapModuleNamePair::class.java)
                if (oapModuleName == null) {
                    return arrayOf()
                } else {
                    val reference: PsiReference = OapModuleReference(m, oapModuleName)
                    return arrayOf(reference)
                }
            } else {
                val moduleName: String? = m.text
                if (moduleName == null) {
                    return arrayOf()
                }
                return StubIndex
                    .getElements(OapModuleNameIndex.KEY, moduleName, m.project, GlobalSearchScope.allScope(m.project), OapModuleNamePair::class.java)
                    .map { moduleName -> OapModuleReference(m, moduleName) }
                    .toTypedArray()
            }
        }

        @JvmStatic
        fun getReference(m: IServiceName): OapServiceReference? {
            val serviceName: String? = m.text
            val moduleFile: PsiFile? = if (m is OapReferenceModulesServiceName) {
                val moduleName: OapReferenceModulesName? = PsiTreeUtil.findChildOfType(m.parent, OapReferenceModulesName::class.java)
                moduleName?.let { ModuleUtils.getModuleFile(it) }
            } else {
                m.containingFile
            }

            val service: OapModuleServicesService? = moduleFile
                ?.let { PsiTreeUtil.findChildrenOfType(it, OapModuleServicesService::class.java) }
                ?.firstOrNull { it.serviceName.text.equals(serviceName) }

            return service?.let { OapServiceReference(m, it) }
        }

        @JvmStatic
        fun getReference(m: OapParameterKeyValueFirstId): JvmNamedElementReference? {
            val service: OapModuleServicesService? = PsiTreeUtil.getParentOfType(m, OapModuleServicesService::class.java)
            val psiClass: PsiClass? = (service?.moduleServicesServiceImplementation?.classNamePsi as? OapClassValueMixin)?.getPsiClass()

            if (psiClass != null) {
                val propertyName: String = m.keyName.text

                val psiMethod: PsiMethod? = psiClass.methods.firstOrNull { m -> m.name.startsWith("set" + Strings.capitalize(propertyName)) && m.parameterList.parametersCount == 1 }
                if (psiMethod != null) {
                    return JvmNamedElementReference(m, psiMethod)
                }

                val parameter: JvmParameter? = psiClass.constructors.flatMap { c -> c.parameters.filter { p -> propertyName.equals(p.name) } }.firstOrNull()
                if (parameter != null) {
                    return JvmNamedElementReference(m, parameter);
                }

                val psiField: PsiField? = psiClass.allFields.firstOrNull { it.name.equals(propertyName) }

                if (psiField != null) {
                    return JvmNamedElementReference(m, psiField)
                }
            }

            return null;
        }

        @JvmStatic
        fun getReference(m: OapModuleInclude): FileReference? {

            val resourceName: String? = m.string?.text?.trim('"')
            if (resourceName == null) {
                return null
            }

            val includeFile: VirtualFile? =
                FilenameIndex.getVirtualFilesByName(resourceName, GlobalSearchScope.allScope(m.project)).firstOrNull()
                    ?: FilenameIndex.getVirtualFilesByName(resourceName + ".oap", GlobalSearchScope.allScope(m.project)).firstOrNull()

            if (includeFile == null) {
                return null
            }

            val psiFile: PsiFile? = includeFile.findPsiFile(m.project)
            if (psiFile == null) {
                return null;
            }

            return FileReference(FileReferenceSet(m), psiFile.textRange, 0, includeFile.name)
        }
    }
}