package oap.application.plugin.gen.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static oap.application.plugin.gen.OapTypes.*;

%%

%{
  public _OapLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%unicode
%class _OapLexer
%public
%implements FlexLexer
%function advance
%type IElementType

BOOL=true|false
DURATION=[0-9]+(kb|mb|gb|ms|s|m|h|d|w)

DOUBLE=[-+]?[0-9]+(_[0-9]+)*\.[0-9]+
LONG = [-+][0-9]+(_[0-9]+)*
ULONG = [0-9]+(_[0-9]+)*

DASH=-
LETTERS=\w+
NEXTLINE=\r\n|\n
WHITE_SPACE=[ \t\x0B\f\r]+
COMMENT=("//"|"#")[^\n]+
STRING=\"(\\\"|[^\"])*\"

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "="                  { return OAP_EQ; }
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { return OAP_RIGHTBRACE; }
  "["                  { return OAP_LEFTBRACKET; }
  "]"                  { return OAP_RIGHTBRACKET; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }
  "<"                  { return OAP_LEFTANGLE; }
  ">"                  { return OAP_RIGHTANGLE; }
  ","                  { return OAP_COMMA; }
  "/"                  { return OAP_DIV; }
  "$"                  { return OAP_DOLLAR; }

  {DURATION}           { return OAP_DURATION; }
  {DOUBLE}             { return OAP_DOUBLE; }
  {LONG}             { return OAP_LONG; }
  {ULONG}             { return OAP_ULONG; }

  "."                  { return OAP_DOT; }
  "-"                  { return OAP_DASH; }

  {NEXTLINE}           { return OAP_NEXTLINE; }
  {BOOL}               { return OAP_BOOL; }

  {LETTERS}            { return OAP_LETTERS; }
  {COMMENT}            { return OAP_COMMENT; }
  {STRING}             { return OAP_STRING; }

}

[^] { return BAD_CHARACTER; }
