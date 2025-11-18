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

public class OapWsserviceObjectImpl extends OapCompositeElementImpl implements OapWsserviceObject {

  public OapWsserviceObjectImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitWsserviceObject(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapWsserviceEntries getWsserviceEntries() {
    return PsiTreeUtil.getChildOfType(this, OapWsserviceEntries.class);
  }

  @Override
  @NotNull
  public PsiElement getLeftbrace() {
    return notNullChild(findChildByType(OAP_LEFTBRACE));
  }

  @Override
  @Nullable
  public PsiElement getRightbrace() {
    return findChildByType(OAP_RIGHTBRACE);
  }

}
