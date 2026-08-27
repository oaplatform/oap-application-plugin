package oap.application.plugin.ref

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiParameter
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.search.UseScopeEnlarger

// PsiParameter.getUseScope() defaults to LocalSearchScope(declarationScope) - just the containing
// method - because plain Java semantics guarantee a parameter can't be referenced outside it. Our
// JvmNamedElementReference (constructor-parameter branch of GrammarPsiImplUtil.getReference) breaks
// that assumption: a .oap `parameters { name = value }` key can reference a constructor parameter
// from a completely different file. ReferencesSearch intersects with getUseScope() BEFORE any file
// scanning happens, so without this, rename/find-usages silently never even looks at .oap files for
// a constructor parameter (fields/setters aren't affected - their default use scope isn't this
// narrow). Mirrors the platform's own GradleUseScopeEnlarger, which solves the identical problem for
// Java elements referenced from Gradle build scripts.
//
// Deliberately NOT restricted to OapFileType via getScopeRestrictedByFileTypes(): that restriction
// is backed by the file-type index, which a light/synthetic test virtual file (and possibly a
// not-yet-indexed real file) never populates, silently making the enlarged scope exclude .oap files
// again - confirmed by reproducing it directly (GlobalSearchScope.allScope(project).contains(file)
// was true, but the file-type-restricted variant of the same scope was false for the identical
// file). OapFindUsagesProvider's WordsScanner already narrows real candidate files downstream, so
// this only needs to be broad enough to survive the LocalSearchScope union, not precise.
class OapUseScopeEnlarger : UseScopeEnlarger() {
    override fun getAdditionalUseScope(element: PsiElement): SearchScope? {
        if (element !is PsiParameter) return null
        return GlobalSearchScope.allScope(element.project)
    }
}
