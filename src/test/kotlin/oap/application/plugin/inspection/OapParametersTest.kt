package oap.application.plugin.inspection

import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.ref.ValidParametersInspection
import java.io.File

class OapParametersTest : OapFixtureTestCase() {
    protected override fun setUp() {
        super.setUp()

        myFixture.enableInspections(ValidParametersInspection::class.java)
    }

    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    fun testParameterAsField() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val file: PsiFile = myFixture.configureByText(
            "testParameterAsField.oap", """
            name = testParameterAsField
            services {
              testParameterAsField {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  <error descr="Final field">finalStringField</error> = fff
                  stringField = "dfg"
                  <error descr="Unknown field">unknownField</error> = "dfg"
                }
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        myFixture.checkHighlighting()
    }

    fun testParameterAsConstructor() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val file: PsiFile = myFixture.configureByText(
            "testParameterAsField.oap", """
            name = testParameterAsField
            services {
              testParameterAsField {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  constructor1StringField = "dfg"
                }
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        myFixture.checkHighlighting()
    }

    fun testParameterAsSetterMethod() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val file: PsiFile = myFixture.configureByText(
            "testParameterAsField.oap", """
            name = testParameterAsField
            services {
              testParameterAsField {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  SetterMethodString = "dfg"
                }
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        myFixture.checkHighlighting()
    }

    fun testFinalParameterAsSetListMap() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val file: PsiFile = myFixture.configureByText(
            "testParameterAsField.oap", """
            name = testParameterAsField
            services {
              testParameterAsField {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  finalMap.a = b
                  finalList = [a,b]
                  finalSet = d
                }
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        myFixture.checkHighlighting()
    }
}