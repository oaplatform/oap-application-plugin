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

public class OapWshandlerEntriesImpl extends OapCompositeElementImpl implements OapWshandlerEntries {

  public OapWshandlerEntriesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OapVisitor visitor) {
    visitor.visitWshandlerEntries(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OapVisitor) accept((OapVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OapWshandlerBlocking> getWshandlerBlockingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWshandlerBlocking.class);
  }

  @Override
  @NotNull
  public List<OapWshandlerCompression> getWshandlerCompressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWshandlerCompression.class);
  }

  @Override
  @NotNull
  public List<OapWsserviceEnabled> getWsserviceEnabledList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWsserviceEnabled.class);
  }

  @Override
  @NotNull
  public List<OapWsservicePath> getWsservicePathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWsservicePath.class);
  }

  @Override
  @NotNull
  public List<OapWsservicePort> getWsservicePortList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OapWsservicePort.class);
  }

}
