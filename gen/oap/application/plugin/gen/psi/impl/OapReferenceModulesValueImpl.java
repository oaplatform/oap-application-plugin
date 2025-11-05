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

public class OapReferenceModulesValueImpl extends OapCompositeElementImpl implements OapReferenceModulesValue {

  public OapReferenceModulesValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitReferenceModulesValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OapIdValue> getIdValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapIdValue.class);
  }

  @Override
  @NotNull
  public PsiElement getLeftangle() {
    return notNullChild(findChildByType(OAP_LEFTANGLE));
  }

  @Override
  @Nullable
  public PsiElement getRightangle() {
    return findChildByType(OAP_RIGHTANGLE);
  }

  @Override
  public @Nullable String getReferenceModuleName() {
    return GrammarPsiImplUtil.getReferenceModuleName(this);
  }

  @Override
  public @Nullable String getReferenceServiceName() {
    return GrammarPsiImplUtil.getReferenceServiceName(this);
  }

}
