package oap.application.plugin.codestyle

import com.intellij.application.options.IndentOptionsEditor
import com.intellij.application.options.SmartIndentOptionsEditor
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.*
import oap.application.plugin.lang.OapLanguage

class OapLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getCodeSample(settingsType: SettingsType): String {
        return """
                name = module-name
                services {
                  service-a {
                    implementation = a.a.A
                  }
                }
                configurations = [
                  {
                    loader = a.a.Loader
                    config {
                      a = 23
                    }
                  }
                ]
            """.trimIndent()
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        fun showCustomOption(name: String, title: String, group: String, vararg options: Any) {
            consumer.showCustomOption(OapCustomCodeStyleSettings::class.java, name, title, group, options)
        }

        val codeStyleSettingsCustomizableOptions: CodeStyleSettingsCustomizableOptions = CodeStyleSettingsCustomizableOptions.getInstance()

        when (settingsType) {
            SettingsType.SPACING_SETTINGS -> {
                showCustomOption("SPACE_BEFORE_ASSIGNMENT", "Before assignment ('=' and '+=')", codeStyleSettingsCustomizableOptions.SPACES_AROUND_OPERATORS)
                showCustomOption("SPACE_AFTER_ASSIGNMENT", "After assignment ('=' and '+=')", codeStyleSettingsCustomizableOptions.SPACES_AROUND_OPERATORS)
            }

            SettingsType.WRAPPING_AND_BRACES_SETTINGS -> {
                consumer.showStandardOptions(CodeStyleSettingsCustomizable.WrappingOrBraceOption.KEEP_LINE_BREAKS.name)
            }

            SettingsType.BLANK_LINES_SETTINGS -> {
                showCustomOption("KEEP_BLANK_LINES_BEFORE_DEPENDS_ON", "Before 'dependsOn'", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
                showCustomOption("KEEP_BLANK_LINES_BEFORE_SERVICES", "Before 'services'", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
                showCustomOption("KEEP_BLANK_LINES_BEFORE_CONFIGURATIONS", "Before 'configurations'", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)

                showCustomOption("KEEP_BLANK_LINES_IN_OBJECTS", "In objects", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
                showCustomOption("KEEP_BLANK_LINES_BEFORE_RBRACE", "Before '}'", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
                showCustomOption("KEEP_BLANK_LINES_IN_LISTS", "In lists", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
                showCustomOption("KEEP_BLANK_LINES_BEFORE_RBRACKET", "Before ']'", codeStyleSettingsCustomizableOptions.BLANK_LINES_KEEP)
            }

            else -> {}
        }
    }

    override fun customizeDefaults(commonSettings: CommonCodeStyleSettings, indentOptions: CommonCodeStyleSettings.IndentOptions) {
        indentOptions.INDENT_SIZE = 2
        indentOptions.TAB_SIZE = 2
        indentOptions.CONTINUATION_INDENT_SIZE = 2
    }

    override fun getPriority(): DisplayPriority {
        return DisplayPriority.COMMON_SETTINGS
    }

    override fun getLanguage(): Language {
        return OapLanguage
    }

    override fun getIndentOptionsEditor(): IndentOptionsEditor {
        return SmartIndentOptionsEditor()
    }

}