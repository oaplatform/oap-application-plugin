package oap.application.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import oap.application.plugin.gen.psi.OapModuleName
import oap.application.plugin.gen.psi.OapModuleNamePair

class OapKeywordCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC, PlatformPatterns.psiElement().afterSibling(PlatformPatterns.psiElement(OapModuleNamePair::class.java)), object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    result.addElement(LookupElementBuilder.create("name").withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE))
                }
            }
        )

        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .withSuperParent(
                    2, PlatformPatterns.psiElement()
                        .withChild(PlatformPatterns.psiElement().afterSibling(PlatformPatterns.psiElement(OapModuleNamePair::class.java)))
                ),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    result.addElement(LookupElementBuilder.create("enabled"));
                    result.addElement(LookupElementBuilder.create("dependOn"));
                    result.addElement(LookupElementBuilder.create("services"));
                    result.addElement(LookupElementBuilder.create("configurations"));
                }
            })
    }

}