package oap.application.plugin.ref

import com.intellij.codeInsight.lookup.LookupElement

class OapPropertyLookupElement(val str: String) : LookupElement() {
    override fun getLookupString(): String {
        return str
    }
}