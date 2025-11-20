package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.stubs.StubIndex
import oap.application.plugin.gen.psi.OapModuleDependsOnName
import oap.application.plugin.psi.ModuleUtils
import oap.application.plugin.stub.OapModuleNameIndex

class ValidModuleDependsOnInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapModuleDependsOnName) {
                    val project: Project = element.project

                    var allKeys: Collection<String> = StubIndex.getInstance().getAllKeys(OapModuleNameIndex.KEY, project)

                    val moduleName: String? = element.text

                    val thisModuleName: String? = ModuleUtils.getModuleName(element.containingFile)

                    if (thisModuleName != null && thisModuleName == moduleName) {
                        holder.registerProblem(
                            element,
                            "Cycle reference to self",
                            ProblemHighlightType.ERROR
                        )
                    }

                    if (!allKeys.contains(moduleName)) {
                        holder.registerProblem(
                            element,
                            "Module '${moduleName ?: ""}' not found",
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