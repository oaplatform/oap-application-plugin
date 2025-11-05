package oap.application.plugin.stub

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import oap.application.plugin.gen.psi.OapModuleName

class OapModuleNameIndex : StringStubIndexExtension<OapModuleName>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, OapModuleName> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, OapModuleName> = StubIndexKey.createIndexKey("oap.module.name")

        const val VERSION = 0
    }
}