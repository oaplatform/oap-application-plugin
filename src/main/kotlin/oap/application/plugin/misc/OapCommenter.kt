package oap.application.plugin.misc

import com.intellij.codeInsight.generation.CommenterDataHolder
import com.intellij.codeInsight.generation.SelfManagingCommenter
import com.intellij.lang.Commenter
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.util.text.CharArrayUtil

// OAP line comments accept either '//' or '#' (grammars/_OapLexer.flex COMMENT token).
// Commenter alone only supports one recognized prefix for uncommenting, so this implements
// SelfManagingCommenter to recognize both while defaulting new comments to '//'.
class OapCommenter : Commenter, SelfManagingCommenter<CommenterDataHolder> {
    companion object {
        private const val DEFAULT_PREFIX = "//"
        private val PREFIXES = listOf("//", "#")
    }

    override fun getLineCommentPrefix(): String = DEFAULT_PREFIX
    override fun getLineCommentPrefixes(): List<String> = PREFIXES

    override fun getBlockCommentPrefix(): String? = null
    override fun getBlockCommentSuffix(): String? = null
    override fun getCommentedBlockCommentPrefix(): String? = null
    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun createLineCommentingState(startLine: Int, endLine: Int, document: Document, file: PsiFile): CommenterDataHolder? = null
    override fun createBlockCommentingState(selectionStart: Int, selectionEnd: Int, document: Document, file: PsiFile): CommenterDataHolder? = null

    override fun commentLine(line: Int, offset: Int, document: Document, data: CommenterDataHolder) {
        document.insertString(offset, DEFAULT_PREFIX)
    }

    override fun uncommentLine(line: Int, offset: Int, document: Document, data: CommenterDataHolder) {
        val prefix = PREFIXES.firstOrNull { CharArrayUtil.regionMatches(document.charsSequence, offset, it) } ?: return
        document.deleteString(offset, offset + prefix.length)
    }

    override fun isLineCommented(line: Int, offset: Int, document: Document, data: CommenterDataHolder): Boolean =
        PREFIXES.any { CharArrayUtil.regionMatches(document.charsSequence, offset, it) }

    override fun getCommentPrefix(line: Int, document: Document, data: CommenterDataHolder): String {
        val lineStart = document.getLineStartOffset(line)
        val lineEnd = document.getLineEndOffset(line)
        val offset = CharArrayUtil.shiftForward(document.charsSequence, lineStart, lineEnd, " \t")
        return PREFIXES.firstOrNull { CharArrayUtil.regionMatches(document.charsSequence, offset, it) } ?: DEFAULT_PREFIX
    }

    override fun getBlockCommentRange(selectionStart: Int, selectionEnd: Int, document: Document, data: CommenterDataHolder): TextRange? =
        throw UnsupportedOperationException()

    override fun getBlockCommentPrefix(selectionStart: Int, document: Document, data: CommenterDataHolder): String? = null
    override fun getBlockCommentSuffix(selectionEnd: Int, document: Document, data: CommenterDataHolder): String? = null

    override fun uncommentBlockComment(startOffset: Int, endOffset: Int, document: Document, data: CommenterDataHolder) {
        throw UnsupportedOperationException()
    }

    override fun insertBlockComment(startOffset: Int, endOffset: Int, document: Document, data: CommenterDataHolder): TextRange? =
        throw UnsupportedOperationException()
}
