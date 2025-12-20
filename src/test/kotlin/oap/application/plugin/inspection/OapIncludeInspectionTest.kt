package oap.application.plugin.inspection

import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.vfs.findOrCreateDirectory
import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidIncludeInspection

class OapIncludeInspectionTest : OapFixtureTestCase() {
    protected override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidIncludeInspection::class.java)
    }

    override fun getBasePath(): String {
        return "inspection"
    }

    fun testIncludeExist() {
        WriteAction.run<Throwable> {
            myFixture.getTempDirFixture().findOrCreateDir("file").findOrCreateDirectory("1");
        }

        val file: PsiFile = myFixture.configureByText(
            "testInclude.oap", """
            name = testInclude
            include required(<error descr="Invalid resource a.conf">"a.conf"</error>)
            include required(<error descr="Oap resource unknown.oap not found">"unknown.oap"</error>)
            include required("a")
            include required("a.oap")
        """.trimIndent()
        )

        myFixture.configureByText(
            "a.oap", """
            services {
            }
        """.trimIndent()
        )

        myFixture.configureByText(
            "a.conf", """
            k = la-la-la
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        myFixture.checkHighlighting()
    }
}