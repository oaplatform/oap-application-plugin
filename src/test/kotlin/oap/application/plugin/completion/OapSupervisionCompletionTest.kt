package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionType
import oap.application.plugin.OapFixtureTestCase

class OapSupervisionCompletionTest : OapFixtureTestCase() {
    override fun getBasePath(): String {
        return "completion"
    }

    fun testAllKeysSuggestedWhenEmpty() {
        myFixture.configureByText(
            "testAllKeysSuggestedWhenEmpty.oap", """
            name = test

            services {
              s {
                implementation = a.B
                supervision {
                  <caret>
                }
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "supervise", "schedule", "thread", "delay", "cron"
        )
    }

    fun testPresentKeysExcluded() {
        myFixture.configureByText(
            "testPresentKeysExcluded.oap", """
            name = test

            services {
              s {
                implementation = a.B
                supervision {
                  supervise = true
                  schedule = true
                  <caret>
                }
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "thread", "delay", "cron"
        )
    }

    fun testPrefixFiltering() {
        myFixture.configureByText(
            "testPrefixFiltering.oap", """
            name = test

            services {
              s {
                implementation = a.B
                supervision {
                  s<caret>
                }
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "supervise", "schedule"
        )
    }

    fun testDotFormAllKeysSuggested() {
        myFixture.configureByText(
            "testDotFormAllKeysSuggested.oap", """
            name = test

            services {
              s {
                implementation = a.B
                supervision.<caret>
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "supervise", "schedule", "thread", "delay", "cron"
        )
    }

    fun testDotFormPrefixFiltering() {
        myFixture.configureByText(
            "testDotFormPrefixFiltering.oap", """
            name = test

            services {
              s {
                implementation = a.B
                supervision.s<caret>
              }
            }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!,
            "supervise", "schedule"
        )
    }
}
