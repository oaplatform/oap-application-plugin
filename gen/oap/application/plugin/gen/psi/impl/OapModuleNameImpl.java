// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static oap.application.plugin.gen.OapTypes.*;
import oap.application.plugin.psi.impl.OapModuleNameBaseImpl;
import oap.application.plugin.gen.psi.*;
import oap.application.plugin.psi.impl.GrammarPsiImplUtil;
import oap.application.plugin.stub.OapModuleNameStub;
import com.intellij.psi.stubs.IStubElementType;

public class OapModuleNameImpl extends OapModuleNameBaseImpl implements OapModuleName {

  public OapModuleNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public OapModuleNameImpl(@NotNull OapModuleNameStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OapModuleNameIdValue getModuleNameIdValue() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapModuleNameIdValue.class));
  }

  @Override
  @Nullable
  public OapModuleNameValue getModuleNameValue() {
    return PsiTreeUtil.getChildOfType(this, OapModuleNameValue.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

}
