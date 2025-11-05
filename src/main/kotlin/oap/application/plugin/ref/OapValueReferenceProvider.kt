package oap.application.plugin.ref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import oap.application.plugin.gen.psi.OapBoolValue
import oap.application.plugin.ref.OapPropertyLookupElement

class OapValueReferenceProvider : PsiReferenceProvider() {
    val vals = listOf("true", "false");

    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<out PsiReference?> {
        val elements: PsiReference = object : PsiReferenceBase<OapBoolValue>(element as OapBoolValue), PsiReference {
            override fun resolve(): PsiElement? {
                val myValue: String? = myElement?.text

                return if (vals.contains(myValue)) myElement else null
            }

            override fun getVariants(): Array<out Any?> {
                return vals.map { OapPropertyLookupElement(it) }.toTypedArray();
            }
        }
        return arrayOf(elements)
    }
}