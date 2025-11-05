// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static oap.application.plugin.gen.OapTypes.*;
import oap.application.plugin.psi.impl.OapCompositeElementImpl;
import oap.application.plugin.gen.psi.*;
import oap.application.plugin.psi.impl.GrammarPsiImplUtil;

public class OapParametersReferenceImpl extends OapCompositeElementImpl implements OapParametersReference {

  public OapParametersReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitParametersReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapReferenceKernelValue getReferenceKernelValue() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceKernelValue.class);
  }

  @Override
  @Nullable
  public OapReferenceModulesValue getReferenceModulesValue() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceModulesValue.class);
  }

  @Override
  @Nullable
  public OapReferenceServicesValue getReferenceServicesValue() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceServicesValue.class);
  }

}
