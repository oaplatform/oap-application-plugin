package oap.application.plugin.psi.impl

import com.intellij.psi.tree.IElementType
import oap.application.plugin.stub.types.OapModuleNameStubElementType

object OapElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        return when (name) {
            "OAP_MODULE_NAME" -> return OapModuleNameStubElementType(name)
            else -> throw RuntimeException("Unknown element type: $name")
        }
    }
}