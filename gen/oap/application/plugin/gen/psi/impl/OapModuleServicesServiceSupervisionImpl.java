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

public class OapModuleServicesServiceSupervisionImpl extends OapCompositeElementImpl implements OapModuleServicesServiceSupervision {

  public OapModuleServicesServiceSupervisionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleServicesServiceSupervision(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceSupervisionEntitiesCron> getModuleServicesServiceSupervisionEntitiesCronList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceSupervisionEntitiesCron.class);
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceSupervisionEntitiesDelay> getModuleServicesServiceSupervisionEntitiesDelayList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceSupervisionEntitiesDelay.class);
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceSupervisionEntitiesSchedule> getModuleServicesServiceSupervisionEntitiesScheduleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceSupervisionEntitiesSchedule.class);
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceSupervisionEntitiesSupervise> getModuleServicesServiceSupervisionEntitiesSuperviseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceSupervisionEntitiesSupervise.class);
  }

  @Override
  @NotNull
  public List<OapModuleServicesServiceSupervisionEntitiesThread> getModuleServicesServiceSupervisionEntitiesThreadList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapModuleServicesServiceSupervisionEntitiesThread.class);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(OAP_DOT);
  }

  @Override
  @NotNull
  public PsiElement getIdSupervision() {
    return notNullChild(findChildByType(OAP_ID_SUPERVISION));
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
