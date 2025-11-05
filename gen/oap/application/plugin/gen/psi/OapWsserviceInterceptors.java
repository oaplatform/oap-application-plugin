// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapWsserviceInterceptors extends OapKeyValuePairWithIndentNormal {

  @NotNull
  List<OapNl> getNlList();

  @NotNull
  List<OapWsserviceInterceptor> getWsserviceInterceptorList();

  @NotNull
  OapWsserviceInterceptorsIdValue getWsserviceInterceptorsIdValue();

  @Nullable
  PsiElement getEq();

  @Nullable
  PsiElement getLeftbracket();

  @Nullable
  PsiElement getRightbracket();

}
