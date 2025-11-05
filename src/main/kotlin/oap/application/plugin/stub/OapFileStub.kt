package oap.application.plugin.stub

import com.intellij.psi.stubs.PsiFileStubImpl
import oap.application.plugin.psi.OapFile

class OapFileStub(file: OapFile?) : PsiFileStubImpl<OapFile>(file)