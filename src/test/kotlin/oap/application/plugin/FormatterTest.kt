package oap.application.plugin

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.util.io.FileUtil
import com.intellij.psi.codeStyle.CodeStyleManager
import java.io.File

class FormatterTest : OapFixtureTestCase() {
    fun testArray() {
        doTest(true)
    }

    private fun doTest(format: Boolean) {
        val inputFile: String = getInputFileName()
        val inputText: String = FileUtil.loadFile(File(getTestDataPath() + inputFile));
        myFixture.configureByText(inputFile, inputText);

        if (format) {
            WriteCommandAction.runWriteCommandAction(myFixture.getProject()) {
                CodeStyleManager.getInstance(getProject()).reformat(myFixture.getFile())
            }
        } else {
            myFixture.type('\n')
        }

        val outputFile: File = File(myFixture.getTestDataPath() + "/" + getExpectedOutputFileName())
        if (!outputFile.exists()) {
            FileUtil.writeToFile(outputFile, "")
            System.err.println("Output file " + outputFile.getPath() + " doesn't exist. It was created.")
        }
        val expectedResultText: String = FileUtil.loadFile(outputFile, true)
        myFixture.checkResult(expectedResultText)
    }

    private fun getInputFileName(): String {
        return getTestName(true) + ".oap"
    }


    private fun getExpectedOutputFileName(): String {
        return getTestName(true) + "-after.oap"
    }

    protected override fun getTestDataPath(): String {
        return "testdata/formatter/"
    }

    protected override fun setUp() {
        super.setUp()
//        setTestStyleSettings()
    }

    public override fun tearDown() {
//        restoreStyleSettings()
        super.tearDown()
    }

//    private var myTemporarySettings: CodeStyleSettings? = null
//
//    private fun setTestStyleSettings() {
//        val settingsManager: CodeStyleSettingsManager = CodeStyleSettingsManager.getInstance(getProject())
//        val currSettings: CodeStyleSettings = settingsManager.getCurrentSettings()
//        assertNotNull(currSettings)
//        myTemporarySettings = currSettings.clone()
//        val indentOptions: IndentOptions = myTemporarySettings!!.getIndentOptions(OapFileType.OapFileType.INSTANCE)
//        assertNotNull(indentOptions)
//        settingsManager.setTemporarySettings(myTemporarySettings!!)
//    }
//
//    private fun restoreStyleSettings() {
//        CodeStyleSettingsManager.getInstance(getProject()).dropTemporarySettings()
//    }
}