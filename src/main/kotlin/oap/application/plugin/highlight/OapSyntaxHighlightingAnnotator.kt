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
            OapTypes.OAP_DURATION_VALUE -> annot(OapHighlighterColors.Duration)
            OapTypes.OAP_CLASS_VALUE -> annot(OapHighlighterColors.ClassValue)

            OapTypes.OAP_MODULE_NAME_ID_VALUE -> annot(OapHighlighterColors.ModuleName)

            OapTypes.OAP_MODULE_DEPENDS_ON_ID_VALUE -> annot(OapHighlighterColors.ModuleDependsOn)
            OapTypes.OAP_MODULE_DEPENDS_ON_MODULE_NAME -> annot(OapHighlighterColors.ModuleDependsOnModuleName)

            OapTypes.OAP_MODULE_SERVICES_ID_VALUE -> annot(OapHighlighterColors.ModuleServices)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_ID_VALUE -> annot(OapHighlighterColors.ModuleService)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_ENABLED_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceEnabled)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceImplementation)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_LISTEN_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceListen)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_PARAMETERS_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceParameters)

            OapTypes.OAP_REFERENCE_MODULES_VALUE -> annot(OapHighlighterColors.ReferenceModuleService)
            OapTypes.OAP_REFERENCE_KERNEL_VALUE -> annot(OapHighlighterColors.ReferenceKernel)

            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervision)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SUPERVISE_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervisionSupervise)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SCHEDULE_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervisionSchedule)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_THREAD_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervisionThread)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_CRON_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervisionCron)
            OapTypes.OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_DELAY_ID_VALUE -> annot(OapHighlighterColors.ModuleServiceSupervisionDelay)

            else -> {}
        }
    }
}