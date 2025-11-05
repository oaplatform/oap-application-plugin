package oap.application.plugin.ref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceProvider
import oap.application.plugin.gen.psi.OapClassValue

class OapJavaClassReferenceProvider : JavaClassReferenceProvider() {
    init {
        setSoft(true)
    }

    override fun getReferencesByString(str: String, position: PsiElement, offsetInPosition: Int): Array<PsiReference> {
        if (position is OapClassValue) {
            return super.getReferencesByString(str, position, offsetInPosition)
        } else {
            return PsiReference.EMPTY_ARRAY;
        }
    }
}