// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePair;
import com.intellij.psi.StubBasedPsiElement;
import oap.application.plugin.stub.OapModuleNameStub;

public interface OapModuleName extends OapKeyValuePair, StubBasedPsiElement<OapModuleNameStub> {

  @NotNull
  OapModuleNameIdValue getModuleNameIdValue();

  @Nullable
  OapModuleNameValue getModuleNameValue();

  @Nullable
  PsiElement getEq();

}
