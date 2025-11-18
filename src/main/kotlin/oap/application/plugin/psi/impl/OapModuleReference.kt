package oap.application.plugin.psi.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import oap.application.plugin.gen.psi.OapModuleName

class OapModuleReference(moduleName: OapModuleName) : PsiReferenceBase<OapModuleName>(moduleName) {
    override fun resolve(): PsiElement? {
        return myElement
    }
}