package oap.application.plugin.stub.types

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.gen.psi.impl.OapModuleServicesServiceImplementationImpl
import oap.application.plugin.stub.OapModuleServicesServiceImplementationIndex
import oap.application.plugin.stub.OapModuleServicesServiceImplementationStub

class OapModuleServicesServiceImplementationStubElementType(debugName: String) : OapStubElementType<OapModuleServicesServiceImplementationStub, OapModuleServicesServiceImplementation>(debugName) {
    override fun serialize(stub: OapModuleServicesServiceImplementationStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): OapModuleServicesServiceImplementationStub {
        return OapModuleServicesServiceImplementationStub(parentStub!!, this, dataStream.readName())
    }

    override fun indexStub(stub: OapModuleServicesServiceImplementationStub, sink: IndexSink) {
        val name = stub.name

        if (name != null) {
            sink.occurrence(OapModuleServicesServiceImplementationIndex.KEY, name)
        }
    }

    override fun createPsi(stub: OapModuleServicesServiceImplementationStub): OapModuleServicesServiceImplementation {
        return OapModuleServicesServiceImplementationImpl(stub, this)
    }

    override fun createStub(
        psi: OapModuleServicesServiceImplementation,
        parentStub: StubElement<out PsiElement?>?
    ): OapModuleServicesServiceImplementationStub {
        return OapModuleServicesServiceImplementationStub(parentStub, this, psi.classNamePsi?.text)
    }

}