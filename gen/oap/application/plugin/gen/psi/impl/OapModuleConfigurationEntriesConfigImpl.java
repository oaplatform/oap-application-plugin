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

public class OapModuleConfigurationEntriesConfigImpl extends OapCompositeElementImpl implements OapModuleConfigurationEntriesConfig {

  public OapModuleConfigurationEntriesConfigImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitModuleConfigurationEntriesConfig(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OapConfigArray getConfigArray() {
    return PsiTreeUtil.getChildOfType(this, OapConfigArray.class);
  }

  @Override
  @Nullable
  public OapConfigObject getConfigObject() {
    return PsiTreeUtil.getChildOfType(this, OapConfigObject.class);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(OAP_EQ);
  }

  @Override
  @Nullable
  public PsiElement getIdConfig() {
    return findChildByType(OAP_ID_CONFIG);
  }

}
