package oap.application.plugin.stub.types

import com.intellij.psi.PsiFile
import com.intellij.psi.StubBuilder
import com.intellij.psi.stubs.DefaultStubBuilder
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType
import oap.application.plugin.lang.OapLanguage
import oap.application.plugin.psi.OapFile
import oap.application.plugin.stub.OapFileStub
import java.io.IOException

object OapFileElementType : IStubFileElementType<OapFileStub>("OAP_FILE", OapLanguage) {
    const val VERSION: Int = 1

    override fun getStubVersion(): Int {
        return VERSION
    }

    override fun getBuilder(): StubBuilder {
        return object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> {
                if (file is OapFile) {
                    return OapFileStub(file)
                }
                return super.createStubForFile(file)
            }
        }
    }

    @Throws(IOException::class)
    override fun serialize(stub: OapFileStub, dataStream: StubOutputStream) {
    }

    @Throws(IOException::class)
    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): OapFileStub {
        return OapFileStub(null)
    }

    override fun getExternalId(): String {
        return "erlang.FILE"
    }
}