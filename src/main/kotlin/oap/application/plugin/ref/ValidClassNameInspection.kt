package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import oap.application.plugin.psi.OapKeyValueClass

class ValidClassNameInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapKeyValueClass) {
                    val psiClass: PsiClass? = element.getPsiClass()

                    if (psiClass == null) {
                        holder.registerProblem(
                            element,
                            "Class '${element.getValueText()}' not found",
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