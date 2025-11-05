package oap.application.plugin.stub.types

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import oap.application.plugin.lang.OapLanguage

abstract class OapStubElementType<S : StubElement<T>, T : PsiElement?>(debugName: String) : IStubElementType<S, T>(debugName, OapLanguage) {
    override fun getExternalId(): String {
        return "oap." + super.toString()
    }
}