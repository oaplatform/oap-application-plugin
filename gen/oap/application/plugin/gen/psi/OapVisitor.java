// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import oap.application.plugin.psi.OapCompositeElement;
import oap.application.plugin.psi.IndentNormal;
import oap.application.plugin.psi.IModuleName;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;
import oap.application.plugin.psi.OapValue;
import oap.application.plugin.psi.OapKeyValuePair;
import oap.application.plugin.psi.IServiceName;
import com.intellij.psi.PsiNamedElement;

public class OapVisitor extends PsiElementVisitor {

  public void visitAnyReference(@NotNull OapAnyReference o) {
    visitCompositeElement(o);
  }

  public void visitAnyReferenceIn(@NotNull OapAnyReferenceIn o) {
    visitCompositeElement(o);
  }

  public void visitBoolValue(@NotNull OapBoolValue o) {
    visitValue(o);
  }

  public void visitClassNamePsi(@NotNull OapClassNamePsi o) {
    visitCompositeElement(o);
  }

  public void visitConfigArray(@NotNull OapConfigArray o) {
    visitCompositeElement(o);
  }

  public void visitConfigArrayItem(@NotNull OapConfigArrayItem o) {
    visitIndentNormal(o);
  }

  public void visitConfigObject(@NotNull OapConfigObject o) {
    visitIndentNormal(o);
  }

