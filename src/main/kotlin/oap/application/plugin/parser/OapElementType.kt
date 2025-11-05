package oap.application.plugin.parser

import com.intellij.psi.tree.IFileElementType
import oap.application.plugin.lang.OapLanguage

object OapElementType {
    val OapFileElementType: IFileElementType = IFileElementType("OAP_FILE", OapLanguage)
}