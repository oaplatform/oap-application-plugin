package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.gen.psi.OapServiceName
import oap.application.plugin.psi.impl.OapCompositeElementImpl

abstract class OapModuleServicesServiceMixin(node: ASTNode) : OapCompositeElementImpl(node), OapNavigationElement, IndentNormal, OapKeyValuePair, OapModuleServicesService {
    fun getValue(): String? {
        return _findChildByClass(OapModuleServicesServiceImplementation::class.java)?.classNamePsi?.text
    }

    fun getImplementationClass(): PsiClass? {
        return getValue()?.let { JavaPsiFacade.getInstance(project).findClass(it, GlobalSearchScope.allScope(project)) }
    }

    fun isEnabled(): Boolean {
        return _findChildByClass(OapModuleServicesServiceEnabledMixin::class.java)?.getBooleanValue() ?: true
    }

    override fun getElementInfo(): String {
        return getServiceName().text
    }
}