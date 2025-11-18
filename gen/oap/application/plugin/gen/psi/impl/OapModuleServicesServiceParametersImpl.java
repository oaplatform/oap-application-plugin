// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static oap.application.plugin.gen.OapTypes.*;
import oap.application.plugin.psi.OapModuleServicesServiceParametersMixin;
import oap.application.plugin.gen.psi.*;
import oap.application.plugin.psi.impl.GrammarPsiImplUtil;

public class OapModuleServicesServiceParametersImpl extends OapModuleServicesServiceParametersMixin implements OapModuleServicesServiceParameters {

  public OapModuleServicesServiceParametersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesServiceParameters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapParameterKeyValue getParameterKeyValue() {
    return PsiTreeUtil.getChildOfType(this, OapParameterKeyValue.class);
  }

  @Override
  @Nullable
  public OapParametersObject getParametersObject() {
    return PsiTreeUtil.getChildOfType(this, OapParametersObject.class);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(OAP_DOT);
  }

  @Override
  @NotNull
  public PsiElement getIdParameters() {
    return notNullChild(findChildByType(OAP_ID_PARAMETERS));
  }

}
