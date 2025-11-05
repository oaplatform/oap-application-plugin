// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import oap.application.plugin.psi.OapCompositeElement;
import oap.application.plugin.psi.IndentNormal;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;
import oap.application.plugin.psi.OapKeyValuePair;
import oap.application.plugin.psi.OapValue;

public class OapVisitor extends PsiElementVisitor {

  public void visitBoolValue(@NotNull OapBoolValue o) {
    visitValue(o);
  }

  public void visitClassPathParametersFunction(@NotNull OapClassPathParametersFunction o) {
    visitCompositeElement(o);
  }

  public void visitClassPathParametersFunctionResource(@NotNull OapClassPathParametersFunctionResource o) {
    visitCompositeElement(o);
  }

  public void visitClassValue(@NotNull OapClassValue o) {
    visitCompositeElement(o);
  }

  public void visitConfigArray(@NotNull OapConfigArray o) {
    visitCompositeElement(o);
  }

  public void visitConfigArrayObject(@NotNull OapConfigArrayObject o) {
    visitIndentNormal(o);
  }

  public void visitConfigObject(@NotNull OapConfigObject o) {
    visitCompositeElement(o);
  }

  public void visitConfigurationsConfigKeyValueIdOrPath(@NotNull OapConfigurationsConfigKeyValueIdOrPath o) {
    visitCompositeElement(o);
  }

  public void visitConfigurationsInclude(@NotNull OapConfigurationsInclude o) {
    visitIndentNormal(o);
  }

  public void visitCronValue(@NotNull OapCronValue o) {
    visitValue(o);
  }

  public void visitDotModuleServicesServiceLinkField(@NotNull OapDotModuleServicesServiceLinkField o) {
    visitCompositeElement(o);
  }

  public void visitDotRemote(@NotNull OapDotRemote o) {
    visitCompositeElement(o);
  }

  public void visitDotWsservicePath(@NotNull OapDotWsservicePath o) {
    visitCompositeElement(o);
  }

  public void visitDurationValue(@NotNull OapDurationValue o) {
    visitCompositeElement(o);
  }

  public void visitEnvVariable(@NotNull OapEnvVariable o) {
    visitCompositeElement(o);
  }

  public void visitIdValue(@NotNull OapIdValue o) {
    visitCompositeElement(o);
  }

  public void visitJsonParametersFunction(@NotNull OapJsonParametersFunction o) {
    visitCompositeElement(o);
  }

  public void visitJsonParametersFunctionBody(@NotNull OapJsonParametersFunctionBody o) {
    visitCompositeElement(o);
  }

