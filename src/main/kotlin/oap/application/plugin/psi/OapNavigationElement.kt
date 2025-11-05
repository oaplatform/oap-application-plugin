package oap.application.plugin.psi

import com.intellij.psi.PsiElement

interface OapNavigationElement {
    fun getFirstChild(): PsiElement?

    fun getElementInfo(): String {
        return getFirstChild()?.text ?: "<unknown>"
    }
}