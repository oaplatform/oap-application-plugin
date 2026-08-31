package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionInitializationContext
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import oap.application.plugin.gen.psi.OapModuleServicesServiceSupervision

class OapSupervisionCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position = parameters.position

                    val supervision = PsiTreeUtil.getParentOfType(position, OapModuleServicesServiceSupervision::class.java, false)
                        ?: return

                    val prefix = position.text.removeSuffix(CompletionInitializationContext.DUMMY_IDENTIFIER_TRIMMED)

                    val present = buildSet {
                        if (supervision.moduleServicesServiceSupervisionEntitiesSuperviseList.isNotEmpty()) add("supervise")
                        if (supervision.moduleServicesServiceSupervisionEntitiesScheduleList.isNotEmpty()) add("schedule")
                        if (supervision.moduleServicesServiceSupervisionEntitiesThreadList.isNotEmpty()) add("thread")
                        if (supervision.moduleServicesServiceSupervisionEntitiesDelayList.isNotEmpty()) add("delay")
                        if (supervision.moduleServicesServiceSupervisionEntitiesCronList.isNotEmpty()) add("cron")
                    }

                    for (key in KEYS) {
                        if (key in present) continue
                        if (key.startsWith(prefix)) {
                            result.addElement(LookupElementBuilder.create(key))
                        }
                    }
                }
            }
        )
    }

    companion object {
        val KEYS: List<String> = listOf("supervise", "schedule", "thread", "delay", "cron")
    }
}
