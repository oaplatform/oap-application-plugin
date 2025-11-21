package oap.application.plugin.inspection

import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidModuleDependsOnInspection
import oap.application.plugin.ref.ValidServiceDependsOnInspection

class OapDependsOnInspectionTest : OapFixtureTestCase() {
    protected override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidModuleDependsOnInspection::class.java, ValidServiceDependsOnInspection::class.java)
    }

    override fun getBasePath(): String {
        return "inspection"
    }

    fun testModuleDependsOnSelf() {
        myFixture.configureByText(
            "testModuleDependsOnSelf.oap", """
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

    fun testServiceDependsOnSelf() {
        myFixture.configureByText(
            "testServiceDependsOnSelf.oap", """
            name = testServiceDependsOnSelf
            services {
              service2 {
                implementation = oap.application.plugin.TestService
                dependsOn = <error descr="Cycle reference to self">service2</error>
              }
            }
        """.trimIndent()
        )

        myFixture.checkHighlighting()
    }

    fun testDependsOnUnknownService() {
        myFixture.configureByText(
            "testDependsOnUnknownService.oap", """
            name = testDependsOnUnknownService
            services {
              service1.implementation = oap.application.plugin.TestService
              service2 {
                implementation = oap.application.plugin.TestService
                dependsOn = [
                  service1
                  <error descr="Service 'unknownService' not found">unknownService</error>
                ]
              }
            }
        """.trimIndent()
        )


        myFixture.checkHighlighting()
    }

}