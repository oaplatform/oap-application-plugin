package oap.application.plugin.manipulators

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import oap.application.plugin.psi.IServiceName
import oap.application.plugin.psi.OapPsiElementFactory

class OapServiceNameManipulator : AbstractElementManipulator<IServiceName>() {
    override fun handleContentChange(
        element: IServiceName,
        range: TextRange,
        newContent: String
    ): IServiceName? {
        return OapPsiElementFactory.replaceText(element, newContent);
    }
}