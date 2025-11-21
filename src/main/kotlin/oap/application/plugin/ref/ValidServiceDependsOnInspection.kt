package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.findParentOfType
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.OapModuleServicesServiceDependsonName
import oap.application.plugin.psi.ModuleUtils

class ValidServiceDependsOnInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapModuleServicesServiceDependsonName) {
                    val serviceName: String? = element.text;

                    val thisServiceName: String? = element.findParentOfType<OapModuleServicesService>()?.serviceName?.text

                    val services: List<OapModuleServicesService> = ModuleUtils.findServices(element.containingFile)

                    if (thisServiceName != null && thisServiceName == serviceName) {
                        holder.registerProblem(
                            element,
                            "Cycle reference to self",
                            ProblemHighlightType.ERROR
                        )
                    }

                    if (!services.map { it.serviceName.text }.contains(serviceName)) {
                        holder.registerProblem(
                            element,
                            "Service '${serviceName ?: ""}' not found",
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