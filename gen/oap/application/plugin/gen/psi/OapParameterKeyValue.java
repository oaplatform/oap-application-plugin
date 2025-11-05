// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapParameterKeyValue extends OapCompositeElement {

  @Nullable
  OapBoolValue getBoolValue();

  @Nullable
  OapClassPathParametersFunction getClassPathParametersFunction();

  @Nullable
  OapDurationValue getDurationValue();

  @Nullable
  OapJsonParametersFunction getJsonParametersFunction();

  @Nullable
  OapNumberValue getNumberValue();

  @NotNull
  OapParameterIdValueOrPath getParameterIdValueOrPath();

  @Nullable
  OapParametersArray getParametersArray();

  @Nullable
  OapParametersObject getParametersObject();

  @Nullable
  OapParametersReference getParametersReference();

  @Nullable
  OapPathParametersFunction getPathParametersFunction();

  @Nullable
  OapStringValue getStringValue();

  @Nullable
  OapUnquotedstringValue getUnquotedstringValue();

  @Nullable
  PsiElement getEq();

}