  public void visitKeyValue(@NotNull OapKeyValue o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitLinkField(@NotNull OapLinkField o) {
    visitCompositeElement(o);
  }

  public void visitModuleConfiguration(@NotNull OapModuleConfiguration o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleConfigurationConfigIdValue(@NotNull OapModuleConfigurationConfigIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleConfigurationEntries(@NotNull OapModuleConfigurationEntries o) {
    visitCompositeElement(o);
  }

  public void visitModuleConfigurationEntriesConfig(@NotNull OapModuleConfigurationEntriesConfig o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleConfigurationEntriesLoader(@NotNull OapModuleConfigurationEntriesLoader o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleConfigurationLoaderIdValue(@NotNull OapModuleConfigurationLoaderIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleConfigurations(@NotNull OapModuleConfigurations o) {
    visitKeyValuePair(o);
  }

  public void visitModuleConfigurationsIdValue(@NotNull OapModuleConfigurationsIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleDependsOn(@NotNull OapModuleDependsOn o) {
    visitCompositeElement(o);
  }

  public void visitModuleDependsOnIdValue(@NotNull OapModuleDependsOnIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleDependsOnModuleName(@NotNull OapModuleDependsOnModuleName o) {
    visitIndentNormal(o);
  }

  public void visitModuleEnabled(@NotNull OapModuleEnabled o) {
    visitCompositeElement(o);
  }

  public void visitModuleInclude(@NotNull OapModuleInclude o) {
    visitCompositeElement(o);
  }

  public void visitModuleName(@NotNull OapModuleName o) {
    visitKeyValuePair(o);
  }

  public void visitModuleNameIdValue(@NotNull OapModuleNameIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleNameValue(@NotNull OapModuleNameValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServices(@NotNull OapModuleServices o) {
    visitKeyValuePair(o);
  }

  public void visitModuleServicesIdValue(@NotNull OapModuleServicesIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesService(@NotNull OapModuleServicesService o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceAbstract(@NotNull OapModuleServicesServiceAbstract o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceAbstractIdValue(@NotNull OapModuleServicesServiceAbstractIdValue o) {
    visitIndentNormal(o);
  }

  public void visitModuleServicesServiceDefault(@NotNull OapModuleServicesServiceDefault o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceDefaultIdValue(@NotNull OapModuleServicesServiceDefaultIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceDependson(@NotNull OapModuleServicesServiceDependson o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceDependsonIdValue(@NotNull OapModuleServicesServiceDependsonIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceEnabled(@NotNull OapModuleServicesServiceEnabled o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceEnabledIdValue(@NotNull OapModuleServicesServiceEnabledIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceIdValue(@NotNull OapModuleServicesServiceIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceImplementation(@NotNull OapModuleServicesServiceImplementation o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceImplementationIdValue(@NotNull OapModuleServicesServiceImplementationIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceLink(@NotNull OapModuleServicesServiceLink o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceLinkField(@NotNull OapModuleServicesServiceLinkField o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceLinkFieldObject(@NotNull OapModuleServicesServiceLinkFieldObject o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceLinkIdValue(@NotNull OapModuleServicesServiceLinkIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceListen(@NotNull OapModuleServicesServiceListen o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceListenIdValue(@NotNull OapModuleServicesServiceListenIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceParameters(@NotNull OapModuleServicesServiceParameters o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceParametersIdValue(@NotNull OapModuleServicesServiceParametersIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceRemote(@NotNull OapModuleServicesServiceRemote o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceRemoteIdValue(@NotNull OapModuleServicesServiceRemoteIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervision(@NotNull OapModuleServicesServiceSupervision o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesCron(@NotNull OapModuleServicesServiceSupervisionEntitiesCron o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesCronIdValue(@NotNull OapModuleServicesServiceSupervisionEntitiesCronIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesDelay(@NotNull OapModuleServicesServiceSupervisionEntitiesDelay o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesDelayIdValue(@NotNull OapModuleServicesServiceSupervisionEntitiesDelayIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesSchedule(@NotNull OapModuleServicesServiceSupervisionEntitiesSchedule o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesScheduleIdValue(@NotNull OapModuleServicesServiceSupervisionEntitiesScheduleIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesSupervise(@NotNull OapModuleServicesServiceSupervisionEntitiesSupervise o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesSuperviseIdValue(@NotNull OapModuleServicesServiceSupervisionEntitiesSuperviseIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesThread(@NotNull OapModuleServicesServiceSupervisionEntitiesThread o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesThreadIdValue(@NotNull OapModuleServicesServiceSupervisionEntitiesThreadIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceSupervisionIdValue(@NotNull OapModuleServicesServiceSupervisionIdValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceWsservice(@NotNull OapModuleServicesServiceWsservice o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceWsserviceIdValue(@NotNull OapModuleServicesServiceWsserviceIdValue o) {
    visitCompositeElement(o);
  }

  public void visitNl(@NotNull OapNl o) {
    visitCompositeElement(o);
  }

  public void visitNumberValue(@NotNull OapNumberValue o) {
    visitCompositeElement(o);
  }

  public void visitParameterIdValueOrPath(@NotNull OapParameterIdValueOrPath o) {
    visitCompositeElement(o);
  }

  public void visitParameterKeyValue(@NotNull OapParameterKeyValue o) {
    visitCompositeElement(o);
  }

  public void visitParametersArray(@NotNull OapParametersArray o) {
    visitCompositeElement(o);
  }

  public void visitParametersArrayItem(@NotNull OapParametersArrayItem o) {
    visitIndentNormal(o);
  }

  public void visitParametersObject(@NotNull OapParametersObject o) {
    visitCompositeElement(o);
  }

  public void visitParametersReference(@NotNull OapParametersReference o) {
    visitCompositeElement(o);
  }

  public void visitPathParametersFunction(@NotNull OapPathParametersFunction o) {
    visitCompositeElement(o);
  }

  public void visitPathParametersFunctionBody(@NotNull OapPathParametersFunctionBody o) {
    visitCompositeElement(o);
  }

  public void visitReferenceKernelValue(@NotNull OapReferenceKernelValue o) {
    visitValue(o);
  }

  public void visitReferenceModulesValue(@NotNull OapReferenceModulesValue o) {
    visitValue(o);
  }

  public void visitReferenceServicesValue(@NotNull OapReferenceServicesValue o) {
    visitValue(o);
  }

  public void visitRemoteEntries(@NotNull OapRemoteEntries o) {
    visitCompositeElement(o);
  }

  public void visitRemoteName(@NotNull OapRemoteName o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitRemoteNameIdValue(@NotNull OapRemoteNameIdValue o) {
    visitCompositeElement(o);
  }

  public void visitRemoteObject(@NotNull OapRemoteObject o) {
    visitCompositeElement(o);
  }

  public void visitRemoteSerialization(@NotNull OapRemoteSerialization o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitRemoteSerializationIdValue(@NotNull OapRemoteSerializationIdValue o) {
    visitCompositeElement(o);
  }

  public void visitRemoteTimeout(@NotNull OapRemoteTimeout o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitRemoteTimeoutIdValue(@NotNull OapRemoteTimeoutIdValue o) {
    visitCompositeElement(o);
  }

  public void visitRemoteUrl(@NotNull OapRemoteUrl o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitRemoteUrlIdValue(@NotNull OapRemoteUrlIdValue o) {
    visitCompositeElement(o);
  }

  public void visitStringValue(@NotNull OapStringValue o) {
    visitValue(o);
  }

  public void visitUnquotedstringValue(@NotNull OapUnquotedstringValue o) {
    visitCompositeElement(o);
  }

  public void visitWspath(@NotNull OapWspath o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceEntries(@NotNull OapWsserviceEntries o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceInterceptor(@NotNull OapWsserviceInterceptor o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceInterceptors(@NotNull OapWsserviceInterceptors o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsserviceInterceptorsIdValue(@NotNull OapWsserviceInterceptorsIdValue o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceObject(@NotNull OapWsserviceObject o) {
    visitCompositeElement(o);
  }

  public void visitWsservicePath(@NotNull OapWsservicePath o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsservicePathIdValue(@NotNull OapWsservicePathIdValue o) {
    visitCompositeElement(o);
  }

  public void visitWsservicePort(@NotNull OapWsservicePort o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsservicePortIdValue(@NotNull OapWsservicePortIdValue o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceSessionAware(@NotNull OapWsserviceSessionAware o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsserviceSessionAwareIdValue(@NotNull OapWsserviceSessionAwareIdValue o) {
    visitCompositeElement(o);
  }

  public void visitIndentNormal(@NotNull IndentNormal o) {
    visitElement(o);
  }

  public void visitKeyValuePair(@NotNull OapKeyValuePair o) {
    visitCompositeElement(o);
  }

  public void visitKeyValuePairWithIndentNormal(@NotNull OapKeyValuePairWithIndentNormal o) {
    visitCompositeElement(o);
  }

  public void visitValue(@NotNull OapValue o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@NotNull OapCompositeElement o) {
    visitElement(o);
  }

}
