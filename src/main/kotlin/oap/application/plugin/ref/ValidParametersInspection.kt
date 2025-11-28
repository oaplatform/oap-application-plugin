package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.util.text.Strings
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapJavaParameterKeyValue
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.OapParameterKeyValueFirstId
import oap.application.plugin.psi.OapClassValueMixin

class ValidParametersInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapJavaParameterKeyValue) {

                    val service: OapModuleServicesService? = PsiTreeUtil.getParentOfType(element, OapModuleServicesService::class.java)
                    val psiClass: PsiClass? = (service?.moduleServicesServiceImplementation?.classNamePsi as? OapClassValueMixin)?.getPsiClass()
                    if (psiClass != null) {
                        val firstId: OapParameterKeyValueFirstId? = PsiTreeUtil.findChildOfType(element, OapParameterKeyValueFirstId::class.java)
                        val propertyName: String? = firstId?.keyName?.text
                        if (propertyName == null) {
                            return;
                        }
                        val setter: Boolean = psiClass.methods.firstOrNull { m -> m.name.startsWith("set" + Strings.capitalize(propertyName)) && m.parameterList.parametersCount == 1 } == null
                        if (!setter) {
                            return;
                        }
                        val parameter: Boolean = psiClass.constructors.flatMap { c -> c.parameters.mapNotNull { p -> p.name } }.distinct().contains(propertyName)
                        if (parameter) {
                            return;
                        }
                        val psiField: PsiField? = psiClass.allFields.firstOrNull { f -> f.name.equals(propertyName) }
                        if (psiField == null) {
                            holder.registerProblem(
                                firstId,
                                "Unknown field",
                                ProblemHighlightType.ERROR
                            )
                            return;
                        } else if (psiField.hasModifierProperty(PsiModifier.FINAL)) {
                            val type: PsiType = psiField.type

                            val classType: PsiClassType? = type as? PsiClassType;

                            if ((classType != null && classType.className != "String")) {
                                return;
                            }


                            holder.registerProblem(
                                firstId,
                                "Final field",
                                ProblemHighlightType.ERROR
                            )
                        }
                    }
                }
            }
        }
    }
}
