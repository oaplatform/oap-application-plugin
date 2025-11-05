package oap.application.plugin.psi

import com.intellij.lang.ASTNode
import oap.application.plugin.gen.psi.OapBoolValue
import oap.application.plugin.psi.impl.OapCompositeElementImpl

abstract class OapModuleServicesServiceEnabledMixin(node: ASTNode) : OapCompositeElementImpl(node), OapKeyValuePair, IndentNormal {
    fun getBooleanValue(): Boolean {
        return findChildByClass(OapBoolValue::class.java)?.getBooleanValue() ?: true;
    }
}