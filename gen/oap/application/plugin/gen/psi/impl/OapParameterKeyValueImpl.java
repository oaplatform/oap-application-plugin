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
  public OapBoolValue getBoolValue() {
    return PsiTreeUtil.getChildOfType(this, OapBoolValue.class);
  }

  @Override
  @Nullable
  public OapClassPathParametersFunction getClassPathParametersFunction() {
    return PsiTreeUtil.getChildOfType(this, OapClassPathParametersFunction.class);
  }

  @Override
  @Nullable
  public OapDurationValue getDurationValue() {
    return PsiTreeUtil.getChildOfType(this, OapDurationValue.class);
  }

  @Override
  @Nullable
  public OapJsonParametersFunction getJsonParametersFunction() {
    return PsiTreeUtil.getChildOfType(this, OapJsonParametersFunction.class);
  }

  @Override
  @Nullable
  public OapNumberValue getNumberValue() {
    return PsiTreeUtil.getChildOfType(this, OapNumberValue.class);
  }

  @Override
  @NotNull
  public OapParameterIdValueOrPath getParameterIdValueOrPath() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapParameterIdValueOrPath.class));
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
  public OapParametersReference getParametersReference() {
    return PsiTreeUtil.getChildOfType(this, OapParametersReference.class);
  }

  @Override
  @Nullable
  public OapPathParametersFunction getPathParametersFunction() {
    return PsiTreeUtil.getChildOfType(this, OapPathParametersFunction.class);
  }

  @Override
  @Nullable
  public OapStringValue getStringValue() {
    return PsiTreeUtil.getChildOfType(this, OapStringValue.class);
  }

  @Override
  @Nullable
  public OapUnquotedstringValue getUnquotedstringValue() {
    return PsiTreeUtil.getChildOfType(this, OapUnquotedstringValue.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
