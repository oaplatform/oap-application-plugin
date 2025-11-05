package oap.application.plugin.psi

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import oap.application.plugin.gen.psi.OapIdValue
import oap.application.plugin.stub.OapModuleNameStub

abstract class OapModuleNameMixin : StubBasedPsiElementBase<OapModuleNameStub>, OapKeyValuePair, PsiNamedElement {
    constructor(node: ASTNode) : super(node)

    fun getModuleName(): String? {
        return _findChildByClass(OapIdValue::class.java)?.text
    }

    override fun getName(): String? {
        return getModuleName()
    }

    override fun setName(name: String): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return javaClass.getSimpleName() + "(" + node.getElementType() + ")"
    }

}