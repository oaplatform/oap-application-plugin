package oap.application.plugin.codestyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class OapCustomCodeStyleSettings(container: CodeStyleSettings) : CustomCodeStyleSettings("OapCodeStyleSettings", container) {
    @JvmField
    var SPACE_BEFORE_ASSIGNMENT: Boolean = true

    @JvmField
    var SPACE_AFTER_ASSIGNMENT: Boolean = true


    //----------------- GENERAL --------------------
    @JvmField
    var KEEP_LINE_BREAKS: Boolean = true


    //BLANK LINES
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_DEPENDS_ON: Int = 1
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_SERVICES: Int = 1
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_CONFIGURATIONS: Int = 1

    @JvmField
    var KEEP_BLANK_LINES_IN_OBJECTS: Int = 0
    @JvmField
    var KEEP_BLANK_LINES_IN_LISTS: Int = 0
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_RBRACE: Int = 0
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_RBRACKET: Int = 0
}
