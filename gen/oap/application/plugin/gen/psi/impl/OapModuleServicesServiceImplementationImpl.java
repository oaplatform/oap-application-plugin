// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static oap.application.plugin.gen.OapTypes.*;
import oap.application.plugin.gen.psi.*;
import oap.application.plugin.psi.impl.GrammarPsiImplUtil;
import oap.application.plugin.stub.OapModuleServicesServiceImplementationStub;
import com.intellij.psi.stubs.IStubElementType;

public class OapModuleServicesServiceImplementationImpl extends oap.application.plugin.psi.impl.OapModuleServicesServiceImplementationImpl implements OapModuleServicesServiceImplementation {

  public OapModuleServicesServiceImplementationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public OapModuleServicesServiceImplementationImpl(@NotNull OapModuleServicesServiceImplementationStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesServiceImplementation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapClassNamePsi getClassNamePsi() {
    return PsiTreeUtil.getChildOfType(this, OapClassNamePsi.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

  @Override
  @NotNull
  public PsiElement getIdImplementation() {
    return notNullChild(findChildByType(OAP_ID_IMPLEMENTATION));
  }

}
