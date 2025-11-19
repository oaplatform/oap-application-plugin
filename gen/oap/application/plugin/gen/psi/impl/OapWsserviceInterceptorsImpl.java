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

public class OapWsserviceInterceptorsImpl extends OapCompositeElementImpl implements OapWsserviceInterceptors {

  public OapWsserviceInterceptorsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitWsserviceInterceptors(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OapWsserviceInterceptorOne> getWsserviceInterceptorOneList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWsserviceInterceptorOne.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

  @Override
  @NotNull
  public PsiElement getIdInterceptors() {
    return notNullChild(findChildByType(OAP_ID_INTERCEPTORS));
  }

  @Override
  @Nullable
  public PsiElement getLeftbracket() {
    return findChildByType(OAP_LEFTBRACKET);
  }

  @Override
  @Nullable
  public PsiElement getRightbracket() {
    return findChildByType(OAP_RIGHTBRACKET);
  }

}
