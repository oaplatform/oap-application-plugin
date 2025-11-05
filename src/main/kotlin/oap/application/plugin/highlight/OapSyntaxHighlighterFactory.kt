package oap.application.plugin.highlight

import com.intellij.ide.highlighter.EmbeddedTokenHighlighter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.util.containers.MultiMap
import oap.application.plugin.gen.OapTypes

class OapSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return OapSyntaxHighlighterFactory;
    }

    object OapSyntaxHighlighterFactory : SyntaxHighlighterBase(), EmbeddedTokenHighlighter {
        private val tokenHighlights: Map<IElementType, TextAttributesKey> = mapOf(
            TokenType.BAD_CHARACTER to OapHighlighterColors.BadCharacter,
            OapTypes.OAP_COMMA to COMMA,
            OapTypes.OAP_EQ to EQ,
        )

        override fun getEmbeddedTokenAttributes(): MultiMap<IElementType, TextAttributesKey> {
            val map: MultiMap<IElementType, TextAttributesKey> = MultiMap.create()
            map.putAllValues(tokenHighlights)
            return map
        }

        override fun getHighlightingLexer(): Lexer {
            return OapHighlightingLexer()
        }

        override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
            return pack(BACKGROUND, tokenHighlights.get(tokenType));
        }
    }

    companion object {
        val BACKGROUND: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OAP.BACKGROUND", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR
        )
        val COMMA: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OAP.COMMA", DefaultLanguageHighlighterColors.COMMA
        )
        val EQ: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OAP.EQ", DefaultLanguageHighlighterColors.SEMICOLON
        )
    }
}