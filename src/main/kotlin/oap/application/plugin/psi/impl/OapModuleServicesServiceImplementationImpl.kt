package oap.application.plugin.psi.impl

import com.intellij.lang.ASTNode
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.psi.IndentNormal
import oap.application.plugin.psi.OapKeyValueClass

abstract class OapModuleServicesServiceImplementationImpl(node: ASTNode) : OapCompositeElementImpl(node), OapKeyValueClass, OapModuleServicesServiceImplementation, IndentNormal {
}