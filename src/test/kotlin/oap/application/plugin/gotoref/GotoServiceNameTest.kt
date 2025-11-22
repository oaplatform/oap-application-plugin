package oap.application.plugin.gotoref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import oap.application.plugin.OapFixtureTestCase
import oap.application.plugin.gen.psi.OapModuleServicesService
import org.assertj.core.api.Assertions.assertThat

class GotoServiceNameTest : OapFixtureTestCase() {
    fun testGotoServiceDependsOn() {
        myFixture.configureByText(
            "testGotoServiceDependsOn.oap", """
            name = module1
            services {
              service1.implementation = oap.application.plugin.TestService
              service2 {
                implementation = oap.application.plugin.TestService
                dependsOn = service<caret>1
              }
            }
        """.trimIndent()
        )

        checkService("service1")
    }

    fun testGotoServiceReferenceModuleThis() {
        myFixture.configureByText(
            "testGotoServiceReferenceModuleThis.oap", """
            name = module1
            services {
              service1.implementation = oap.application.plugin.TestService
              service2 {
                implementation = oap.application.plugin.TestService
                parameters.ref = <modules.this.service<caret>1>
              }
            }
        """.trimIndent()
        )

        checkService("service1")
    }

    fun testGotoServiceReferenceModule() {
        myFixture.configureByText(
            "testGotoServiceReferenceModule1.oap", """
            name = module1
            services {
              module1-service1.implementation = oap.application.plugin.TestService
              service2 {
                implementation = oap.application.plugin.TestService
                parameters.ref = <modules.module1.service<caret>1>
              }
            }
        """.trimIndent()
        )

        val file: PsiFile = myFixture.configureByText(
            "testGotoServiceReferenceModule2.oap", """
            name = module2
            services {
              service1.implementation = oap.application.plugin.TestService
              service2 {
                implementation = oap.application.plugin.TestService
                parameters.ref = <modules.module1.module1-service<caret>1>
              }
            }
        """.trimIndent()
        )

        myFixture.openFileInEditor(file.virtualFile)

        checkService("module1-service1")
    }

    private fun checkService(serviceName: String) {
        val focusedElement: PsiElement = myFixture.getFile().findElementAt(myFixture.getEditor().getCaretModel().getOffset())!!
        val reference: PsiReference? = focusedElement.reference ?: focusedElement.parent.reference

        val psiElement: PsiElement? = reference?.resolve()
        assertThat(psiElement).isInstanceOf(OapModuleServicesService::class.java)
        assertThat((psiElement as? OapModuleServicesService)?.serviceName?.text).isEqualTo(serviceName)
    }
}