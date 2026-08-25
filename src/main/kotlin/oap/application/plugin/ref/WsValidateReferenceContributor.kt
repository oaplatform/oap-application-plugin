package oap.application.plugin.ref

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.ElementManipulators
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext

class WsValidateReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiLiteralExpression::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                    if (element !is PsiLiteralExpression || !WsValidateUtil.isWsValidateLiteral(element)) {
                        return PsiReference.EMPTY_ARRAY
                    }
                    return arrayOf(WsValidateMethodReference(element))
                }
            }
        )
    }
}

class WsValidateMethodReference(literal: PsiLiteralExpression) : PsiReferenceBase<PsiLiteralExpression>(literal, ElementManipulators.getValueTextRange(literal)) {
    override fun resolve(): PsiElement? {
        return WsValidateUtil.findValidatorMethod(element)
    }
}
