// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapParametersObject extends OapCompositeElement {

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  List<OapParameterKeyValue> getParameterKeyValueList();

  @NotNull
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
