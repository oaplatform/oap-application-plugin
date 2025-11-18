// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapModuleServicesService extends OapCompositeElement {

  @Nullable
  OapModuleServicesServiceAbstract getModuleServicesServiceAbstract();

  @Nullable
  OapModuleServicesServiceDefault getModuleServicesServiceDefault();

  @Nullable
  OapModuleServicesServiceDependson getModuleServicesServiceDependson();

  @Nullable
  OapModuleServicesServiceEnabled getModuleServicesServiceEnabled();

  @Nullable
  OapModuleServicesServiceImplementation getModuleServicesServiceImplementation();

  @Nullable
  OapModuleServicesServiceLink getModuleServicesServiceLink();

  @Nullable
  OapModuleServicesServiceListen getModuleServicesServiceListen();

  @Nullable
  OapModuleServicesServiceParameters getModuleServicesServiceParameters();

  @Nullable
  OapModuleServicesServiceRemote getModuleServicesServiceRemote();

  @Nullable
  OapModuleServicesServiceSupervision getModuleServicesServiceSupervision();

  @Nullable
  OapModuleServicesServiceWshandler getModuleServicesServiceWshandler();

  @Nullable
  OapModuleServicesServiceWsservice getModuleServicesServiceWsservice();

  @NotNull
  OapServiceName getServiceName();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
