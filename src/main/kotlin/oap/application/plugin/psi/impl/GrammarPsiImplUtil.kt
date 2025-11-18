package oap.application.plugin.psi.impl

import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.*
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
        fun getReference(m: OapReferenceModulesName): OapModuleReference? {
            if (m.idThis?.text != null) {
                val oapModuleName: OapModuleName? = PsiTreeUtil.findChildOfType(m.containingFile, OapModuleName::class.java)
                return oapModuleName?.let { OapModuleReference(it) }
            } else {
                val moduleName: String? = m.referenceValue?.text
                return moduleName?.let { t ->
                    return StubIndex
                        .getElements(OapModuleNameIndex.KEY, t, m.project, GlobalSearchScope.allScope(m.project), OapModuleNamePair::class.java)
                        .mapNotNull { PsiTreeUtil.findChildOfType(m.containingFile, OapModuleName::class.java) }
                        .firstOrNull()
                        ?.let { moduleName -> OapModuleReference(moduleName) }
                }
            }
        }
    }
}