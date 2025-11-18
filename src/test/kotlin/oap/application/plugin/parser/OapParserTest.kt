package oap.application.plugin.parser

import com.intellij.testFramework.ParsingTestCase

class OapParserTest : ParsingTestCase("parser", "oap", OapParserDefinition()) {
    override fun getTestDataPath(): String {
        return "testdata"
    }

    override fun doTest(suppressErrors: Boolean) {
        super.doTest(true)

        if (!suppressErrors) {
            assertFalse(
                "PsiFile contains error elements",
                toParseTreeText(myFile, skipSpaces(), includeRanges()).contains("PsiErrorElement")
            )
        }
    }

    fun testInclude() {
        doTest(false)
    }

    fun testInvalidServices() {
        doTest(true)
    }

    fun testParameters() {
        doTest(false)
    }

    fun testParametersArray1() {
        doTest(false)
    }

    fun testParametersMap() {
        doTest(false)
    }

    fun testParametersObjectComma() {
        doTest(false)
    }
}