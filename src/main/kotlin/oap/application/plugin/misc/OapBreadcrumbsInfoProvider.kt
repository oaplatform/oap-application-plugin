package oap.application.plugin.misc

import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import oap.application.plugin.lang.OapLanguage
import oap.application.plugin.psi.OapNavigationElement

class OapBreadcrumbsInfoProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<out Language?> {
        return arrayOf(OapLanguage)
    }

    override fun acceptElement(element: PsiElement): Boolean {
        return element is OapNavigationElement
    }

    override fun getElementInfo(element: PsiElement): String {
        return (element as? OapNavigationElement)?.getElementInfo() ?: ""
    }
}