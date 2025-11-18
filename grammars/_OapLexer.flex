package oap.application.plugin.gen.parser;

import java.util.Stack;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static oap.application.plugin.gen.OapTypes.*;

%%

//%debug
%{
  public _OapLexer() {
      this((java.io.Reader)null);
    }

    private static String zzToPrintable(CharSequence str) {
        return zzToPrintable(str.toString());
    }

    private Stack<Integer> stack = new Stack<Integer>();

    // Helper method to push the current state onto the stack and switch to a new state
    private void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    private String printState(int state) {
        return switch (state) {
            case YYINITIAL -> "YYINITIAL";
            case INCLUDE -> "INCLUDE";
            case DEPENDS_ON -> "DEPENDS_ON";
            case DEPENDS_ON_IN -> "DEPENDS_ON_IN";
            case CONFIGURATIONS -> "CONFIGURATIONS";
            case CONFIGURATIONS_OBJECTS -> "CONFIGURATIONS_OBJECTS";
            case CONFIGURATIONS_OBJECT -> "CONFIGURATIONS_OBJECT";
            case CONFIGURATIONS_OBJECT_LOADER -> "CONFIGURATIONS_OBJECT_LOADER";
            case CONFIGURATIONS_OBJECT_CONFIG -> "CONFIGURATIONS_OBJECT_CONFIG";
            case SERVICES -> "SERVICES";
            case SERVICES_IN -> "SERVICES_IN";
            case SERVICES_SERVICE -> "SERVICES_SERVICE";
            case SERVICES_SERVICE_REMOTE -> "SERVICES_SERVICE_REMOTE";
            case SERVICES_SERVICE_PARAMETERS -> "SERVICES_SERVICE_PARAMETERS";
            case SERVICES_SERVICE_WS_SERVICE -> "SERVICES_SERVICE_WS_SERVICE";
            case SERVICES_SERVICE_WS_SERVICE_DOT_PATH -> "SERVICES_SERVICE_WS_SERVICE_DOT_PATH";
            case SERVICES_SERVICE_WS_HANDLER -> "SERVICES_SERVICE_WS_HANDLER";
            case SERVICES_SERVICE_WS_HANDLER_DOT_PATH -> "SERVICES_SERVICE_WS_HANDLER_DOT_PATH";
            case SERVICES_SERVICE_SUPERVISION -> "SERVICES_SERVICE_SUPERVISION";
            case LISTEN -> "LISTEN";
            case LISTEN_IN -> "LISTEN_IN";
            case _ARRAY -> "_ARRAY";
            case _OBJECT -> "_OBJECT";
            case _OBJECT_ENTITY -> "_OBJECT_ENTITY";
            case KEY_VALUE_SINGLE_OR_ARRAY -> "KEY_VALUE_SINGLE_OR_ARRAY";
            case KEY_VALUE_SINGLE_OR_ARRAY_ARRAY -> "KEY_VALUE_SINGLE_OR_ARRAY_ARRAY";
            case KEY_VALUE_CLASS -> "KEY_VALUE_CLASS";
            case KEY_VALUE_STRING -> "KEY_VALUE_STRING";
            case _VALUE_REFERENCE -> "_VALUE_REFERENCE";
            case VALUE_REFERENCE -> "VALUE_REFERENCE";
            case KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY -> "KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY";
            case KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY -> "KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY";
            case MODULE_REFERENCE -> "MODULE_REFERENCE";
            case _ENV -> "_ENV";

            default -> throw new RuntimeException("Unknown state" + state);
        };
    }

    // Helper method to pop a state from the stack and switch to it
    private void yypopState() {
      if(!stack.isEmpty()) {
        Integer s = stack.pop();
//        System.out.println("pop state " + printState(yystate()) + " -> " + printState(s));
        yybegin(s);
      } else {
        // Handle the error or default to YYINITIAL if the stack is empty
        System.out.println("pop state (no change) " + printState(yystate()) + " -> " + "YYINITIAL");
        yybegin(YYINITIAL);
      }
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

NEXTLINE=(\r\n|\n)+
WHITE_SPACE=[ \t\x0B\f\r]+
COMMENT=("//"|"#")[^\n]+
STRING=\"(\\\"|[^\"])*\"
UNQUOTED_STRING=([:jletterdigit:]|[-/\.]) ([:jletterdigit:]|[-/\. ])*
CLASS_NAME=([:jletter:] [:jletterdigit:]+)("." [:jletter:] [:jletterdigit:]+)+
FIELD_NAME=[:jletter:] [:jletterdigit:]+
KEY_NAME=[:jletter:] ([:jletterdigit:]|[-/])*

%state INCLUDE
%state DEPENDS_ON, DEPENDS_ON_IN
%state CONFIGURATIONS, CONFIGURATIONS_OBJECTS, CONFIGURATIONS_OBJECT, CONFIGURATIONS_OBJECT_LOADER, CONFIGURATIONS_OBJECT_CONFIG
%state SERVICES, SERVICES_IN, SERVICES_SERVICE, SERVICES_SERVICE_REMOTE
%state SERVICES_SERVICE_PARAMETERS
%state SERVICES_SERVICE_WS_SERVICE, SERVICES_SERVICE_WS_SERVICE_DOT_PATH
%state SERVICES_SERVICE_WS_HANDLER, SERVICES_SERVICE_WS_HANDLER_DOT_PATH
%state SERVICES_SERVICE_SUPERVISION
%state LISTEN, LISTEN_IN

%state _ARRAY, _OBJECT, _OBJECT_ENTITY

%state KEY_VALUE_SINGLE_OR_ARRAY, KEY_VALUE_SINGLE_OR_ARRAY_ARRAY
%state KEY_VALUE_CLASS, KEY_VALUE_STRING, _VALUE_REFERENCE, VALUE_REFERENCE
%state KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY, KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY, MODULE_REFERENCE

%state _ENV

%%
<YYINITIAL> {
  "name"               { yypushState(KEY_VALUE_STRING); return OAP_ID_NAME; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }
  "include"/{WHITE_SPACE}"required" { yypushState(INCLUDE); return OAP_ID_INCLUDE; }
  "dependsOn"          { yypushState(DEPENDS_ON); return OAP_ID_DEPENDS_ON; }
  "services"           { yybegin(SERVICES); return OAP_ID_SERVICES; }
  "configurations"     { yybegin(CONFIGURATIONS); return OAP_ID_CONFIGURATIONS; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}

  {COMMENT}            { return OAP_COMMENT; }

<INCLUDE> {
  "required"           { return OAP_ID_REQUIRED; }
  {BOOL}               { return OAP_BOOL; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }
  {STRING}             { return OAP_INCLUDE_RESOURCE_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<DEPENDS_ON> {
  "="                  { return OAP_EQ; }
  "["                  { yypushState(DEPENDS_ON_IN); return OAP_LEFTBRACKET; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<DEPENDS_ON_IN> {
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  ","                  { return OAP_COMMA; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}

<SERVICES_SERVICE_PARAMETERS> {
  "{"                  { yypopState(); yypushState(_OBJECT); return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }

  "."                  { return OAP_DOT; }
  "="                  { yypopState(); yypushState(_OBJECT_ENTITY); return OAP_EQ; }

  {KEY_NAME}           { return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}

<CONFIGURATIONS> {
  "="                  { return OAP_EQ; }

  "["                  { yybegin(CONFIGURATIONS_OBJECTS); return OAP_LEFTBRACKET; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<CONFIGURATIONS_OBJECTS> {
  "]"                  { yybegin(YYINITIAL); return OAP_RIGHTBRACKET; }

  "{"                  { yybegin(CONFIGURATIONS_OBJECT); return OAP_LEFTBRACE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<CONFIGURATIONS_OBJECT> {
  "}"                  { yybegin(CONFIGURATIONS_OBJECTS); return OAP_RIGHTBRACE; }

  "loader"             { yybegin(CONFIGURATIONS_OBJECT_LOADER); return OAP_ID_LOADER; }
  "config"             { yybegin(CONFIGURATIONS_OBJECT_CONFIG); return OAP_ID_CONFIG; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<CONFIGURATIONS_OBJECT_LOADER> {
  "="                  { return OAP_EQ; }
  {CLASS_NAME}         { return OAP_CLASS_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yybegin(CONFIGURATIONS_OBJECT); return WHITE_SPACE; }
}
<CONFIGURATIONS_OBJECT_CONFIG> {
  "="                  { return OAP_EQ; }
  "["                  { yypushState(_ARRAY); return OAP_LEFTBRACKET; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yybegin(CONFIGURATIONS_OBJECT); return WHITE_SPACE; }
}


<SERVICES> {
  "{"                  { yybegin(SERVICES_IN); return OAP_LEFTBRACE; }
  "}"                  { yybegin(YYINITIAL); return OAP_RIGHTBRACE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<SERVICES_IN> {
  "implementation"     { yypushState(SERVICES_IN); yybegin(KEY_VALUE_CLASS); return OAP_ID_IMPLEMENTATION; }

  {KEY_NAME}           { return OAP_KEY_NAME; }
  "{"                  { yypushState(SERVICES_SERVICE); return OAP_LEFTBRACE; }
  "."                  { return OAP_DOT; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }


  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}

<SERVICES_SERVICE> {
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }

  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }
  "abstract"           { yypushState(KEY_VALUE_STRING); return OAP_ID_ABSTRACT; }
  "implementation"     { yypushState(KEY_VALUE_CLASS); return OAP_ID_IMPLEMENTATION; }
  "default"            { yypushState(KEY_VALUE_STRING); return OAP_ID_DEFAULT; }
  "dependsOn"          { yypushState(DEPENDS_ON); return OAP_ID_DEPENDS_ON; }
  "listen"             { yypushState(LISTEN); return OAP_ID_LISTEN; }
  "link"               { yypushState(LISTEN); return OAP_ID_LINK; }
  "parameters"         { yypushState(SERVICES_SERVICE_PARAMETERS); return OAP_ID_PARAMETERS; }
  "remote"             { yybegin(SERVICES_SERVICE_REMOTE); return OAP_ID_REMOTE; }
  "ws-service"         { yypushState(SERVICES_SERVICE_WS_SERVICE); return OAP_ID_WS_SERVICE; }
  "ws-handler"         { yypushState(SERVICES_SERVICE_WS_HANDLER); return OAP_ID_WS_HANDLER; }
  "supervision"        { yypushState(SERVICES_SERVICE_SUPERVISION); return OAP_ID_SUPERVISION; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<SERVICES_SERVICE_REMOTE> {
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yybegin(SERVICES_SERVICE); return OAP_RIGHTBRACE; }
  "url"                { yypushState(KEY_VALUE_STRING); return OAP_ID_URL; }
  "name"               { yypushState(_VALUE_REFERENCE); return OAP_ID_NAME; }
  "serialization"      { yypushState(KEY_VALUE_STRING); return OAP_ID_SERIALIZATION; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<SERVICES_SERVICE_WS_SERVICE> {
  "."                  { yybegin(SERVICES_SERVICE_WS_SERVICE_DOT_PATH); return OAP_DOT; }
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "path"               { yypushState(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }
  "port"               { yypushState(KEY_VALUE_STRING); return OAP_ID_PATH; }
  "interceptors"       { yypushState(KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY); return OAP_ID_INTERCEPTORS; }
  "sessionAware"       { yypushState(KEY_VALUE_STRING); return OAP_ID_SESSIONAWARE; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<SERVICES_SERVICE_WS_SERVICE_DOT_PATH> {
  "path"               { yybegin(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<SERVICES_SERVICE_WS_HANDLER> {
  "."                  { yybegin(SERVICES_SERVICE_WS_HANDLER_DOT_PATH); return OAP_DOT; }
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "path"               { yypushState(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }
  "port"               { yypushState(KEY_VALUE_STRING); return OAP_ID_PATH; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }
  "compression"        { yypushState(KEY_VALUE_STRING); return OAP_ID_COMPRESSION; }
  "blocking"           { yypushState(KEY_VALUE_STRING); return OAP_ID_BLOCKING; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<SERVICES_SERVICE_WS_HANDLER_DOT_PATH> {
  "path"               { yybegin(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}

<SERVICES_SERVICE_SUPERVISION> {
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "."                  { yypopState(); yybegin(SERVICES_SERVICE_SUPERVISION); return OAP_DOT; }
  "supervise"          { yypushState(KEY_VALUE_STRING); return OAP_ID_SUPERVISE; }
  "schedule"           { yypushState(KEY_VALUE_STRING); return OAP_ID_SCHEDULE; }
  "thread"             { yypushState(KEY_VALUE_STRING); return OAP_ID_THREAD; }
  "delay"              { yypushState(KEY_VALUE_STRING); return OAP_ID_DELAY; }
  "cron"              { yypushState(KEY_VALUE_STRING); return OAP_ID_CRON; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<LISTEN> {
  "{"                  { yypopState(); yypushState(LISTEN_IN); return OAP_LEFTBRACE; }
  "."                  { return OAP_DOT; }

  {KEY_NAME}           { yypopState(); yypushState(_VALUE_REFERENCE); return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<LISTEN_IN> {
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }

  {KEY_NAME}           {yypushState(_VALUE_REFERENCE); return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}




<KEY_VALUE_STRING> {
  "="                  { return OAP_EQ; }
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  {BOOL}               { return OAP_BOOL; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<KEY_VALUE_CLASS> {
  "="                  { return OAP_EQ; }

  {CLASS_NAME}         { return OAP_CLASS_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<KEY_VALUE_SINGLE_OR_ARRAY> {
  "="                  { return OAP_EQ; }
  "["                  { yypushState(KEY_VALUE_SINGLE_OR_ARRAY_ARRAY); return OAP_LEFTBRACKET; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<KEY_VALUE_SINGLE_OR_ARRAY_ARRAY> {
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  ","                  { return OAP_COMMA; }
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<_VALUE_REFERENCE> {
  "="                  {  return OAP_EQ; }
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<VALUE_REFERENCE> {
  ">"                  { yypopState(); return OAP_RIGHTANGLE; }
  "."                  { return OAP_DOT; }

  "modules"            { return OAP_ID_MODULES; }
  "services"           { return OAP_ID_SERVICES; }
  "self"               { return OAP_ID_SELF; }
  "this"               { return OAP_ID_THIS; }
  "kernel"             { return OAP_ID_KERNEL; }

  {KEY_NAME}           { return OAP_REFERENCE_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypushback(yytext().length()); yypopState(); return WHITE_SPACE; }
}
<KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY> {
  "="                  {  return OAP_EQ; }
  "<"                  { yypushState(MODULE_REFERENCE); return OAP_LEFTANGLE; }
  "["                  { yypushState(KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY); return OAP_LEFTBRACKET; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY> {
  "<"                  { yypushState(MODULE_REFERENCE); return OAP_LEFTANGLE; }
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  ","                  { return OAP_COMMA; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<MODULE_REFERENCE> {
  ">"                  { yypopState(); return OAP_RIGHTANGLE; }
  "."                  { return OAP_DOT; }

  "modules"            { return OAP_ID_MODULES; }

  {KEY_NAME}           { return OAP_REFERENCE_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
}


<_ARRAY> {
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }
  ","                  { return OAP_COMMA; }
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<_OBJECT> {
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }

  {KEY_NAME}           { return OAP_KEY_NAME; }
  "."                  { return OAP_DOT; }
  "="                  { yypushState(_OBJECT_ENTITY); return OAP_EQ; }

  ","                  { return OAP_COMMA; }

  "include"/{WHITE_SPACE}"required" { yypushState(INCLUDE); return OAP_ID_INCLUDE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return WHITE_SPACE; }
}
<_OBJECT_ENTITY> {
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  "["                  { yypushState(_ARRAY); return OAP_LEFTBRACKET; }
  "}"                  { yypopState(); yypushback(1); }

  "$"                 { yypushState(_ENV); return OAP_DOLLAR; }
  {BOOL}               { return OAP_BOOL; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return WHITE_SPACE; }
}
<_ENV> {
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
}

[^] { return BAD_CHARACTER; }
