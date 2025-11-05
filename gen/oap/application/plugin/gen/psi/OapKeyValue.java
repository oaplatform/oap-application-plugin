// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapKeyValue extends OapKeyValuePairWithIndentNormal {

  @Nullable
  OapBoolValue getBoolValue();

  @Nullable
  OapClassValue getClassValue();

  @Nullable
  OapConfigArray getConfigArray();

  @Nullable
  OapConfigObject getConfigObject();

  @NotNull
  OapConfigurationsConfigKeyValueIdOrPath getConfigurationsConfigKeyValueIdOrPath();

  @Nullable
  OapIdValue getIdValue();

  @Nullable
  OapNumberValue getNumberValue();

  @Nullable
  OapStringValue getStringValue();

  @Nullable
  PsiElement getEq();

}
