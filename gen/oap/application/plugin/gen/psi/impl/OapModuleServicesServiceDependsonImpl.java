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

public class OapModuleServicesServiceDependsonImpl extends OapCompositeElementImpl implements OapModuleServicesServiceDependson {

  public OapModuleServicesServiceDependsonImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesServiceDependson(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OapModuleServicesServiceDependsonId getModuleServicesServiceDependsonId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceDependsonId.class));
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceDependsonName> getModuleServicesServiceDependsonNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceDependsonName.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
