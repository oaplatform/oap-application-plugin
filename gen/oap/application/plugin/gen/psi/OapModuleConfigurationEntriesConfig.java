// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapModuleConfigurationEntriesConfig extends OapKeyValuePairWithIndentNormal {

  @Nullable
  OapConfigArray getConfigArray();

  @NotNull
  List<OapConfigArrayItem> getConfigArrayItemList();

  @Nullable
  OapConfigObject getConfigObject();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getDedent();

  @Nullable
  PsiElement getEq();

  @Nullable
  PsiElement getIdConfig();

  @Nullable
  PsiElement getIndent();

}
