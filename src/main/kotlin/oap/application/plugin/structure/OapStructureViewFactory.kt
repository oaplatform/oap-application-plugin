package oap.application.plugin.structure

import com.intellij.icons.AllIcons
import com.intellij.ide.structureView.*
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.OapModuleName
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.psi.impl.OapModuleServicesServiceImpl
import oap.application.plugin.psi.OapPsiFile
import org.jetbrains.annotations.Unmodifiable
import javax.swing.Icon

class OapStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return OapModel(psiFile, editor)
            }

            override fun isRootNodeShown(): Boolean {
                return true
            }
        }
    }
}

class OapModel(psiFile: PsiFile, editor: Editor?) : StructureViewModelBase(psiFile, OapStructureViewElement(psiFile)), StructureViewModel.ElementInfoProvider {
    init {
        withSuitableClasses(OapModuleServicesService::class.java)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return false;
    }

    override fun dispose() {
        super.dispose()
    }

}

class OapStructureViewElement(val e: PsiElement) : PsiTreeElementBase<PsiElement?>(e), NavigationItem {
    override fun getChildrenBase(): @Unmodifiable Collection<StructureViewTreeElement?> {
        val result: MutableList<StructureViewTreeElement> = arrayListOf()

        if (e is OapPsiFile) {
            val services: @Unmodifiable Collection<OapModuleServicesService> = PsiTreeUtil.findChildrenOfType(e, OapModuleServicesService::class.java)
            for (service: OapModuleServicesService in services) {
                result.add(OapStructureViewElement(service))
            }
        }

        return result
    }

    override fun getPresentableText(): String {
        return when (e) {
            is OapPsiFile -> PsiTreeUtil.findChildOfType(e, OapModuleName::class.java)?.text ?: "Unknown"
            is OapModuleServicesServiceImpl -> {
                val psiClass: PsiClass? = e.getImplementationClass()
                return e.getServiceName().text + (if (psiClass != null) "(${psiClass.qualifiedName})" else "")
            }

            else -> "Unknown"
        }
    }

    override fun getName(): String? {
        return null;
    }

    override fun getPresentation(): ItemPresentation {
        return this;
    }

    override fun getIcon(open: Boolean): Icon? {
        return when (e) {
            is OapPsiFile -> AllIcons.Nodes.Module
            is OapModuleServicesServiceImpl -> if (e.isEnabled()) AllIcons.Nodes.Class else AllIcons.Windows.Close
            else -> null
        }
    }

}