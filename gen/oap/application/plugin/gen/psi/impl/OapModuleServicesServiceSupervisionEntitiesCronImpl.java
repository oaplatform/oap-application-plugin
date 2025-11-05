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

public class OapModuleServicesServiceSupervisionEntitiesCronImpl extends OapCompositeElementImpl implements OapModuleServicesServiceSupervisionEntitiesCron {

  public OapModuleServicesServiceSupervisionEntitiesCronImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesServiceSupervisionEntitiesCron(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapCronValue getCronValue() {
    return PsiTreeUtil.getChildOfType(this, OapCronValue.class);
  }

  @Override
  @NotNull
  public OapModuleServicesServiceSupervisionEntitiesCronIdValue getModuleServicesServiceSupervisionEntitiesCronIdValue() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceSupervisionEntitiesCronIdValue.class));
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
