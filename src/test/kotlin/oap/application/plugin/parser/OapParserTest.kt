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

    fun testLineComment() {
        doTest(false)
    }


    fun testModuleConfigurations() {
        doTest(false)
    }

    fun testModuleConfigurationsArray() {
        doTest(false)
    }

    fun testModuleConfigurationsEmpty() {
        doTest(false)
    }

    fun testModuleConfigurationsInclude() {
        doTest(false)
    }

    fun testModuleConfigurationsPath() {
        doTest(false)
    }




    fun testModuleDependsOnList() {
        doTest(false)
    }

    fun testModuleDependsOnListError() {
        doTest(true)
    }

    fun testModuleDependsOnSingle() {
        doTest(false)
    }


    fun testParameters() {
        doTest(false)
    }

    fun testParametersArray1() {
        doTest(false)
    }

    fun testParametersArray2() {
        doTest(false)
    }

    fun testParametersArrayRefs() {
        doTest(false)
    }

    fun testParametersDotPath() {
        doTest(false)
    }

    fun testParametersDotPath2() {
        doTest(false)
    }

    fun testParametersMap() {
        doTest(false)
    }

    fun testParametersObjectComma() {
        doTest(false)
    }

    fun testRemote() {
        doTest(false)
    }

    fun testRemoteNameError() {
        doTest(true)
    }

    fun testService() {
        doTest(false)
    }

    fun testServiceDotImplementation() {
        doTest(false)
    }


    fun testWsServiceInterceptors() {
        doTest(false)
    }
}