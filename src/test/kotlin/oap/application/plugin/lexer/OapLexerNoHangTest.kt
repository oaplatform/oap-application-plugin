package oap.application.plugin.lexer

import junit.framework.TestCase
import oap.application.plugin.highlight.OapHighlightingLexer
import org.assertj.core.api.Assertions.assertThat

// Regression test for a real "Lexer is not progressing after calling advance()" crash
// (com.intellij.diagnostic.PluginException from ValidatingLexerWrapper, used by
// OapHighlightingLexer for editor/diff highlighting) triggered by a config: dash-list-of-maps
// under configurations:. ParsingTestCase (see OapParserTest) never caught this because the
// parser's error recovery always makes forward progress one BAD_CHARACTER at a time; only the
// stricter same-(tokenType, startOffset, endOffset, state) repeat check used for highlighting
// flags a genuine zero-width infinite loop. Drives the same core lexer directly and bounds the
// iteration count so a reintroduced hang fails this test instead of only failing at runtime.
class OapLexerNoHangTest : TestCase() {
    private fun assertLexesWithoutHanging(text: String) {
        val lexer = OapHighlightingLexer()
        lexer.start(text)

        var iterations = 0
        val maxIterations = text.length * 4 + 1000
        var lastTuple: Quadruple? = null

        while (lexer.tokenType != null) {
            iterations++
            assertThat(iterations)
                .withFailMessage("Lexer did not terminate within $maxIterations iterations - likely an infinite loop")
                .isLessThan(maxIterations)

            val tuple = Quadruple(lexer.tokenType, lexer.tokenStart, lexer.tokenEnd, lexer.state)
            if (tuple == lastTuple) {
                fail("Lexer is not progressing: repeated $tuple")
            }
            lastTuple = tuple

            lexer.advance()
        }
    }

    private data class Quadruple(val tokenType: Any?, val start: Int, val end: Int, val state: Int)

    fun testConfigColonBlockArrayOfMapsLoaderEqDoesNotHang() {
        assertLexesWithoutHanging(
            """
            name = lightad-account-api

            dependsOn = []

            configurations:
              - loader = oap.json.ext.ExtDeserializer
                config:
                  - class: oap.ws.account.User
                    field: ext
                    abstract: oap.json.ext.Ext
                    implementation: com.lightad.LightadUserExt
                  - class: oap.ws.account.Organization
                    field: ext
                    abstract: oap.json.ext.Ext
                    implementation: com.lightad.LightadOrganizationExt
            """.trimIndent()
        )
    }
}