  public void visitConfigurationKeyValuePair(@NotNull OapConfigurationKeyValuePair o) {
    visitKeyValuePairWithIndentNormal(o);
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

  public void visitEnvValue(@NotNull OapEnvValue o) {
    visitCompositeElement(o);
  }

  public void visitFunction(@NotNull OapFunction o) {
    visitCompositeElement(o);
  }

  public void visitIdValue(@NotNull OapIdValue o) {
    visitCompositeElement(o);
  }

  public void visitJavaParameterKeyValue(@NotNull OapJavaParameterKeyValue o) {
    visitCompositeElement(o);
  }

  public void visitModuleConfiguration(@NotNull OapModuleConfiguration o) {
    visitKeyValuePairWithIndentNormal(o);
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

  public void visitModuleConfigurations(@NotNull OapModuleConfigurations o) {
    visitKeyValuePair(o);
  }

  public void visitModuleDependsOn(@NotNull OapModuleDependsOn o) {
    visitCompositeElement(o);
  }

  public void visitModuleDependsOnName(@NotNull OapModuleDependsOnName o) {
    visitIndentNormal(o);
    // visitIModuleName(o);
  }

  public void visitModuleEnabled(@NotNull OapModuleEnabled o) {
    visitCompositeElement(o);
  }

  public void visitModuleInclude(@NotNull OapModuleInclude o) {
    visitCompositeElement(o);
  }

  public void visitModuleName(@NotNull OapModuleName o) {
    visitIModuleName(o);
  }

  public void visitModuleNamePair(@NotNull OapModuleNamePair o) {
    visitKeyValuePair(o);
  }

  public void visitModuleServices(@NotNull OapModuleServices o) {
    visitKeyValuePair(o);
  }

  public void visitModuleServicesService(@NotNull OapModuleServicesService o) {
    visitPsiNamedElement(o);
  }

  public void visitModuleServicesServiceAbstract(@NotNull OapModuleServicesServiceAbstract o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceDefault(@NotNull OapModuleServicesServiceDefault o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceDependson(@NotNull OapModuleServicesServiceDependson o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceDependsonId(@NotNull OapModuleServicesServiceDependsonId o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceDependsonName(@NotNull OapModuleServicesServiceDependsonName o) {
    visitIndentNormal(o);
    // visitIServiceName(o);
  }

  public void visitModuleServicesServiceEnabled(@NotNull OapModuleServicesServiceEnabled o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceImplementation(@NotNull OapModuleServicesServiceImplementation o) {
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

  public void visitModuleServicesServiceListen(@NotNull OapModuleServicesServiceListen o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceParameters(@NotNull OapModuleServicesServiceParameters o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceParametersId(@NotNull OapModuleServicesServiceParametersId o) {
    visitCompositeElement(o);
  }

  public void visitModuleServicesServiceRemote(@NotNull OapModuleServicesServiceRemote o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervision(@NotNull OapModuleServicesServiceSupervision o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesCron(@NotNull OapModuleServicesServiceSupervisionEntitiesCron o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesDelay(@NotNull OapModuleServicesServiceSupervisionEntitiesDelay o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesSchedule(@NotNull OapModuleServicesServiceSupervisionEntitiesSchedule o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesSupervise(@NotNull OapModuleServicesServiceSupervisionEntitiesSupervise o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceSupervisionEntitiesThread(@NotNull OapModuleServicesServiceSupervisionEntitiesThread o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceWshandler(@NotNull OapModuleServicesServiceWshandler o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitModuleServicesServiceWsservice(@NotNull OapModuleServicesServiceWsservice o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitParameterKeyValue(@NotNull OapParameterKeyValue o) {
    visitCompositeElement(o);
  }

  public void visitParameterKeyValueFirstId(@NotNull OapParameterKeyValueFirstId o) {
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

  public void visitReferenceKernelValue(@NotNull OapReferenceKernelValue o) {
    visitValue(o);
  }

  public void visitReferenceKernelValueIn(@NotNull OapReferenceKernelValueIn o) {
    visitCompositeElement(o);
  }

  public void visitReferenceModulesName(@NotNull OapReferenceModulesName o) {
    visitIModuleName(o);
  }

  public void visitReferenceModulesServiceName(@NotNull OapReferenceModulesServiceName o) {
    visitIServiceName(o);
  }

  public void visitReferenceModulesValue(@NotNull OapReferenceModulesValue o) {
    visitValue(o);
  }

  public void visitReferenceModulesValueIn(@NotNull OapReferenceModulesValueIn o) {
    visitCompositeElement(o);
  }

  public void visitReferenceServicesIn(@NotNull OapReferenceServicesIn o) {
    visitCompositeElement(o);
  }

  public void visitReferenceServicesValue(@NotNull OapReferenceServicesValue o) {
    visitValue(o);
  }

  public void visitReferenceTypeKernel(@NotNull OapReferenceTypeKernel o) {
    visitCompositeElement(o);
  }

  public void visitReferenceTypeModules(@NotNull OapReferenceTypeModules o) {
    visitCompositeElement(o);
  }

  public void visitReferenceTypeServices(@NotNull OapReferenceTypeServices o) {
    visitCompositeElement(o);
  }

  public void visitReferenceTypeServicesProperty(@NotNull OapReferenceTypeServicesProperty o) {
    visitCompositeElement(o);
  }

  public void visitReferenceTypeServicesSelf(@NotNull OapReferenceTypeServicesSelf o) {
    visitCompositeElement(o);
  }

  public void visitRemoteEntries(@NotNull OapRemoteEntries o) {
    visitCompositeElement(o);
  }

  public void visitRemoteName(@NotNull OapRemoteName o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitRemoteObject(@NotNull OapRemoteObject o) {
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

  public void visitServiceName(@NotNull OapServiceName o) {
    visitCompositeElement(o);
  }

  public void visitWshandlerBlocking(@NotNull OapWshandlerBlocking o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWshandlerCompression(@NotNull OapWshandlerCompression o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWshandlerEntries(@NotNull OapWshandlerEntries o) {
    visitCompositeElement(o);
  }

  public void visitWshandlerObject(@NotNull OapWshandlerObject o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceEnabled(@NotNull OapWsserviceEnabled o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsserviceEnabledId(@NotNull OapWsserviceEnabledId o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceEntries(@NotNull OapWsserviceEntries o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceInterceptorOne(@NotNull OapWsserviceInterceptorOne o) {
    visitIndentNormal(o);
  }

  public void visitWsserviceInterceptors(@NotNull OapWsserviceInterceptors o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsserviceInterceptorsId(@NotNull OapWsserviceInterceptorsId o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceObject(@NotNull OapWsserviceObject o) {
    visitCompositeElement(o);
  }

  public void visitWsservicePath(@NotNull OapWsservicePath o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsservicePathId(@NotNull OapWsservicePathId o) {
    visitCompositeElement(o);
  }

  public void visitWsservicePort(@NotNull OapWsservicePort o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsservicePortId(@NotNull OapWsservicePortId o) {
    visitCompositeElement(o);
  }

  public void visitWsserviceSessionAware(@NotNull OapWsserviceSessionAware o) {
    visitKeyValuePairWithIndentNormal(o);
  }

  public void visitWsserviceSessionAwareId(@NotNull OapWsserviceSessionAwareId o) {
    visitCompositeElement(o);
  }

  public void visitPsiNamedElement(@NotNull PsiNamedElement o) {
    visitElement(o);
  }

  public void visitIModuleName(@NotNull IModuleName o) {
    visitElement(o);
  }

  public void visitIServiceName(@NotNull IServiceName o) {
    visitElement(o);
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
