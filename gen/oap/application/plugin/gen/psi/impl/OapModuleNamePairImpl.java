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

public class OapModuleNamePairImpl extends OapModuleNameBaseImpl implements OapModuleNamePair {

  public OapModuleNamePairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public OapModuleNamePairImpl(@NotNull OapModuleNameStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleNamePair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapModuleName getModuleName() {
    return PsiTreeUtil.getChildOfType(this, OapModuleName.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

  @Override
  @Nullable
  public PsiElement getIdName() {
    return findChildByType(OAP_ID_NAME);
  }

}
