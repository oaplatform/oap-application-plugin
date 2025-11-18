package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.parentOfType
import oap.application.plugin.gen.psi.OapModuleNamePair
import oap.application.plugin.gen.psi.OapModuleServices
import oap.application.plugin.gen.psi.OapReferenceModulesValue
import oap.application.plugin.stub.OapModuleNameIndex

class ValidReferenceModuleServiceInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapReferenceModulesValue) {

                    val project: Project = element.project

                    val allKeys: Collection<String> = StubIndex.getInstance().getAllKeys(OapModuleNameIndex.KEY, project)

                    val referenceModuleName: String? = element.referenceModuleName

                    if (!"this".equals(referenceModuleName) && !allKeys.contains(referenceModuleName)) {
                        holder.registerProblem(
                            element,
                            "Module '${referenceModuleName ?: ""}' not found",
                            ProblemHighlightType.ERROR
                        )

                        return
                    }

                    val referenceServiceName: String? = element.referenceServiceName

                    val services: List<OapModuleServices>;

                    if ("this".equals(referenceModuleName)) {
                        services = element.parentOfType<OapModuleServices>()?.let { listOf(it) } ?: emptyList()
                    } else {
                        if (referenceModuleName != null) {
                            services = StubIndex
                                .getElements(OapModuleNameIndex.KEY, referenceModuleName, element.project, GlobalSearchScope.allScope(project), OapModuleNamePair::class.java)
                                .mapNotNull { PsiTreeUtil.findChildOfType(it.parent, OapModuleServices::class.java) }
                        } else {
                            services = emptyList()
                        }
                    }

                    val serviceNames: List<String> = services.flatMap { it.moduleServicesServiceList.map { it.serviceName.text } }

                    if (!serviceNames.contains(referenceServiceName)) {
                        holder.registerProblem(
                            element,
                            "Service '${referenceServiceName ?: ""}' not found in module '${referenceModuleName ?: ""}'",
                            ProblemHighlightType.ERROR
                        )

                    }

                } else {
                    super.visitElement(element)
                }
            }
        }
    }
}