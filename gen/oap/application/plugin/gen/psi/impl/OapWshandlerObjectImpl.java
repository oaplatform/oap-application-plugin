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

public class OapWshandlerObjectImpl extends OapCompositeElementImpl implements OapWshandlerObject {

  public OapWshandlerObjectImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitWshandlerObject(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapWshandlerEntries getWshandlerEntries() {
    return PsiTreeUtil.getChildOfType(this, OapWshandlerEntries.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(OAP_COLON);
  }

  @Override
  @Nullable
  public PsiElement getDedent() {
    return findChildByType(OAP_DEDENT);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(OAP_INDENT);
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
