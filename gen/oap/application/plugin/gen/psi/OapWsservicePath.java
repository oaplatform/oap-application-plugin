// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapWsservicePath extends OapKeyValuePairWithIndentNormal {

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  List<OapWspath> getWspathList();

  @NotNull
  OapWsservicePathIdValue getWsservicePathIdValue();

  @Nullable
  PsiElement getEq();

  @Nullable
  PsiElement getLeftbracket();

  @Nullable
  PsiElement getRightbracket();

}
