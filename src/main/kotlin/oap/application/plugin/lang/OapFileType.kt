package oap.application.plugin.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import oap.application.plugin.OapIcons
import javax.swing.Icon

class OapFileType : LanguageFileType(OapLanguage) {
    override fun getName(): String {
        return "OAP"
    }

    override fun getDescription(): String {
        return "OAP"
    }

    override fun getDefaultExtension(): String {
        return "oap"
    }

    override fun getIcon(): Icon {
        return OapIcons.Action
    }

    object OapFileType {
        val INSTANCE = OapFileType()
    }
}