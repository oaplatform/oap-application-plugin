package oap.application.plugin.psi.impl

import com.intellij.lang.jvm.JvmParameter
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.text.Strings
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.findPsiFile
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiMethod
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
        fun getReference(m: IModuleName): OapModuleReference? {
            if ("this".equals(m.text)) {
                val oapModuleName: OapModuleNamePair? = PsiTreeUtil.findChildOfType(m.containingFile, OapModuleNamePair::class.java)
                return oapModuleName?.let { OapModuleReference(m, it) }
            } else {
                val moduleName: String? = m.text
                return moduleName?.let { t ->
                    return StubIndex
                        .getElements(OapModuleNameIndex.KEY, t, m.project, GlobalSearchScope.allScope(m.project), OapModuleNamePair::class.java)
                        .firstOrNull()
                        ?.let { moduleName -> OapModuleReference(m, moduleName) }
                }
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

            return FileReference(FileReferenceSet(m.containingFile), psiFile.textRange, 0, includeFile.name)
        }
    }
}