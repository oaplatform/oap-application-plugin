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
    // Bump on every change to grammars/oap.bnf, grammars/_OapLexer.flex or stub serialization.
    // IDEA rebuilds stub indexes only when this changes; a stale index built by an older parser
    // throws UpToDateStubIndexMismatch ("Stub count (N) doesn't match stubbed node length (M)").
    const val VERSION: Int = 3

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