package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import org.assertj.core.api.Assertions.assertThat

class OapCompletionTest : OapFixtureTestCase() {
    override fun getBasePath(): String {
        return "completion"
    }

//    fun testModuleName() {
//        myFixture.configureByText("testModuleName.oap", "<caret>")
//        myFixture.complete(CompletionType.BASIC)
//
//        myFixture.checkResult("name")
//    }

    fun testAfterModuleName() {
        myFixture.configureByText(
            "testAfterModuleName.oap", """
            name = test

            <caret>
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(myFixture.lookupElementStrings!!, "enabled", "dependOn", "services", "configurations")
    }

    fun testReferenceId() {
        myFixture.configureByText(
            "testReferenceId.oap", """
            name = testReferenceId
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters.selfLink = <<caret>
                }
            }
        """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        assertSameElements(
            myFixture.lookupElementStrings!!, "services", "modules", "kernel"
        )
    }

    fun testReferenceIdM() {
        myFixture.configureByText(
            "testReferenceIdM.oap", """
            name = testReferenceIdM
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters.selfLink = <m<caret>
                }
            }
        """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        myFixture.checkResult(
            """
            name = testReferenceIdM
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters.selfLink = <modules
                }
            }
            """.trimIndent()
        )
    }

//    fun testReferenceIdModules() {
//        val file1: PsiFile = myFixture.configureByText(
//            "testReferenceIdModules1.oap", """
//            name = testReferenceIdModules1
//            services {
//                test-service {
//                    implementation = oap.application.plugin.TestService
//                    parameters.selfLink = <modules.<caret>
//                }
//            }
//            """.trimIndent()
//        )
//        myFixture.configureByText(
//            "testReferenceIdModules2.oap", """
//            name = testReferenceIdModules2
//            services {
//                test-service2.implementation = oap.application.plugin.TestService
//            }
//            """.trimIndent()
//        )
//
//        myFixture.openFileInEditor(file1.virtualFile)
//
//        myFixture.complete(CompletionType.BASIC)
//        assertThat(myFixture.lookupElementStrings!!).containsExactly("this", "testReferenceIdModules2")
//    }

    fun testReferenceIdMod_caret_ules() {
        myFixture.configureByText(
            "testReferenceIdMod_caret_ules.oap", """
            name = testReferenceIdMod_caret_ules
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters {
                      selfLink = <mod<caret>ules.this.test-service
                    }
                }
            }
        """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)

        myFixture.checkResult(
            """
            name = testReferenceIdMod_caret_ules
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters {
                      selfLink = <modules.this.test-service
                    }
                }
            }
            """.trimIndent()
        )
    }

    fun testReferenceServiceNameAnotherModule() {
        val file1: PsiFile = myFixture.configureByText(
            "testReferenceServiceNameAnotherModule1.oap", """
            name = testReferenceServiceNameAnotherModule1
            services {
                test-service {
                    implementation = oap.application.plugin.TestService
                    parameters.selfLink = <modules.testReferenceServiceNameAnotherModule2.<caret>
                }
            }
            """.trimIndent()
        )
        myFixture.configureByText(
            "testReferenceServiceNameAnotherModule2.oap", """
            name = testReferenceServiceNameAnotherModule2
            services {
                test-service2.implementation = oap.application.plugin.TestService
                test-service3.implementation = oap.application.plugin.TestService
            }
            """.trimIndent()
        )

        myFixture.openFileInEditor(file1.virtualFile)

        myFixture.complete(CompletionType.BASIC)
        assertThat(myFixture.lookupElementStrings!!).containsExactly("test-service2", "test-service3")
    }
}