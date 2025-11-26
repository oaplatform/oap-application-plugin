package oap.application.plugin.psi.impl

import com.intellij.psi.tree.IElementType
import oap.application.plugin.stub.types.OapModuleNameStubElementType
import oap.application.plugin.stub.types.OapModuleServicesServiceStubElementType

object OapElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        return when (name) {
            "OAP_MODULE_NAME_PAIR" -> return OapModuleNameStubElementType(name)
            "OAP_MODULE_SERVICES_SERVICE" -> return OapModuleServicesServiceStubElementType(name)
            else -> throw RuntimeException("Unknown element type: $name")
        }
    }
}