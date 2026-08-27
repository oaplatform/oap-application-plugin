package oap.application.plugin.rename

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.OapFixtureTestCase
import org.assertj.core.api.Assertions.assertThat
import java.io.File

class RenameParameterTest : OapFixtureTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    fun testRenameOapKeyRenamesJavaField() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val oapFile: PsiFile = myFixture.configureByText(
            "testRenameOapKeyRenamesJavaField.oap", """
            name = testRenameOapKeyRenamesJavaField
            services {
              test-service {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  stri<caret>ngField = "dfg"
                }
              }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(oapFile.virtualFile)

        myFixture.renameElementAtCaret("renamedField")

        val psiClass = JavaPsiFacade.getInstance(project)
            .findClass("oap.application.plugin.TestJavaService", GlobalSearchScope.allScope(project))!!
        assertThat(psiClass.findFieldByName("renamedField", false)).isNotNull()
        assertThat(psiClass.findFieldByName("stringField", false)).isNull()
    }

    fun testRenameJavaFieldRenamesOapKey() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val oapFile: PsiFile = myFixture.configureByText(
            "testRenameJavaFieldRenamesOapKey.oap", """
            name = testRenameJavaFieldRenamesOapKey
            services {
              test-service {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  stringField = "dfg"
                }
              }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(oapFile.virtualFile)

        val psiClass = JavaPsiFacade.getInstance(project)
            .findClass("oap.application.plugin.TestJavaService", GlobalSearchScope.allScope(project))!!
        val field = psiClass.findFieldByName("stringField", false)!!

        myFixture.renameElement(field, "renamedField")

        val updatedText = oapFile.text
        assertThat(updatedText).contains("renamedField = \"dfg\"")
        assertThat(updatedText).doesNotContain("stringField")
    }

    fun testRenameJavaConstructorParameterRenamesOapKey() {
        myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val oapFile: PsiFile = myFixture.configureByText(
            "testRenameJavaConstructorParameterRenamesOapKey.oap", """
            name = testRenameJavaConstructorParameterRenamesOapKey
            services {
              test-service {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  constructor1StringField = "dfg"
                }
              }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(oapFile.virtualFile)

        val psiClass = JavaPsiFacade.getInstance(project)
            .findClass("oap.application.plugin.TestJavaService", GlobalSearchScope.allScope(project))!!
        val parameter = psiClass.constructors
            .flatMap { it.parameterList.parameters.toList() }
            .first { it.name == "constructor1StringField" }

        myFixture.renameElement(parameter, "renamedConstructorParam")

        val updatedText = oapFile.text
        assertThat(updatedText).contains("renamedConstructorParam = \"dfg\"")
        assertThat(updatedText).doesNotContain("constructor1StringField")
    }
}
