package oap.application.plugin.misc

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import oap.application.plugin.gen.OapTypes

class OapBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<out BracePair?> {
        return arrayOf(
            BracePair(OapTypes.OAP_LEFTBRACE, OapTypes.OAP_RIGHTBRACE, true),
            BracePair(OapTypes.OAP_LEFTBRACKET, OapTypes.OAP_RIGHTBRACKET, false),
            BracePair(OapTypes.OAP_LEFTANGLE, OapTypes.OAP_RIGHTANGLE, false)
        )
    }

    private val AllowsPairedBraceBefore: TokenSet = TokenSet.orSet(TokenSet.create(OapTypes.OAP_RIGHTBRACKET), TokenSet.create(OapTypes.OAP_RIGHTBRACE))

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
        return AllowsPairedBraceBefore.contains(contextType)
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}