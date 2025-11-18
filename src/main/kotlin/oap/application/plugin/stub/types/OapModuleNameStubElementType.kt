package oap.application.plugin.stub.types

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import oap.application.plugin.gen.psi.OapModuleNamePair
import oap.application.plugin.gen.psi.impl.OapModuleNamePairImpl
import oap.application.plugin.stub.OapModuleNameIndex
import oap.application.plugin.stub.OapModuleNameStub

class OapModuleNameStubElementType(debugName: String) : OapStubElementType<OapModuleNameStub, OapModuleNamePair>(debugName) {
    override fun serialize(stub: OapModuleNameStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): OapModuleNameStub {
        return OapModuleNameStub(parentStub!!, this, dataStream.readName())
    }

    override fun indexStub(stub: OapModuleNameStub, sink: IndexSink) {
        val name = stub.name

        if (name != null) {
            sink.occurrence(OapModuleNameIndex.KEY, name)
        }
    }

    override fun createPsi(stub: OapModuleNameStub): OapModuleNamePair {
        return OapModuleNamePairImpl(stub, this)
    }

    override fun createStub(
        psi: OapModuleNamePair,
        parentStub: StubElement<out PsiElement?>?
    ): OapModuleNameStub {
        return OapModuleNameStub(parentStub, this, psi.moduleName?.text)
    }

}