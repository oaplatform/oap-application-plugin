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
  OapBoolValue getBoolValue();

  @Nullable
  OapFunction getFunction();

  @Nullable
  OapIdValue getIdValue();

  @Nullable
  OapModuleInclude getModuleInclude();

  @Nullable
  OapParametersArray getParametersArray();

  @Nullable
  OapParametersObject getParametersObject();

  @Nullable
  PsiElement getEq();

}
