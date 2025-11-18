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

public class OapReferenceModulesValueInImpl extends OapCompositeElementImpl implements OapReferenceModulesValueIn {

  public OapReferenceModulesValueInImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitReferenceModulesValueIn(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapReferenceModulesName getReferenceModulesName() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceModulesName.class);
  }

  @Override
  @Nullable
  public OapReferenceModulesServiceName getReferenceModulesServiceName() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceModulesServiceName.class);
  }

  @Override
  @NotNull
  public OapReferenceTypeModules getReferenceTypeModules() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapReferenceTypeModules.class));
  }

}
