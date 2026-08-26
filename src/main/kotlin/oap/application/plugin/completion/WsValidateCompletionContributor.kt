package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import oap.application.plugin.ref.WsValidateUtil

class WsValidateCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                    // Whether the completion position IS the literal, or a child of it (this
                    // differs between a freshly-parsed in-memory file and a stub-backed real
                    // project file), is an implementation detail we shouldn't depend on - look
                    // for a PsiLiteralExpression starting at the position itself (strict=false).
                    val literal = PsiTreeUtil.getParentOfType(parameters.position, PsiLiteralExpression::class.java, false) ?: return
                    val annotation = WsValidateUtil.enclosingAnnotation(literal) ?: return
                    val owner = WsValidateUtil.annotatedOwner(annotation) ?: return

                    for (method in WsValidateUtil.candidateValidatorMethods(owner)) {
                        result.addElement(
                            LookupElementBuilder.create(method.name)
                                .withIcon(AllIcons.Nodes.Method)
                                .withTypeText(WsValidateUtil.VALIDATION_ERRORS_FQN)
                        )
                    }
                }
            }
        )
    }
}
