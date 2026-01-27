package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionType
import oap.application.plugin.OapFixtureTestCase
import java.io.File

class OapParametersCompletionTest : OapFixtureTestCase() {
    override fun getBasePath(): String {
        return "completion"
    }

    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    fun testParameterName() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        myFixture.configureByText(
            "testParameterName.oap", """
            name = test

            services {
              test-service {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  <caret>                
                }
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "constructor1StringField", "constructor2IntField", "constructor2StringField", "integerField", "intField", "privateStringField", "setterMethodString", "stringField"
        )
    }
}