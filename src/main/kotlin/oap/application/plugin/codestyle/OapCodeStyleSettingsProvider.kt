package oap.application.plugin.codestyle

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.*
import oap.application.plugin.lang.OapLanguage


class OapCodeStyleSettingsProvider : CodeStyleSettingsProvider() {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        return OapCustomCodeStyleSettings(settings)
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, "OAP") {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return object : TabbedLanguageCodeStylePanel(OapLanguage, getCurrentSettings(), settings) {}
            }
        }
    }

    override fun getConfigurableDisplayName(): String {
        return "OAP"
    }

    override fun getPriority(): DisplayPriority {
        return DisplayPriority.COMMON_SETTINGS
    }


}