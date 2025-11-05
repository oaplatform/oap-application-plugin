package oap.application.plugin.highlight

import com.intellij.lexer.LayeredLexer
import com.intellij.lexer.StringLiteralLexer
import com.intellij.psi.tree.IElementType
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.lexer.OapLexer

class OapHighlightingLexer : LayeredLexer(OapLexer()) {
    init {
        val stringLiteralLexer = StringLiteralLexer('\"', OapTypes.OAP_STRING)
        registerSelfStoppingLayer(
            stringLiteralLexer,
            arrayOf<IElementType?>(OapTypes.OAP_STRING),
            IElementType.EMPTY_ARRAY
        )
    }
}
