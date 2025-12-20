package oap.application.plugin.highlight

import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.NlsContexts
import org.jetbrains.annotations.NonNls
import oap.application.plugin.lang.OapLanguage
import javax.swing.Icon

class OapColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon {
        return AllIcons.FileTypes.Config
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return SyntaxHighlighterFactory.getSyntaxHighlighter(OapLanguage, null, null)
    }

    override fun getDemoText(): @NonNls String {
        return """<badchar>*</badchar>
            |<modulename>name</modulename> <eq>=</eq> module-name
            |
            |<moduledependson>dependsOn</moduledependson> <eq>=</eq> [
            |  <module_dependson_module_name>a</module_dependson_module_name>
            |  <module_dependson_module_name>b</module_dependson_module_name>
            |]
            |
            |<include>include</include> <required>required</required>("resource")
            |
            |<moduleservices>services</moduleservices> <brackets>{</brackets>
            |  <moduleservice>service-name</moduleservice> <brackets>{</brackets>
            |    <service_enabled>enabled</service_enabled> <eq>=</eq> <Boolean>false</Boolean>
            |    <module_service_implementation>implementation</module_service_implementation> <eq>=</eq> <Class>org.test.Main</Class>
            |    <module_service_listen>listen</module_service_listen> <brackets>{</brackets>
            |      a = <<reference_module_service>modules.this.service1</reference_module_service>>
            |    <brackets>}</brackets>
            |    <module_service_parameters>parameters</module_service_parameters> <brackets>{</brackets>
            |      ref <eq>=</eq> <<reference_module_service>modules.this.service1</reference_module_service>>
            |      k <eq>=</eq> <<reference_kernel>kernel.self</reference_kernel>>
            |    <brackets>}</brackets>
            |    <ws_service>ws-service</ws_service> <brackets>{</brackets>
            |      <ws_service_enabled>enabled</ws_service_enabled> <eq>=</eq> <Boolean>true</Boolean>
            |      <ws_service_path>path</ws_service_path> <eq>=</eq> /test/a
            |      <ws_service_port>port</ws_service_port> <eq>=</eq> httpprivate
            |      <ws_service_sessionAware>sessionAware</ws_service_sessionAware> <eq>=</eq> <Boolean>true</Boolean>
            |      <ws_service_interceptors>interceptors</ws_service_interceptors> <eq>=</eq> [
            |        <<reference_module_service>modules.oap-ws-sso-api.oap-ws-sso-api-key-interceptor</reference_module_service>>
            |      ]
            |    <brackets>}</brackets>
            |    <module_service_supervision>supervision</module_service_supervision> <brackets>{</brackets>
            |      <module_services_supervision_supervise>supervise</module_services_supervision_supervise> <eq>=</eq> <Boolean>true</Boolean>
            |      <module_service_supervision_schedule>schedule</module_service_supervision_schedule> <eq>=</eq> <Boolean>true</Boolean>
            |      <module_service_supervision_thread>thread</module_service_supervision_thread> <eq>=</eq> <Boolean>true</Boolean>
            |      <module_service_supervision_cron>cron</module_service_supervision_cron> <eq>=</eq> <quotedstring>"10 * * * * ? *"</quotedstring>
            |      <module_service_supervision_delay>delay</module_service_supervision_delay> <eq>=</eq> <Duration>1s</Duration>
            |    <brackets>}</brackets>
            |  <brackets>}</brackets>
            |  
            |  <moduleservice>service-name-2</moduleservice> <brackets>{</brackets>
            |    <module_service_implementation>implementation</module_service_implementation> <eq>=</eq> <Class>org.test.Main</Class>
            |    <module_service_dependson>dependsOn</module_service_dependson> <eq>=</eq> <module_service_dependson_name>service-name</module_service_dependson_name>
            |  <brackets>}</brackets>
            |<brackets>}</brackets>
        """.trimMargin()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return linkedMapOf(
            "badchar" to OapHighlighterColors.BadCharacter,
            "brackets" to OapHighlighterColors.Brackets,
            "Boolean" to OapHighlighterColors.Boolean,
            "Duration" to OapHighlighterColors.Duration,
            "Class" to OapHighlighterColors.ClassValue,
            "eq" to OapHighlighterColors.Eq,
            "quotedstring" to OapHighlighterColors.QuotedString,

            "reference_module_service" to OapHighlighterColors.ReferenceModuleService,
            "reference_kernel" to OapHighlighterColors.ReferenceKernel,

            "modulename" to OapHighlighterColors.ModuleName,

            "moduledependson" to OapHighlighterColors.ModuleDependsOn,
            "module_dependson_module_name" to OapHighlighterColors.ModuleDependsOnModuleName,

            "include" to OapHighlighterColors.Include,
            "required" to OapHighlighterColors.Required,

            "moduleservices" to OapHighlighterColors.ModuleServices,
            "moduleservice" to OapHighlighterColors.ModuleService,
            "service_enabled" to OapHighlighterColors.ModuleServiceEnabled,
            "module_service_implementation" to OapHighlighterColors.ModuleServiceImplementation,
            "module_service_dependson" to OapHighlighterColors.ModuleServiceDependsOn,
            "module_service_dependson_name" to OapHighlighterColors.ModuleServiceDependsOnServiceName,
            "module_service_listen" to OapHighlighterColors.ModuleServiceListen,
            "module_service_parameters" to OapHighlighterColors.ModuleServiceParameters,

            "ws_service" to OapHighlighterColors.WsService,
            "ws_service_enabled" to OapHighlighterColors.WsServiceEnabled,
            "ws_service_path" to OapHighlighterColors.WsServicePath,
            "ws_service_port" to OapHighlighterColors.WsServicePort,
            "ws_service_sessionAware" to OapHighlighterColors.WsServiceSessionAware,
            "ws_service_interceptors" to OapHighlighterColors.WsServiceInterceptors,

            "module_service_supervision" to OapHighlighterColors.ModuleServiceSupervision,
            "module_services_supervision_supervise" to OapHighlighterColors.ModuleServiceSupervisionSupervise,
            "module_service_supervision_schedule" to OapHighlighterColors.ModuleServiceSupervisionSchedule,
            "module_service_supervision_thread" to OapHighlighterColors.ModuleServiceSupervisionThread,
            "module_service_supervision_cron" to OapHighlighterColors.ModuleServiceSupervisionCron,
            "module_service_supervision_delay" to OapHighlighterColors.ModuleServiceSupervisionDelay,
        )
    }

    override fun getAttributeDescriptors(): Array<out AttributesDescriptor?> {
        return OapColorSettingsPage.Attrs
    }

    override fun getColorDescriptors(): Array<out ColorDescriptor?> {
        return emptyArray()
    }

    override fun getDisplayName(): @NlsContexts.ConfigurableName String {
        return "OAP"
    }

    object OapColorSettingsPage {
        val Attrs: Array<AttributesDescriptor> = arrayOf(
            "Bad character" to OapHighlighterColors.BadCharacter,
//            "Null" to OapHighlighterColors.Null,
            "Boolean" to OapHighlighterColors.Boolean,
//            "Quoted string" to OapHighlighterColors.QuotedString,
            "Duration" to OapHighlighterColors.Duration,
            "Brackets" to OapHighlighterColors.Brackets,
            "Equals" to OapHighlighterColors.Eq,

            "Service Reference" to OapHighlighterColors.ReferenceModuleService,
            "Kernel Reference" to OapHighlighterColors.ReferenceKernel,

            "Module name" to OapHighlighterColors.ModuleName,
            "Module dependsOn" to OapHighlighterColors.ModuleDependsOn,
            "Module dependsOn [module name]" to OapHighlighterColors.ModuleDependsOnModuleName,

            "Module include" to OapHighlighterColors.Include,
            "Module include required" to OapHighlighterColors.Required,

            "Services" to OapHighlighterColors.ModuleServices,
            "Service Name" to OapHighlighterColors.ModuleService,
            "Service enabled/disabled" to OapHighlighterColors.ModuleServiceEnabled,
            "Service implementation" to OapHighlighterColors.ModuleServiceImplementation,
            "Service listen" to OapHighlighterColors.ModuleServiceListen,

            "Service ws-service" to OapHighlighterColors.WsService,
            "Service ws-service/enabled" to OapHighlighterColors.WsServiceEnabled,
            "Service ws-service/path" to OapHighlighterColors.WsServicePath,
            "Service ws-service/port" to OapHighlighterColors.WsServicePort,
            "Service ws-service/sessionAware" to OapHighlighterColors.WsServicePath,
            "Service ws-service/interceptors" to OapHighlighterColors.WsServiceInterceptors,

            "Service supervision" to OapHighlighterColors.ModuleServiceSupervision,
            "Service supervision/supervise" to OapHighlighterColors.ModuleServiceSupervisionSupervise,
            "Service supervision/schedule" to OapHighlighterColors.ModuleServiceSupervisionSchedule,
            "Service supervision/thread" to OapHighlighterColors.ModuleServiceSupervisionThread,
            "Service supervision/cron" to OapHighlighterColors.ModuleServiceSupervisionCron,
            "Service supervision/delay" to OapHighlighterColors.ModuleServiceSupervisionDelay,
        )
            .map { AttributesDescriptor(it.first, it.second) }
            .toTypedArray()

    }
}