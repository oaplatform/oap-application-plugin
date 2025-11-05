package oap.application.plugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.lexer.LookAheadLexer
import com.intellij.lexer.MergingLexerAdapter
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.gen.parser.OapParser
import oap.application.plugin.gen.parser._OapLexer
import oap.application.plugin.stub.types.OapFileElementType
import oap.application.plugin.psi.OapPsiFile

class OapParserDefinition : ParserDefinition {
    val WS: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENT: TokenSet = TokenSet.create(OapTypes.OAP_COMMENT)

    override fun createLexer(project: Project): Lexer {
        return OapLexer(project)
    }

    override fun createParser(project: Project?): PsiParser {
        return OapParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return OapFileElementType
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENT
    }

    override fun getStringLiteralElements(): TokenSet {
//        return OapTokenSets.StringLiteral.tokenSet
        return TokenSet.EMPTY
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WS;
    }

    override fun createElement(node: ASTNode): PsiElement {
        return OapTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return OapPsiFile(viewProvider)
    }
}

class OapLexer(project: Project) : LookAheadLexer(MergingLexerAdapter(FlexAdapter(_OapLexer(null)), TokenSet.EMPTY)) {

}