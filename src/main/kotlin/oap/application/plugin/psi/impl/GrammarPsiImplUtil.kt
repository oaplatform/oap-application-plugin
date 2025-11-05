package oap.application.plugin.psi.impl

import oap.application.plugin.gen.psi.OapBoolValue
import oap.application.plugin.gen.psi.OapReferenceModulesValue

class GrammarPsiImplUtil {
    companion object {
        val pattern = Regex("""<modules\.(?<module>[^.]+)\.(?<service>[^>]+)>""")

        @JvmStatic
        fun getReferenceServiceName(ref: OapReferenceModulesValue): String? {
            return pattern.matchEntire(ref.text)?.groups["service"]?.value
        }

        @JvmStatic
        fun getReferenceModuleName(ref: OapReferenceModulesValue): String? {
            return pattern.matchEntire(ref.text)?.groups["module"]?.value
        }

        @JvmStatic
        fun getBooleanValue(ref: OapBoolValue): Boolean {
            return "true" == ref.text
        }

    }
}