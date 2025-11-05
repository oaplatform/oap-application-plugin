package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import oap.application.plugin.gen.psi.OapIdValue
import oap.application.plugin.psi.impl.OapCompositeElementImpl

abstract class OapIdValueMixin(node: ASTNode) : OapCompositeElementImpl(node), OapIdValue