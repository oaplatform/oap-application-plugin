package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiParameter

class ValidWsValidateInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element !is PsiLiteralExpression || !WsValidateUtil.isWsValidateLiteral(element)) {
                    super.visitElement(element)
                    return
                }

                val resolved = WsValidateUtil.resolve(element) ?: return
                val validator = resolved.validator

                when (val owner = resolved.owner) {
                    is PsiMethod -> checkMethodLevel(owner, validator, element, holder)
                    is PsiParameter -> checkParameterLevel(validator, element, holder)
                }

                checkReturnType(validator, element, holder)
            }
        }
    }

    private fun checkMethodLevel(annotatedMethod: PsiMethod, validator: PsiMethod, element: PsiLiteralExpression, holder: ProblemsHolder) {
        val missing = WsValidateUtil.missingParameterNames(annotatedMethod, validator)
        if (missing.isNotEmpty()) {
            holder.registerProblem(
                element,
                "Validator '${validator.name}' parameter(s) ${missing.joinToString(", ")} not supplied by '${annotatedMethod.name}'",
                ProblemHighlightType.ERROR
            )
        }
    }

    private fun checkParameterLevel(validator: PsiMethod, element: PsiLiteralExpression, holder: ProblemsHolder) {
        if (validator.parameterList.parametersCount != 1) {
            holder.registerProblem(
                element,
                "Validator '${validator.name}' must take exactly one parameter for a parameter-level @WsValidate",
                ProblemHighlightType.ERROR
            )
        }
    }

    private fun checkReturnType(validator: PsiMethod, element: PsiLiteralExpression, holder: ProblemsHolder) {
        if (!WsValidateUtil.returnsValidationErrors(validator)) {
            holder.registerProblem(
                element,
                "Validator '${validator.name}' must return ${WsValidateUtil.VALIDATION_ERRORS_FQN}",
                ProblemHighlightType.ERROR
            )
        }
    }
}
