package oap.application.plugin.editor

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.psi.OapClassValueMixin

class OapImplementationLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is OapModuleServicesServiceImplementation) {

            return NavigationGutterIconBuilder
                .create(AllIcons.Nodes.Class)
                .setTargets(listOf((element.classNamePsi as OapClassValueMixin).getPsiClass()))
                .setTooltipText("Service implementation")
                .setAlignment(GutterIconRenderer.Alignment.RIGHT)
                .createLineMarkerInfo(element)
        }

        return null
    }
}
