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

public class OapReferenceServicesInImpl extends OapCompositeElementImpl implements OapReferenceServicesIn {

  public OapReferenceServicesInImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitReferenceServicesIn(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OapReferenceTypeServices getReferenceTypeServices() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapReferenceTypeServices.class));
  }

  @Override
  @Nullable
  public OapReferenceTypeServicesProperty getReferenceTypeServicesProperty() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceTypeServicesProperty.class);
  }

  @Override
  @Nullable
  public OapReferenceTypeServicesSelf getReferenceTypeServicesSelf() {
    return PsiTreeUtil.getChildOfType(this, OapReferenceTypeServicesSelf.class);
  }

}
