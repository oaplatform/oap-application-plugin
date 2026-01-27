package oap.application.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.Icons
import com.intellij.util.ProcessingContext
import oap.application.plugin.gen.psi.OapParameterKeyValueFirstId
import oap.application.plugin.psi.impl.JavaPsiUtils

class OapParameterCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(OapParameterKeyValueFirstId::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position: PsiElement = parameters.position

                    var prefix: String = position.text.removeSuffix(CompletionInitializationContext.DUMMY_IDENTIFIER_TRIMMED)

                    val parameters: List<JavaPsiUtils.ServiceParameter> = JavaPsiUtils.findParameters(position)

                    for (parameter: JavaPsiUtils.ServiceParameter in parameters) {
                        if (parameter.name.startsWith(prefix)) {
                            result.addElement(LookupElementBuilder.create(parameter.name).withIcon(
                                when(parameter.type) {
                                    JavaPsiUtils.ServiceParameterType.FIELD -> AllIcons.Nodes.Field
                                    JavaPsiUtils.ServiceParameterType.CONSTRUCTOR_PARAMETER -> AllIcons.Nodes.Constructor
                                    JavaPsiUtils.ServiceParameterType.METHOD -> AllIcons.Nodes.Method
                                }
                            ))
                        }
                    }
                }
            }
        )
    }
}