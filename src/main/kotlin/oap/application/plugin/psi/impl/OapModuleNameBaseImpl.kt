package oap.application.plugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.stubs.IStubElementType
import oap.application.plugin.stub.OapModuleNameStub

abstract class OapModuleNameBaseImpl : OapStubBasedPsiElementBase<OapModuleNameStub>, PsiNameIdentifierOwner {
    protected constructor(node: ASTNode) : super(node)

    protected constructor(stub: OapModuleNameStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun getNameIdentifier(): PsiElement? {
        return this.node.psi
    }
}