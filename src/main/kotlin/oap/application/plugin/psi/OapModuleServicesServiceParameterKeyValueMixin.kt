package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import oap.application.plugin.psi.impl.OapCompositeElementImpl
import oap.application.plugin.psi.OapNavigationElement

abstract class OapModuleServicesServiceParameterKeyValueMixin(node: ASTNode) : OapCompositeElementImpl(node), OapNavigationElement, IndentNormal