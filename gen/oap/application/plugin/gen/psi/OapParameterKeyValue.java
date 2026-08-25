// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapParameterKeyValue extends OapCompositeElement {

  @Nullable
  OapAnyReference getAnyReference();

  @Nullable
  OapBlockScalarValue getBlockScalarValue();

  @Nullable
  OapBoolValue getBoolValue();

  @Nullable
  OapFunction getFunction();

  @Nullable
  OapIdValue getIdValue();

  @NotNull
  OapParameterKeyValueFirstId getParameterKeyValueFirstId();

  @Nullable
  OapParametersArray getParametersArray();

  @NotNull
  List<OapParametersArrayItem> getParametersArrayItemList();

  @Nullable
  OapParametersObject getParametersObject();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getDedent();

  @Nullable
  PsiElement getEq();

  @Nullable
  PsiElement getIndent();

}
