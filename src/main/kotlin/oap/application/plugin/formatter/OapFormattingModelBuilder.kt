package oap.application.plugin.formatter

import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.formatter.FormattingDocumentModelImpl
import com.intellij.psi.formatter.PsiBasedFormattingModel

class OapFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val psiElement: PsiElement = formattingContext.psiElement
        val containingFile: PsiFile = psiElement.containingFile
        val block = OapFormattingBlock(OapFormatter (formattingContext.codeStyleSettings), psiElement.node, null, null, null)
        return PsiBasedFormattingModel(containingFile, block, FormattingDocumentModelImpl.createOn(containingFile))
    }

    override fun getRangeAffectingIndent(file: PsiFile?, offset: Int, elementAtOffset: ASTNode?): TextRange? {
        return elementAtOffset?.textRange
    }
}