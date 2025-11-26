package oap.application.plugin.editor

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.stub.OapModuleServicesServiceIndex

class JavaOapServiceLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is PsiClass) {
            val services: Collection<OapModuleServicesService>? = element.qualifiedName?.let {
                StubIndex
                    .getElements(OapModuleServicesServiceIndex.KEY, it, element.project, GlobalSearchScope.allScope(element.project), OapModuleServicesService::class.java);
            }

            if (services != null) {
                return NavigationGutterIconBuilder
                    .create(AllIcons.Nodes.Services)
                    .setTargets(services)
                    .setTooltipText("Service implementation")
                    .setAlignment(GutterIconRenderer.Alignment.RIGHT)
                    .createLineMarkerInfo(element)
            }
        }

        return null;
    }
}
