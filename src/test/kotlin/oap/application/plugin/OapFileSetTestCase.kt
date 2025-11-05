package oap.application.plugin

import com.intellij.FileSetTestCase
import com.intellij.application.options.CodeStyle
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.testFramework.EditorTestUtil
import com.intellij.util.LocalTimeCounter
import oap.application.plugin.lang.OapLanguage
import org.apache.commons.lang3.StringUtils
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

abstract class OapFileSetTestCase(path: String) : FileSetTestCase(TestdataPath + "/" + path) {
    override fun transform(testName: String, data: Array<String>): String {
        val settings: CommonCodeStyleSettings = CodeStyle.getSettings(myProject).getCommonSettings(OapLanguage)

        val indentOptions: CommonCodeStyleSettings.IndentOptions? = settings.getIndentOptions()
        indentOptions!!.INDENT_SIZE = 2
        indentOptions.CONTINUATION_INDENT_SIZE = 2
        indentOptions.TAB_SIZE = 2

        val st: Array<String> = Array(data.size) { i -> StringUtils.stripEnd(data[i], null) }

        return transform(st)
    }

    protected abstract fun transform(data: Array<String>): String

    protected fun createPseudoPhysicalFile(text: String, extension: String): PsiFile {
        val project: Project = myProject
        val tempFile: String = project.getBasePath() + "/temp." + extension
        val fileType: FileType = FileTypeManager.getInstance().getFileTypeByFileName(tempFile)
        return PsiFileFactory.getInstance(project)
            .createFileFromText(tempFile, fileType, text, LocalTimeCounter.currentTime(), true)
    }

    protected fun createPseudoPhysicalOapFile(text: String): PsiFile {
        return createPseudoPhysicalFile(text, "oap")
    }

    fun <T> inWriteCommandAction(body: () -> T): T {
        return WriteCommandAction.writeCommandAction(myProject).compute<T, RuntimeException>(body)
    }

    companion object {
        init {
            System.setProperty("fileset.pattern", "(.*)\\.oap")
        }

        private val TestdataPath: String

        init {
            TestdataPath = find(Paths.get(".")).toFile().getAbsolutePath()
        }

        private fun find(dir: Path?): Path {
            if (dir == null) {
                throw RuntimeException("testdata dir not found")
            } else {
                val td: Path = dir.resolve("testdata")

                if (Files.exists(td)) {
                    return td
                } else {
                    return find(dir.getParent())
                }
            }
        }

        fun extractCaret(fileText: String): Pair<String, Int> {
            val caretOffset: Int = fileText.indexOf(EditorTestUtil.CARET_TAG)

            val newFileText: String =
                if (caretOffset >= 0) fileText.substring(0, caretOffset) + fileText.substring(caretOffset + EditorTestUtil.CARET_TAG.length)
                else fileText

            return Pair(newFileText, caretOffset)
        }
    }
}