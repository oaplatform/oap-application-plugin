package oap.application.plugin.stub

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import oap.application.plugin.gen.psi.OapModuleNamePair

class OapModuleNameIndex : StringStubIndexExtension<OapModuleNamePair>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, OapModuleNamePair> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, OapModuleNamePair> = StubIndexKey.createIndexKey("oap.module.name")

        const val VERSION = 0
    }
}