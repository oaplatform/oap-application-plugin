package oap.application.plugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class OapCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return node.elementType.toString()
    }
}