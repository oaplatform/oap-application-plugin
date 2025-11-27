package oap.application.plugin.parser

import com.intellij.platform.testFramework.core.FileComparisonFailedError
import com.intellij.testFramework.ParsingTestCase
import com.jetbrains.rd.util.string.println
import org.assertj.core.util.diff.DiffUtils
import org.assertj.core.util.diff.Patch


class OapParserTest : ParsingTestCase("parser", "oap", OapParserDefinition()) {
    override fun getTestDataPath(): String {
        return "testdata"
    }

    override fun doTest(suppressErrors: Boolean) {
        try {
            super.doTest(true)
        } catch (e: FileComparisonFailedError) {
//            println("actual:\n${e.actualStringPresentation}\n---\nexpected:\n${e.expectedStringPresentation}")
//
//            val actual: List<String> = e.actualStringPresentation.lines()
//            val expected: List<String> = e.expectedStringPresentation.lines()
//
//            val patch: Patch<String> = DiffUtils.diff(expected, actual)
//
//            for (delta in patch.getDeltas()) {
//                println(delta)
//            }

            throw e;
        }

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
    fun testInclude2() {
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


    fun testModuleEnabled() {
        doTest(false)
    }

    fun testModuleEnabledEqError() {
        doTest(true)
    }

    fun testModuleNameEqualError() {
        doTest(true)
    }

    fun testModuleNameNoEqualError() {
        doTest(true)
    }

    fun testModuleNoNameError() {
        doTest(true)
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

    fun testParametersEnv() {
        doTest(false)
    }

    fun testParametersErrorReference() {
        doTest(true)
    }

    fun testParametersFunctions() {
        doTest(false)
    }

    fun testParametersFunctionsArray() {
        doTest(false)
    }

    fun testParametersMap() {
        doTest(false)
    }

    fun testParametersObjectComma() {
        doTest(false)
    }

    fun testParametersValueDotNumber() {
        doTest(false)
    }


    fun testRemote() {
        doTest(false)
    }

    fun testRemoteTimeout() {
        doTest(false)
    }

    fun testRemoteDotName() {
        doTest(false)
    }

    fun testRemoteNameError() {
        doTest(true)
    }

    fun testService() {
        doTest(false)
    }

    fun testServiceAbstractDefault() {
        doTest(false)
    }

    fun testServiceDependsOn() {
        doTest(false)
    }

    fun testServiceDotImplementation() {
        doTest(false)
    }

    fun testServiceDotNames() {
        doTest(false)
    }

    fun testServiceImplementationPartialError() {
        doTest(true)
    }

    fun testServiceListen() {
        doTest(false)
    }

    fun testServiceNoImplementation() {
        doTest(true)
    }

    fun testServiceSupervisionErros() {
        doTest(true)
    }


    fun testSimpleModule() {
        doTest(false)
    }


    fun testWsHandler() {
        doTest(false)
    }
    fun testWsHandlerDotPath() {
        doTest(false)
    }
    fun testWsService() {
        doTest(false)
    }
    fun testWsServiceDotPath() {
        doTest(false)
    }
    fun testWsServiceEnabled() {
        doTest(false)
    }
    fun testWsServiceInterceptors() {
        doTest(false)
    }
    fun testWsServicePathArray() {
        doTest(false)
    }
}