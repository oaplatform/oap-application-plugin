package oap.application.plugin.lexer

import com.intellij.lexer.FlexAdapter
import oap.application.plugin.gen.parser._OapLexer

class OapLexer : FlexAdapter(_OapLexer())