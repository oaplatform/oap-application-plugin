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

public class OapKeyValueImpl extends OapCompositeElementImpl implements OapKeyValue {

  public OapKeyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitKeyValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapBoolValue getBoolValue() {
    return PsiTreeUtil.getChildOfType(this, OapBoolValue.class);
  }

  @Override
  @Nullable
  public OapClassValue getClassValue() {
    return PsiTreeUtil.getChildOfType(this, OapClassValue.class);
  }

  @Override
  @Nullable
  public OapConfigArray getConfigArray() {
    return PsiTreeUtil.getChildOfType(this, OapConfigArray.class);
  }

  @Override
  @Nullable
  public OapConfigObject getConfigObject() {
    return PsiTreeUtil.getChildOfType(this, OapConfigObject.class);
  }

  @Override
  @NotNull
  public OapConfigurationsConfigKeyValueIdOrPath getConfigurationsConfigKeyValueIdOrPath() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapConfigurationsConfigKeyValueIdOrPath.class));
  }

  @Override
  @Nullable
  public OapIdValue getIdValue() {
    return PsiTreeUtil.getChildOfType(this, OapIdValue.class);
  }

  @Override
  @Nullable
  public OapNumberValue getNumberValue() {
    return PsiTreeUtil.getChildOfType(this, OapNumberValue.class);
  }

  @Override
  @Nullable
  public OapStringValue getStringValue() {
    return PsiTreeUtil.getChildOfType(this, OapStringValue.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
