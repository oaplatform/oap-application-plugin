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
import oap.application.plugin.stub.OapModuleServicesServiceStub;
import com.intellij.psi.stubs.IStubElementType;

public class OapModuleServicesServiceImpl extends oap.application.plugin.psi.impl.OapModuleServicesServiceImpl implements OapModuleServicesService {

  public OapModuleServicesServiceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public OapModuleServicesServiceImpl(@NotNull OapModuleServicesServiceStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesService(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceAbstract getModuleServicesServiceAbstract() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceAbstract.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceDefault getModuleServicesServiceDefault() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceDefault.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceDependson getModuleServicesServiceDependson() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceDependson.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceEnabled getModuleServicesServiceEnabled() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceEnabled.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceImplementation getModuleServicesServiceImplementation() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceImplementation.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceLink getModuleServicesServiceLink() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceLink.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceListen getModuleServicesServiceListen() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceListen.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceParameters getModuleServicesServiceParameters() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceParameters.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceRemote getModuleServicesServiceRemote() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceRemote.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceSupervision getModuleServicesServiceSupervision() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceSupervision.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceWshandler getModuleServicesServiceWshandler() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceWshandler.class);
  }

  @Override
  @Nullable
  public OapModuleServicesServiceWsservice getModuleServicesServiceWsservice() {
    return PsiTreeUtil.getChildOfType(this, OapModuleServicesServiceWsservice.class);
  }

  @Override
  @NotNull
  public OapServiceName getServiceName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, OapServiceName.class));
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(OAP_DOT);
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
