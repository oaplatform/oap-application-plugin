package oap.application.plugin.ref

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.lexer.OapLexer

// Without a WordsScanner, .oap files are never indexed for identifier search, so renaming a Java
// field/constructor-parameter/setter that a .oap parameters{} key resolves to (via
// JvmNamedElementReference) has no way to discover that .oap usage at all.
class OapFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner =
        DefaultWordsScanner(OapLexer(), TokenSet.create(OapTypes.OAP_KEY_NAME), TokenSet.create(OapTypes.OAP_COMMENT), TokenSet.EMPTY)

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean = true

    override fun getHelpId(psiElement: PsiElement): String? = null

    override fun getType(element: PsiElement): String = ""

    override fun getDescriptiveName(element: PsiElement): String = element.text

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String = element.text
}
