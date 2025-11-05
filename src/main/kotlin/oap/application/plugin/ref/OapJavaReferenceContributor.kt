package oap.application.plugin.ref

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import oap.application.plugin.gen.psi.OapClassValue
import oap.application.plugin.ref.OapJavaClassReferenceProvider

class OapJavaReferenceContributor : PsiReferenceContributor() {
    inline private fun <reified T : PsiElement> pattern(): PsiElementPattern.Capture<T> {
        return PlatformPatterns.psiElement(T::class.java)
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(pattern<OapClassValue>(), OapJavaClassReferenceProvider())
    }
}