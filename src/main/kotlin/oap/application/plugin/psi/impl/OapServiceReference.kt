package oap.application.plugin.psi.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import oap.application.plugin.gen.psi.OapModuleServicesService

class OapServiceReference(owner: PsiElement, val service: OapModuleServicesService) : PsiReferenceBase<PsiElement>(owner) {
    override fun resolve(): PsiElement {
        return service
    }
}