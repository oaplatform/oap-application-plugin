// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import oap.application.plugin.psi.OapClassValueMixin;
import oap.application.plugin.gen.psi.*;

public class OapClassValueImpl extends OapClassValueMixin implements OapClassValue {

  public OapClassValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitClassValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

}
