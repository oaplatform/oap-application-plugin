package oap.application.plugin.editor

import com.intellij.codeInsight.daemon.DefaultGutterIconNavigationHandler
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.util.FunctionUtil
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation
import oap.application.plugin.stub.OapModuleServicesServiceImplementationIndex
import java.util.function.Supplier

class JavaOapImplementationLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is PsiClass) {
            val services: Collection<OapModuleServicesServiceImplementation>? = element.qualifiedName?.let {
                StubIndex
                    .getElements(OapModuleServicesServiceImplementationIndex.KEY, it, element.project, GlobalSearchScope.allScope(element.project), OapModuleServicesServiceImplementation::class.java);
            }

            if( services != null ) {
                return NavigationGutterIconBuilder
                    .create(AllIcons.Nodes.Services)
                    .setTargets(services.map { it.parent })
                    .setTooltipText("Service implementation")
                    .setAlignment(GutterIconRenderer.Alignment.RIGHT)
                    .createLineMarkerInfo(element)
            }
        }

        return null;
    }
}
