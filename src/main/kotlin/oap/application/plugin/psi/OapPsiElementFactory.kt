package oap.application.plugin.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.gen.psi.OapClassNamePsi
import oap.application.plugin.lang.OapFileType

object OapPsiElementFactory {
    private val Dummy = "dummy.oap"

    fun createServiceImplementation(content: String, element: OapClassNamePsi): OapClassNamePsi {
        val createFileFromText: PsiFile = PsiFileFactory.getInstance(element.project)
            .createFileFromText(
                Dummy, OapFileType.OapFileType.INSTANCE, """
                name = dummy
                services {
                  dummy.implementation = $content
                }
            """.trimIndent()
            )

        return PsiTreeUtil.findChildOfType(createFileFromText, OapClassNamePsi::class.java)!!
    }

    private fun <T : PsiElement> dummyChild(project: com.intellij.openapi.project.Project, snippet: String, targetClass: Class<T>): T {
        val dummyFile: PsiFile = PsiFileFactory.getInstance(project)
            .createFileFromText(Dummy, OapFileType.OapFileType.INSTANCE, snippet)

        return PsiTreeUtil.findChildOfType(dummyFile, targetClass)!!
    }

    fun <T> replaceText(element: T, newContent: String): T where T : PsiElement {
        val replacement: PsiElement = when (element.node.elementType) {
            OapTypes.OAP_MODULE_NAME ->
                dummyChild(element.project, "name = $newContent", element.javaClass)

            OapTypes.OAP_SERVICE_NAME ->
                dummyChild(element.project, "name = dummy\nservices {\n  $newContent {\n    implementation = a.B\n  }\n}", element.javaClass)

            OapTypes.OAP_PARAMETER_KEY_VALUE_FIRST_ID ->
                dummyChild(
                    element.project,
                    "name = dummy\nservices {\n  s {\n    implementation = a.B\n    parameters {\n      $newContent = \"x\"\n    }\n  }\n}",
                    element.javaClass
                )

            else -> TODO("not implemented")
        }

        @Suppress("UNCHECKED_CAST")
        return element.replace(replacement) as T
    }
}