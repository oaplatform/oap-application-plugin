// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapModuleDependsOn extends OapCompositeElement {

  @NotNull
  OapModuleDependsOnIdValue getModuleDependsOnIdValue();

  @NotNull
  List<OapModuleDependsOnModuleName> getModuleDependsOnModuleNameList();

  @NotNull
  List<OapNl> getNlList();

  @Nullable
  PsiElement getEq();

}
