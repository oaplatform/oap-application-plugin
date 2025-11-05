package oap.application.plugin.psi

import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.impl.source.PsiFileImpl
import com.intellij.psi.impl.source.PsiFileWithStubSupport
import oap.application.plugin.lang.OapFileType
import oap.application.plugin.parser.OapElementType

class OapPsiFile(provider: FileViewProvider) : PsiFileImpl(OapElementType.OapFileElementType, OapElementType.OapFileElementType, provider), PsiFileWithStubSupport {
    override fun getFileType(): FileType {
        return OapFileType.OapFileType.INSTANCE
    }

    override fun accept(visitor: PsiElementVisitor) {
        visitor.visitFile(this)
    }
}