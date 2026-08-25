package oap.application.plugin.ref

import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.PsiParameter
import com.intellij.psi.util.PsiTreeUtil

// Shared lookup logic for the oap.ws.validate.WsValidate annotation contract (see CLAUDE.md,
// "oap-ws Module" section) - a validator method name is always resolved by simple name on the
// SAME class as the annotated element, whether @WsValidate sits on a method or on a parameter.
object WsValidateUtil {
    const val ANNOTATION_FQN = "oap.ws.validate.WsValidate"
    const val VALIDATION_ERRORS_FQN = "oap.ws.validate.ValidationErrors"

    fun enclosingAnnotation(literal: PsiLiteralExpression): PsiAnnotation? {
        val annotation = PsiTreeUtil.getParentOfType(literal, PsiAnnotation::class.java) ?: return null
        return if (annotation.qualifiedName == ANNOTATION_FQN) annotation else null
    }

    fun annotatedOwner(annotation: PsiAnnotation): PsiModifierListOwner? {
        return PsiTreeUtil.getParentOfType(annotation, PsiModifierListOwner::class.java)
    }

    fun containingClass(owner: PsiModifierListOwner): PsiClass? {
        return when (owner) {
            is PsiParameter -> (owner.declarationScope as? PsiMethod)?.containingClass
            is PsiMethod -> owner.containingClass
            else -> null
        }
    }

    fun findValidatorMethod(literal: PsiLiteralExpression): PsiMethod? {
        return resolve(literal)?.validator
    }

    class Resolved(val owner: PsiModifierListOwner, val validator: PsiMethod)

    fun resolve(literal: PsiLiteralExpression): Resolved? {
        val name = literal.value as? String ?: return null
        val annotation = enclosingAnnotation(literal) ?: return null
        val owner = annotatedOwner(annotation) ?: return null
        val psiClass = containingClass(owner) ?: return null
        val validator = psiClass.findMethodsByName(name, true).firstOrNull() ?: return null
        return Resolved(owner, validator)
    }

    fun isWsValidateLiteral(element: PsiElement): Boolean {
        return element is PsiLiteralExpression && element.value is String && enclosingAnnotation(element) != null
    }

    // Names required by `candidate` that `owner`'s own parameters don't supply - empty means the
    // candidate's parameter list is fully satisfiable (see ValidWsValidateInspection.checkMethodLevel
    // for the runtime contract this mirrors: unmatched names throw IllegalArgumentException at
    // request time in oap-ws's own MethodValidatorPeer).
    fun missingParameterNames(owner: PsiMethod, candidate: PsiMethod): List<String> {
        val ownerParamNames = owner.parameterList.parameters.map { it.name }.toSet()
        return candidate.parameterList.parameters.map { it.name }.filter { it !in ownerParamNames }
    }

    fun returnsValidationErrors(method: PsiMethod): Boolean {
        return method.returnType?.canonicalText == VALIDATION_ERRORS_FQN
    }

    fun isShapeCompatible(owner: PsiModifierListOwner, candidate: PsiMethod): Boolean {
        return when (owner) {
            is PsiMethod -> missingParameterNames(owner, candidate).isEmpty()
            is PsiParameter -> candidate.parameterList.parametersCount == 1
            else -> false
        }
    }

    // Only methods that would NOT be flagged by ValidWsValidateInspection - completion should
    // never suggest something the inspection then reports as wrong.
    //
    // Uses allMethods (declared + inherited), not methods (declared only) - resolve() above finds
    // a validator via findMethodsByName(name, checkBases=true), which searches superclasses too
    // (WS classes commonly extend a shared base class holding common validators), so candidate
    // enumeration must search the same scope or it silently misses every inherited validator.
    fun candidateValidatorMethods(owner: PsiModifierListOwner): List<PsiMethod> {
        val psiClass = containingClass(owner) ?: return emptyList()
        return psiClass.allMethods
            .distinctBy { it.name }
            .filter { returnsValidationErrors(it) && isShapeCompatible(owner, it) }
    }
}
