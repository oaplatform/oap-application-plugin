package oap.application.plugin.inspection

import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidModuleDependsOnInspection

class OapModuleDependsOnInspectionTest : OapFixtureTestCase() {
    override fun getBasePath(): String {
        return "inspection"
    }

    fun testDependsOnSelf() {
        myFixture.configureByText(
            "testDependsOnSelf.oap", """
            name = testDependsOnSelf
            dependsOn = <error descr="Cycle reference to self">testDependsOnSelf</error>
        """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testDependsOnUnknownModule() {
        myFixture.configureByText(
            "knownModule.oap", """
            name = knownModule
        """.trimIndent()
        )

        val file1: PsiFile = myFixture.configureByText(
            "testDependsOnUnknownModule.oap", """
            name = testDependsOnUnknownModule
            dependsOn = [
              knownModule
              <error descr="Module 'unknownModule' not found">unknownModule</error>
            ]
        """.trimIndent()
        )

        myFixture.openFileInEditor(file1.virtualFile)

        myFixture.checkHighlighting()
    }

}