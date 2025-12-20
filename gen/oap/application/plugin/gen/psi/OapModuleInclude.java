// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapCompositeElement;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference;

public interface OapModuleInclude extends OapCompositeElement {

  @NotNull
  PsiElement getIdInclude();

  @Nullable
  PsiElement getIdRequired();

  @Nullable
  PsiElement getLeftparen();

  @Nullable
  PsiElement getRightparen();

  @Nullable
  PsiElement getString();

  @Nullable FileReference getReference();

}
