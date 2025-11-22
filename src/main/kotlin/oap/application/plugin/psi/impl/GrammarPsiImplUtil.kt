package oap.application.plugin.psi.impl

import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.*
import oap.application.plugin.psi.IModuleName
import oap.application.plugin.psi.IServiceName
import oap.application.plugin.psi.ModuleUtils
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
    }
}