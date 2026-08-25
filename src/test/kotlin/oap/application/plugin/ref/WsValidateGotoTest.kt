package oap.application.plugin.ref

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.OapFixtureTestCase
import org.assertj.core.api.Assertions.assertThat
import java.io.File

class WsValidateGotoTest : OapFixtureTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    private fun loadTestClass(): PsiClass {
        myFixture.configureByFile("oap/ws/validate/WsValidate.java")
        myFixture.configureByFile("oap/ws/validate/ValidationErrors.java")
        myFixture.configureByFile("oap/application/plugin/TestWsValidateService.java")
        val psiClass = JavaPsiFacade.getInstance(project)
            .findClass("oap.application.plugin.TestWsValidateService", GlobalSearchScope.allScope(project))
        return psiClass!!
    }

    private fun wsValidateLiteral(annotationOwner: PsiModifierListOwner): PsiLiteralExpression {
        val annotation: PsiAnnotation = annotationOwner.getAnnotation(WsValidateUtil.ANNOTATION_FQN)!!
        return annotation.parameterList.attributes[0].value as PsiLiteralExpression
    }

    fun testGotoMethodLevelValidator() {
        val psiClass = loadTestClass()
        val method = psiClass.findMethodsByName("methodLevelValid", false)[0]
        val literal = wsValidateLiteral(method)

        val resolved = literal.references.firstOrNull()?.resolve()
        assertThat(resolved).isInstanceOf(PsiMethod::class.java)
        assertThat((resolved as PsiMethod).name).isEqualTo("isValid")
    }

    fun testGotoParameterLevelValidator() {
        val psiClass = loadTestClass()
        val method = psiClass.findMethodsByName("parameterLevelValid", false)[0]
        val parameter = method.parameterList.parameters[0]
        val literal = wsValidateLiteral(parameter)

        val resolved = literal.references.firstOrNull()?.resolve()
        assertThat(resolved).isInstanceOf(PsiMethod::class.java)
        assertThat((resolved as PsiMethod).name).isEqualTo("oddParamValidator")
    }

    fun testGotoUnresolvedValidator() {
        val psiClass = loadTestClass()
        val method = psiClass.findMethodsByName("methodLevelUnresolved", false)[0]
        val literal = wsValidateLiteral(method)

        val resolved = literal.references.firstOrNull()?.resolve()
        assertThat(resolved).isNull()
    }
}
