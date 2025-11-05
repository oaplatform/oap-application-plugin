package oap.application.plugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import oap.application.plugin.stub.OapModuleNameStub

abstract class OapModuleNameBaseImpl : OapStubBasedPsiElementBase<OapModuleNameStub> {
    protected constructor(node: ASTNode) : super(node)

    protected constructor(stub: OapModuleNameStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
}