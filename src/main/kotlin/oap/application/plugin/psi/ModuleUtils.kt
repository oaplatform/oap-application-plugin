package oap.application.plugin.psi

import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapModuleName
import oap.application.plugin.gen.psi.OapModuleServicesService

object ModuleUtils {
    fun getModuleName(psiFile: PsiFile): String? {
        return PsiTreeUtil.findChildOfType<OapModuleName>(psiFile, OapModuleName::class.java)?.keyValue?.text
    }

    fun findServices(psiFile: PsiFile): List<OapModuleServicesService> {
        return PsiTreeUtil.findChildOfType(psiFile, OapModuleServicesService::class.java)?.let { listOf(it) } ?: emptyList()
    }
}