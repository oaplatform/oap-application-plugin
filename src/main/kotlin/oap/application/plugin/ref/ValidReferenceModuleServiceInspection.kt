package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.stubs.StubIndex
import oap.application.plugin.gen.psi.OapReferenceModulesValue
import oap.application.plugin.psi.ModuleUtils
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
                    val serviceNames: List<String> = ModuleUtils.getServices(element, referenceModuleName).map { it.serviceName.text }

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