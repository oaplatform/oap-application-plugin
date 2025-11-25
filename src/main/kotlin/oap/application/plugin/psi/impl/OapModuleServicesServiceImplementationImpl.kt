package oap.application.plugin.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.psi.IndentNormal
import oap.application.plugin.psi.OapKeyValueClass
import oap.application.plugin.stub.OapModuleServicesServiceImplementationStub

abstract class OapModuleServicesServiceImplementationImpl : OapStubBasedPsiElementBase<OapModuleServicesServiceImplementationStub>,
    OapKeyValueClass, OapModuleServicesServiceImplementation, IndentNormal {

    protected constructor(node: ASTNode) : super(node)

    protected constructor(stub: OapModuleServicesServiceImplementationStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)

    override fun getName(): String? {
        return getClassNamePsi()?.text;
    }
}