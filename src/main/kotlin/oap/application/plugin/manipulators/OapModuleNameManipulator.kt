package oap.application.plugin.manipulators

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import oap.application.plugin.gen.psi.OapModuleName

class OapModuleNameManipulator : AbstractElementManipulator<OapModuleName>() {
    override fun handleContentChange(
        element: OapModuleName,
        range: TextRange,
        newContent: String
    ): OapModuleName? {
        return null
    }
}