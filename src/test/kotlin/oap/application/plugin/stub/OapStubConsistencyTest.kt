package oap.application.plugin.stub

import com.intellij.psi.stubs.StubTextInconsistencyException
import oap.application.plugin.OapFixtureTestCase
import java.io.File

// Stub tree built from file text must match the stubbed nodes of the full AST, otherwise IDEA throws
// UpToDateStubIndexMismatch ("Stub count (N) doesn't match stubbed node length (M)") at runtime.
class OapStubConsistencyTest : OapFixtureTestCase() {
    override fun getBasePath(): String = "parser"

    fun testParserFixtures() {
        val files = File(testDataPath).listFiles { f -> f.extension == "oap" }!!.sortedBy { it.name }
        assertTrue(files.isNotEmpty())

        for (f in files) {
            val psiFile = myFixture.configureByText(f.name, f.readText())
            try {
                StubTextInconsistencyException.checkStubTextConsistency(psiFile)
            } catch (e: Throwable) {
                throw AssertionError("stub/AST mismatch in ${f.name}: ${e.message}", e)
            }
        }
    }
}
