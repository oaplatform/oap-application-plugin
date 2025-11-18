package oap.application.plugin.manipulators

import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.AbstractElementManipulator
import oap.application.plugin.gen.psi.OapClassNamePsi
import oap.application.plugin.psi.OapPsiElementFactory

class OapValueManipulator : AbstractElementManipulator<OapClassNamePsi>() {
    val ForbiddenChars: String = """$"{}[]:=,+#`^?!@*&\"""

    override fun handleContentChange(
        element: OapClassNamePsi,
        range: TextRange,
        newContent: String
    ): OapClassNamePsi? {
        val oldText: String = element.getText()
        val escapedContent: String = StringUtil.escapeStringCharacters(newContent)

        val needsQuoting: Boolean = (newContent.isEmpty() || newContent.startsWith(" ") || newContent.endsWith(" ")
                || newContent.any { ForbiddenChars.contains(it) } || escapedContent != newContent)

        val unquotedText: String = oldText.substring(0, range.getStartOffset()) + escapedContent + oldText.substring(range.getEndOffset())
        val quotedText: String = if (needsQuoting) "\"" + unquotedText + "\"" else unquotedText


        val newValue: OapClassNamePsi? = OapPsiElementFactory.createServiceImplementation(quotedText, element)

        if (newValue != null) {
            element.replace(newValue)
        }

        return newValue
    }
}