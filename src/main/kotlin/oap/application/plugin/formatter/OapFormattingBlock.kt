package oap.application.plugin.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.tree.IElementType
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.lang.OapLanguage
import oap.application.plugin.psi.IndentNormal

class OapFormattingBlock(val formatter: OapFormatter, node: ASTNode, val myIndent: Indent?, wrap: Wrap?, alignment: Alignment?) : AbstractBlock(node, wrap, alignment) {
    override fun getDebugName(): String {
        return node.psi.toString()
    }

    private fun calcIndent(parent: ASTNode, child: ASTNode): Indent? {
        return when (child.psi) {
            is IndentNormal -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    override fun getIndent(): Indent? {
        return myIndent
    }

    override fun buildChildren(): List<Block?> {
        val blocks: MutableList<Block> = arrayListOf()
        var child: ASTNode? = myNode.firstChildNode
        while (child != null) {
            val childType: IElementType = child.elementType
            if (child.textRange.length == 0) {
                child = child.treeNext
                continue
            }
            if (childType == TokenType.WHITE_SPACE) {
                child = child.treeNext
                continue
            }

            val indent: Indent? = calcIndent(myNode, child)
            val e = OapFormattingBlock(formatter, child, indent, wrap, alignment)
            blocks.add(e)
            child = child.treeNext
        }
        return blocks
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        fun defaultSpace(keepBlankLines: Int): Spacing {
            return Spacing.createSpacing(0, 0, 0, true, keepBlankLines)
        }

        if (child1 == null) {
            return Spacing.createSpacing(0, 0, 0, true, 0);
        }

        return when ((child2 as OapFormattingBlock).myNode.elementType) {
            OapTypes.OAP_MODULE_SERVICES_SERVICE -> defaultSpace(0)

            OapTypes.OAP_MODULE_DEPENDS_ON -> defaultSpace(formatter.customSettings.KEEP_BLANK_LINES_BEFORE_DEPENDS_ON)
            OapTypes.OAP_MODULE_SERVICES -> defaultSpace(formatter.customSettings.KEEP_BLANK_LINES_BEFORE_SERVICES)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION ->
                defaultSpace(0)

            OapTypes.OAP_MODULE_CONFIGURATIONS -> defaultSpace(formatter.customSettings.KEEP_BLANK_LINES_BEFORE_CONFIGURATIONS)

            else -> SpacingBuilder(formatter.settings, OapLanguage)
                .before(OapTypes.OAP_EQ).spaceIf(formatter.customSettings.SPACE_BEFORE_ASSIGNMENT)
                .after(OapTypes.OAP_EQ).spaceIf(formatter.customSettings.SPACE_AFTER_ASSIGNMENT)

                .before(OapTypes.OAP_LEFTBRACE).spaces(1)
                .before(OapTypes.OAP_RIGHTBRACE).spacing(0, 0, 0, true, formatter.customSettings.KEEP_BLANK_LINES_BEFORE_RBRACE)
                .before(OapTypes.OAP_RIGHTBRACKET).spacing(0, 0, 0, true, formatter.customSettings.KEEP_BLANK_LINES_BEFORE_RBRACKET)

                .getSpacing(this, child1, child2)
        }
    }

    override fun isLeaf(): Boolean {
        return myNode.firstChildNode == null
    }

}