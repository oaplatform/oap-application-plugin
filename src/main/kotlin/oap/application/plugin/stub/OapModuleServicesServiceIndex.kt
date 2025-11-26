package oap.application.plugin.stub

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import oap.application.plugin.gen.psi.OapModuleServicesService

class OapModuleServicesServiceIndex : StringStubIndexExtension<OapModuleServicesService>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, OapModuleServicesService> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, OapModuleServicesService> = StubIndexKey.createIndexKey("oap.module.service")

        const val VERSION = 0
    }
}