// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapRemoteObject extends OapCompositeElement {

  @NotNull
  List<OapNl> getNlList();

  @Nullable
  OapRemoteEntries getRemoteEntries();

  @NotNull
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
