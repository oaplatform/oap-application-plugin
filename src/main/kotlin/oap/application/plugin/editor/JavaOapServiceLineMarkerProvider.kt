package oap.application.plugin.editor

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiIdentifier
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.stub.OapModuleServicesServiceIndex

class JavaOapServiceLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        // line markers must be registered on leaf elements: the class name identifier
        if (element !is PsiIdentifier) return null
        val psiClass = element.parent as? PsiClass ?: return null
        if (psiClass.nameIdentifier != element) return null

        val qualifiedName = psiClass.qualifiedName ?: return null
        // StubIndex.getElements returns an empty collection (never null) for classes no oap-module uses
        val services: Collection<OapModuleServicesService> = StubIndex
            .getElements(OapModuleServicesServiceIndex.KEY, qualifiedName, element.project, GlobalSearchScope.allScope(element.project), OapModuleServicesService::class.java)
        if (services.isEmpty()) return null

        return NavigationGutterIconBuilder
            .create(AllIcons.Nodes.Services)
            .setTargets(services)
            .setTooltipText("Service implementation")
            .setAlignment(GutterIconRenderer.Alignment.RIGHT)
            .createLineMarkerInfo(element)
    }
}
