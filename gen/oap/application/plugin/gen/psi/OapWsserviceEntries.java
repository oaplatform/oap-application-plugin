// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapWsserviceEntries extends OapCompositeElement {

  @NotNull
  List<OapWsserviceEnabled> getWsserviceEnabledList();

  @NotNull
  List<OapWsserviceInterceptors> getWsserviceInterceptorsList();

  @NotNull
  List<OapWsservicePath> getWsservicePathList();

  @NotNull
  List<OapWsservicePort> getWsservicePortList();

  @NotNull
  List<OapWsserviceSessionAware> getWsserviceSessionAwareList();

}
