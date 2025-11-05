package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import oap.application.plugin.psi.impl.OapCompositeElementImpl
import oap.application.plugin.psi.OapKeyValueClass

abstract class OapModuleServicesServiceImplementationMixin(node: ASTNode) : OapCompositeElementImpl(node), OapKeyValueClass, IndentNormal