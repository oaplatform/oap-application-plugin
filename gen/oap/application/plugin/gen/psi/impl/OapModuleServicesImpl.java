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

public class OapModuleServicesImpl extends OapCompositeElementImpl implements OapModuleServices {

  public OapModuleServicesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServices(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OapModuleServicesIdValue getModuleServicesIdValue() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapModuleServicesIdValue.class));
  }

  @Override
  @NotNull
  public List<OapModuleServicesService> getModuleServicesServiceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesService.class);
  }

  @Override
  @Nullable
  public OapNl getNl() {
    return PsiTreeUtil.getChildOfType(this, OapNl.class);
  }

  @Override
  @Nullable
  public PsiElement getLeftbrace() {
    return findChildByType(OAP_LEFTBRACE);
  }

  @Override
  @Nullable
  public PsiElement getRightbrace() {
    return findChildByType(OAP_RIGHTBRACE);
  }

}
