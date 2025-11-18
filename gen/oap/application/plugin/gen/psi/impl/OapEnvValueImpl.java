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

public class OapEnvValueImpl extends OapCompositeElementImpl implements OapEnvValue {

  public OapEnvValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitEnvValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getDollar() {
    return notNullChild(findChildByType(OAP_DOLLAR));
  }

  @Override
  @NotNull
  public PsiElement getKeyValue() {
    return notNullChild(findChildByType(OAP_KEY_VALUE));
  }

  @Override
  @NotNull
  public PsiElement getLeftbrace() {
    return notNullChild(findChildByType(OAP_LEFTBRACE));
  }

  @Override
  @NotNull
  public PsiElement getRightbrace() {
    return notNullChild(findChildByType(OAP_RIGHTBRACE));
  }

}
