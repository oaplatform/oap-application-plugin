package oap.application.plugin.psi

import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapClassNamePsi
import oap.application.plugin.lang.OapFileType

object OapPsiElementFactory {
    private val Dummy = "dummy.oap"

    fun createServiceImplementation(content: String, element: OapClassNamePsi): OapClassNamePsi? {
        val createFileFromText: PsiFile = PsiFileFactory.getInstance(element.project)
            .createFileFromText(
                Dummy, OapFileType.OapFileType.INSTANCE, """
                name = dummy
                services {
                  dummy.implementation = $content
                }
            """.trimIndent()
            )

        return PsiTreeUtil.findChildOfType(createFileFromText, OapClassNamePsi::class.java)
    }
}