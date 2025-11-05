package oap.application.plugin.psi.impl

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.StubBasedPsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class OapStubBasedPsiElementBase<T> : StubBasedPsiElementBase<T>, StubBasedPsiElement<T> where T : StubElement<*> {
    protected constructor(node: ASTNode) : super(node)

    protected constructor(stub: T, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun toString(): String {
        return getElementType().toString()
    }
}