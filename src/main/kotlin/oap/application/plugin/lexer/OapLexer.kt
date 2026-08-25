package oap.application.plugin.lexer

import com.intellij.lexer.FlexAdapter
import oap.application.plugin.gen.parser._OapLexer

class OapLexer : FlexAdapter(_OapLexer()) {
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        (flex as _OapLexer).resetIndentState()
        super.start(buffer, startOffset, endOffset, initialState)
    }
}