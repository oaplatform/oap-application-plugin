package oap.application.plugin.psi

import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.gen.psi.OapBlockScalarValue

class OapBlockScalarValueTest : OapFixtureTestCase() {
    private fun scalarTexts(text: String): List<String> {
        val file: PsiFile = myFixture.configureByText("testScalar.oap", text)
        return PsiTreeUtil.findChildrenOfType(file, OapBlockScalarValue::class.java)
            .map { it.scalarText }
    }

    fun testLiteralClip() {
        val texts = scalarTexts(
            """
            name = testLiteralClip
            services {
              test-master {
                implementation = oap.application.plugin.TestService
                parameters:
                  description: |
                    line one
                    line two
              }
            }
            """.trimIndent()
        )
        assertEquals("line one\nline two\n", texts[0])
    }

    fun testLiteralStrip() {
        val texts = scalarTexts(
            """
            name = testLiteralStrip
            services {
              test-master {
                implementation = oap.application.plugin.TestService
                parameters:
                  raw: |-
                    no trailing newline
              }
            }
            """.trimIndent()
        )
        assertEquals("no trailing newline", texts[0])
    }

    fun testLiteralKeep() {
        val texts = scalarTexts(
            """
            name = testLiteralKeep
            services {
              test-master {
                implementation = oap.application.plugin.TestService
                parameters:
                  keep: |+
                    keep trailing blanks


                  after: true
              }
            }
            """.trimIndent()
        )
        assertEquals("keep trailing blanks\n\n\n", texts[0])
    }

    fun testFolded() {
        val texts = scalarTexts(
            """
            name = testFolded
            services {
              test-master {
                implementation = oap.application.plugin.TestService
                parameters:
                  summary: >
                    folded
                    onto one line
              }
            }
            """.trimIndent()
        )
        assertEquals("folded onto one line\n", texts[0])
    }

    fun testFoldedMoreIndentedLineStaysLiteral() {
        val texts = scalarTexts(
            """
            name = testFoldedMoreIndentedLineStaysLiteral
            services {
              test-master {
                implementation = oap.application.plugin.TestService
                parameters:
                  summary: >
                    normal line

                        literal line
                    normal again
              }
            }
            """.trimIndent()
        )
        assertEquals("normal line\n    literal line\nnormal again\n", texts[0])
    }
}
