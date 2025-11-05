package oap.application.plugin.misc

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.tree.TokenSet
import oap.application.plugin.gen.OapTypes
import oap.application.plugin.psi.OapModuleServicesServiceMixin
import oap.application.plugin.psi.OapCompositeElement
import kotlin.collections.plusAssign

class OapFoldingBuilder : FoldingBuilder {
    override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
        val foldableTypes: TokenSet = TokenSet.create(
            OapTypes.OAP_MODULE_SERVICES_SERVICE,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_REMOTE,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_WSSERVICE,

            OapTypes.OAP_MODULE_CONFIGURATIONS,
            OapTypes.OAP_MODULE_CONFIGURATION
        )
        val buffer: MutableList<FoldingDescriptor> = mutableListOf()
        val iterator: Iterator<ASTNode> = depthFirst(node)
        while (iterator.hasNext()) {
            val n: ASTNode = iterator.next()
            if (foldableTypes.contains(n.elementType) && n.textLength > 0) {
                buffer.add( FoldingDescriptor(n, n.textRange) )
            }
        }
        return buffer.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        return when (node.elementType) {
            OapTypes.OAP_MODULE_SERVICES_SERVICE -> "{...} // ${(node.getPsi() as OapModuleServicesServiceMixin).getServiceName()}"

            OapTypes.OAP_MODULE_SERVICES_SERVICE_REMOTE,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION,
            OapTypes.OAP_MODULE_SERVICES_SERVICE_WSSERVICE,
            OapTypes.OAP_MODULE_CONFIGURATIONS,
            OapTypes.OAP_MODULE_CONFIGURATION -> "{...} // ${(node.getPsi() as OapCompositeElement).firstChild.text}"

            else -> null
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }

    fun depthFirst(root: ASTNode): Iterator<ASTNode> {
        return DepthFirstIterator(root)
    }

    private class DepthFirstIterator(node: ASTNode) : Iterator<ASTNode> {
        private val stack: ArrayDeque<ASTNode> = ArrayDeque(listOf(node))

        override fun next(): ASTNode {
            val element: ASTNode = stack.removeFirst()
            pushChildren(element)
            return element
        }

        override fun hasNext(): Boolean {
            return stack.isNotEmpty()
        }

        fun pushChildren(element: ASTNode) {
            var child: ASTNode? = element.lastChildNode
            while (child != null) {
                stack.addFirst(child)
                child = child.treePrev
            }
        }
    }
}