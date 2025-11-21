package oap.application.plugin.psi

import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapModuleName

object ModuleUtils {
    fun getModuleName(psiFile: PsiFile): String? {
        return PsiTreeUtil.findChildOfType<OapModuleName>(psiFile, OapModuleName::class.java)?.keyValue?.text
    }
}