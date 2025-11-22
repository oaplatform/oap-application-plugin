package oap.application.plugin.psi.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import oap.application.plugin.gen.psi.OapModuleNamePair

class OapModuleReference(owner: PsiElement, val moduleName: OapModuleNamePair) : PsiReferenceBase<PsiElement>(owner) {
    override fun resolve(): PsiElement {
        return moduleName
    }
}