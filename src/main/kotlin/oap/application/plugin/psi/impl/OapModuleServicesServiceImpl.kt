package oap.application.plugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.IStubElementType
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.psi.IndentNormal
import oap.application.plugin.psi.OapKeyValuePair
import oap.application.plugin.psi.OapModuleServicesServiceEnabledMixin
import oap.application.plugin.psi.OapNavigationElement
import oap.application.plugin.stub.OapModuleServicesServiceStub

abstract class OapModuleServicesServiceImpl : OapStubBasedPsiElementBase<OapModuleServicesServiceStub>, OapNavigationElement, IndentNormal, OapKeyValuePair, OapModuleServicesService {
    protected constructor(node: ASTNode) : super(node)

    protected constructor(stub: OapModuleServicesServiceStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun getName(): String? {
        return serviceName.text;
    }

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