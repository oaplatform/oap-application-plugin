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
  public OapBlockScalarValue getBlockScalarValue() {
    return PsiTreeUtil.getChildOfType(this, OapBlockScalarValue.class);
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
  @NotNull
  public OapParameterKeyValueFirstId getParameterKeyValueFirstId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapParameterKeyValueFirstId.class));
  }

  @Override
  @Nullable
  public OapParametersArray getParametersArray() {
    return PsiTreeUtil.getChildOfType(this, OapParametersArray.class);
  }

  @Override
  @NotNull
  public List<OapParametersArrayItem> getParametersArrayItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapParametersArrayItem.class);
  }

  @Override
  @Nullable
  public OapParametersObject getParametersObject() {
    return PsiTreeUtil.getChildOfType(this, OapParametersObject.class);
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
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(OAP_INDENT);
  }

}
