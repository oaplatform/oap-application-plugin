package oap.application.plugin.gotoref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiParameter
import com.intellij.psi.PsiReference
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.gen.psi.OapModuleServicesService
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import java.io.File

class GotoParameterTest : OapFixtureTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    fun testGotoField() {
        val javaFile: PsiFile = myFixture.configureByFile("oap/application/plugin/TestJavaService.java")

        val file: PsiFile = myFixture.configureByText(
            "testParameterAsField.oap", """
            name = testParameterAsField
            services {
              testParameterAsField {
                implementation = oap.application.plugin.TestJavaService
                parameters {
                  stri<caret>ngField = "dfg"
                }
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        assertThat(psiElement).isInstanceOf(PsiField::class.java)
        assertThat(psiElement?.containingFile).isSameAs(javaFile)
    }
}