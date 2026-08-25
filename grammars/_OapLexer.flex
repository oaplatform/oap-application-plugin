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

    // Indentation tracking for YAML-style ':' block objects.
    // Column stack for currently-open colon blocks; a "-1" entry means the block
    // was just opened and its indent column has not been established yet.
    private Stack<Integer> indentStack = new Stack<Integer>();
    // The lexer state to resume in once BOL_CHECK has resolved the current line's indentation.
    private int pendingReturnState = YYINITIAL;

    // Generated reset(CharSequence, int, int, int) reinitializes the character buffer and JFlex
    // %state, but knows nothing about the extra fields above (stack, indentStack,
    // pendingReturnState) - if a lexer instance is reused for a new document (or a different
    // range) without this, stale entries from whatever was lexed previously leak into the new
    // lex. Called from oap.application.plugin.lexer.OapLexer.start(), which every wrapper
    // around this lexer (highlighting, parsing) is built on.
    public void resetIndentState() {
        stack.clear();
        indentStack.clear();
        pendingReturnState = YYINITIAL;
    }

    // Called from every {NEXTLINE} rule's action, after any state transition it already
    // performs. If we're currently inside one or more open colon-blocks, route the next
    // line's leading whitespace through BOL_CHECK to decide INDENT/DEDENT; otherwise this
    // is a no-op and behaves exactly as before (plain WHITE_SPACE), so brace-only input is
    // completely unaffected.
    private IElementType handleNextline() {
        if (!indentStack.isEmpty()) {
            pendingReturnState = yystate();
            yybegin(BOL_CHECK);
        }
        return WHITE_SPACE;
    }

    // Peeks the character right after the current match without consuming it. JFlex's
    // trailing-context '/' operator can't be used here (both sides would be variable-length,
    // which JFlex rejects), so BOL_CHECK inspects the next character directly instead.
    private char peekChar() {
        return zzMarkedPos < zzEndRead ? zzBuffer.charAt(zzMarkedPos) : '\0';
    }

    // Scans forward from the current position, skipping spaces/tabs, to decide what a nested
    // key's ':' means: true if only whitespace/comment/EOF follows before the next newline (this
    // ':' opens a nested block, YAML-style), false if real content follows on the same line
    // (this ':' is a scalar assignment, same as '=').
    private boolean colonOpensBlock() {
        int i = zzMarkedPos;
        while (i < zzEndRead) {
            char c = zzBuffer.charAt(i);
            if (c == ' ' || c == '\t') { i++; continue; }
            if (c == '\r' || c == '\n') return true;
            if (c == '#') return true;
            if (c == '/' && i + 1 < zzEndRead && zzBuffer.charAt(i + 1) == '/') return true;
            return false;
        }
        return true;
    }

    private String printState(int state) {
        return switch (state) {
            case YYINITIAL -> "YYINITIAL";
            case INCLUDE -> "INCLUDE";
            case DEPENDS_ON -> "DEPENDS_ON";
            case DEPENDS_ON_IN -> "DEPENDS_ON_IN";
            case DEPENDS_ON_BLOCK_ITEM -> "DEPENDS_ON_BLOCK_ITEM";
            case CONFIGURATIONS -> "CONFIGURATIONS";
            case CONFIGURATIONS_OBJECTS -> "CONFIGURATIONS_OBJECTS";
            case CONFIGURATIONS_OBJECT -> "CONFIGURATIONS_OBJECT";
            case CONFIGURATIONS_OBJECT_LOADER -> "CONFIGURATIONS_OBJECT_LOADER";
            case CONFIGURATIONS_OBJECT_CONFIG -> "CONFIGURATIONS_OBJECT_CONFIG";
            case CONFIGURATIONS_BLOCK_ITEM -> "CONFIGURATIONS_BLOCK_ITEM";
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
            case _ARRAY_BLOCK_ITEM -> "_ARRAY_BLOCK_ITEM";
            case KEY_VALUE_SINGLE_OR_ARRAY -> "KEY_VALUE_SINGLE_OR_ARRAY";
            case KEY_VALUE_SINGLE_OR_ARRAY_ARRAY -> "KEY_VALUE_SINGLE_OR_ARRAY_ARRAY";
            case KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM -> "KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM";
            case KEY_VALUE_CLASS -> "KEY_VALUE_CLASS";
            case KEY_VALUE_STRING -> "KEY_VALUE_STRING";
            case _VALUE_REFERENCE -> "_VALUE_REFERENCE";
            case VALUE_REFERENCE -> "VALUE_REFERENCE";
            case KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY -> "KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY";
            case KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY -> "KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY";
            case KEY_VALUE_MODULE_REFERENCE_BLOCK_ITEM -> "KEY_VALUE_MODULE_REFERENCE_BLOCK_ITEM";
            case MODULE_REFERENCE -> "MODULE_REFERENCE";
            case _ENV -> "_ENV";
            case BOL_CHECK -> "BOL_CHECK";
            case BOL_CHECK2 -> "BOL_CHECK2";

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
//        System.out.println("pop state (no change) " + printState(yystate()) + " -> " + "YYINITIAL");
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
COMMENT=("//"|"#")[^\n]*
STRING=\"(\\\"|[^\"])*\"
UNQUOTED_STRING=([:jletterdigit:]|[-/\.]) ([:jletterdigit:]|[-/\. ])*
// Same as UNQUOTED_STRING but the first character can't be '-': used inside dash-list block
// items (DEPENDS_ON_BLOCK_ITEM, KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM), where a bare "-" is a
// list marker and UNQUOTED_STRING's own leading '-' would otherwise longest-match straight
// through "- value" (dash, space, value) as a single token, since its continuation class
// includes space too.
UNQUOTED_STRING_ITEM=([:jletterdigit:]|[/\.]) ([:jletterdigit:]|[-/\. ])*
CLASS_NAME=([:jletter:] [:jletterdigit:]*)("." [:jletter:] [:jletterdigit:]*)*
FIELD_NAME=[:jletter:] [:jletterdigit:]+
KEY_NAME=[:jletter:] ([:jletterdigit:]|[-/])*

%state INCLUDE
%state DEPENDS_ON, DEPENDS_ON_IN, DEPENDS_ON_BLOCK_ITEM
%state CONFIGURATIONS, CONFIGURATIONS_OBJECTS, CONFIGURATIONS_OBJECT, CONFIGURATIONS_OBJECT_LOADER, CONFIGURATIONS_OBJECT_CONFIG, CONFIGURATIONS_BLOCK_ITEM
%state SERVICES, SERVICES_IN, SERVICES_SERVICE, SERVICES_SERVICE_REMOTE, SERVICES_SERVICE_REMOTE_DOT_NAME
%state SERVICES_SERVICE_PARAMETERS
%state SERVICES_SERVICE_WS_SERVICE, SERVICES_SERVICE_WS_SERVICE_DOT_PATH
%state SERVICES_SERVICE_WS_HANDLER, SERVICES_SERVICE_WS_HANDLER_DOT_PATH
%state SERVICES_SERVICE_SUPERVISION
%state LISTEN, LISTEN_IN

%state _ARRAY, _OBJECT, _OBJECT_ENTITY, _ARRAY_BLOCK_ITEM

%state KEY_VALUE_SINGLE_OR_ARRAY, KEY_VALUE_SINGLE_OR_ARRAY_ARRAY, KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM
%state KEY_VALUE_CLASS, KEY_VALUE_STRING, _VALUE_REFERENCE, VALUE_REFERENCE
%state KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY, KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY, MODULE_REFERENCE, KEY_VALUE_MODULE_REFERENCE_BLOCK_ITEM

%state _ENV

%state BOL_CHECK, BOL_CHECK2

%%
<YYINITIAL> {
  "name"               { yypushState(KEY_VALUE_STRING); return OAP_ID_NAME; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }
  "include"/{WHITE_SPACE}"required" { yypushState(INCLUDE); return OAP_ID_INCLUDE; }
  "dependsOn"          { yypushState(DEPENDS_ON); return OAP_ID_DEPENDS_ON; }
  "services"           { yybegin(SERVICES); return OAP_ID_SERVICES; }
  "configurations"     { yybegin(CONFIGURATIONS); return OAP_ID_CONFIGURATIONS; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}

  {COMMENT}            { return OAP_COMMENT; }

<INCLUDE> {
  "required"           { return OAP_ID_REQUIRED; }
  {BOOL}               { return OAP_BOOL; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }
  {STRING}             { return OAP_STRING; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<DEPENDS_ON> {
  "="                  { return OAP_EQ; }
  ":"                  {
                           if (colonOpensBlock()) {
                               yypopState();
                               yypushState(DEPENDS_ON_BLOCK_ITEM);
                               indentStack.push(-1);
                           }
                           return OAP_COLON;
                       }
  "["                  { yypushState(DEPENDS_ON_IN); return OAP_LEFTBRACKET; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<DEPENDS_ON_BLOCK_ITEM> {
  "-"                  { return OAP_DASH; }
  {UNQUOTED_STRING_ITEM} { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<DEPENDS_ON_IN> {
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  ","                  { return OAP_COMMA; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}

<SERVICES_SERVICE_PARAMETERS> {
  "{"                  { yypopState(); yypushState(_OBJECT); return OAP_LEFTBRACE; }
  ":"                  { yypopState(); yypushState(_OBJECT); indentStack.push(-1); return OAP_COLON; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }

  "."                  { return OAP_DOT; }
  "="                  { yypopState(); yypushState(_OBJECT_ENTITY); return OAP_EQ; }

  {KEY_NAME}           { return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}

<CONFIGURATIONS> {
  "="                  { return OAP_EQ; }
  ":"                  { yybegin(CONFIGURATIONS_BLOCK_ITEM); return OAP_COLON; }

  "["                  { yybegin(CONFIGURATIONS_OBJECTS); return OAP_LEFTBRACKET; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<CONFIGURATIONS_OBJECTS> {
  "]"                  { yybegin(YYINITIAL); return OAP_RIGHTBRACKET; }

  "{"                  { yybegin(CONFIGURATIONS_OBJECT); return OAP_LEFTBRACE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<CONFIGURATIONS_OBJECT> {
  "}"                  { yybegin(CONFIGURATIONS_OBJECTS); return OAP_RIGHTBRACE; }

  "loader"             { yypushState(CONFIGURATIONS_OBJECT_LOADER); return OAP_ID_LOADER; }
  "config"             { yypushState(CONFIGURATIONS_OBJECT_CONFIG); return OAP_ID_CONFIG; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<CONFIGURATIONS_OBJECT_LOADER> {
  "="                  { return OAP_EQ; }
  ":"                  { return OAP_COLON; }
  {CLASS_NAME}         { return OAP_CLASS_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<CONFIGURATIONS_OBJECT_CONFIG> {
  "="                  { return OAP_EQ; }
  "["                  { yypushState(_ARRAY); return OAP_LEFTBRACKET; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }
  ":"                  {
                           // Unlike "{", whose closing '}' is consumed by _OBJECT and then relies
                           // on this state's own {NEXTLINE} rule (below) to pop through to
                           // CONFIGURATIONS_OBJECT - a second pop that a synthetic DEDENT has no
                           // separate event to trigger. Popping here instead means DEDENT's single
                           // yypopState() lands directly on CONFIGURATIONS_OBJECT, which already
                           // knows how to handle the '}' that follows (same pop-then-push pattern
                           // used by every other ':' block entry point, e.g. SERVICES_SERVICE_PARAMETERS).
                           yypopState();
                           yypushState(_OBJECT);
                           indentStack.push(-1);
                           return OAP_COLON;
                       }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<CONFIGURATIONS_BLOCK_ITEM> {
  "-"                  { return OAP_DASH; }

  "loader"             { yypushState(CONFIGURATIONS_OBJECT_LOADER); return OAP_ID_LOADER; }
  "config"             { yypushState(CONFIGURATIONS_OBJECT_CONFIG); return OAP_ID_CONFIG; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}


<SERVICES> {
  "{"                  { yybegin(SERVICES_IN); return OAP_LEFTBRACE; }
  ":"                  { yybegin(SERVICES_IN); indentStack.push(-1); return OAP_COLON; }
  "}"                  { yybegin(YYINITIAL); return OAP_RIGHTBRACE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<SERVICES_IN> {
  "implementation"     { yypushState(SERVICES_IN); yybegin(KEY_VALUE_CLASS); return OAP_ID_IMPLEMENTATION; }

  {KEY_NAME}           { return OAP_KEY_NAME; }
  "{"                  { yypushState(SERVICES_SERVICE); return OAP_LEFTBRACE; }
  ":"                  { yypushState(SERVICES_SERVICE); indentStack.push(-1); return OAP_COLON; }
  "."                  { return OAP_DOT; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }


  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
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
  "remote"             { yypushState(SERVICES_SERVICE_REMOTE); return OAP_ID_REMOTE; }
  "ws-service"         { yypushState(SERVICES_SERVICE_WS_SERVICE); return OAP_ID_WS_SERVICE; }
  "ws-handler"         { yypushState(SERVICES_SERVICE_WS_HANDLER); return OAP_ID_WS_HANDLER; }
  "supervision"        { yypushState(SERVICES_SERVICE_SUPERVISION); return OAP_ID_SUPERVISION; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<SERVICES_SERVICE_REMOTE> {
  "."                  { yybegin(SERVICES_SERVICE_REMOTE_DOT_NAME); return OAP_DOT; }
  "{"                  { return OAP_LEFTBRACE; }
  ":"                  { indentStack.push(-1); return OAP_COLON; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "url"                { yypushState(KEY_VALUE_STRING); return OAP_ID_URL; }
  "name"               { yypushState(_VALUE_REFERENCE); return OAP_ID_NAME; }
  "timeout"            { yypushState(KEY_VALUE_STRING); return OAP_ID_TIMEOUT; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<SERVICES_SERVICE_REMOTE_DOT_NAME> {
  "name"               { yybegin(_VALUE_REFERENCE); return OAP_ID_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<SERVICES_SERVICE_WS_SERVICE> {
  "."                  { yybegin(SERVICES_SERVICE_WS_SERVICE_DOT_PATH); return OAP_DOT; }
  "{"                  { return OAP_LEFTBRACE; }
  ":"                  { indentStack.push(-1); return OAP_COLON; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "path"               { yypushState(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }
  "port"               { yypushState(KEY_VALUE_STRING); return OAP_ID_PATH; }
  "interceptors"       { yypushState(KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY); return OAP_ID_INTERCEPTORS; }
  "sessionAware"       { yypushState(KEY_VALUE_STRING); return OAP_ID_SESSIONAWARE; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<SERVICES_SERVICE_WS_SERVICE_DOT_PATH> {
  "path"               { yybegin(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<SERVICES_SERVICE_WS_HANDLER> {
  "."                  { yybegin(SERVICES_SERVICE_WS_HANDLER_DOT_PATH); return OAP_DOT; }
  "{"                  { return OAP_LEFTBRACE; }
  ":"                  { indentStack.push(-1); return OAP_COLON; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "path"               { yypushState(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }
  "port"               { yypushState(KEY_VALUE_STRING); return OAP_ID_PATH; }
  "enabled"            { yypushState(KEY_VALUE_STRING); return OAP_ID_ENABLED; }
  "compression"        { yypushState(KEY_VALUE_STRING); return OAP_ID_COMPRESSION; }
  "blocking"           { yypushState(KEY_VALUE_STRING); return OAP_ID_BLOCKING; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<SERVICES_SERVICE_WS_HANDLER_DOT_PATH> {
  "path"               { yybegin(KEY_VALUE_SINGLE_OR_ARRAY); return OAP_ID_PATH; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}

<SERVICES_SERVICE_SUPERVISION> {
  "{"                  { return OAP_LEFTBRACE; }
  ":"                  { indentStack.push(-1); return OAP_COLON; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "."                  { yypopState(); yybegin(SERVICES_SERVICE_SUPERVISION); return OAP_DOT; }
  "supervise"          { yypushState(KEY_VALUE_STRING); return OAP_ID_SUPERVISE; }
  "schedule"           { yypushState(KEY_VALUE_STRING); return OAP_ID_SCHEDULE; }
  "thread"             { yypushState(KEY_VALUE_STRING); return OAP_ID_THREAD; }
  "delay"              { yypushState(KEY_VALUE_STRING); return OAP_ID_DELAY; }
  "cron"              { yypushState(KEY_VALUE_STRING); return OAP_ID_CRON; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<LISTEN> {
  "{"                  { yypopState(); yypushState(LISTEN_IN); return OAP_LEFTBRACE; }
  ":"                  { yypopState(); yypushState(LISTEN_IN); indentStack.push(-1); return OAP_COLON; }
  "."                  { return OAP_DOT; }

  {KEY_NAME}           { yypopState(); yypushState(_VALUE_REFERENCE); return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<LISTEN_IN> {
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }

  {KEY_NAME}           {yypushState(_VALUE_REFERENCE); return OAP_KEY_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}




<KEY_VALUE_STRING> {
  "="                  { return OAP_EQ; }
  ":"                  { return OAP_COLON; }
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  {BOOL}               { return OAP_BOOL; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<KEY_VALUE_CLASS> {
  "="                  { return OAP_EQ; }
  ":"                  { return OAP_COLON; }

  {CLASS_NAME}         { return OAP_CLASS_NAME; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<KEY_VALUE_SINGLE_OR_ARRAY> {
  "="                  { return OAP_EQ; }
  ":"                  {
                           if (colonOpensBlock()) {
                               yypopState();
                               yypushState(KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM);
                               indentStack.push(-1);
                           }
                           return OAP_COLON;
                       }
  "["                  { yypushState(KEY_VALUE_SINGLE_OR_ARRAY_ARRAY); return OAP_LEFTBRACKET; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<KEY_VALUE_SINGLE_OR_ARRAY_BLOCK_ITEM> {
  "-"                  { return OAP_DASH; }
  {UNQUOTED_STRING_ITEM} { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<KEY_VALUE_SINGLE_OR_ARRAY_ARRAY> {
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  ","                  { return OAP_COMMA; }
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<_VALUE_REFERENCE> {
  "="                  {  return OAP_EQ; }
  ":"                  { return OAP_COLON; }
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
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
  ":"                  {
                           if (colonOpensBlock()) {
                               yypopState();
                               yypushState(KEY_VALUE_MODULE_REFERENCE_BLOCK_ITEM);
                               indentStack.push(-1);
                           }
                           return OAP_COLON;
                       }
  "<"                  { yypushState(MODULE_REFERENCE); return OAP_LEFTANGLE; }
  "["                  { yypushState(KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY); return OAP_LEFTBRACKET; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
}
<KEY_VALUE_MODULE_REFERENCE_BLOCK_ITEM> {
  "-"                  { return OAP_DASH; }
  "<"                  { yypushState(MODULE_REFERENCE); return OAP_LEFTANGLE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<KEY_VALUE_MODULE_REFERENCE_SINGLE_OR_ARRAY_ARRAY> {
  "<"                  { yypushState(MODULE_REFERENCE); return OAP_LEFTANGLE; }
  "]"                  { yypopState(); return OAP_RIGHTBRACKET; }
  ","                  { return OAP_COMMA; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
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
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }

  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<_OBJECT> {
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }
  ":"                  {
                           if (colonOpensBlock()) {
                               yypushState(_OBJECT);
                               indentStack.push(-1);
                           } else {
                               yypushState(_OBJECT_ENTITY);
                           }
                           return OAP_COLON;
                       }

  {KEY_NAME}           { return OAP_KEY_NAME; }
  {STRING}             { return OAP_KEY_NAME; }
  "."                  { return OAP_DOT; }
  "="                  { yypushState(_OBJECT_ENTITY); return OAP_EQ; }

  ","                  { return OAP_COMMA; }

  "include"/{WHITE_SPACE}"required" { yypushState(INCLUDE); return OAP_ID_INCLUDE; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<_OBJECT_ENTITY> {
  "<"                  { yypushState(VALUE_REFERENCE); return OAP_LEFTANGLE; }

  "["                  { yypushState(_ARRAY); return OAP_LEFTBRACKET; }
  "{"                  { yypushState(_OBJECT); return OAP_LEFTBRACE; }
  "}"                  { yypopState(); yypushback(1); }

  "$"                 { yypushState(_ENV); return OAP_DOLLAR; }
  {BOOL}               { return OAP_BOOL; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
  {STRING}             { return OAP_KEY_VALUE; }
  "("                  { return OAP_LEFTPAREN; }
  ")"                  { return OAP_RIGHTPAREN; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { yypopState(); return handleNextline(); }
  ","                  { yypopState(); return OAP_COMMA; }
}
// Items of a YAML-style dash-list under an arbitrary parameters/config key (the ambiguous
// case: BOL_CHECK redirects here instead of _OBJECT once it sees the first real character
// of the block is '-', which a nested-object key can never start with). Reuses
// _OBJECT_ENTITY's existing value matching (<ref>, [array], {object}, bool, id_value,
// function, string) for whatever follows each dash.
<_ARRAY_BLOCK_ITEM> {
  "-"                  { yypushState(_OBJECT_ENTITY); return OAP_DASH; }

  {WHITE_SPACE}        { return WHITE_SPACE; }
  {NEXTLINE}           { return handleNextline(); }
}
<_ENV> {
  "{"                  { return OAP_LEFTBRACE; }
  "}"                  { yypopState(); return OAP_RIGHTBRACE; }
  {UNQUOTED_STRING}    { return OAP_KEY_VALUE; }
}

// Resolves the indentation of the next real line against `indentStack`, emitting
// synthetic zero-width OAP_INDENT/OAP_DEDENT tokens as needed, then resumes lexing
// in `pendingReturnState`. Blank-ish lines (only whitespace before the next newline)
// and comment-only lines never trigger an indent decision.
//
// BOL_CHECK/BOL_CHECK2 are two copies of the same state, ping-ponged between on each
// dedent loop iteration. IntelliJ's ValidatingLexerWrapper flags a lexer as "not
// progressing" when consecutive advance() calls return an identical
// (tokenType, startOffset, endOffset, state) tuple - which a multi-level dedent would
// otherwise do, since each OAP_DEDENT is zero-width at the same offset and indentStack
// (which is genuinely shrinking each iteration) isn't part of the observable state.
// Alternating the lexer state between iterations breaks that tuple without changing
// the emitted token stream.
//
// The pattern matches the leading whitespace run plus, greedily, one more character.
// That trailing "[^\r\n]?" is required: JFlex always prefers the longest match among
// competing rules, and the file-wide catch-all `[^]` rule (needed for BAD_CHARACTER
// recovery) matches 1 character everywhere, including here. At a genuine column-0
// decision point - no leading whitespace at all, e.g. a dedent all the way back to
// column 0 - this rule's "real" match is 0-length, so without the optional trailing
// character the catch-all would always win that comparison and this rule would never
// fire, silently skipping the dedent. `col`/`next` are re-derived from the buffer
// instead of relying on the (now longer, and not always whitespace-only) matched text.
<BOL_CHECK, BOL_CHECK2> {
  [ \t]*[^\r\n]? {
      int col = 0;
      while (zzStartRead + col < zzEndRead) {
          char c = zzBuffer.charAt(zzStartRead + col);
          if (c != ' ' && c != '\t') break;
          col++;
      }
      char next = col < yylength() ? yycharat(col) : peekChar();
      if (next == '\0' || next == '\r' || next == '\n' || next == '/' || next == '#') {
          // blank-ish or comment-only line: defer the indent decision to the next real line
          yypushback(yylength() - col);
          yybegin(pendingReturnState);
          if (col > 0) return WHITE_SPACE;
          // zero-width match: fall through, let JFlex continue scanning in the new state
      } else if (indentStack.isEmpty()) {
          yypushback(yylength() - col);
          yybegin(pendingReturnState);
          if (col > 0) return WHITE_SPACE;
          // zero-width match: fall through, let JFlex continue scanning in the new state
      } else {
          int top = indentStack.peek();
          if (top == -1) {
              indentStack.pop();
              indentStack.push(col);
              // Arbitrary parameters/config key values are ambiguous: ':' followed by an
              // indented block could be a nested object (the default, pendingReturnState
              // already _OBJECT) or a dash-list. A block's first real line starting with '-'
              // can only mean the latter, since a nested object's first key (KEY_NAME) can
              // never start with '-' - so redirect there instead. Scoped to pendingReturnState
              // == _OBJECT specifically so it can't clobber the unambiguous dash-list fields
              // (dependsOn, interceptors, path), which already resume in their own correct
              // dedicated block-item state by this point.
              if (next == '-' && pendingReturnState == _OBJECT) {
                  pendingReturnState = _ARRAY_BLOCK_ITEM;
              }
              yypushback(yylength());
              yybegin(pendingReturnState);
              return OAP_INDENT;
          } else if (col < top) {
              int nextBolState = yystate() == BOL_CHECK ? BOL_CHECK2 : BOL_CHECK;
              indentStack.pop();
              yypopState();
              pendingReturnState = yystate();
              yybegin(nextBolState);
              yypushback(yylength());
              return OAP_DEDENT;
          } else {
              yypushback(yylength() - col);
              yybegin(pendingReturnState);
              if (col > 0) return WHITE_SPACE;
              // zero-width match: fall through, let JFlex continue scanning in the new state
          }
      }
  }
}

<<EOF>> {
    if (!indentStack.isEmpty()) {
        indentStack.pop();
        zzAtEOF = false;
        return OAP_DEDENT;
    }
    return null;
}

[^] { return BAD_CHARACTER; }
