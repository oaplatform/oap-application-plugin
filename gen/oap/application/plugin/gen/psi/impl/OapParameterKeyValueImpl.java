// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static oap.application.plugin.gen.OapTypes.*;
import oap.application.plugin.psi.OapModuleServicesServiceParameterKeyValueMixin;
import oap.application.plugin.gen.psi.*;
import oap.application.plugin.psi.impl.GrammarPsiImplUtil;

public class OapParameterKeyValueImpl extends OapModuleServicesServiceParameterKeyValueMixin implements OapParameterKeyValue {

  public OapParameterKeyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitParameterKeyValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapAnyReference getAnyReference() {
    return PsiTreeUtil.getChildOfType(this, OapAnyReference.class);
  }

  @Override
  @Nullable
  public OapBoolValue getBoolValue() {
    return PsiTreeUtil.getChildOfType(this, OapBoolValue.class);
  }

  @Override
  @Nullable
  public OapFunction getFunction() {
    return PsiTreeUtil.getChildOfType(this, OapFunction.class);
  }

  @Override
  @Nullable
  public OapIdValue getIdValue() {
    return PsiTreeUtil.getChildOfType(this, OapIdValue.class);
  }

  @Override
  @Nullable
  public OapModuleInclude getModuleInclude() {
    return PsiTreeUtil.getChildOfType(this, OapModuleInclude.class);
  }

  @Override
  @Nullable
  public OapParametersArray getParametersArray() {
    return PsiTreeUtil.getChildOfType(this, OapParametersArray.class);
  }

  @Override
  @Nullable
  public OapParametersObject getParametersObject() {
    return PsiTreeUtil.getChildOfType(this, OapParametersObject.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
