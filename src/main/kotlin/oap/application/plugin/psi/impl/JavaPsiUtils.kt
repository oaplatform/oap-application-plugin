package oap.application.plugin.psi.impl

import com.intellij.lang.jvm.JvmParameter
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.psi.OapClassValueMixin
import oap.application.plugin.psi.impl.JavaPsiUtils.ServiceParameterType.*

object JavaPsiUtils {
    fun findParameters(serviceIn: PsiElement): List<ServiceParameter> {
        val service: OapModuleServicesService? = PsiTreeUtil.getParentOfType(serviceIn, OapModuleServicesService::class.java)
        val psiClass: PsiClass? = (service?.moduleServicesServiceImplementation?.classNamePsi as? OapClassValueMixin)?.getPsiClass()
        if (psiClass != null) {
            return CachedValuesManager.getCachedValue(psiClass, Key("Class Parameters")) {
                val ret = ArrayList<ServiceParameter>()

                val psiMethods: List<PsiMethod> = psiClass.methods.filter { m -> m.name.startsWith("set") && m.parameterList.parametersCount == 1 }

                val parameters: List<JvmParameter> = psiClass.constructors.flatMap { c -> c.parameters.filter { c -> c.name != null } }

                val fields: List<PsiField> = psiClass.allFields.asList()

                psiMethods.forEach { m -> ret.add(ServiceParameter(m.name, METHOD)) }
                parameters.forEach { c -> ret.add(ServiceParameter(c.name!!, CONSTRUCTOR_PARAMETER)) }
                fields.forEach { f -> ret.add(ServiceParameter(f.name, FIELD)) }

                CachedValueProvider.Result.create(ret)
            }

        }

        return listOf()
    }

    enum class ServiceParameterType {
        METHOD, CONSTRUCTOR_PARAMETER, FIELD
    }

    class ServiceParameter(val name: String, val type: ServiceParameterType)
}