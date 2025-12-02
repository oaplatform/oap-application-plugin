package oap.application.plugin.manipulators

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import oap.application.plugin.gen.psi.OapParameterKeyValueFirstId
import oap.application.plugin.psi.IModuleName
import oap.application.plugin.psi.OapPsiElementFactory

class OapParameterKeyValueFirstIdManipulator : AbstractElementManipulator<OapParameterKeyValueFirstId>() {
    override fun handleContentChange(
        element: OapParameterKeyValueFirstId,
        range: TextRange,
        newContent: String
    ): OapParameterKeyValueFirstId? {
        return OapPsiElementFactory.replaceText(element, newContent);
    }
}