// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapWshandlerEntries extends OapCompositeElement {

  @NotNull
  List<OapWshandlerBlocking> getWshandlerBlockingList();

  @NotNull
  List<OapWshandlerCompression> getWshandlerCompressionList();

  @NotNull
  List<OapWsserviceEnabled> getWsserviceEnabledList();

  @NotNull
  List<OapWsservicePath> getWsservicePathList();

  @NotNull
  List<OapWsservicePort> getWsservicePortList();

}
