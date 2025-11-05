// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;

public interface OapConfigArray extends OapCompositeElement {

  @NotNull
  List<OapConfigArrayObject> getConfigArrayObjectList();

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  PsiElement getLeftbracket();

  @Nullable
  PsiElement getRightbracket();

}
