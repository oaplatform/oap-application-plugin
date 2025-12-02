package oap.application.plugin.psi.impl

import com.intellij.lang.jvm.JvmNamedElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class JvmNamedElementReference(owner: PsiElement, val javaElement: JvmNamedElement) : PsiReferenceBase<PsiElement>(owner) {
    override fun resolve(): PsiElement {
        return javaElement.sourceElement!!
    }
}