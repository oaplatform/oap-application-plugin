package oap.application.plugin.psi

import andel.intervals.toReversedList
import com.intellij.lang.ASTNode
import com.intellij.psi.ContributedReferenceHost
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiQualifiedNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceService
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.gen.psi.OapIdValue
import oap.application.plugin.psi.impl.OapCompositeElementImpl

abstract class OapClassValueMixin(node: ASTNode) : OapCompositeElementImpl(node), OapValue, PsiQualifiedNamedElement, ContributedReferenceHost {
    fun getPsiClass(): PsiClass? {
        return text?.let { JavaPsiFacade.getInstance(getProject()).findClass(it, GlobalSearchScope.allScope(getProject())) }
    }

    override fun getQualifiedName(): String? {
        return generateSequence(this.parent) { it.parent }
            .takeWhile { it !is OapPsiFile }
            .map { (it.firstChild as? OapIdValue)?.text ?: "" }
            .toReversedList()
            .joinToString(separator = ".")
    }

    override fun getName(): String? {
        return text
    }

    override fun setName(name: String): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getReferences(): Array<out PsiReference?> {
        return PsiReferenceService.getService().getContributedReferences(this);
    }
}