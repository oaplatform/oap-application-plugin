// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePair;

public interface OapModuleConfigurations extends OapKeyValuePair {

  @NotNull
  List<OapModuleConfiguration> getModuleConfigurationList();

  @Nullable
  PsiElement getEq();

  @NotNull
  PsiElement getIdConfigurations();

  @Nullable
  PsiElement getLeftbracket();

  @Nullable
  PsiElement getRightbracket();

}
