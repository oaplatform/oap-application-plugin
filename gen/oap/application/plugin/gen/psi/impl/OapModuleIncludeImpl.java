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

public class OapModuleIncludeImpl extends OapCompositeElementImpl implements OapModuleInclude {

  public OapModuleIncludeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleInclude(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdInclude() {
    return notNullChild(findChildByType(OAP_ID_INCLUDE));
  }

  @Override
  @Nullable
  public PsiElement getIdRequired() {
    return findChildByType(OAP_ID_REQUIRED);
  }

  @Override
  @Nullable
  public PsiElement getLeftparen() {
    return findChildByType(OAP_LEFTPAREN);
  }

  @Override
  @Nullable
  public PsiElement getRightparen() {
    return findChildByType(OAP_RIGHTPAREN);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(OAP_STRING);
  }

}
