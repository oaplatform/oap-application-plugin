package oap.application.plugin.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object OapHighlighterColors {
    val BadCharacter = key("OAP_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    val Boolean = key("OAP_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD)
    val QuotedString = key("OAP_QUOTED_STRING", DefaultLanguageHighlighterColors.STRING)
    val Duration = key("OAP_DURATION", DefaultLanguageHighlighterColors.LABEL)
    val ClassValue = key("OAP_CLASS_VALUE", DefaultLanguageHighlighterColors.CLASS_NAME)

    val Brackets = key("OAP_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val Eq = key("OAP_EQ", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    //
    val ModuleName = key("OAP_MODULE_NAME", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleDependsOn = key("OAP_MODULE_DEPENDS_ON", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleDependsOnModuleName = key("OAP_MODULE_DEPENDS_ON_MODULE_NAME", DefaultLanguageHighlighterColors.LABEL)

    val Include = key("OAP_INCLUDE", DefaultLanguageHighlighterColors.KEYWORD)
    val Required = key("OAP_REQUIRED", DefaultLanguageHighlighterColors.KEYWORD)

    val ModuleServices = key("OAP_MODULE_SERVICES", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleService = key("OAP_MODULE_SERVICE", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
    val ModuleServiceEnabled = key("OAP_MODULE_SERVICE_ENABLED", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceImplementation = key("OAP_MODULE_SERVICE_IMPLEMENTATION", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceDependsOn = key("OAP_MODULE_SERVICE_DEPENDS_ON", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceDependsOnServiceName = key("OAP_MODULE_SERVICE_DEPENDS_ON_SERVICE_NAME", DefaultLanguageHighlighterColors.LABEL)
    val ModuleServiceListen = key("OAP_MODULE_SERVICES_SERVICE_LISTEN", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceParameters = key("OAP_MODULE_SERVICES_SERVICE_PARAMETERS", DefaultLanguageHighlighterColors.KEYWORD)


    val ReferenceModuleService = key("OAP_REFERENCE_MODULES_VALUE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
    val ReferenceKernel = key("OAP_REFERENCE_KERNEL_VALUE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)


    val ModuleServiceSupervision = key("OAP_MODULE_SERVICE_SUPERVISION", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceSupervisionSupervise = key("OAP_MODULE_SERVICE_SUPERVISION_SUPERVISE", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceSupervisionSchedule = key("OAP_MODULE_SERVICE_SUPERVISION_SCHEDULE", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceSupervisionThread = key("OAP_MODULE_SERVICE_SUPERVISION_THREAD", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceSupervisionCron = key("OAP_MODULE_SERVICE_SUPERVISION_THREAD", DefaultLanguageHighlighterColors.KEYWORD)
    val ModuleServiceSupervisionDelay = key("OAP_MODULE_SERVICE_SUPERVISION_DELAY", DefaultLanguageHighlighterColors.KEYWORD)

    val WsService = key("OAP_MODULE_SERVICE_WS_SERVICE", DefaultLanguageHighlighterColors.KEYWORD)
    val WsServicePath = key("OAP_MODULE_SERVICE_WS_SERVICE_PATH", DefaultLanguageHighlighterColors.KEYWORD)
    val WsServiceEnabled = key("OAP_MODULE_SERVICE_WS_SERVICE_ENABLED", DefaultLanguageHighlighterColors.KEYWORD)
    val WsServiceSessionAware = key("OAP_MODULE_SERVICE_WS_SERVICE_SESSIONAWARE", DefaultLanguageHighlighterColors.KEYWORD)
    val WsServicePort = key("OAP_MODULE_SERVICE_WS_SERVICE_PORT", DefaultLanguageHighlighterColors.KEYWORD)
    val WsServiceInterceptors = key("OAP_MODULE_SERVICE_WS_SERVICE_INTERCEPTORS", DefaultLanguageHighlighterColors.KEYWORD)

    private fun key(name: String, prototype: TextAttributesKey): TextAttributesKey {
        return TextAttributesKey.createTextAttributesKey(name, prototype)
    }
}