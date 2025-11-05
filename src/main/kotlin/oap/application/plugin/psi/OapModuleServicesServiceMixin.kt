package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.gen.psi.OapIdValue
import oap.application.plugin.gen.psi.impl.OapModuleServicesServiceImplementationImpl
import oap.application.plugin.psi.impl.OapCompositeElementImpl
import oap.application.plugin.psi.OapNavigationElement

abstract class OapModuleServicesServiceMixin(node: ASTNode) : OapCompositeElementImpl(node), OapNavigationElement, IndentNormal, OapKeyValuePair {
    fun getValue(): String? {
        return _findChildByClass(OapModuleServicesServiceImplementationImpl::class.java)?.classValue?.text
    }

    fun getImplementationClass(): PsiClass? {
        return getValue()?.let { JavaPsiFacade.getInstance(project).findClass(it, GlobalSearchScope.allScope(project)) }
    }

    fun getServiceName(): String {
        return _findChildByClass(OapIdValue::class.java)!!.text
    }

    fun isEnabled(): Boolean {
        return _findChildByClass(OapModuleServicesServiceEnabledMixin::class.java)?.getBooleanValue() ?: true
    }

    override fun getElementInfo(): String {
        return getServiceName()
    }
}