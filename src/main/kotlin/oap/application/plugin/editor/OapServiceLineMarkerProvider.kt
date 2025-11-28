package oap.application.plugin.editor

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import oap.application.plugin.gen.psi.OapModuleServicesService
import oap.application.plugin.psi.OapClassValueMixin

class OapServiceLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is OapModuleServicesService) {
            val psiClass: PsiClass? = (element.moduleServicesServiceImplementation?.classNamePsi as? OapClassValueMixin)?.getPsiClass()

            if (psiClass != null) {
                return NavigationGutterIconBuilder
                    .create(AllIcons.Nodes.Class)
                    .setTargets(listOf(psiClass))
                    .setTooltipText(psiClass.qualifiedName!!)
                    .setAlignment(GutterIconRenderer.Alignment.RIGHT)
                    .createLineMarkerInfo(element.serviceName.keyName)
            }
        }

        return null
    }
}
