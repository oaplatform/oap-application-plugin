package oap.application.plugin.stub

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef
import oap.application.plugin.gen.psi.OapModuleServicesService

class OapModuleServicesServiceStub : NamedStubBase<OapModuleServicesService> {
    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: StringRef?) : super(
        parent,
        elementType,
        name
    )

    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: String?) : super(
        parent,
        elementType,
        name
    )

    override fun toString(): String {
        return "${super.toString()}($name)"
    }

}