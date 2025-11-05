package oap.application.plugin.psi

import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.extractMethod.newImpl.ExtractMethodHelper.addSiblingAfter
import oap.application.plugin.gen.psi.OapClassValue
import oap.application.plugin.gen.psi.OapIdValue
import oap.application.plugin.psi.OapCompositeElement
import oap.application.plugin.psi.OapValue

interface OapKeyValuePair : PsiElement, OapCompositeElement, PsiNamedElement {
    fun getId(): OapIdValue {
        return _findChildByClass(OapIdValue::class.java)!!
    }

    fun <T> _findChildByClass(aClass: Class<T>): T? where T : PsiElement {
        return PsiTreeUtil.findChildOfType(this, aClass)
    }

    fun getValueText(): String? {
        return _findChildByClass(OapValue::class.java)?.getText()
    }

    fun replaceValue(newKeyValue: OapKeyValuePair) {
        val error: PsiElement? = _findChildByClass(PsiErrorElement::class.java)
        if (error != null) {
            val clazz: OapClassValue = newKeyValue._findChildByClass(OapClassValue::class.java)!!
            while (clazz.nextSibling != null) {
                clazz.nextSibling.delete()
            }
            if (error.nextSibling is PsiWhiteSpace && !error.nextSibling.text.contains("\n")) {
                error.nextSibling.addSiblingAfter(clazz)
            } else {
                error.addSiblingAfter(clazz)
            }
            error.delete()
        } else {
            val clazz: OapClassValue = newKeyValue._findChildByClass(OapClassValue::class.java)!!
            _findChildByClass(OapClassValue::class.java)!!.replace(clazz)
        }
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }
}