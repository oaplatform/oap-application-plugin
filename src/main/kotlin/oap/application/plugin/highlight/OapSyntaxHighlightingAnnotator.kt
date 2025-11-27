package oap.application.plugin.highlight

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import oap.application.plugin.gen.OapTypes

class OapSyntaxHighlightingAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        fun annot(attrs: TextAttributesKey) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(attrs).create()
        }

        when (element.getNode().getElementType()) {
            OapTypes.OAP_EQ -> annot(OapHighlighterColors.Eq)
            OapTypes.OAP_BOOL_VALUE -> annot(OapHighlighterColors.Boolean)
            OapTypes.OAP_DURATION -> annot(OapHighlighterColors.Duration)
            OapTypes.OAP_STRING -> annot(OapHighlighterColors.QuotedString)
            OapTypes.OAP_CLASS_NAME -> annot(OapHighlighterColors.ClassValue)

            OapTypes.OAP_MODULE_NAME -> annot(OapHighlighterColors.ModuleName)

            OapTypes.OAP_ID_DEPENDS_ON -> annot(OapHighlighterColors.ModuleDependsOn)
            OapTypes.OAP_MODULE_DEPENDS_ON_NAME -> annot(OapHighlighterColors.ModuleDependsOnModuleName)

            OapTypes.OAP_ID_SERVICES -> annot(OapHighlighterColors.ModuleServices)
            OapTypes.OAP_SERVICE_NAME -> annot(OapHighlighterColors.ModuleService)
            OapTypes.OAP_ID_ENABLED -> annot(OapHighlighterColors.ModuleServiceEnabled)
            OapTypes.OAP_ID_IMPLEMENTATION -> annot(OapHighlighterColors.ModuleServiceImplementation)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_DEPENDSON_ID -> annot(OapHighlighterColors.ModuleServiceDependsOn)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_DEPENDSON_NAME -> annot(OapHighlighterColors.ModuleServiceDependsOnServiceName)
//            OapTypes.OAP_MODULE_SERVICES_SERVICE_LISTEN_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceListen)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_PARAMETERS_ID -> annot(OapHighlighterColors.ModuleServiceParameters)

            OapTypes.OAP_REFERENCE_MODULES_VALUE_IN -> annot(OapHighlighterColors.ReferenceModuleService)
            OapTypes.OAP_REFERENCE_KERNEL_VALUE_IN -> annot(OapHighlighterColors.ReferenceKernel)

            OapTypes.OAP_ID_SUPERVISION -> annot(OapHighlighterColors.ModuleServiceSupervision)
            OapTypes.OAP_ID_SUPERVISE -> annot(OapHighlighterColors.ModuleServiceSupervisionSupervise)
            OapTypes.OAP_ID_SCHEDULE -> annot(OapHighlighterColors.ModuleServiceSupervisionSchedule)
            OapTypes.OAP_ID_THREAD -> annot(OapHighlighterColors.ModuleServiceSupervisionThread)
            OapTypes.OAP_ID_CRON -> annot(OapHighlighterColors.ModuleServiceSupervisionCron)
            OapTypes.OAP_ID_DELAY -> annot(OapHighlighterColors.ModuleServiceSupervisionDelay)

            OapTypes.OAP_ID_WS_SERVICE -> annot(OapHighlighterColors.WsService)
            OapTypes.OAP_WSSERVICE_PATH_ID -> annot(OapHighlighterColors.WsServicePath)
            OapTypes.OAP_WSSERVICE_ENABLED_ID -> annot(OapHighlighterColors.WsServiceEnabled)
            OapTypes.OAP_WSSERVICE_SESSION_AWARE_ID -> annot(OapHighlighterColors.WsServiceSessionAware)
            OapTypes.OAP_WSSERVICE_PORT_ID -> annot(OapHighlighterColors.WsServicePort)
            OapTypes.OAP_WSSERVICE_INTERCEPTORS_ID -> annot(OapHighlighterColors.WsServiceInterceptors)

            else -> {}
        }
    }
}