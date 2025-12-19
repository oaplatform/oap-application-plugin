package oap.application.plugin.gotoref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.gen.psi.OapModuleNamePair
import oap.application.plugin.gen.psi.OapModuleServicesService
import org.assertj.core.api.Assertions

class GotoIncludeTest : OapFixtureTestCase() {
    fun testGotoInclude() {
        val file1: PsiFile = myFixture.configureByText(
            "testInclude.oap", """
            name = module1
            include required("inc<caret>lude")
        """.trimIndent()
        )

        val file2: PsiFile = myFixture.configureByText(
            "include.oap", """
            name = include
            services {
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file1.virtualFile)

        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        Assertions.assertThat(psiElement).isInstanceOf(PsiFile::class.java)
        Assertions.assertThat(psiElement).isSameAs(file2)
    }
}