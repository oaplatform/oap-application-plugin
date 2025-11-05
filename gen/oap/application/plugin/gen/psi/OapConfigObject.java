// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapConfigObject extends OapCompositeElement {

  @NotNull
  List<OapConfigurationsInclude> getConfigurationsIncludeList();

  @NotNull
  List<OapKeyValue> getKeyValueList();

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
