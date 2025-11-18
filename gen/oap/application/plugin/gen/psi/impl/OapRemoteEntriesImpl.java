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

public class OapRemoteEntriesImpl extends OapCompositeElementImpl implements OapRemoteEntries {

  public OapRemoteEntriesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitRemoteEntries(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OapRemoteName> getRemoteNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapRemoteName.class);
  }

  @Override
  @NotNull
  public List<OapRemoteSerialization> getRemoteSerializationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapRemoteSerialization.class);
  }

  @Override
  @NotNull
  public List<OapRemoteTimeout> getRemoteTimeoutList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapRemoteTimeout.class);
  }

  @Override
  @NotNull
  public List<OapRemoteUrl> getRemoteUrlList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapRemoteUrl.class);
  }

}
