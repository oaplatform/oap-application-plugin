package oap.application.plugin.psi

import com.intellij.psi.PsiClass
import oap.application.plugin.psi.OapClassValueMixin

interface OapKeyValueClass : OapKeyValuePair {
    fun getPsiClass(): PsiClass? {
        return _findChildByClass(OapClassValueMixin::class.java)?.getPsiClass()
    }
}