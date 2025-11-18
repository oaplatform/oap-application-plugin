// This is a generated file. Not intended for manual editing.
package oap.application.plugin.gen.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static oap.application.plugin.gen.OapTypes.*;
import static oap.application.plugin.parser.OapParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OapParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return module(b, l + 1);
  }

  /* ********************************************************** */
  // '<'  any_reference_in '>'
  public static boolean any_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_ANY_REFERENCE, "<any reference>");
    r = consumeToken(b, OAP_LEFTANGLE);
    p = r; // pin = 1
    r = r && report_error_(b, any_reference_in(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_reference);
    return r || p;
  }

  /* ********************************************************** */
  // &'modules' reference_modules_value_in | &'services' reference_services_in | &'kernel' reference_kernel_value_in
  public static boolean any_reference_in(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_ANY_REFERENCE_IN, "<any reference in>");
    r = any_reference_in_0(b, l + 1);
    if (!r) r = any_reference_in_1(b, l + 1);
    if (!r) r = any_reference_in_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'modules' reference_modules_value_in
  private static boolean any_reference_in_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any_reference_in_0_0(b, l + 1);
    r = r && reference_modules_value_in(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'modules'
  private static boolean any_reference_in_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_MODULES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'services' reference_services_in
  private static boolean any_reference_in_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any_reference_in_1_0(b, l + 1);
    r = r && reference_services_in(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'services'
  private static boolean any_reference_in_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SERVICES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'kernel' reference_kernel_value_in
  private static boolean any_reference_in_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any_reference_in_2_0(b, l + 1);
    r = r && reference_kernel_value_in(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'kernel'
  private static boolean any_reference_in_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any_reference_in_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_KERNEL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bool
  public static boolean bool_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_value")) return false;
    if (!nextTokenIs(b, OAP_BOOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_BOOL);
    exit_section_(b, m, OAP_BOOL_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // class_name
  public static boolean class_name_psi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name_psi")) return false;
    if (!nextTokenIs(b, OAP_CLASS_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_CLASS_NAME);
    exit_section_(b, m, OAP_CLASS_NAME_PSI, r);
    return r;
  }

  /* ********************************************************** */
  // '[' config_array_object* ']'
  public static boolean config_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIG_ARRAY, null);
    r = consumeToken(b, OAP_LEFTBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, config_array_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // config_array_object*
  private static boolean config_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_array_object(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_array_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // config_object
  public static boolean config_array_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_object(b, l + 1);
    exit_section_(b, m, OAP_CONFIG_ARRAY_OBJECT, r);
    return r;
  }

  /* ********************************************************** */
  // '{' (configuration_key_value_pair)* '}'
  public static boolean config_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIG_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, config_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (configuration_key_value_pair)*
  private static boolean config_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_object_1", c)) break;
    }
    return true;
  }

  // (configuration_key_value_pair)
  private static boolean config_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configuration_key_value_pair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( &'include' module_include ) | key_name ('.' key_name)* ('=' (&'[' config_array | bool_value | id_value ) | config_object )
  public static boolean configuration_key_value_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair")) return false;
    if (!nextTokenIs(b, "<configuration key value pair>", OAP_ID_INCLUDE, OAP_KEY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIGURATION_KEY_VALUE_PAIR, "<configuration key value pair>");
    r = configuration_key_value_pair_0(b, l + 1);
    if (!r) r = configuration_key_value_pair_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'include' module_include
  private static boolean configuration_key_value_pair_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configuration_key_value_pair_0_0(b, l + 1);
    r = r && module_include(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'include'
  private static boolean configuration_key_value_pair_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // key_name ('.' key_name)* ('=' (&'[' config_array | bool_value | id_value ) | config_object )
  private static boolean configuration_key_value_pair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_KEY_NAME);
    r = r && configuration_key_value_pair_1_1(b, l + 1);
    r = r && configuration_key_value_pair_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('.' key_name)*
  private static boolean configuration_key_value_pair_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!configuration_key_value_pair_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "configuration_key_value_pair_1_1", c)) break;
    }
    return true;
  }

  // '.' key_name
  private static boolean configuration_key_value_pair_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_DOT, OAP_KEY_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' (&'[' config_array | bool_value | id_value ) | config_object
  private static boolean configuration_key_value_pair_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configuration_key_value_pair_1_2_0(b, l + 1);
    if (!r) r = config_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' (&'[' config_array | bool_value | id_value )
  private static boolean configuration_key_value_pair_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_EQ);
    r = r && configuration_key_value_pair_1_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'[' config_array | bool_value | id_value
  private static boolean configuration_key_value_pair_1_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configuration_key_value_pair_1_2_0_1_0(b, l + 1);
    if (!r) r = bool_value(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'[' config_array
  private static boolean configuration_key_value_pair_1_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configuration_key_value_pair_1_2_0_1_0_0(b, l + 1);
    r = r && config_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'['
  private static boolean configuration_key_value_pair_1_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configuration_key_value_pair_1_2_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '.' module_services_service_implementation
  static boolean dot_implementation_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_implementation_service")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_implementation(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '.' module_services_service_link_field
  public static boolean dot_module_services_service_link_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_module_services_service_link_field")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_DOT_MODULE_SERVICES_SERVICE_LINK_FIELD, null);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_link_field(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '.' parameter_key_value
  static boolean dot_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_parameters")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DOT);
    r = r && parameter_key_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '.' remote_name
  public static boolean dot_remote(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_remote")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DOT);
    r = r && remote_name(b, l + 1);
    exit_section_(b, m, OAP_DOT_REMOTE, r);
    return r;
  }

  /* ********************************************************** */
  // '.' module_services_service_supervision_entities
  static boolean dot_supervision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_supervision")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_supervision_entities(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '.' wsservice_path
  public static boolean dot_wsservice_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_wsservice_path")) return false;
    if (!nextTokenIs(b, OAP_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_DOT_WSSERVICE_PATH, null);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && wsservice_path(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '$' '{' key_value '}'
  public static boolean env_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_value")) return false;
    if (!nextTokenIs(b, OAP_DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_DOLLAR, OAP_LEFTBRACE, OAP_KEY_VALUE, OAP_RIGHTBRACE);
    exit_section_(b, m, OAP_ENV_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // &(id_value '(') id_value '(' id_value ')'
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, "<function>", OAP_DOLLAR, OAP_KEY_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_FUNCTION, "<function>");
    r = function_0(b, l + 1);
    r = r && id_value(b, l + 1);
    r = r && consumeToken(b, OAP_LEFTPAREN);
    r = r && id_value(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &(id_value '(')
  private static boolean function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = function_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id_value '('
  private static boolean function_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_value(b, l + 1);
    r = r && consumeToken(b, OAP_LEFTPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // env_value id_value? | key_value id_value?
  public static boolean id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value")) return false;
    if (!nextTokenIs(b, "<id value>", OAP_DOLLAR, OAP_KEY_VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_ID_VALUE, "<id value>");
    r = id_value_0(b, l + 1);
    if (!r) r = id_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // env_value id_value?
  private static boolean id_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = env_value(b, l + 1);
    r = r && id_value_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id_value?
  private static boolean id_value_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_0_1")) return false;
    id_value(b, l + 1);
    return true;
  }

  // key_value id_value?
  private static boolean id_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_KEY_VALUE);
    r = r && id_value_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // id_value?
  private static boolean id_value_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_1_1")) return false;
    id_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // []
  //         module_name_pair
  //         ( &'enabled' module_enabled )?
  //         ( &'include' module_include )?
  //         ( &'dependsOn' module_depends_on )?
  //         ( &'include' module_include )?
  //         ( &'services' module_services )?
  //         ( &'include' module_include )?
  //         ( &'configurations' module_configurations )?
  static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = module_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, module_name_pair(b, l + 1));
    r = p && report_error_(b, module_2(b, l + 1)) && r;
    r = p && report_error_(b, module_3(b, l + 1)) && r;
    r = p && report_error_(b, module_4(b, l + 1)) && r;
    r = p && report_error_(b, module_5(b, l + 1)) && r;
    r = p && report_error_(b, module_6(b, l + 1)) && r;
    r = p && report_error_(b, module_7(b, l + 1)) && r;
    r = p && module_8(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_module);
    return r || p;
  }

  // []
  private static boolean module_0(PsiBuilder b, int l) {
    return true;
  }

  // ( &'enabled' module_enabled )?
  private static boolean module_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2")) return false;
    module_2_0(b, l + 1);
    return true;
  }

  // &'enabled' module_enabled
  private static boolean module_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_2_0_0(b, l + 1);
    r = r && module_enabled(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'enabled'
  private static boolean module_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_ENABLED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'include' module_include )?
  private static boolean module_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3")) return false;
    module_3_0(b, l + 1);
    return true;
  }

  // &'include' module_include
  private static boolean module_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_3_0_0(b, l + 1);
    r = r && module_include(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'include'
  private static boolean module_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'dependsOn' module_depends_on )?
  private static boolean module_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4")) return false;
    module_4_0(b, l + 1);
    return true;
  }

  // &'dependsOn' module_depends_on
  private static boolean module_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_4_0_0(b, l + 1);
    r = r && module_depends_on(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'dependsOn'
  private static boolean module_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_DEPENDS_ON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'include' module_include )?
  private static boolean module_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_5")) return false;
    module_5_0(b, l + 1);
    return true;
  }

  // &'include' module_include
  private static boolean module_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_5_0_0(b, l + 1);
    r = r && module_include(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'include'
  private static boolean module_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'services' module_services )?
  private static boolean module_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_6")) return false;
    module_6_0(b, l + 1);
    return true;
  }

  // &'services' module_services
  private static boolean module_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_6_0_0(b, l + 1);
    r = r && module_services(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'services'
  private static boolean module_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SERVICES);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'include' module_include )?
  private static boolean module_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_7")) return false;
    module_7_0(b, l + 1);
    return true;
  }

  // &'include' module_include
  private static boolean module_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_7_0_0(b, l + 1);
    r = r && module_include(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'include'
  private static boolean module_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'configurations' module_configurations )?
  private static boolean module_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_8")) return false;
    module_8_0(b, l + 1);
    return true;
  }

  // &'configurations' module_configurations
  private static boolean module_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_8_0_0(b, l + 1);
    r = r && module_configurations(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'configurations'
  private static boolean module_8_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_8_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_CONFIGURATIONS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' module_configuration_entries '}'
  public static boolean module_configuration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    r = r && module_configuration_entries(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // [] module_configuration_entries_loader module_configuration_entries_config
  public static boolean module_configuration_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES, "<module configuration entries>");
    r = module_configuration_entries_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, module_configuration_entries_loader(b, l + 1));
    r = p && module_configuration_entries_config(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean module_configuration_entries_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] 'config' ('=' config_array | config_object)
  public static boolean module_configuration_entries_config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_CONFIG, "<module configuration entries config>");
    r = module_configuration_entries_config_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_ID_CONFIG));
    r = p && module_configuration_entries_config_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean module_configuration_entries_config_0(PsiBuilder b, int l) {
    return true;
  }

  // '=' config_array | config_object
  private static boolean module_configuration_entries_config_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_configuration_entries_config_2_0(b, l + 1);
    if (!r) r = config_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' config_array
  private static boolean module_configuration_entries_config_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_EQ);
    r = r && config_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'loader' '=' class_name_psi
  public static boolean module_configuration_entries_loader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_loader")) return false;
    if (!nextTokenIs(b, OAP_ID_LOADER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_LOADER, null);
    r = consumeTokens(b, 1, OAP_ID_LOADER, OAP_EQ);
    p = r; // pin = 1
    r = r && class_name_psi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'configurations' '=' '[' module_configuration* ']'
  public static boolean module_configurations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations")) return false;
    if (!nextTokenIs(b, OAP_ID_CONFIGURATIONS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATIONS, null);
    r = consumeTokens(b, 1, OAP_ID_CONFIGURATIONS, OAP_EQ, OAP_LEFTBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, module_configurations_3(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module_configuration*
  private static boolean module_configurations_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_configuration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_configurations_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'dependsOn' '=' ('[' (key_value ','?)* ']' | key_value)
  public static boolean module_depends_on(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_DEPENDS_ON, "<module depends on>");
    r = consumeTokens(b, 1, OAP_ID_DEPENDS_ON, OAP_EQ);
    p = r; // pin = 1
    r = r && module_depends_on_2(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::recover_module);
    return r || p;
  }

  // '[' (key_value ','?)* ']' | key_value
  private static boolean module_depends_on_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on_2_0(b, l + 1);
    if (!r) r = consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' (key_value ','?)* ']'
  private static boolean module_depends_on_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && module_depends_on_2_0_1(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (key_value ','?)*
  private static boolean module_depends_on_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_depends_on_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_depends_on_2_0_1", c)) break;
    }
    return true;
  }

  // key_value ','?
  private static boolean module_depends_on_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_KEY_VALUE);
    r = r && module_depends_on_2_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean module_depends_on_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0_1_0_1")) return false;
    consumeToken(b, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // 'enabled' '=' bool
  public static boolean module_enabled(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_enabled")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_ENABLED, "<module enabled>");
    r = consumeTokens(b, 1, OAP_ID_ENABLED, OAP_EQ, OAP_BOOL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, OapParser::recover_module);
    return r || p;
  }

  /* ********************************************************** */
  // 'include' 'required' '(' include_resource_name ')'
  public static boolean module_include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_include")) return false;
    if (!nextTokenIs(b, OAP_ID_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_INCLUDE, null);
    r = consumeTokens(b, 1, OAP_ID_INCLUDE, OAP_ID_REQUIRED, OAP_LEFTPAREN, OAP_INCLUDE_RESOURCE_NAME, OAP_RIGHTPAREN);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // [] key_value
  public static boolean module_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_NAME, "<module name>");
    r = module_name_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean module_name_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] id_name eq module_name
  public static boolean module_name_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name_pair")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_NAME_PAIR, "<module name pair>");
    r = module_name_pair_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeTokens(b, -1, OAP_ID_NAME, OAP_EQ));
    r = p && module_name(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean module_name_pair_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // 'services' '{' module_services_service* '}'
  public static boolean module_services(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services")) return false;
    if (!nextTokenIs(b, OAP_ID_SERVICES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES, null);
    r = consumeTokens(b, 1, OAP_ID_SERVICES, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, module_services_2(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module_services_service*
  private static boolean module_services_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // service_name ( &dot dot_implementation_service | object_service )
  public static boolean module_services_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service")) return false;
    if (!nextTokenIs(b, OAP_KEY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE, null);
    r = service_name(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &dot dot_implementation_service | object_service
  private static boolean module_services_service_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_1_0(b, l + 1);
    if (!r) r = object_service(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_implementation_service
  private static boolean module_services_service_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_1_0_0(b, l + 1);
    r = r && dot_implementation_service(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'abstract' '=' bool_value
  public static boolean module_services_service_abstract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_abstract")) return false;
    if (!nextTokenIs(b, OAP_ID_ABSTRACT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ABSTRACT, null);
    r = consumeTokens(b, 1, OAP_ID_ABSTRACT, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'default' '=' reference_modules_value
  public static boolean module_services_service_default(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_default")) return false;
    if (!nextTokenIs(b, OAP_ID_DEFAULT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEFAULT, null);
    r = consumeTokens(b, 1, OAP_ID_DEFAULT, OAP_EQ);
    p = r; // pin = 1
    r = r && reference_modules_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'dependsOn' '=' ('[' ( ','? key_value )* ']' | key_value)*
  public static boolean module_services_service_dependson(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson")) return false;
    if (!nextTokenIs(b, OAP_ID_DEPENDS_ON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON, null);
    r = consumeTokens(b, 1, OAP_ID_DEPENDS_ON, OAP_EQ);
    p = r; // pin = 1
    r = r && module_services_service_dependson_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('[' ( ','? key_value )* ']' | key_value)*
  private static boolean module_services_service_dependson_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_dependson_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_dependson_2", c)) break;
    }
    return true;
  }

  // '[' ( ','? key_value )* ']' | key_value
  private static boolean module_services_service_dependson_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_2_0_0(b, l + 1);
    if (!r) r = consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' ( ','? key_value )* ']'
  private static boolean module_services_service_dependson_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && module_services_service_dependson_2_0_0_1(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ','? key_value )*
  private static boolean module_services_service_dependson_2_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_dependson_2_0_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_dependson_2_0_0_1", c)) break;
    }
    return true;
  }

  // ','? key_value
  private static boolean module_services_service_dependson_2_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_2_0_0_1_0_0(b, l + 1);
    r = r && consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean module_services_service_dependson_2_0_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0_1_0_0")) return false;
    consumeToken(b, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // 'enabled' '=' bool_value
  public static boolean module_services_service_enabled(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_enabled")) return false;
    if (!nextTokenIs(b, OAP_ID_ENABLED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ENABLED, null);
    r = consumeTokens(b, 1, OAP_ID_ENABLED, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ( &'enabled' module_services_service_enabled )?
  //     ( &'abstract' module_services_service_abstract )?
  //     module_services_service_implementation
  //     ( &'dependsOn' module_services_service_dependson )?
  //     ( &'default' module_services_service_default )?
  //     ( &'listen' module_services_service_listen )?
  //     ( &'parameters' module_services_service_parameters )?
  //     ( &'link' module_services_service_link )?
  //     ( &'remote' module_services_service_remote)?
  //     ( &'ws-service' module_services_service_wsservice)?
  //     ( &'ws-handler' module_services_service_wshandler)?
  //     ( &'supervision' module_services_service_supervision )?
  static boolean module_services_service_entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_0(b, l + 1);
    r = r && module_services_service_entities_1(b, l + 1);
    r = r && module_services_service_implementation(b, l + 1);
    r = r && module_services_service_entities_3(b, l + 1);
    r = r && module_services_service_entities_4(b, l + 1);
    r = r && module_services_service_entities_5(b, l + 1);
    r = r && module_services_service_entities_6(b, l + 1);
    r = r && module_services_service_entities_7(b, l + 1);
    r = r && module_services_service_entities_8(b, l + 1);
    r = r && module_services_service_entities_9(b, l + 1);
    r = r && module_services_service_entities_10(b, l + 1);
    r = r && module_services_service_entities_11(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( &'enabled' module_services_service_enabled )?
  private static boolean module_services_service_entities_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0")) return false;
    module_services_service_entities_0_0(b, l + 1);
    return true;
  }

  // &'enabled' module_services_service_enabled
  private static boolean module_services_service_entities_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_0_0_0(b, l + 1);
    r = r && module_services_service_enabled(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'enabled'
  private static boolean module_services_service_entities_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_ENABLED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'abstract' module_services_service_abstract )?
  private static boolean module_services_service_entities_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1")) return false;
    module_services_service_entities_1_0(b, l + 1);
    return true;
  }

  // &'abstract' module_services_service_abstract
  private static boolean module_services_service_entities_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_1_0_0(b, l + 1);
    r = r && module_services_service_abstract(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'abstract'
  private static boolean module_services_service_entities_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_ABSTRACT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'dependsOn' module_services_service_dependson )?
  private static boolean module_services_service_entities_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_3")) return false;
    module_services_service_entities_3_0(b, l + 1);
    return true;
  }

  // &'dependsOn' module_services_service_dependson
  private static boolean module_services_service_entities_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_3_0_0(b, l + 1);
    r = r && module_services_service_dependson(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'dependsOn'
  private static boolean module_services_service_entities_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_DEPENDS_ON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'default' module_services_service_default )?
  private static boolean module_services_service_entities_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_4")) return false;
    module_services_service_entities_4_0(b, l + 1);
    return true;
  }

  // &'default' module_services_service_default
  private static boolean module_services_service_entities_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_4_0_0(b, l + 1);
    r = r && module_services_service_default(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'default'
  private static boolean module_services_service_entities_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_DEFAULT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'listen' module_services_service_listen )?
  private static boolean module_services_service_entities_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5")) return false;
    module_services_service_entities_5_0(b, l + 1);
    return true;
  }

  // &'listen' module_services_service_listen
  private static boolean module_services_service_entities_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_5_0_0(b, l + 1);
    r = r && module_services_service_listen(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'listen'
  private static boolean module_services_service_entities_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_LISTEN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'parameters' module_services_service_parameters )?
  private static boolean module_services_service_entities_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6")) return false;
    module_services_service_entities_6_0(b, l + 1);
    return true;
  }

  // &'parameters' module_services_service_parameters
  private static boolean module_services_service_entities_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_6_0_0(b, l + 1);
    r = r && module_services_service_parameters(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'parameters'
  private static boolean module_services_service_entities_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_PARAMETERS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'link' module_services_service_link )?
  private static boolean module_services_service_entities_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7")) return false;
    module_services_service_entities_7_0(b, l + 1);
    return true;
  }

  // &'link' module_services_service_link
  private static boolean module_services_service_entities_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_7_0_0(b, l + 1);
    r = r && module_services_service_link(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'link'
  private static boolean module_services_service_entities_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_LINK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'remote' module_services_service_remote)?
  private static boolean module_services_service_entities_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8")) return false;
    module_services_service_entities_8_0(b, l + 1);
    return true;
  }

  // &'remote' module_services_service_remote
  private static boolean module_services_service_entities_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_8_0_0(b, l + 1);
    r = r && module_services_service_remote(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'remote'
  private static boolean module_services_service_entities_8_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_REMOTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'ws-service' module_services_service_wsservice)?
  private static boolean module_services_service_entities_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9")) return false;
    module_services_service_entities_9_0(b, l + 1);
    return true;
  }

  // &'ws-service' module_services_service_wsservice
  private static boolean module_services_service_entities_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_9_0_0(b, l + 1);
    r = r && module_services_service_wsservice(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'ws-service'
  private static boolean module_services_service_entities_9_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_WS_SERVICE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'ws-handler' module_services_service_wshandler)?
  private static boolean module_services_service_entities_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10")) return false;
    module_services_service_entities_10_0(b, l + 1);
    return true;
  }

  // &'ws-handler' module_services_service_wshandler
  private static boolean module_services_service_entities_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_10_0_0(b, l + 1);
    r = r && module_services_service_wshandler(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'ws-handler'
  private static boolean module_services_service_entities_10_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_WS_HANDLER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( &'supervision' module_services_service_supervision )?
  private static boolean module_services_service_entities_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11")) return false;
    module_services_service_entities_11_0(b, l + 1);
    return true;
  }

  // &'supervision' module_services_service_supervision
  private static boolean module_services_service_entities_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_11_0_0(b, l + 1);
    r = r && module_services_service_supervision(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'supervision'
  private static boolean module_services_service_entities_11_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SUPERVISION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'implementation' '=' class_name_psi
  public static boolean module_services_service_implementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_implementation")) return false;
    if (!nextTokenIs(b, OAP_ID_IMPLEMENTATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION, null);
    r = consumeTokens(b, 1, OAP_ID_IMPLEMENTATION, OAP_EQ);
    p = r; // pin = 1
    r = r && class_name_psi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'link' ( &'.' dot_module_services_service_link_field | module_services_service_link_field_object )
  public static boolean module_services_service_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link")) return false;
    if (!nextTokenIs(b, OAP_ID_LINK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK, null);
    r = consumeToken(b, OAP_ID_LINK);
    p = r; // pin = 1
    r = r && module_services_service_link_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_link_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_link_1_0(b, l + 1);
    if (!r) r = module_services_service_link_field_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_module_services_service_link_field
  private static boolean module_services_service_link_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_link_1_0_0(b, l + 1);
    r = r && dot_module_services_service_link_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_link_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key_name '=' reference_modules_value
  public static boolean module_services_service_link_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field")) return false;
    if (!nextTokenIs(b, OAP_KEY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD, null);
    r = consumeTokens(b, 1, OAP_KEY_NAME, OAP_EQ);
    p = r; // pin = 1
    r = r && reference_modules_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '{' module_services_service_link_field* '}'
  public static boolean module_services_service_link_field_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, module_services_service_link_field_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module_services_service_link_field*
  private static boolean module_services_service_link_field_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_link_field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_link_field_object_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'listen' ( &'.' dot_module_services_service_link_field | module_services_service_link_field_object)
  public static boolean module_services_service_listen(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen")) return false;
    if (!nextTokenIs(b, OAP_ID_LISTEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LISTEN, null);
    r = consumeToken(b, OAP_ID_LISTEN);
    p = r; // pin = 1
    r = r && module_services_service_listen_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_listen_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_listen_1_0(b, l + 1);
    if (!r) r = module_services_service_link_field_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_module_services_service_link_field
  private static boolean module_services_service_listen_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_listen_1_0_0(b, l + 1);
    r = r && dot_module_services_service_link_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_listen_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'parameters' ( &'.' dot_parameters | parameters_object )
  public static boolean module_services_service_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters")) return false;
    if (!nextTokenIs(b, OAP_ID_PARAMETERS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_PARAMETERS, null);
    r = consumeToken(b, OAP_ID_PARAMETERS);
    p = r; // pin = 1
    r = r && module_services_service_parameters_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_parameters | parameters_object
  private static boolean module_services_service_parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_parameters_1_0(b, l + 1);
    if (!r) r = parameters_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_parameters
  private static boolean module_services_service_parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_parameters_1_0_0(b, l + 1);
    r = r && dot_parameters(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_parameters_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'remote' (&'.' dot_remote | remote_object )
  public static boolean module_services_service_remote(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote")) return false;
    if (!nextTokenIs(b, OAP_ID_REMOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_REMOTE, null);
    r = consumeToken(b, OAP_ID_REMOTE);
    p = r; // pin = 1
    r = r && module_services_service_remote_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_remote | remote_object
  private static boolean module_services_service_remote_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_remote_1_0(b, l + 1);
    if (!r) r = remote_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_remote
  private static boolean module_services_service_remote_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_remote_1_0_0(b, l + 1);
    r = r && dot_remote(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_remote_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'supervision' ( &'.' dot_supervision | supervision_object )
  public static boolean module_services_service_supervision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision")) return false;
    if (!nextTokenIs(b, OAP_ID_SUPERVISION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION, null);
    r = consumeToken(b, OAP_ID_SUPERVISION);
    p = r; // pin = 1
    r = r && module_services_service_supervision_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_supervision | supervision_object
  private static boolean module_services_service_supervision_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_1_0(b, l + 1);
    if (!r) r = supervision_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_supervision
  private static boolean module_services_service_supervision_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_1_0_0(b, l + 1);
    r = r && dot_supervision(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_supervision_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // &'supervise' module_services_service_supervision_entities_supervise
  //     | &'schedule' module_services_service_supervision_entities_schedule
  //     | &'thread' module_services_service_supervision_entities_thread
  //     | &'delay' module_services_service_supervision_entities_delay
  //     | &'cron' module_services_service_supervision_entities_cron
  static boolean module_services_service_supervision_entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_0(b, l + 1);
    if (!r) r = module_services_service_supervision_entities_1(b, l + 1);
    if (!r) r = module_services_service_supervision_entities_2(b, l + 1);
    if (!r) r = module_services_service_supervision_entities_3(b, l + 1);
    if (!r) r = module_services_service_supervision_entities_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'supervise' module_services_service_supervision_entities_supervise
  private static boolean module_services_service_supervision_entities_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_0_0(b, l + 1);
    r = r && module_services_service_supervision_entities_supervise(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'supervise'
  private static boolean module_services_service_supervision_entities_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SUPERVISE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'schedule' module_services_service_supervision_entities_schedule
  private static boolean module_services_service_supervision_entities_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_1_0(b, l + 1);
    r = r && module_services_service_supervision_entities_schedule(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'schedule'
  private static boolean module_services_service_supervision_entities_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SCHEDULE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'thread' module_services_service_supervision_entities_thread
  private static boolean module_services_service_supervision_entities_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_2_0(b, l + 1);
    r = r && module_services_service_supervision_entities_thread(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'thread'
  private static boolean module_services_service_supervision_entities_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_THREAD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'delay' module_services_service_supervision_entities_delay
  private static boolean module_services_service_supervision_entities_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_3_0(b, l + 1);
    r = r && module_services_service_supervision_entities_delay(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'delay'
  private static boolean module_services_service_supervision_entities_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_DELAY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'cron' module_services_service_supervision_entities_cron
  private static boolean module_services_service_supervision_entities_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_entities_4_0(b, l + 1);
    r = r && module_services_service_supervision_entities_cron(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'cron'
  private static boolean module_services_service_supervision_entities_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_CRON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'cron' '=' key_value
  public static boolean module_services_service_supervision_entities_cron(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_cron")) return false;
    if (!nextTokenIs(b, OAP_ID_CRON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_CRON, null);
    r = consumeTokens(b, 1, OAP_ID_CRON, OAP_EQ, OAP_KEY_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'delay' '=' key_value
  public static boolean module_services_service_supervision_entities_delay(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_delay")) return false;
    if (!nextTokenIs(b, OAP_ID_DELAY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_DELAY, null);
    r = consumeTokens(b, 1, OAP_ID_DELAY, OAP_EQ, OAP_KEY_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'schedule' '=' bool_value
  public static boolean module_services_service_supervision_entities_schedule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_schedule")) return false;
    if (!nextTokenIs(b, OAP_ID_SCHEDULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SCHEDULE, null);
    r = consumeTokens(b, 1, OAP_ID_SCHEDULE, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'supervise' eq bool_value
  public static boolean module_services_service_supervision_entities_supervise(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_supervise")) return false;
    if (!nextTokenIs(b, OAP_ID_SUPERVISE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SUPERVISE, null);
    r = consumeTokens(b, 1, OAP_ID_SUPERVISE, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'thread' '=' bool_value
  public static boolean module_services_service_supervision_entities_thread(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_thread")) return false;
    if (!nextTokenIs(b, OAP_ID_THREAD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_THREAD, null);
    r = consumeTokens(b, 1, OAP_ID_THREAD, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'ws-handler' ( &'.' dot_wsservice_path | wshandler_object )
  public static boolean module_services_service_wshandler(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wshandler")) return false;
    if (!nextTokenIs(b, OAP_ID_WS_HANDLER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSHANDLER, null);
    r = consumeToken(b, OAP_ID_WS_HANDLER);
    p = r; // pin = 1
    r = r && module_services_service_wshandler_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_wsservice_path | wshandler_object
  private static boolean module_services_service_wshandler_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wshandler_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wshandler_1_0(b, l + 1);
    if (!r) r = wshandler_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_wsservice_path
  private static boolean module_services_service_wshandler_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wshandler_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wshandler_1_0_0(b, l + 1);
    r = r && dot_wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_wshandler_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wshandler_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'ws-service' ( &'.' dot_wsservice_path | wsservice_object )
  public static boolean module_services_service_wsservice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice")) return false;
    if (!nextTokenIs(b, OAP_ID_WS_SERVICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSSERVICE, null);
    r = consumeToken(b, OAP_ID_WS_SERVICE);
    p = r; // pin = 1
    r = r && module_services_service_wsservice_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'.' dot_wsservice_path | wsservice_object
  private static boolean module_services_service_wsservice_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wsservice_1_0(b, l + 1);
    if (!r) r = wsservice_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.' dot_wsservice_path
  private static boolean module_services_service_wsservice_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wsservice_1_0_0(b, l + 1);
    r = r && dot_wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'.'
  private static boolean module_services_service_wsservice_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' module_services_service_entities '}'
  static boolean object_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_service")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, module_services_service_entities(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // &'include' module_include
  //     | parameter_key_value_key
  public static boolean parameter_key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value")) return false;
    if (!nextTokenIs(b, "<parameter key value>", OAP_ID_INCLUDE, OAP_KEY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETER_KEY_VALUE, "<parameter key value>");
    r = parameter_key_value_0(b, l + 1);
    if (!r) r = parameter_key_value_key(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'include' module_include
  private static boolean parameter_key_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_0_0(b, l + 1);
    r = r && module_include(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'include'
  private static boolean parameter_key_value_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INCLUDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key_name ('.' key_name)* (&'=' parameter_key_value_key_eq | parameter_key_value_key_object )
  static boolean parameter_key_value_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key")) return false;
    if (!nextTokenIs(b, OAP_KEY_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_KEY_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, parameter_key_value_key_1(b, l + 1));
    r = p && parameter_key_value_key_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('.' key_name)*
  private static boolean parameter_key_value_key_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_key_value_key_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_key_value_key_1", c)) break;
    }
    return true;
  }

  // '.' key_name
  private static boolean parameter_key_value_key_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_DOT, OAP_KEY_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'=' parameter_key_value_key_eq | parameter_key_value_key_object
  private static boolean parameter_key_value_key_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_key_2_0(b, l + 1);
    if (!r) r = parameter_key_value_key_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'=' parameter_key_value_key_eq
  private static boolean parameter_key_value_key_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_key_2_0_0(b, l + 1);
    r = r && parameter_key_value_key_eq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'='
  private static boolean parameter_key_value_key_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_EQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '=' ( &'[' parameters_array | &'<' any_reference | function | bool_value | id_value )
  static boolean parameter_key_value_key_eq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq")) return false;
    if (!nextTokenIs(b, OAP_EQ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_EQ);
    p = r; // pin = 1
    r = r && parameter_key_value_key_eq_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'[' parameters_array | &'<' any_reference | function | bool_value | id_value
  private static boolean parameter_key_value_key_eq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_key_eq_1_0(b, l + 1);
    if (!r) r = parameter_key_value_key_eq_1_1(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = bool_value(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'[' parameters_array
  private static boolean parameter_key_value_key_eq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_key_eq_1_0_0(b, l + 1);
    r = r && parameters_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'['
  private static boolean parameter_key_value_key_eq_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'<' any_reference
  private static boolean parameter_key_value_key_eq_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_key_eq_1_1_0(b, l + 1);
    r = r && any_reference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'<'
  private static boolean parameter_key_value_key_eq_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_key_eq_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTANGLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // parameters_object
  static boolean parameter_key_value_key_object(PsiBuilder b, int l) {
    return parameters_object(b, l + 1);
  }

  /* ********************************************************** */
  // '[' parameters_array_item* ']'
  public static boolean parameters_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_ARRAY, null);
    r = consumeToken(b, OAP_LEFTBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, parameters_array_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // parameters_array_item*
  private static boolean parameters_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_array_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_array_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // &'<' any_reference | &'{' parameters_object | ( id_value (',' id_value )* )
  public static boolean parameters_array_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_ARRAY_ITEM, "<parameters array item>");
    r = parameters_array_item_0(b, l + 1);
    if (!r) r = parameters_array_item_1(b, l + 1);
    if (!r) r = parameters_array_item_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'<' any_reference
  private static boolean parameters_array_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_array_item_0_0(b, l + 1);
    r = r && any_reference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'<'
  private static boolean parameters_array_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTANGLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'{' parameters_object
  private static boolean parameters_array_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_array_item_1_0(b, l + 1);
    r = r && parameters_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'{'
  private static boolean parameters_array_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id_value (',' id_value )*
  private static boolean parameters_array_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_value(b, l + 1);
    r = r && parameters_array_item_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' id_value )*
  private static boolean parameters_array_item_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_array_item_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_array_item_2_1", c)) break;
    }
    return true;
  }

  // ',' id_value
  private static boolean parameters_array_item_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_COMMA);
    r = r && id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' parameter_key_value* '}'
  public static boolean parameters_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, parameters_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // parameter_key_value*
  private static boolean parameters_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_object_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !( 'enabled' | 'name' | 'dependsOn' | 'include' | 'services' | 'configurations' )
  static boolean recover_module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_module")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_module_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'enabled' | 'name' | 'dependsOn' | 'include' | 'services' | 'configurations'
  private static boolean recover_module_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_module_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_ID_ENABLED);
    if (!r) r = consumeToken(b, OAP_ID_NAME);
    if (!r) r = consumeToken(b, OAP_ID_DEPENDS_ON);
    if (!r) r = consumeToken(b, OAP_ID_INCLUDE);
    if (!r) r = consumeToken(b, OAP_ID_SERVICES);
    if (!r) r = consumeToken(b, OAP_ID_CONFIGURATIONS);
    return r;
  }

  /* ********************************************************** */
  // !('}' | ']' | ',' | '<' | 'link' | 'remote' | 'ws-service' | 'supervision' | key_name )
  static boolean recover_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_reference_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | ']' | ',' | '<' | 'link' | 'remote' | 'ws-service' | 'supervision' | key_name
  private static boolean recover_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_reference_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = consumeToken(b, OAP_COMMA);
    if (!r) r = consumeToken(b, OAP_LEFTANGLE);
    if (!r) r = consumeToken(b, OAP_ID_LINK);
    if (!r) r = consumeToken(b, OAP_ID_REMOTE);
    if (!r) r = consumeToken(b, OAP_ID_WS_SERVICE);
    if (!r) r = consumeToken(b, OAP_ID_SUPERVISION);
    if (!r) r = consumeToken(b, OAP_KEY_NAME);
    return r;
  }

  /* ********************************************************** */
  // '<' reference_kernel_value_in '>'
  public static boolean reference_kernel_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_kernel_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_KERNEL_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    p = r; // pin = 1
    r = r && report_error_(b, reference_kernel_value_in(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // reference_type_kernel '.' 'self'
  public static boolean reference_kernel_value_in(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_kernel_value_in")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_KERNEL_VALUE_IN, "<reference kernel value in>");
    r = reference_type_kernel(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeTokens(b, -1, OAP_DOT, OAP_ID_SELF));
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // [] (reference_value | 'this')
  public static boolean reference_modules_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_name")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_MODULES_NAME, "<reference modules name>");
    r = reference_modules_name_0(b, l + 1);
    p = r; // pin = 1
    r = r && reference_modules_name_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_modules_name_0(PsiBuilder b, int l) {
    return true;
  }

  // reference_value | 'this'
  private static boolean reference_modules_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_name_1")) return false;
    boolean r;
    r = consumeToken(b, OAP_REFERENCE_VALUE);
    if (!r) r = consumeToken(b, OAP_ID_THIS);
    return r;
  }

  /* ********************************************************** */
  // [] reference_value
  public static boolean reference_modules_service_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_service_name")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_MODULES_SERVICE_NAME, "<reference modules service name>");
    r = reference_modules_service_name_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_REFERENCE_VALUE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_modules_service_name_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '<' reference_modules_value_in '>'
  public static boolean reference_modules_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_MODULES_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    p = r; // pin = 1
    r = r && report_error_(b, reference_modules_value_in(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // reference_type_modules '.' reference_modules_name '.' reference_modules_service_name
  public static boolean reference_modules_value_in(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_value_in")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_MODULES_VALUE_IN, "<reference modules value in>");
    r = reference_type_modules(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_DOT));
    r = p && report_error_(b, reference_modules_name(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OAP_DOT)) && r;
    r = p && reference_modules_service_name(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // reference_type_services '.' reference_type_services_self '.' reference_type_services_property
  public static boolean reference_services_in(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_services_in")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_SERVICES_IN, "<reference services in>");
    r = reference_type_services(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_DOT));
    r = p && report_error_(b, reference_type_services_self(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OAP_DOT)) && r;
    r = p && reference_type_services_property(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '<' reference_services_in '>'
  public static boolean reference_services_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_services_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_SERVICES_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    p = r; // pin = 1
    r = r && report_error_(b, reference_services_in(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // [] 'kernel'
  public static boolean reference_type_kernel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type_kernel")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_TYPE_KERNEL, "<reference type kernel>");
    r = reference_type_kernel_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_ID_KERNEL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_type_kernel_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] 'modules'
  public static boolean reference_type_modules(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type_modules")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_TYPE_MODULES, "<reference type modules>");
    r = reference_type_modules_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_ID_MODULES);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_type_modules_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] 'services'
  public static boolean reference_type_services(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type_services")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_TYPE_SERVICES, "<reference type services>");
    r = reference_type_services_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_ID_SERVICES);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_type_services_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] reference_value
  public static boolean reference_type_services_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type_services_property")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_TYPE_SERVICES_PROPERTY, "<reference type services property>");
    r = reference_type_services_property_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_REFERENCE_VALUE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_type_services_property_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // [] 'self'
  public static boolean reference_type_services_self(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_type_services_self")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_TYPE_SERVICES_SELF, "<reference type services self>");
    r = reference_type_services_self_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, OAP_ID_SELF);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // []
  private static boolean reference_type_services_self_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // (&'name' remote_name | &'timeout' remote_timeout | &'serialization' remote_serialization | &'url' remote_url )*
  public static boolean remote_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries")) return false;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_ENTRIES, "<remote entries>");
    while (true) {
      int c = current_position_(b);
      if (!remote_entries_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "remote_entries", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // &'name' remote_name | &'timeout' remote_timeout | &'serialization' remote_serialization | &'url' remote_url
  private static boolean remote_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0(b, l + 1);
    if (!r) r = remote_entries_0_1(b, l + 1);
    if (!r) r = remote_entries_0_2(b, l + 1);
    if (!r) r = remote_entries_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'name' remote_name
  private static boolean remote_entries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_0(b, l + 1);
    r = r && remote_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'name'
  private static boolean remote_entries_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'timeout' remote_timeout
  private static boolean remote_entries_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_1_0(b, l + 1);
    r = r && remote_timeout(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'timeout'
  private static boolean remote_entries_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "timeout");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'serialization' remote_serialization
  private static boolean remote_entries_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_2_0(b, l + 1);
    r = r && remote_serialization(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'serialization'
  private static boolean remote_entries_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SERIALIZATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'url' remote_url
  private static boolean remote_entries_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_3_0(b, l + 1);
    r = r && remote_url(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'url'
  private static boolean remote_entries_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'name' '=' reference_modules_value
  public static boolean remote_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_name")) return false;
    if (!nextTokenIs(b, OAP_ID_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_NAME, null);
    r = consumeTokens(b, 1, OAP_ID_NAME, OAP_EQ);
    p = r; // pin = 1
    r = r && reference_modules_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '{' remote_entries '}'
  public static boolean remote_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, remote_entries(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'serialization' '=' key_value
  public static boolean remote_serialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_serialization")) return false;
    if (!nextTokenIs(b, OAP_ID_SERIALIZATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_SERIALIZATION, null);
    r = consumeTokens(b, 1, OAP_ID_SERIALIZATION, OAP_EQ, OAP_KEY_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // remote_timeout_id_value eq duration
  public static boolean remote_timeout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_timeout")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_TIMEOUT, "<remote timeout>");
    r = remote_timeout_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeTokens(b, -1, OAP_EQ, OAP_DURATION));
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'timeout'
  public static boolean remote_timeout_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_timeout_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_TIMEOUT_ID_VALUE, "<remote timeout id value>");
    r = consumeToken(b, "timeout");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'url' '=' key_value
  public static boolean remote_url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_url")) return false;
    if (!nextTokenIs(b, OAP_ID_URL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_URL, null);
    r = consumeTokens(b, 1, OAP_ID_URL, OAP_EQ, OAP_KEY_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // key_name
  public static boolean service_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_name")) return false;
    if (!nextTokenIs(b, OAP_KEY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_KEY_NAME);
    exit_section_(b, m, OAP_SERVICE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // '{' module_services_service_supervision_entities* '}'
  static boolean supervision_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, supervision_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module_services_service_supervision_entities*
  private static boolean supervision_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_supervision_entities(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "supervision_object_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'blocking' '=' bool_value
  public static boolean wshandler_blocking(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_blocking")) return false;
    if (!nextTokenIs(b, OAP_ID_BLOCKING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSHANDLER_BLOCKING, null);
    r = consumeTokens(b, 1, OAP_ID_BLOCKING, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'compression' '=' bool_value
  public static boolean wshandler_compression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_compression")) return false;
    if (!nextTokenIs(b, OAP_ID_COMPRESSION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSHANDLER_COMPRESSION, null);
    r = consumeTokens(b, 1, OAP_ID_COMPRESSION, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (&'path' wsservice_path | &'port' wsservice_port| &'compression' wshandler_compression | &'blocking' wshandler_blocking | &'enabled' wsservice_enabled)*
  public static boolean wshandler_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries")) return false;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSHANDLER_ENTRIES, "<wshandler entries>");
    while (true) {
      int c = current_position_(b);
      if (!wshandler_entries_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wshandler_entries", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // &'path' wsservice_path | &'port' wsservice_port| &'compression' wshandler_compression | &'blocking' wshandler_blocking | &'enabled' wsservice_enabled
  private static boolean wshandler_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_0(b, l + 1);
    if (!r) r = wshandler_entries_0_1(b, l + 1);
    if (!r) r = wshandler_entries_0_2(b, l + 1);
    if (!r) r = wshandler_entries_0_3(b, l + 1);
    if (!r) r = wshandler_entries_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path' wsservice_path
  private static boolean wshandler_entries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_0_0(b, l + 1);
    r = r && wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path'
  private static boolean wshandler_entries_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_PATH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'port' wsservice_port
  private static boolean wshandler_entries_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_1_0(b, l + 1);
    r = r && wsservice_port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'port'
  private static boolean wshandler_entries_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_PORT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'compression' wshandler_compression
  private static boolean wshandler_entries_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_2_0(b, l + 1);
    r = r && wshandler_compression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'compression'
  private static boolean wshandler_entries_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_COMPRESSION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'blocking' wshandler_blocking
  private static boolean wshandler_entries_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_3_0(b, l + 1);
    r = r && wshandler_blocking(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'blocking'
  private static boolean wshandler_entries_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_BLOCKING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'enabled' wsservice_enabled
  private static boolean wshandler_entries_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wshandler_entries_0_4_0(b, l + 1);
    r = r && wsservice_enabled(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'enabled'
  private static boolean wshandler_entries_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_entries_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_ENABLED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' wshandler_entries? '}'
  public static boolean wshandler_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSHANDLER_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, wshandler_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // wshandler_entries?
  private static boolean wshandler_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wshandler_object_1")) return false;
    wshandler_entries(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'enabled' '=' bool_value
  public static boolean wsservice_enabled(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_enabled")) return false;
    if (!nextTokenIs(b, OAP_ID_ENABLED)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_ENABLED, null);
    r = consumeTokens(b, 1, OAP_ID_ENABLED, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (&'path' wsservice_path | &'port' wsservice_port| &'sessionAware' wsservice_sessionAware| &'interceptors' wsservice_interceptors | &'enabled' wsservice_enabled)*
  public static boolean wsservice_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries")) return false;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_ENTRIES, "<wsservice entries>");
    while (true) {
      int c = current_position_(b);
      if (!wsservice_entries_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_entries", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // &'path' wsservice_path | &'port' wsservice_port| &'sessionAware' wsservice_sessionAware| &'interceptors' wsservice_interceptors | &'enabled' wsservice_enabled
  private static boolean wsservice_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0(b, l + 1);
    if (!r) r = wsservice_entries_0_1(b, l + 1);
    if (!r) r = wsservice_entries_0_2(b, l + 1);
    if (!r) r = wsservice_entries_0_3(b, l + 1);
    if (!r) r = wsservice_entries_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path' wsservice_path
  private static boolean wsservice_entries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_0(b, l + 1);
    r = r && wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path'
  private static boolean wsservice_entries_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_PATH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'port' wsservice_port
  private static boolean wsservice_entries_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_1_0(b, l + 1);
    r = r && wsservice_port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'port'
  private static boolean wsservice_entries_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_PORT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'sessionAware' wsservice_sessionAware
  private static boolean wsservice_entries_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_2_0(b, l + 1);
    r = r && wsservice_sessionAware(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'sessionAware'
  private static boolean wsservice_entries_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_SESSIONAWARE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'interceptors' wsservice_interceptors
  private static boolean wsservice_entries_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_3_0(b, l + 1);
    r = r && wsservice_interceptors(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'interceptors'
  private static boolean wsservice_entries_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_INTERCEPTORS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'enabled' wsservice_enabled
  private static boolean wsservice_entries_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_4_0(b, l + 1);
    r = r && wsservice_enabled(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'enabled'
  private static boolean wsservice_entries_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_ID_ENABLED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' wsservice_interceptor_one ( ','? wsservice_interceptor_one )* ']'
  static boolean wsservice_interceptor_multiple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, wsservice_interceptor_one(b, l + 1));
    r = p && report_error_(b, wsservice_interceptor_multiple_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( ','? wsservice_interceptor_one )*
  private static boolean wsservice_interceptor_multiple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wsservice_interceptor_multiple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_interceptor_multiple_2", c)) break;
    }
    return true;
  }

  // ','? wsservice_interceptor_one
  private static boolean wsservice_interceptor_multiple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptor_multiple_2_0_0(b, l + 1);
    r = r && wsservice_interceptor_one(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean wsservice_interceptor_multiple_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_2_0_0")) return false;
    consumeToken(b, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // reference_modules_value
  static boolean wsservice_interceptor_one(PsiBuilder b, int l) {
    return reference_modules_value(b, l + 1);
  }

  /* ********************************************************** */
  // 'interceptors' '=' (&'[' wsservice_interceptor_multiple|wsservice_interceptor_one)
  public static boolean wsservice_interceptors(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors")) return false;
    if (!nextTokenIs(b, OAP_ID_INTERCEPTORS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_INTERCEPTORS, null);
    r = consumeTokens(b, 1, OAP_ID_INTERCEPTORS, OAP_EQ);
    p = r; // pin = 1
    r = r && wsservice_interceptors_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'[' wsservice_interceptor_multiple|wsservice_interceptor_one
  private static boolean wsservice_interceptors_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptors_2_0(b, l + 1);
    if (!r) r = wsservice_interceptor_one(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'[' wsservice_interceptor_multiple
  private static boolean wsservice_interceptors_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptors_2_0_0(b, l + 1);
    r = r && wsservice_interceptor_multiple(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'['
  private static boolean wsservice_interceptors_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' wsservice_entries? '}'
  public static boolean wsservice_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, wsservice_object_1(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // wsservice_entries?
  private static boolean wsservice_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1")) return false;
    wsservice_entries(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'path' '=' (&'[' wsservice_path_multiple | key_value )
  public static boolean wsservice_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path")) return false;
    if (!nextTokenIs(b, OAP_ID_PATH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PATH, null);
    r = consumeTokens(b, 1, OAP_ID_PATH, OAP_EQ);
    p = r; // pin = 1
    r = r && wsservice_path_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &'[' wsservice_path_multiple | key_value
  private static boolean wsservice_path_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_2_0(b, l + 1);
    if (!r) r = consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'[' wsservice_path_multiple
  private static boolean wsservice_path_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_2_0_0(b, l + 1);
    r = r && wsservice_path_multiple(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'['
  private static boolean wsservice_path_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' key_value (!']' ','? key_value)* ']'
  static boolean wsservice_path_multiple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_LEFTBRACKET, OAP_KEY_VALUE);
    r = r && wsservice_path_multiple_2(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (!']' ','? key_value)*
  private static boolean wsservice_path_multiple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wsservice_path_multiple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_path_multiple_2", c)) break;
    }
    return true;
  }

  // !']' ','? key_value
  private static boolean wsservice_path_multiple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_multiple_2_0_0(b, l + 1);
    r = r && wsservice_path_multiple_2_0_1(b, l + 1);
    r = r && consumeToken(b, OAP_KEY_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // !']'
  private static boolean wsservice_path_multiple_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ','?
  private static boolean wsservice_path_multiple_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_2_0_1")) return false;
    consumeToken(b, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // 'port' '=' key_value
  public static boolean wsservice_port(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_port")) return false;
    if (!nextTokenIs(b, OAP_ID_PORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PORT, null);
    r = consumeTokens(b, 1, OAP_ID_PORT, OAP_EQ, OAP_KEY_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'sessionAware' '=' bool_value
  public static boolean wsservice_sessionAware(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_sessionAware")) return false;
    if (!nextTokenIs(b, OAP_ID_SESSIONAWARE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_SESSION_AWARE, null);
    r = consumeTokens(b, 1, OAP_ID_SESSIONAWARE, OAP_EQ);
    p = r; // pin = 1
    r = r && bool_value(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
