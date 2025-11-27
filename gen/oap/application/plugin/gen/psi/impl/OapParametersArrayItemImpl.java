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

public class OapParametersArrayItemImpl extends OapCompositeElementImpl implements OapParametersArrayItem {

  public OapParametersArrayItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitParametersArrayItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapAnyReference getAnyReference() {
    return PsiTreeUtil.getChildOfType(this, OapAnyReference.class);
  }

  @Override
  @Nullable
  public OapBoolValue getBoolValue() {
    return PsiTreeUtil.getChildOfType(this, OapBoolValue.class);
  }

  @Override
  @Nullable
  public OapFunction getFunction() {
    return PsiTreeUtil.getChildOfType(this, OapFunction.class);
  }

  @Override
  @Nullable
  public OapIdValue getIdValue() {
    return PsiTreeUtil.getChildOfType(this, OapIdValue.class);
  }

  @Override
  @Nullable
  public OapParametersObject getParametersObject() {
    return PsiTreeUtil.getChildOfType(this, OapParametersObject.class);
  }

}
