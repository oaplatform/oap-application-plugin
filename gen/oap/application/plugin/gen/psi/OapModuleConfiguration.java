// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapModuleConfiguration extends OapKeyValuePairWithIndentNormal {

  @Nullable
  OapModuleConfigurationEntries getModuleConfigurationEntries();

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
