package oap.application.plugin.stub.types

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.gen.psi.impl.OapModuleServicesServiceImpl
import oap.application.plugin.stub.OapModuleServicesServiceIndex
import oap.application.plugin.stub.OapModuleServicesServiceStub

class OapModuleServicesServiceStubElementType(debugName: String) : OapStubElementType<OapModuleServicesServiceStub, OapModuleServicesService>(debugName) {
    override fun serialize(stub: OapModuleServicesServiceStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): OapModuleServicesServiceStub {
        return OapModuleServicesServiceStub(parentStub!!, this, dataStream.readName())
    }

    override fun indexStub(stub: OapModuleServicesServiceStub, sink: IndexSink) {
        val name = stub.name

        if (name != null) {
            sink.occurrence(OapModuleServicesServiceIndex.KEY, name)
        }
    }

    override fun createPsi(stub: OapModuleServicesServiceStub): OapModuleServicesService {
        return OapModuleServicesServiceImpl(stub, this)
    }

    override fun createStub(
        psi: OapModuleServicesService,
        parentStub: StubElement<out PsiElement?>?
    ): OapModuleServicesServiceStub {
        return OapModuleServicesServiceStub(parentStub, this, psi.moduleServicesServiceImplementation?.classNamePsi?.text)
    }

}