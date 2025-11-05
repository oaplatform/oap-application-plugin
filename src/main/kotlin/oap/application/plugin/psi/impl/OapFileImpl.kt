package oap.application.plugin.psi.impl

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.scratch.ScratchUtil
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import oap.application.plugin.lang.OapLanguage
import oap.application.plugin.psi.OapFile

class OapFileImpl(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, OapLanguage), OapFile, PsiNameIdentifierOwner {
    override fun getFileType(): FileType {
        val fileType = getViewProvider().getFileType()
        if (ScratchUtil.isScratch(getViewProvider().getVirtualFile())) return fileType
//        if (fileType !is OapFileType && ApplicationManager.getApplication().isUnitTestMode()) {
//            return getFileTypeForTests()
//        }
        return fileType
    }

    override fun getNameIdentifier(): PsiElement? {
        return null //intellij-erlang: hack for inplace rename: InplaceRefactoring#getVariable()
    }
}