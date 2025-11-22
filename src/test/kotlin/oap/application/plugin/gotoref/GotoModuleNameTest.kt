package oap.application.plugin.gotoref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.gen.psi.OapModuleNamePair
import oap.application.plugin.gen.psi.OapModuleServicesService
import org.assertj.core.api.Assertions

class GotoModuleNameTest : OapFixtureTestCase() {
    fun testGotoModuleDependsOn() {
        val file1: PsiFile? = myFixture.configureByText(
            "testGotoModuleDependsOn1.oap", """
            name = module1
        """.trimIndent()
        )

        val file2: PsiFile = myFixture.configureByText(
            "testGotoModuleDependsOn2.oap", """
            name = testModule
            dependsOn = mod<caret>ule1
        """.trimIndent()
        )

        myFixture.openFileInEditor(file2.virtualFile)

        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        Assertions.assertThat(psiElement).isInstanceOf(OapModuleNamePair::class.java)
        Assertions.assertThat(psiElement?.containingFile).isSameAs(file1)
    }

    fun testGotoModuleReferenceThis() {
        myFixture.configureByText(
            "testGotoModuleReferenceThis.oap", """
            name = module1
            services {
              service1 {
                implementation = oap.application.plugin.TestService
                parameters.a = <modules.th<caret>is.service1>
              }            
            }
        """.trimIndent()
        )

        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        Assertions.assertThat((psiElement as? OapModuleNamePair)?.moduleName?.text).isEqualTo("module1")
    }

    fun testGotoModuleReferenceModuleName() {
        val file1: PsiFile = myFixture.configureByText(
            "testGotoModuleReferenceModuleName1.oap", """
            name = module1
            services {
              service1.implementation = oap.application.plugin.TestService
            }
        """.trimIndent()
        )

        val file2: PsiFile = myFixture.configureByText(
            "testGotoModuleReferenceModuleName2.oap", """
            name = module2
            services {
              service1 {
                implementation = oap.application.plugin.TestService
                parameters.a = <modules.mo<caret>dule1.service1>
              }            
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file2.virtualFile)

        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        Assertions.assertThat((psiElement as? OapModuleNamePair)?.moduleName?.text).isEqualTo("module1")
        Assertions.assertThat(psiElement?.containingFile).isSameAs(file1)
    }
}