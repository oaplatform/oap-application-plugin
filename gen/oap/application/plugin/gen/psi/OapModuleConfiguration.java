// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapModuleConfiguration extends OapKeyValuePairWithIndentNormal {

  @NotNull
  OapModuleConfigurationEntries getModuleConfigurationEntries();

  @NotNull
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
