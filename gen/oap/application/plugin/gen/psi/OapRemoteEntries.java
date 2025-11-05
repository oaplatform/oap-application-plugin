// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapRemoteEntries extends OapCompositeElement {

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  List<OapRemoteName> getRemoteNameList();

  @NotNull
  List<OapRemoteSerialization> getRemoteSerializationList();

  @NotNull
  List<OapRemoteTimeout> getRemoteTimeoutList();

  @NotNull
  List<OapRemoteUrl> getRemoteUrlList();

}
