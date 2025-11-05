package oap.application.plugin.formatter

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import oap.application.plugin.codestyle.OapCustomCodeStyleSettings
import oap.application.plugin.lang.OapLanguage

class OapFormatter(val settings: CodeStyleSettings) {
    val commonSettings: CommonCodeStyleSettings = settings.getCommonSettings(OapLanguage)
    val customSettings: OapCustomCodeStyleSettings = settings.getCustomSettings(OapCustomCodeStyleSettings::class.java)
}