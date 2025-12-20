package oap.application.plugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.PsiTreeUtil
import oap.application.plugin.gen.psi.*
import oap.application.plugin.stub.OapModuleNameIndex

object ModuleUtils {
    fun getModuleName(psiFile: PsiFile): String? {
        return PsiTreeUtil.findChildOfType<OapModuleName>(psiFile, OapModuleName::class.java)?.keyValue?.text
    }

    fun findServices(psiFile: PsiFile): Collection<OapModuleServicesService> {
        return PsiTreeUtil.findChildrenOfType(psiFile, OapModuleServicesService::class.java)
    }

    fun getModuleFile(moduleName: OapReferenceModulesName): PsiFile? {
        if ("this".equals(moduleName.text)) {
            return moduleName.containingFile
        } else {
            return StubIndex
                .getElements(OapModuleNameIndex.KEY, moduleName.text, moduleName.project, GlobalSearchScope.allScope(moduleName.project), OapModuleNamePair::class.java)
                .map { it.containingFile }
                .firstOrNull()
        }

    }

    fun getServices(element: PsiElement, moduleNameOrThis: String?): List<OapModuleServicesService> {
        var moduleName: String? = moduleNameOrThis;

        if ("this".equals(moduleName)) {
            moduleName = getModuleName(element.containingFile)
        }

        if (moduleName == null) {
            return emptyList();
        }

        val project: Project = element.project;

        return StubIndex
            .getElements(OapModuleNameIndex.KEY, moduleName, project, GlobalSearchScope.allScope(project), OapModuleNamePair::class.java)
            .mapNotNull { PsiTreeUtil.findChildOfType(it.parent, OapModuleServices::class.java) }
            .flatMap { it.services }

    }
}