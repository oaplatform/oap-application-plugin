package oap.application.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.Project
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.parentOfType
import com.intellij.util.ProcessingContext
import oap.application.plugin.gen.psi.*
import oap.application.plugin.stub.OapModuleNameIndex

class OapReferenceCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(OapAnyReference::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position: PsiElement = parameters.position

                    var prefix: String = position.text.removeSuffix(CompletionInitializationContext.DUMMY_IDENTIFIER_TRIMMED)

                    for (type: String in TYPES) {
                        if (type.startsWith(prefix)) {
                            result.addElement(LookupElementBuilder.create(type))
                        }
                    }
                }
            }
        )

        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(OapReferenceModulesName::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position: PsiElement = parameters.position

                    var prefix: String = position.text.removeSuffix(CompletionInitializationContext.DUMMY_IDENTIFIER_TRIMMED)

                    val allKeys: Collection<String> = StubIndex.getInstance().getAllKeys(OapModuleNameIndex.KEY, position.project)

                    val thisModuleName: String? = PsiTreeUtil.findChildOfType(parameters.originalFile, OapModuleName::class.java)?.text

                    if ("this".startsWith(prefix)) {
                        result.addElement(
                            PrioritizedLookupElement.withPriority(LookupElementBuilder.create("this").bold(), 1000.0)
                        )
                    }
                    for (moduleName in allKeys) {
                        if (thisModuleName != null && thisModuleName.equals(moduleName)) {
                            continue
                        }
                        if (moduleName.startsWith(prefix)) {
                            result.addElement(LookupElementBuilder.create(moduleName))
                        }
                    }

                    result.stopHere()
                }
            }
        )

        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(OapReferenceModulesServiceName::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position: PsiElement = parameters.position
                    val moduleName: String? = (position.parent.parent as? OapReferenceModulesValueIn)?.referenceModulesName?.text
                    if (moduleName != null) {
                        val project: Project = position.project

                        val services: List<OapModuleServices>;

                        if ("this".equals(moduleName)) {
                            services = position.parentOfType<OapModuleServices>()?.let { listOf(it) } ?: emptyList()
                        } else {
                            services = StubIndex
                                .getElements(OapModuleNameIndex.KEY, moduleName, project, GlobalSearchScope.allScope(project), OapModuleNamePair::class.java)
                                .mapNotNull { PsiTreeUtil.findChildOfType(it.parent, OapModuleServices::class.java) }
                        }

                        val serviceNames: List<String> = services.flatMap { it.moduleServicesServiceList.map { it.serviceName.text } }

                        for (service in serviceNames.sorted()) {
                            result.addElement(LookupElementBuilder.create(service))
                        }
                    }
                }
            }
        )
    }

    companion object {
        val TYPES: List<String> = listOf("modules", "services", "kernel");
    }
}