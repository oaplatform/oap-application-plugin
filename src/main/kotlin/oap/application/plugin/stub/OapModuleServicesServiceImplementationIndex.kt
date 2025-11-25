package oap.application.plugin.stub

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import oap.application.plugin.gen.psi.OapModuleServicesServiceImplementation

class OapModuleServicesServiceImplementationIndex : StringStubIndexExtension<OapModuleServicesServiceImplementation>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, OapModuleServicesServiceImplementation> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, OapModuleServicesServiceImplementation> = StubIndexKey.createIndexKey("oap.module.service.implementation")

        const val VERSION = 0
    }
}