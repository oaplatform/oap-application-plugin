package oap.application.plugin.ref

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import oap.application.plugin.gen.psi.OapBoolValue
import oap.application.plugin.ref.OapValueReferenceProvider

class OapReferenceContributor : PsiReferenceContributor() {
    private inline fun <reified T> pattern(): PsiElementPattern.Capture<T> where T : PsiElement {
        return PlatformPatterns.psiElement(T::class.java)
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(pattern<OapBoolValue>(), OapValueReferenceProvider())
    }
}