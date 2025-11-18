// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import oap.application.plugin.psi.OapKeyValuePairWithIndentNormal;

public interface OapModuleServicesServiceSupervision extends OapKeyValuePairWithIndentNormal {

  @NotNull
  List<OapModuleServicesServiceSupervisionEntitiesCron> getModuleServicesServiceSupervisionEntitiesCronList();

  @NotNull
  List<OapModuleServicesServiceSupervisionEntitiesDelay> getModuleServicesServiceSupervisionEntitiesDelayList();

  @NotNull
  List<OapModuleServicesServiceSupervisionEntitiesSchedule> getModuleServicesServiceSupervisionEntitiesScheduleList();

  @NotNull
  List<OapModuleServicesServiceSupervisionEntitiesSupervise> getModuleServicesServiceSupervisionEntitiesSuperviseList();

  @NotNull
  List<OapModuleServicesServiceSupervisionEntitiesThread> getModuleServicesServiceSupervisionEntitiesThreadList();

  @Nullable
  PsiElement getDot();

  @NotNull
  PsiElement getIdSupervision();

  @Nullable
  PsiElement getLeftbrace();

  @Nullable
  PsiElement getRightbrace();

}
