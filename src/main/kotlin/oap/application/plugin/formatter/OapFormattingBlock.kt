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
    companion object {
        // Parent element types whose direct '-' child is a dash-list item marker spliced in by a
        // private *_block_item grammar rule (see calcIndent below for why these six specifically).
        private val DASH_LIST_PARENT_TYPES = setOf(
            OapTypes.OAP_MODULE_DEPENDS_ON,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_DEPENDSON,
            OapTypes.OAP_WSSERVICE_INTERCEPTORS,
            OapTypes.OAP_WSSERVICE_PATH,
            OapTypes.OAP_PARAMETER_KEY_VALUE,
            OapTypes.OAP_CONFIGURATION_KEY_VALUE_PAIR,
        )
    }

    override fun getDebugName(): String {
        return node.psi.toString()
    }

    private fun calcIndent(parent: ASTNode, child: ASTNode): Indent? {
        return when {
            child.psi is IndentNormal -> Indent.getNormalIndent()
            // Dash-list item markers ('- item') from the private *_block_item grammar rules
            // (dependsOn/interceptors/path/parameters/config dash-lists) are spliced in as bare
            // leaf children of the parent rule's node - a private bnf rule never gets its own PSI
            // class, so it can't declare implements=IndentNormal the way module_configuration_block
            // (the public configurations: block-array rule) does, and the leaf dash itself falls
            // into the else branch below by default. Indenting the dash leaf directly fixes that -
            // but ONLY for these six parent types: module_configuration_block already gets its
            // indent as a whole composite (dash + entries together, via its own IndentNormal), and
            // giving its dash leaf a second, separate Indent here double-indents it (confirmed by a
            // regression in testConfigurationsBlockArray when this was tried unconditionally).
            child.elementType == OapTypes.OAP_DASH && parent.elementType in DASH_LIST_PARENT_TYPES ->
                Indent.getNormalIndent()
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

    // A comment already flush at column 0 in the original source is left completely untouched
    // (e.g. flush-left to visually flag "everything below is disabled"); a comment at any other
    // original column still gets normal computed alignment. Keyed on the comment's own original
    // column, not on its position/neighbors - containingFile.text is the immutable snapshot the
    // formatting model was built from, so AST offsets line up with it.
    private fun isAtColumnZero(node: ASTNode): Boolean {
        val text = node.psi.containingFile.text
        var i = node.startOffset
        while (i > 0 && text[i - 1] != '\n') i--
        return i == node.startOffset
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        fun defaultSpace(keepBlankLines: Int): Spacing {
            return Spacing.createSpacing(0, 0, 0, true, keepBlankLines)
        }

        if ((child2 as OapFormattingBlock).myNode.elementType == OapTypes.OAP_COMMENT &&
            isAtColumnZero(child2.myNode)
        ) {
            return Spacing.getReadOnlySpacing()
        }

        if (child1 == null) {
            return Spacing.createSpacing(0, 0, 0, true, 0);
        }

        return when (child2.myNode.elementType) {
            OapTypes.OAP_MODULE_SERVICES_SERVICE -> defaultSpace(formatter.customSettings.KEEP_BLANK_LINES_BEFORE_SERVICES_SERVICE)

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