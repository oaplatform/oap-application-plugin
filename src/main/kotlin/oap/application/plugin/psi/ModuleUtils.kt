package oap.application.plugin.psi

import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapModuleName
import oap.application.plugin.gen.psi.OapModuleNamePair
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.OapReferenceModulesName
import oap.application.plugin.stub.OapModuleNameIndex

object ModuleUtils {
    fun getModuleName(psiFile: PsiFile): String? {
        return PsiTreeUtil.findChildOfType<OapModuleName>(psiFile, OapModuleName::class.java)?.keyValue?.text
    }

    fun findServices(psiFile: PsiFile): List<OapModuleServicesService> {
        return PsiTreeUtil.findChildOfType(psiFile, OapModuleServicesService::class.java)?.let { listOf(it) } ?: emptyList()
    }

    fun getModuleFile(moduleName: OapReferenceModulesName): PsiFile? {
        if ("this".equals(moduleName.text)) {
            return moduleName.containingFile
        } else {
            return StubIndex
                .getElements(OapModuleNameIndex.KEY, moduleName.text, moduleName.project, GlobalSearchScope.allScope(moduleName.project), OapModuleNamePair::class.java)
                .map { it.containingFile }
                .firstOrNull()
        }

    }
}