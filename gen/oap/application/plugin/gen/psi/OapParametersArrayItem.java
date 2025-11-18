// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.IndentNormal;

public interface OapParametersArrayItem extends IndentNormal {

  @Nullable
  OapAnyReference getAnyReference();

  @NotNull
  List<OapIdValue> getIdValueList();

  @Nullable
  OapParametersObject getParametersObject();

}
