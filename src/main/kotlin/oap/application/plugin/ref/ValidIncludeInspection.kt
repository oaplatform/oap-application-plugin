package oap.application.plugin.ref

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import oap.application.plugin.gen.psi.OapModuleInclude

class ValidIncludeInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is OapModuleInclude) {
                    val resource: PsiElement? = element.string

                    if (resource != null) {
                        val resourceName: String = resource.text.trim('"')

                        if( resourceName.endsWith(".conf")) {
                            holder.registerProblem(
                                resource,
                                "Invalid resource ${resourceName}",
                                ProblemHighlightType.ERROR
                            )
                            return;
                        }

                        val includeFile: VirtualFile? =
                            FilenameIndex.getVirtualFilesByName(resourceName, GlobalSearchScope.allScope(element.project)).firstOrNull()
                                ?: FilenameIndex.getVirtualFilesByName(resourceName + ".oap", GlobalSearchScope.allScope(element.project)).firstOrNull()

                        if (includeFile == null) {
                            holder.registerProblem(
                                resource,
                                "Oap resource ${resourceName} not found",
                                ProblemHighlightType.ERROR
                            )
                        }
                    }
                }
            }
        }
    }
}
