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
  // 'classpath' leftparen class_path_parameters_function_resource rightparen
  public static boolean class_path_parameters_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_path_parameters_function")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CLASS_PATH_PARAMETERS_FUNCTION, "<class path parameters function>");
    r = consumeToken(b, "classpath");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_LEFTPAREN));
    r = p && report_error_(b, class_path_parameters_function_resource(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // div? id_value (div | id_value | env_variable | dot)*
  public static boolean class_path_parameters_function_resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_path_parameters_function_resource")) return false;
    if (!nextTokenIs(b, "<class path parameters function resource>", OAP_DIV, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_CLASS_PATH_PARAMETERS_FUNCTION_RESOURCE, "<class path parameters function resource>");
    r = class_path_parameters_function_resource_0(b, l + 1);
    r = r && id_value(b, l + 1);
    r = r && class_path_parameters_function_resource_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // div?
  private static boolean class_path_parameters_function_resource_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_path_parameters_function_resource_0")) return false;
    consumeToken(b, OAP_DIV);
    return true;
  }

  // (div | id_value | env_variable | dot)*
  private static boolean class_path_parameters_function_resource_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_path_parameters_function_resource_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_path_parameters_function_resource_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_path_parameters_function_resource_2", c)) break;
    }
    return true;
  }

  // div | id_value | env_variable | dot
  private static boolean class_path_parameters_function_resource_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_path_parameters_function_resource_2_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_DIV);
    if (!r) r = id_value(b, l + 1);
    if (!r) r = env_variable(b, l + 1);
    if (!r) r = consumeToken(b, OAP_DOT);
    return r;
  }

  /* ********************************************************** */
  // letters (long | letters)* (dot letters (long | letters)* )*
  public static boolean class_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LETTERS);
    r = r && class_value_1(b, l + 1);
    r = r && class_value_2(b, l + 1);
    exit_section_(b, m, OAP_CLASS_VALUE, r);
    return r;
  }

  // (long | letters)*
  private static boolean class_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_value_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_value_1", c)) break;
    }
    return true;
  }

  // long | letters
  private static boolean class_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LONG);
    if (!r) r = consumeToken(b, OAP_LETTERS);
    return r;
  }

  // (dot letters (long | letters)* )*
  private static boolean class_value_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_value_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_value_2", c)) break;
    }
    return true;
  }

  // dot letters (long | letters)*
  private static boolean class_value_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_DOT, OAP_LETTERS);
    r = r && class_value_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (long | letters)*
  private static boolean class_value_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_value_2_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_value_2_0_2", c)) break;
    }
    return true;
  }

  // long | letters
  private static boolean class_value_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_value_2_0_2_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LONG);
    if (!r) r = consumeToken(b, OAP_LETTERS);
    return r;
  }

  /* ********************************************************** */
  // leftbracket (!(rightbracket | nl rightbracket) nl? config_array_object )* nl? rightbracket
  public static boolean config_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIG_ARRAY, "<config array>");
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && config_array_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, config_array_2(b, l + 1));
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (!(rightbracket | nl rightbracket) nl? config_array_object )*
  private static boolean config_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_array_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_array_1", c)) break;
    }
    return true;
  }

  // !(rightbracket | nl rightbracket) nl? config_array_object
  private static boolean config_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_array_1_0_0(b, l + 1);
    r = r && config_array_1_0_1(b, l + 1);
    r = r && config_array_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean config_array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !config_array_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean config_array_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = config_array_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean config_array_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean config_array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_1_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean config_array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_array_2")) return false;
    nl(b, l + 1);
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
  // leftbrace (!(rightbrace | nl rightbrace) nl? (configurations_include | key_value))* nl? rightbrace
  public static boolean config_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIG_OBJECT, "<config object>");
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, config_object_1(b, l + 1));
    r = p && report_error_(b, config_object_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (!(rightbrace | nl rightbrace) nl? (configurations_include | key_value))*
  private static boolean config_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!config_object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "config_object_1", c)) break;
    }
    return true;
  }

  // !(rightbrace | nl rightbrace) nl? (configurations_include | key_value)
  private static boolean config_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_object_1_0_0(b, l + 1);
    r = r && config_object_1_0_1(b, l + 1);
    r = r && config_object_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbrace | nl rightbrace)
  private static boolean config_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !config_object_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbrace | nl rightbrace
  private static boolean config_object_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = config_object_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbrace
  private static boolean config_object_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean config_object_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // configurations_include | key_value
  private static boolean config_object_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = configurations_include(b, l + 1);
    if (!r) r = key_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean config_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_object_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id_value ( dot id_value )*
  public static boolean configurations_config_key_value_id_or_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configurations_config_key_value_id_or_path")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIGURATIONS_CONFIG_KEY_VALUE_ID_OR_PATH, null);
    r = id_value(b, l + 1);
    p = r; // pin = 1
    r = r && configurations_config_key_value_id_or_path_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( dot id_value )*
  private static boolean configurations_config_key_value_id_or_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configurations_config_key_value_id_or_path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!configurations_config_key_value_id_or_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "configurations_config_key_value_id_or_path_1", c)) break;
    }
    return true;
  }

  // dot id_value
  private static boolean configurations_config_key_value_id_or_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configurations_config_key_value_id_or_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DOT);
    r = r && id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // module_include
  public static boolean configurations_include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "configurations_include")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_CONFIGURATIONS_INCLUDE, "<configurations include>");
    r = module_include(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean cron_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cron_value")) return false;
    if (!nextTokenIs(b, OAP_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_STRING);
    exit_section_(b, m, OAP_CRON_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // dot module_services_service_implementation
  static boolean dot_implementation_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_implementation_service")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_implementation(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // dot module_services_service_link_field
  public static boolean dot_module_services_service_link_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_module_services_service_link_field")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_DOT_MODULE_SERVICES_SERVICE_LINK_FIELD, "<dot module services service link field>");
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_link_field(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // dot parameter_key_value
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
  // dot remote_name
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
  // dot module_services_service_supervision_entities
  static boolean dot_supervision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_supervision")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_DOT);
    p = r; // pin = 1
    r = r && module_services_service_supervision_entities(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // dot wsservice_path
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
  // long | duration
  public static boolean duration_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "duration_value")) return false;
    if (!nextTokenIs(b, "<duration value>", OAP_DURATION, OAP_LONG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_DURATION_VALUE, "<duration value>");
    r = consumeToken(b, OAP_LONG);
    if (!r) r = consumeToken(b, OAP_DURATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // dollar leftbrace (letters|'_')+ rightbrace
  public static boolean env_variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_variable")) return false;
    if (!nextTokenIs(b, OAP_DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OAP_DOLLAR, OAP_LEFTBRACE);
    r = r && env_variable_2(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, OAP_ENV_VARIABLE, r);
    return r;
  }

  // (letters|'_')+
  private static boolean env_variable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_variable_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = env_variable_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!env_variable_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "env_variable_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letters|'_'
  private static boolean env_variable_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_variable_2_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, "_");
    return r;
  }

  /* ********************************************************** */
  // letters (dash|letters|long)*
  public static boolean id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LETTERS);
    r = r && id_value_1(b, l + 1);
    exit_section_(b, m, OAP_ID_VALUE, r);
    return r;
  }

  // (dash|letters|long)*
  private static boolean id_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!id_value_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_value_1", c)) break;
    }
    return true;
  }

  // dash|letters|long
  private static boolean id_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_value_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_DASH);
    if (!r) r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_LONG);
    return r;
  }

  /* ********************************************************** */
  // 'json' leftparen json_parameters_function_body rightparen
  public static boolean json_parameters_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_parameters_function")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_JSON_PARAMETERS_FUNCTION, "<json parameters function>");
    r = consumeToken(b, "json");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_LEFTPAREN));
    r = p && report_error_(b, json_parameters_function_body(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // string_value
  public static boolean json_parameters_function_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_parameters_function_body")) return false;
    if (!nextTokenIs(b, OAP_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_value(b, l + 1);
    exit_section_(b, m, OAP_JSON_PARAMETERS_FUNCTION_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // configurations_config_key_value_id_or_path ( eq (bool_value | number_value | class_value | string_value | id_value | config_array ) | config_object )
  public static boolean key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_KEY_VALUE, "<key value>");
    r = configurations_config_key_value_id_or_path(b, l + 1);
    p = r; // pin = 1
    r = r && key_value_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // eq (bool_value | number_value | class_value | string_value | id_value | config_array ) | config_object
  private static boolean key_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_value_1_0(b, l + 1);
    if (!r) r = config_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eq (bool_value | number_value | class_value | string_value | id_value | config_array )
  private static boolean key_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_EQ);
    r = r && key_value_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // bool_value | number_value | class_value | string_value | id_value | config_array
  private static boolean key_value_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_value(b, l + 1);
    if (!r) r = number_value(b, l + 1);
    if (!r) r = class_value(b, l + 1);
    if (!r) r = string_value(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    if (!r) r = config_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // letters (digits | letters)*
  public static boolean link_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_field")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LETTERS);
    r = r && link_field_1(b, l + 1);
    exit_section_(b, m, OAP_LINK_FIELD, r);
    return r;
  }

  // (digits | letters)*
  private static boolean link_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_field_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!link_field_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "link_field_1", c)) break;
    }
    return true;
  }

  // digits | letters
  private static boolean link_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_field_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_DIGITS);
    if (!r) r = consumeToken(b, OAP_LETTERS);
    return r;
  }

  /* ********************************************************** */
  // nl? module_name nl (module_enabled nl)? ( (module_include nl)? (module_depends_on nl (module_include nl)?)? module_services)? nl? (module_include nl)? module_configurations? nl? (module_include nl?)?
  static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_0(b, l + 1);
    r = r && module_name(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_3(b, l + 1);
    r = r && module_4(b, l + 1);
    r = r && module_5(b, l + 1);
    r = r && module_6(b, l + 1);
    r = r && module_7(b, l + 1);
    r = r && module_8(b, l + 1);
    r = r && module_9(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_0")) return false;
    nl(b, l + 1);
    return true;
  }

  // (module_enabled nl)?
  private static boolean module_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3")) return false;
    module_3_0(b, l + 1);
    return true;
  }

  // module_enabled nl
  private static boolean module_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_enabled(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( (module_include nl)? (module_depends_on nl (module_include nl)?)? module_services)?
  private static boolean module_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4")) return false;
    module_4_0(b, l + 1);
    return true;
  }

  // (module_include nl)? (module_depends_on nl (module_include nl)?)? module_services
  private static boolean module_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_4_0_0(b, l + 1);
    r = r && module_4_0_1(b, l + 1);
    r = r && module_services(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (module_include nl)?
  private static boolean module_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_0")) return false;
    module_4_0_0_0(b, l + 1);
    return true;
  }

  // module_include nl
  private static boolean module_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_include(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (module_depends_on nl (module_include nl)?)?
  private static boolean module_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_1")) return false;
    module_4_0_1_0(b, l + 1);
    return true;
  }

  // module_depends_on nl (module_include nl)?
  private static boolean module_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_4_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (module_include nl)?
  private static boolean module_4_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_1_0_2")) return false;
    module_4_0_1_0_2_0(b, l + 1);
    return true;
  }

  // module_include nl
  private static boolean module_4_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_include(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_5")) return false;
    nl(b, l + 1);
    return true;
  }

  // (module_include nl)?
  private static boolean module_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_6")) return false;
    module_6_0(b, l + 1);
    return true;
  }

  // module_include nl
  private static boolean module_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_include(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // module_configurations?
  private static boolean module_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_7")) return false;
    module_configurations(b, l + 1);
    return true;
  }

  // nl?
  private static boolean module_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_8")) return false;
    nl(b, l + 1);
    return true;
  }

  // (module_include nl?)?
  private static boolean module_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_9")) return false;
    module_9_0(b, l + 1);
    return true;
  }

  // module_include nl?
  private static boolean module_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_include(b, l + 1);
    r = r && module_9_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_9_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_9_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // nl leftbrace nl? module_configuration_entries nl? rightbrace
  public static boolean module_configuration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION, "<module configuration>");
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, module_configuration_2(b, l + 1));
    r = p && report_error_(b, module_configuration_entries(b, l + 1)) && r;
    r = p && report_error_(b, module_configuration_4(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // nl?
  private static boolean module_configuration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_2")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean module_configuration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_4")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'config'
  public static boolean module_configuration_config_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_config_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_CONFIG_ID_VALUE, "<module configuration config id value>");
    r = consumeToken(b, "config");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_configuration_entries_loader nl module_configuration_entries_config
  public static boolean module_configuration_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES, "<module configuration entries>");
    r = module_configuration_entries_loader(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_configuration_entries_config(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_configuration_config_id_value (eq config_array | config_object)
  public static boolean module_configuration_entries_config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_CONFIG, "<module configuration entries config>");
    r = module_configuration_config_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_configuration_entries_config_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // eq config_array | config_object
  private static boolean module_configuration_entries_config_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_configuration_entries_config_1_0(b, l + 1);
    if (!r) r = config_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eq config_array
  private static boolean module_configuration_entries_config_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_config_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_EQ);
    r = r && config_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // module_configuration_loader_id_value eq class_value
  public static boolean module_configuration_entries_loader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_entries_loader")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_LOADER, "<module configuration entries loader>");
    r = module_configuration_loader_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && class_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'loader'
  public static boolean module_configuration_loader_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configuration_loader_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATION_LOADER_ID_VALUE, "<module configuration loader id value>");
    r = consumeToken(b, "loader");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_configurations_id_value eq leftbracket (!(rightbracket | nl rightbracket) module_configuration)* nl? rightbracket nl?
  public static boolean module_configurations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATIONS, "<module configurations>");
    r = module_configurations_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeTokens(b, -1, OAP_EQ, OAP_LEFTBRACKET));
    r = p && report_error_(b, module_configurations_3(b, l + 1)) && r;
    r = p && report_error_(b, module_configurations_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OAP_RIGHTBRACKET)) && r;
    r = p && module_configurations_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (!(rightbracket | nl rightbracket) module_configuration)*
  private static boolean module_configurations_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_configurations_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_configurations_3", c)) break;
    }
    return true;
  }

  // !(rightbracket | nl rightbracket) module_configuration
  private static boolean module_configurations_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_configurations_3_0_0(b, l + 1);
    r = r && module_configuration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean module_configurations_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_configurations_3_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean module_configurations_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = module_configurations_3_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean module_configurations_3_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_3_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_configurations_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_4")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean module_configurations_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_6")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'configurations'
  public static boolean module_configurations_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_configurations_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_CONFIGURATIONS_ID_VALUE, "<module configurations id value>");
    r = consumeToken(b, "configurations");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_depends_on_id_value eq (&leftbracket module_depends_on_list | module_depends_on_single)*
  public static boolean module_depends_on(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_DEPENDS_ON, "<module depends on>");
    r = module_depends_on_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && module_depends_on_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (&leftbracket module_depends_on_list | module_depends_on_single)*
  private static boolean module_depends_on_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_depends_on_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_depends_on_2", c)) break;
    }
    return true;
  }

  // &leftbracket module_depends_on_list | module_depends_on_single
  private static boolean module_depends_on_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on_2_0_0(b, l + 1);
    if (!r) r = module_depends_on_single(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket module_depends_on_list
  private static boolean module_depends_on_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on_2_0_0_0(b, l + 1);
    r = r && module_depends_on_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket
  private static boolean module_depends_on_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'dependsOn'
  public static boolean module_depends_on_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_DEPENDS_ON_ID_VALUE, "<module depends on id value>");
    r = consumeToken(b, "dependsOn");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbracket module_depends_on_modules? nl? rightbracket
  static boolean module_depends_on_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_list")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && module_depends_on_list_1(b, l + 1);
    r = r && module_depends_on_list_2(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // module_depends_on_modules?
  private static boolean module_depends_on_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_list_1")) return false;
    module_depends_on_modules(b, l + 1);
    return true;
  }

  // nl?
  private static boolean module_depends_on_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_list_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // module_name_value
  public static boolean module_depends_on_module_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_module_name")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_name_value(b, l + 1);
    exit_section_(b, m, OAP_MODULE_DEPENDS_ON_MODULE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // !(rightbracket | nl rightbracket) nl module_depends_on_module_name (!(rightbracket | nl rightbracket) (nl|comma nl?) module_depends_on_module_name)*
  static boolean module_depends_on_modules(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on_modules_0(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_depends_on_module_name(b, l + 1);
    r = r && module_depends_on_modules_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean module_depends_on_modules_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_depends_on_modules_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean module_depends_on_modules_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = module_depends_on_modules_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean module_depends_on_modules_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (!(rightbracket | nl rightbracket) (nl|comma nl?) module_depends_on_module_name)*
  private static boolean module_depends_on_modules_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_depends_on_modules_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_depends_on_modules_3", c)) break;
    }
    return true;
  }

  // !(rightbracket | nl rightbracket) (nl|comma nl?) module_depends_on_module_name
  private static boolean module_depends_on_modules_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_depends_on_modules_3_0_0(b, l + 1);
    r = r && module_depends_on_modules_3_0_1(b, l + 1);
    r = r && module_depends_on_module_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean module_depends_on_modules_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_depends_on_modules_3_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean module_depends_on_modules_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = module_depends_on_modules_3_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean module_depends_on_modules_3_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl|comma nl?
  private static boolean module_depends_on_modules_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    if (!r) r = module_depends_on_modules_3_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma nl?
  private static boolean module_depends_on_modules_3_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_COMMA);
    r = r && module_depends_on_modules_3_0_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_depends_on_modules_3_0_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_depends_on_modules_3_0_1_1_1")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // module_depends_on_module_name
  static boolean module_depends_on_single(PsiBuilder b, int l) {
    return module_depends_on_module_name(b, l + 1);
  }

  /* ********************************************************** */
  // 'enabled' eq bool_value
  public static boolean module_enabled(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_enabled")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_ENABLED, "<module enabled>");
    r = consumeToken(b, "enabled");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'include' 'required' leftparen string_value rightparen
  public static boolean module_include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_include")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_INCLUDE, "<module include>");
    r = consumeToken(b, "include");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, "required"));
    r = p && report_error_(b, consumeToken(b, OAP_LEFTPAREN)) && r;
    r = p && report_error_(b, string_value(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // module_name_id_value eq module_name_value
  public static boolean module_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_NAME, "<module name>");
    r = module_name_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && module_name_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'name'
  public static boolean module_name_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_NAME_ID_VALUE, "<module name id value>");
    r = consumeToken(b, "name");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id_value
  public static boolean module_name_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name_value")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_value(b, l + 1);
    exit_section_(b, m, OAP_MODULE_NAME_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // module_services_id_value leftbrace ( !(rightbrace|nl rightbrace) module_services_service )* nl? rightbrace
  public static boolean module_services(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES, "<module services>");
    r = module_services_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_LEFTBRACE));
    r = p && report_error_(b, module_services_2(b, l + 1)) && r;
    r = p && report_error_(b, module_services_3(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // ( !(rightbrace|nl rightbrace) module_services_service )*
  private static boolean module_services_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_2", c)) break;
    }
    return true;
  }

  // !(rightbrace|nl rightbrace) module_services_service
  private static boolean module_services_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_2_0_0(b, l + 1);
    r = r && module_services_service(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbrace|nl rightbrace)
  private static boolean module_services_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_services_2_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbrace|nl rightbrace
  private static boolean module_services_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = module_services_2_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbrace
  private static boolean module_services_2_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_2_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_services_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_3")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'services'
  public static boolean module_services_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_ID_VALUE, "<module services id value>");
    r = consumeToken(b, "services");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nl module_services_service_id_value ( &dot dot_implementation_service | object_service )
  public static boolean module_services_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE, "<module services service>");
    r = nl(b, l + 1);
    r = r && module_services_service_id_value(b, l + 1);
    p = r; // pin = 2
    r = r && module_services_service_2(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // &dot dot_implementation_service | object_service
  private static boolean module_services_service_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_2_0(b, l + 1);
    if (!r) r = object_service(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_implementation_service
  private static boolean module_services_service_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_2_0_0(b, l + 1);
    r = r && dot_implementation_service(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_abstract_id_value eq bool_value
  public static boolean module_services_service_abstract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_abstract")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ABSTRACT, "<module services service abstract>");
    r = module_services_service_abstract_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'abstract'
  public static boolean module_services_service_abstract_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_abstract_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ABSTRACT_ID_VALUE, "<module services service abstract id value>");
    r = consumeToken(b, "abstract");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_default_id_value eq reference_modules_value
  public static boolean module_services_service_default(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_default")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEFAULT, "<module services service default>");
    r = module_services_service_default_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && reference_modules_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'default'
  public static boolean module_services_service_default_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_default_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEFAULT_ID_VALUE, "<module services service default id value>");
    r = consumeToken(b, "default");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_dependson_id_value eq (&leftbracket module_services_service_dependson_on_list | module_services_service_dependson_single)*
  public static boolean module_services_service_dependson(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON, "<module services service dependson>");
    r = module_services_service_dependson_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && module_services_service_dependson_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (&leftbracket module_services_service_dependson_on_list | module_services_service_dependson_single)*
  private static boolean module_services_service_dependson_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_dependson_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_dependson_2", c)) break;
    }
    return true;
  }

  // &leftbracket module_services_service_dependson_on_list | module_services_service_dependson_single
  private static boolean module_services_service_dependson_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_2_0_0(b, l + 1);
    if (!r) r = module_services_service_dependson_single(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket module_services_service_dependson_on_list
  private static boolean module_services_service_dependson_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_2_0_0_0(b, l + 1);
    r = r && module_services_service_dependson_on_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket
  private static boolean module_services_service_dependson_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'dependsOn'
  public static boolean module_services_service_dependson_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON_ID_VALUE, "<module services service dependson id value>");
    r = consumeToken(b, "dependsOn");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbracket module_services_service_dependson_services? nl? rightbracket
  static boolean module_services_service_dependson_on_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_on_list")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && module_services_service_dependson_on_list_1(b, l + 1);
    r = r && module_services_service_dependson_on_list_2(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // module_services_service_dependson_services?
  private static boolean module_services_service_dependson_on_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_on_list_1")) return false;
    module_services_service_dependson_services(b, l + 1);
    return true;
  }

  // nl?
  private static boolean module_services_service_dependson_on_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_on_list_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(rightbracket | nl rightbracket) nl? module_services_service_id_value (!(rightbracket | nl rightbracket) (nl|comma nl?) module_services_service_id_value)*
  static boolean module_services_service_dependson_services(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_services_0(b, l + 1);
    r = r && module_services_service_dependson_services_1(b, l + 1);
    r = r && module_services_service_id_value(b, l + 1);
    r = r && module_services_service_dependson_services_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean module_services_service_dependson_services_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_services_service_dependson_services_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean module_services_service_dependson_services_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = module_services_service_dependson_services_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean module_services_service_dependson_services_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_services_service_dependson_services_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // (!(rightbracket | nl rightbracket) (nl|comma nl?) module_services_service_id_value)*
  private static boolean module_services_service_dependson_services_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_dependson_services_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_dependson_services_3", c)) break;
    }
    return true;
  }

  // !(rightbracket | nl rightbracket) (nl|comma nl?) module_services_service_id_value
  private static boolean module_services_service_dependson_services_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_dependson_services_3_0_0(b, l + 1);
    r = r && module_services_service_dependson_services_3_0_1(b, l + 1);
    r = r && module_services_service_id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean module_services_service_dependson_services_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_services_service_dependson_services_3_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean module_services_service_dependson_services_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = module_services_service_dependson_services_3_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean module_services_service_dependson_services_3_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl|comma nl?
  private static boolean module_services_service_dependson_services_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    if (!r) r = module_services_service_dependson_services_3_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma nl?
  private static boolean module_services_service_dependson_services_3_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_COMMA);
    r = r && module_services_service_dependson_services_3_0_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_services_service_dependson_services_3_0_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_dependson_services_3_0_1_1_1")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // module_services_service_id_value
  static boolean module_services_service_dependson_single(PsiBuilder b, int l) {
    return module_services_service_id_value(b, l + 1);
  }

  /* ********************************************************** */
  // module_services_service_enabled_id_value eq bool_value
  public static boolean module_services_service_enabled(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_enabled")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ENABLED, "<module services service enabled>");
    r = module_services_service_enabled_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'enabled'
  public static boolean module_services_service_enabled_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_enabled_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_ENABLED_ID_VALUE, "<module services service enabled id value>");
    r = consumeToken(b, "enabled");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (&'enabled' module_services_service_enabled nl)?
  //     (&'abstract' module_services_service_abstract nl)?
  //     &'implementation' module_services_service_implementation nl
  //     (&'dependsOn' module_services_service_dependson nl)?
  //     (&'default' module_services_service_default nl)?
  //     (&'listen' module_services_service_listen nl)?
  //     (&'parameters' module_services_service_parameters nl)?
  //     (&'link' module_services_service_link nl)?
  //     (&'remote' module_services_service_remote nl)?
  //     (&'ws-service' module_services_service_wsservice nl)?
  //     (&'supervision' module_services_service_supervision nl)?
  static boolean module_services_service_entities(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_0(b, l + 1);
    r = r && module_services_service_entities_1(b, l + 1);
    r = r && module_services_service_entities_2(b, l + 1);
    r = r && module_services_service_implementation(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_services_service_entities_5(b, l + 1);
    r = r && module_services_service_entities_6(b, l + 1);
    r = r && module_services_service_entities_7(b, l + 1);
    r = r && module_services_service_entities_8(b, l + 1);
    r = r && module_services_service_entities_9(b, l + 1);
    r = r && module_services_service_entities_10(b, l + 1);
    r = r && module_services_service_entities_11(b, l + 1);
    r = r && module_services_service_entities_12(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&'enabled' module_services_service_enabled nl)?
  private static boolean module_services_service_entities_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0")) return false;
    module_services_service_entities_0_0(b, l + 1);
    return true;
  }

  // &'enabled' module_services_service_enabled nl
  private static boolean module_services_service_entities_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_0_0_0(b, l + 1);
    r = r && module_services_service_enabled(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'enabled'
  private static boolean module_services_service_entities_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "enabled");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'abstract' module_services_service_abstract nl)?
  private static boolean module_services_service_entities_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1")) return false;
    module_services_service_entities_1_0(b, l + 1);
    return true;
  }

  // &'abstract' module_services_service_abstract nl
  private static boolean module_services_service_entities_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_1_0_0(b, l + 1);
    r = r && module_services_service_abstract(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'abstract'
  private static boolean module_services_service_entities_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "abstract");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'implementation'
  private static boolean module_services_service_entities_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "implementation");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'dependsOn' module_services_service_dependson nl)?
  private static boolean module_services_service_entities_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5")) return false;
    module_services_service_entities_5_0(b, l + 1);
    return true;
  }

  // &'dependsOn' module_services_service_dependson nl
  private static boolean module_services_service_entities_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_5_0_0(b, l + 1);
    r = r && module_services_service_dependson(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'dependsOn'
  private static boolean module_services_service_entities_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "dependsOn");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'default' module_services_service_default nl)?
  private static boolean module_services_service_entities_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6")) return false;
    module_services_service_entities_6_0(b, l + 1);
    return true;
  }

  // &'default' module_services_service_default nl
  private static boolean module_services_service_entities_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_6_0_0(b, l + 1);
    r = r && module_services_service_default(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'default'
  private static boolean module_services_service_entities_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "default");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'listen' module_services_service_listen nl)?
  private static boolean module_services_service_entities_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7")) return false;
    module_services_service_entities_7_0(b, l + 1);
    return true;
  }

  // &'listen' module_services_service_listen nl
  private static boolean module_services_service_entities_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_7_0_0(b, l + 1);
    r = r && module_services_service_listen(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'listen'
  private static boolean module_services_service_entities_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "listen");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'parameters' module_services_service_parameters nl)?
  private static boolean module_services_service_entities_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8")) return false;
    module_services_service_entities_8_0(b, l + 1);
    return true;
  }

  // &'parameters' module_services_service_parameters nl
  private static boolean module_services_service_entities_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_8_0_0(b, l + 1);
    r = r && module_services_service_parameters(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'parameters'
  private static boolean module_services_service_entities_8_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_8_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "parameters");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'link' module_services_service_link nl)?
  private static boolean module_services_service_entities_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9")) return false;
    module_services_service_entities_9_0(b, l + 1);
    return true;
  }

  // &'link' module_services_service_link nl
  private static boolean module_services_service_entities_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_9_0_0(b, l + 1);
    r = r && module_services_service_link(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'link'
  private static boolean module_services_service_entities_9_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_9_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "link");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'remote' module_services_service_remote nl)?
  private static boolean module_services_service_entities_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10")) return false;
    module_services_service_entities_10_0(b, l + 1);
    return true;
  }

  // &'remote' module_services_service_remote nl
  private static boolean module_services_service_entities_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_10_0_0(b, l + 1);
    r = r && module_services_service_remote(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'remote'
  private static boolean module_services_service_entities_10_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_10_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "remote");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'ws-service' module_services_service_wsservice nl)?
  private static boolean module_services_service_entities_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11")) return false;
    module_services_service_entities_11_0(b, l + 1);
    return true;
  }

  // &'ws-service' module_services_service_wsservice nl
  private static boolean module_services_service_entities_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_11_0_0(b, l + 1);
    r = r && module_services_service_wsservice(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'ws-service'
  private static boolean module_services_service_entities_11_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_11_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "ws-service");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (&'supervision' module_services_service_supervision nl)?
  private static boolean module_services_service_entities_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_12")) return false;
    module_services_service_entities_12_0(b, l + 1);
    return true;
  }

  // &'supervision' module_services_service_supervision nl
  private static boolean module_services_service_entities_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_12_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_entities_12_0_0(b, l + 1);
    r = r && module_services_service_supervision(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'supervision'
  private static boolean module_services_service_entities_12_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_entities_12_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "supervision");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id_value
  public static boolean module_services_service_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_id_value")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_value(b, l + 1);
    exit_section_(b, m, OAP_MODULE_SERVICES_SERVICE_ID_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_implementation_id_value eq class_value
  public static boolean module_services_service_implementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_implementation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION, "<module services service implementation>");
    r = module_services_service_implementation_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && class_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'implementation'
  public static boolean module_services_service_implementation_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_implementation_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION_ID_VALUE, "<module services service implementation id value>");
    r = consumeToken(b, "implementation");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_link_id_value ( &dot dot_module_services_service_link_field | module_services_service_link_field_object)
  public static boolean module_services_service_link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK, "<module services service link>");
    r = module_services_service_link_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_link_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &dot dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_link_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_link_1_0(b, l + 1);
    if (!r) r = module_services_service_link_field_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_module_services_service_link_field
  private static boolean module_services_service_link_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_link_1_0_0(b, l + 1);
    r = r && dot_module_services_service_link_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_link_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // link_field eq reference_modules_value
  public static boolean module_services_service_link_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD, "<module services service link field>");
    r = link_field(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && reference_modules_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // leftbrace (!(rightbrace | nl rightbrace) nl module_services_service_link_field)* nl? rightbrace
  public static boolean module_services_service_link_field_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD_OBJECT, "<module services service link field object>");
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, module_services_service_link_field_object_1(b, l + 1));
    r = p && report_error_(b, module_services_service_link_field_object_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (!(rightbrace | nl rightbrace) nl module_services_service_link_field)*
  private static boolean module_services_service_link_field_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!module_services_service_link_field_object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_services_service_link_field_object_1", c)) break;
    }
    return true;
  }

  // !(rightbrace | nl rightbrace) nl module_services_service_link_field
  private static boolean module_services_service_link_field_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_link_field_object_1_0_0(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && module_services_service_link_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbrace | nl rightbrace)
  private static boolean module_services_service_link_field_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !module_services_service_link_field_object_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbrace | nl rightbrace
  private static boolean module_services_service_link_field_object_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = module_services_service_link_field_object_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbrace
  private static boolean module_services_service_link_field_object_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean module_services_service_link_field_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_field_object_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'link'
  public static boolean module_services_service_link_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_link_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_ID_VALUE, "<module services service link id value>");
    r = consumeToken(b, "link");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_listen_id_value ( &dot dot_module_services_service_link_field | module_services_service_link_field_object)
  public static boolean module_services_service_listen(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LISTEN, "<module services service listen>");
    r = module_services_service_listen_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_listen_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &dot dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_listen_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_listen_1_0(b, l + 1);
    if (!r) r = module_services_service_link_field_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_module_services_service_link_field
  private static boolean module_services_service_listen_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_listen_1_0_0(b, l + 1);
    r = r && dot_module_services_service_link_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_listen_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'listen'
  public static boolean module_services_service_listen_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_listen_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_LISTEN_ID_VALUE, "<module services service listen id value>");
    r = consumeToken(b, "listen");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_parameters_id_value ( &dot dot_parameters | parameters_object )
  public static boolean module_services_service_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_PARAMETERS, "<module services service parameters>");
    r = module_services_service_parameters_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_parameters_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // &dot dot_parameters | parameters_object
  private static boolean module_services_service_parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_parameters_1_0(b, l + 1);
    if (!r) r = parameters_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_parameters
  private static boolean module_services_service_parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_parameters_1_0_0(b, l + 1);
    r = r && dot_parameters(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_parameters_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'parameters'
  public static boolean module_services_service_parameters_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_parameters_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_PARAMETERS_ID_VALUE, "<module services service parameters id value>");
    r = consumeToken(b, "parameters");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_remote_id_value (&dot dot_remote | remote_object )
  public static boolean module_services_service_remote(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_REMOTE, "<module services service remote>");
    r = module_services_service_remote_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_remote_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // &dot dot_remote | remote_object
  private static boolean module_services_service_remote_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_remote_1_0(b, l + 1);
    if (!r) r = remote_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_remote
  private static boolean module_services_service_remote_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_remote_1_0_0(b, l + 1);
    r = r && dot_remote(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_remote_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'remote'
  public static boolean module_services_service_remote_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_remote_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_REMOTE_ID_VALUE, "<module services service remote id value>");
    r = consumeToken(b, "remote");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_id_value ( &dot dot_supervision | supervision_object )
  public static boolean module_services_service_supervision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION, "<module services service supervision>");
    r = module_services_service_supervision_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_supervision_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // &dot dot_supervision | supervision_object
  private static boolean module_services_service_supervision_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_1_0(b, l + 1);
    if (!r) r = supervision_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_supervision
  private static boolean module_services_service_supervision_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_supervision_1_0_0(b, l + 1);
    r = r && dot_supervision(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
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
    r = consumeToken(b, "supervise");
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
    r = consumeToken(b, "schedule");
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
    r = consumeToken(b, "thread");
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
    r = consumeToken(b, "delay");
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
    r = consumeToken(b, "cron");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_entities_cron_id_value eq cron_value
  public static boolean module_services_service_supervision_entities_cron(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_cron")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_CRON, "<module services service supervision entities cron>");
    r = module_services_service_supervision_entities_cron_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && cron_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'cron'
  public static boolean module_services_service_supervision_entities_cron_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_cron_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_CRON_ID_VALUE, "<module services service supervision entities cron id value>");
    r = consumeToken(b, "cron");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_entities_delay_id_value eq duration_value
  public static boolean module_services_service_supervision_entities_delay(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_delay")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_DELAY, "<module services service supervision entities delay>");
    r = module_services_service_supervision_entities_delay_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && duration_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'delay'
  public static boolean module_services_service_supervision_entities_delay_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_delay_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_DELAY_ID_VALUE, "<module services service supervision entities delay id value>");
    r = consumeToken(b, "delay");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_entities_schedule_id_value eq bool_value
  public static boolean module_services_service_supervision_entities_schedule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_schedule")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SCHEDULE, "<module services service supervision entities schedule>");
    r = module_services_service_supervision_entities_schedule_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'schedule'
  public static boolean module_services_service_supervision_entities_schedule_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_schedule_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SCHEDULE_ID_VALUE, "<module services service supervision entities schedule id value>");
    r = consumeToken(b, "schedule");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_entities_supervise_id_value eq bool_value
  public static boolean module_services_service_supervision_entities_supervise(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_supervise")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SUPERVISE, "<module services service supervision entities supervise>");
    r = module_services_service_supervision_entities_supervise_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'supervise'
  public static boolean module_services_service_supervision_entities_supervise_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_supervise_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SUPERVISE_ID_VALUE, "<module services service supervision entities supervise id value>");
    r = consumeToken(b, "supervise");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_services_service_supervision_entities_thread_id_value eq bool_value
  public static boolean module_services_service_supervision_entities_thread(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_thread")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_THREAD, "<module services service supervision entities thread>");
    r = module_services_service_supervision_entities_thread_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'thread'
  public static boolean module_services_service_supervision_entities_thread_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_entities_thread_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_THREAD_ID_VALUE, "<module services service supervision entities thread id value>");
    r = consumeToken(b, "thread");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'supervision'
  public static boolean module_services_service_supervision_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ID_VALUE, "<module services service supervision id value>");
    r = consumeToken(b, "supervision");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nl module_services_service_supervision_entities
  static boolean module_services_service_supervision_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_supervision_line")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = nl(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_supervision_entities(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // module_services_service_wsservice_id_value ( &dot dot_wsservice_path | wsservice_object )
  public static boolean module_services_service_wsservice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSSERVICE, "<module services service wsservice>");
    r = module_services_service_wsservice_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && module_services_service_wsservice_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // &dot dot_wsservice_path | wsservice_object
  private static boolean module_services_service_wsservice_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wsservice_1_0(b, l + 1);
    if (!r) r = wsservice_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot dot_wsservice_path
  private static boolean module_services_service_wsservice_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_services_service_wsservice_1_0_0(b, l + 1);
    r = r && dot_wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &dot
  private static boolean module_services_service_wsservice_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'ws-service'
  public static boolean module_services_service_wsservice_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_services_service_wsservice_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSSERVICE_ID_VALUE, "<module services service wsservice id value>");
    r = consumeToken(b, "ws-service");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nextline+
  public static boolean nl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nl")) return false;
    if (!nextTokenIs(b, OAP_NEXTLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_NEXTLINE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, OAP_NEXTLINE)) break;
      if (!empty_element_parsed_guard_(b, "nl", c)) break;
    }
    exit_section_(b, m, OAP_NL, r);
    return r;
  }

  /* ********************************************************** */
  // long | ulong | double
  public static boolean number_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_NUMBER_VALUE, "<number value>");
    r = consumeToken(b, OAP_LONG);
    if (!r) r = consumeToken(b, OAP_ULONG);
    if (!r) r = consumeToken(b, OAP_DOUBLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace nl module_services_service_entities rightbrace
  static boolean object_service(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_service")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, nl(b, l + 1));
    r = p && report_error_(b, module_services_service_entities(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  /* ********************************************************** */
  // id_value ( dot id_value )*
  public static boolean parameter_id_value_or_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_id_value_or_path")) return false;
    if (!nextTokenIs(b, OAP_LETTERS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETER_ID_VALUE_OR_PATH, null);
    r = id_value(b, l + 1);
    p = r; // pin = 1
    r = r && parameter_id_value_or_path_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( dot id_value )*
  private static boolean parameter_id_value_or_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_id_value_or_path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_id_value_or_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_id_value_or_path_1", c)) break;
    }
    return true;
  }

  // dot id_value
  private static boolean parameter_id_value_or_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_id_value_or_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DOT);
    r = r && id_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parameter_id_value_or_path ( eq (
  //           &leftbracket parameters_array
  //         | parameters_reference
  //         | parameters_function
  //         | bool_value
  //         | number_value &(nl|comma|rightbrace|rightbracket)
  //         | duration_value
  //         | string_value
  //         | unquotedstring_value
  //     ) | parameters_object )
  public static boolean parameter_key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETER_KEY_VALUE, "<parameter key value>");
    r = parameter_id_value_or_path(b, l + 1);
    p = r; // pin = 1
    r = r && parameter_key_value_1(b, l + 1);
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // eq (
  //           &leftbracket parameters_array
  //         | parameters_reference
  //         | parameters_function
  //         | bool_value
  //         | number_value &(nl|comma|rightbrace|rightbracket)
  //         | duration_value
  //         | string_value
  //         | unquotedstring_value
  //     ) | parameters_object
  private static boolean parameter_key_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_1_0(b, l + 1);
    if (!r) r = parameters_object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // eq (
  //           &leftbracket parameters_array
  //         | parameters_reference
  //         | parameters_function
  //         | bool_value
  //         | number_value &(nl|comma|rightbrace|rightbracket)
  //         | duration_value
  //         | string_value
  //         | unquotedstring_value
  //     )
  private static boolean parameter_key_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_EQ);
    r = r && parameter_key_value_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket parameters_array
  //         | parameters_reference
  //         | parameters_function
  //         | bool_value
  //         | number_value &(nl|comma|rightbrace|rightbracket)
  //         | duration_value
  //         | string_value
  //         | unquotedstring_value
  private static boolean parameter_key_value_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_1_0_1_0(b, l + 1);
    if (!r) r = parameters_reference(b, l + 1);
    if (!r) r = parameters_function(b, l + 1);
    if (!r) r = bool_value(b, l + 1);
    if (!r) r = parameter_key_value_1_0_1_4(b, l + 1);
    if (!r) r = duration_value(b, l + 1);
    if (!r) r = string_value(b, l + 1);
    if (!r) r = unquotedstring_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket parameters_array
  private static boolean parameter_key_value_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value_1_0_1_0_0(b, l + 1);
    r = r && parameters_array(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket
  private static boolean parameter_key_value_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // number_value &(nl|comma|rightbrace|rightbracket)
  private static boolean parameter_key_value_1_0_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_value(b, l + 1);
    r = r && parameter_key_value_1_0_1_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(nl|comma|rightbrace|rightbracket)
  private static boolean parameter_key_value_1_0_1_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = parameter_key_value_1_0_1_4_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nl|comma|rightbrace|rightbracket
  private static boolean parameter_key_value_1_0_1_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_key_value_1_0_1_4_1_0")) return false;
    boolean r;
    r = nl(b, l + 1);
    if (!r) r = consumeToken(b, OAP_COMMA);
    if (!r) r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = consumeToken(b, OAP_RIGHTBRACKET);
    return r;
  }

  /* ********************************************************** */
  // leftbracket (!(rightbracket | nl rightbracket) nl? parameters_array_item)* nl? rightbracket
  public static boolean parameters_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_ARRAY, "<parameters array>");
    r = consumeToken(b, OAP_LEFTBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, parameters_array_1(b, l + 1));
    r = p && report_error_(b, parameters_array_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACKET) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // (!(rightbracket | nl rightbracket) nl? parameters_array_item)*
  private static boolean parameters_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_array_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_array_1", c)) break;
    }
    return true;
  }

  // !(rightbracket | nl rightbracket) nl? parameters_array_item
  private static boolean parameters_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_array_1_0_0(b, l + 1);
    r = r && parameters_array_1_0_1(b, l + 1);
    r = r && parameters_array_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean parameters_array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !parameters_array_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean parameters_array_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = parameters_array_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean parameters_array_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean parameters_array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_1_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean parameters_array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // parameters_object | parameters_reference | parameters_values
  public static boolean parameters_array_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_array_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_ARRAY_ITEM, "<parameters array item>");
    r = parameters_object(b, l + 1);
    if (!r) r = parameters_reference(b, l + 1);
    if (!r) r = parameters_values(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // &'classpath' class_path_parameters_function | &'json' json_parameters_function | &'path' path_parameters_function
  static boolean parameters_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_function_0(b, l + 1);
    if (!r) r = parameters_function_1(b, l + 1);
    if (!r) r = parameters_function_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'classpath' class_path_parameters_function
  private static boolean parameters_function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_function_0_0(b, l + 1);
    r = r && class_path_parameters_function(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'classpath'
  private static boolean parameters_function_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "classpath");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'json' json_parameters_function
  private static boolean parameters_function_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_function_1_0(b, l + 1);
    r = r && json_parameters_function(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'json'
  private static boolean parameters_function_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "json");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'path' path_parameters_function
  private static boolean parameters_function_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_function_2_0(b, l + 1);
    r = r && path_parameters_function(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path'
  private static boolean parameters_function_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_function_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "path");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace (!(rightbracket | nl rightbracket) nl? parameters_object_entries)? nl? rightbrace
  public static boolean parameters_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PARAMETERS_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, parameters_object_1(b, l + 1));
    r = p && report_error_(b, parameters_object_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (!(rightbracket | nl rightbracket) nl? parameters_object_entries)?
  private static boolean parameters_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1")) return false;
    parameters_object_1_0(b, l + 1);
    return true;
  }

  // !(rightbracket | nl rightbracket) nl? parameters_object_entries
  private static boolean parameters_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_object_1_0_0(b, l + 1);
    r = r && parameters_object_1_0_1(b, l + 1);
    r = r && parameters_object_entries(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean parameters_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !parameters_object_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean parameters_object_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = parameters_object_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean parameters_object_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean parameters_object_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_1_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // nl?
  private static boolean parameters_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (parameter_key_value nl?)*
  static boolean parameters_object_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_entries")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_object_entries_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_object_entries", c)) break;
    }
    return true;
  }

  // parameter_key_value nl?
  private static boolean parameters_object_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_key_value(b, l + 1);
    r = r && parameters_object_entries_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean parameters_object_entries_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_object_entries_0_1")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // &(leftangle 'modules') reference_modules_value | &(leftangle 'services') reference_services_value | &(leftangle 'kernel') reference_kernel_value
  public static boolean parameters_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_reference_0(b, l + 1);
    if (!r) r = parameters_reference_1(b, l + 1);
    if (!r) r = parameters_reference_2(b, l + 1);
    exit_section_(b, m, OAP_PARAMETERS_REFERENCE, r);
    return r;
  }

  // &(leftangle 'modules') reference_modules_value
  private static boolean parameters_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_reference_0_0(b, l + 1);
    r = r && reference_modules_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(leftangle 'modules')
  private static boolean parameters_reference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = parameters_reference_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // leftangle 'modules'
  private static boolean parameters_reference_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "modules");
    exit_section_(b, m, null, r);
    return r;
  }

  // &(leftangle 'services') reference_services_value
  private static boolean parameters_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_reference_1_0(b, l + 1);
    r = r && reference_services_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(leftangle 'services')
  private static boolean parameters_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = parameters_reference_1_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // leftangle 'services'
  private static boolean parameters_reference_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "services");
    exit_section_(b, m, null, r);
    return r;
  }

  // &(leftangle 'kernel') reference_kernel_value
  private static boolean parameters_reference_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_reference_2_0(b, l + 1);
    r = r && reference_kernel_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(leftangle 'kernel')
  private static boolean parameters_reference_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = parameters_reference_2_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // leftangle 'kernel'
  private static boolean parameters_reference_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_reference_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "kernel");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (string_value | id_value) (comma (string_value | id_value) )*
  static boolean parameters_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_values")) return false;
    if (!nextTokenIs(b, "", OAP_LETTERS, OAP_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters_values_0(b, l + 1);
    r = r && parameters_values_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_value | id_value
  private static boolean parameters_values_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_values_0")) return false;
    boolean r;
    r = string_value(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    return r;
  }

  // (comma (string_value | id_value) )*
  private static boolean parameters_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_values_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_values_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_values_1", c)) break;
    }
    return true;
  }

  // comma (string_value | id_value)
  private static boolean parameters_values_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_values_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_COMMA);
    r = r && parameters_values_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_value | id_value
  private static boolean parameters_values_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_values_1_0_1")) return false;
    boolean r;
    r = string_value(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'path' leftparen path_parameters_function_body rightparen
  public static boolean path_parameters_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_PATH_PARAMETERS_FUNCTION, "<path parameters function>");
    r = consumeToken(b, "path");
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_LEFTPAREN));
    r = p && report_error_(b, path_parameters_function_body(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // div? (env_variable | id_value ) (div | id_value | env_variable | dot)*
  public static boolean path_parameters_function_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_PATH_PARAMETERS_FUNCTION_BODY, "<path parameters function body>");
    r = path_parameters_function_body_0(b, l + 1);
    r = r && path_parameters_function_body_1(b, l + 1);
    r = r && path_parameters_function_body_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // div?
  private static boolean path_parameters_function_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function_body_0")) return false;
    consumeToken(b, OAP_DIV);
    return true;
  }

  // env_variable | id_value
  private static boolean path_parameters_function_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function_body_1")) return false;
    boolean r;
    r = env_variable(b, l + 1);
    if (!r) r = id_value(b, l + 1);
    return r;
  }

  // (div | id_value | env_variable | dot)*
  private static boolean path_parameters_function_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function_body_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_parameters_function_body_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_parameters_function_body_2", c)) break;
    }
    return true;
  }

  // div | id_value | env_variable | dot
  private static boolean path_parameters_function_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_parameters_function_body_2_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_DIV);
    if (!r) r = id_value(b, l + 1);
    if (!r) r = env_variable(b, l + 1);
    if (!r) r = consumeToken(b, OAP_DOT);
    return r;
  }

  /* ********************************************************** */
  // !( nextline | rightbracket | rightbrace | rightparen ) nl?
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_recover_0(b, l + 1);
    r = r && property_recover_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !( nextline | rightbracket | rightbrace | rightparen )
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nextline | rightbracket | rightbrace | rightparen
  private static boolean property_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_NEXTLINE);
    if (!r) r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = consumeToken(b, OAP_RIGHTPAREN);
    return r;
  }

  // nl?
  private static boolean property_recover_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_1")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(nextline|<<eof>>)
  static boolean recover_to_end_of_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_to_end_of_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_to_end_of_line_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nextline|<<eof>>
  private static boolean recover_to_end_of_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_to_end_of_line_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_NEXTLINE);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // leftangle 'kernel' dot 'self' rightangle
  public static boolean reference_kernel_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_kernel_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_KERNEL_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "kernel");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, OAP_DOT));
    r = p && report_error_(b, consumeToken(b, "self")) && r;
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // leftangle 'modules' dot (id_value | 'this') dot id_value rightangle
  public static boolean reference_modules_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_MODULES_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "modules");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, OAP_DOT));
    r = p && report_error_(b, reference_modules_value_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OAP_DOT)) && r;
    r = p && report_error_(b, id_value(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // id_value | 'this'
  private static boolean reference_modules_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_modules_value_3")) return false;
    boolean r;
    r = id_value(b, l + 1);
    if (!r) r = consumeToken(b, "this");
    return r;
  }

  /* ********************************************************** */
  // leftangle 'services' dot 'self' dot 'name' rightangle
  public static boolean reference_services_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_services_value")) return false;
    if (!nextTokenIs(b, OAP_LEFTANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REFERENCE_SERVICES_VALUE, null);
    r = consumeToken(b, OAP_LEFTANGLE);
    r = r && consumeToken(b, "services");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, OAP_DOT));
    r = p && report_error_(b, consumeToken(b, "self")) && r;
    r = p && report_error_(b, consumeToken(b, OAP_DOT)) && r;
    r = p && report_error_(b, consumeToken(b, "name")) && r;
    r = p && consumeToken(b, OAP_RIGHTANGLE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ((&'name' remote_name | &'timeout' remote_timeout | &'serialization' remote_serialization | &'url' remote_url ) nl )*
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

  // (&'name' remote_name | &'timeout' remote_timeout | &'serialization' remote_serialization | &'url' remote_url ) nl
  private static boolean remote_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'name' remote_name | &'timeout' remote_timeout | &'serialization' remote_serialization | &'url' remote_url
  private static boolean remote_entries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_0(b, l + 1);
    if (!r) r = remote_entries_0_0_1(b, l + 1);
    if (!r) r = remote_entries_0_0_2(b, l + 1);
    if (!r) r = remote_entries_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'name' remote_name
  private static boolean remote_entries_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_0_0(b, l + 1);
    r = r && remote_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'name'
  private static boolean remote_entries_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "name");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'timeout' remote_timeout
  private static boolean remote_entries_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_1_0(b, l + 1);
    r = r && remote_timeout(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'timeout'
  private static boolean remote_entries_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "timeout");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'serialization' remote_serialization
  private static boolean remote_entries_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_2_0(b, l + 1);
    r = r && remote_serialization(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'serialization'
  private static boolean remote_entries_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "serialization");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'url' remote_url
  private static boolean remote_entries_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_entries_0_0_3_0(b, l + 1);
    r = r && remote_url(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'url'
  private static boolean remote_entries_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_entries_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "url");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // remote_name_id_value eq reference_modules_value
  public static boolean remote_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_name")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_NAME, "<remote name>");
    r = remote_name_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && reference_modules_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'name'
  public static boolean remote_name_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_name_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_NAME_ID_VALUE, "<remote name id value>");
    r = consumeToken(b, "name");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace (!(rightbrace | nl rightbrace) nl remote_entries) nl? rightbrace
  public static boolean remote_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, remote_object_1(b, l + 1));
    r = p && report_error_(b, remote_object_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !(rightbrace | nl rightbrace) nl remote_entries
  private static boolean remote_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = remote_object_1_0(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && remote_entries(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbrace | nl rightbrace)
  private static boolean remote_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !remote_object_1_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbrace | nl rightbrace
  private static boolean remote_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = remote_object_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbrace
  private static boolean remote_object_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean remote_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_object_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // remote_serialization_id_value eq ('DEFAULT'|'JSON'|'BINARY')
  public static boolean remote_serialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_serialization")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_SERIALIZATION, "<remote serialization>");
    r = remote_serialization_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && remote_serialization_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  // 'DEFAULT'|'JSON'|'BINARY'
  private static boolean remote_serialization_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_serialization_2")) return false;
    boolean r;
    r = consumeToken(b, "DEFAULT");
    if (!r) r = consumeToken(b, "JSON");
    if (!r) r = consumeToken(b, "BINARY");
    return r;
  }

  /* ********************************************************** */
  // 'serialization'
  public static boolean remote_serialization_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_serialization_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_SERIALIZATION_ID_VALUE, "<remote serialization id value>");
    r = consumeToken(b, "serialization");
    exit_section_(b, l, m, r, false, null);
    return r;
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
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
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
  // remote_url_id_value eq string_value
  public static boolean remote_url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_url")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_URL, "<remote url>");
    r = remote_url_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && string_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'url'
  public static boolean remote_url_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "remote_url_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_REMOTE_URL_ID_VALUE, "<remote url id value>");
    r = consumeToken(b, "url");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean string_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_value")) return false;
    if (!nextTokenIs(b, OAP_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_STRING);
    exit_section_(b, m, OAP_STRING_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // leftbrace ( !(rightbrace | nl rightbrace) module_services_service_supervision_line )* nl rightbrace
  static boolean supervision_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, supervision_object_1(b, l + 1));
    r = p && report_error_(b, nl(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // ( !(rightbrace | nl rightbrace) module_services_service_supervision_line )*
  private static boolean supervision_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!supervision_object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "supervision_object_1", c)) break;
    }
    return true;
  }

  // !(rightbrace | nl rightbrace) module_services_service_supervision_line
  private static boolean supervision_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = supervision_object_1_0_0(b, l + 1);
    r = r && module_services_service_supervision_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbrace | nl rightbrace)
  private static boolean supervision_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !supervision_object_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbrace | nl rightbrace
  private static boolean supervision_object_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACE);
    if (!r) r = supervision_object_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbrace
  private static boolean supervision_object_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supervision_object_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( letters | long | ulong | double | dash | div | ' ' | dot )+
  public static boolean unquotedstring_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquotedstring_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_UNQUOTEDSTRING_VALUE, "<unquotedstring value>");
    r = unquotedstring_value_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!unquotedstring_value_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unquotedstring_value", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // letters | long | ulong | double | dash | div | ' ' | dot
  private static boolean unquotedstring_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquotedstring_value_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_LONG);
    if (!r) r = consumeToken(b, OAP_ULONG);
    if (!r) r = consumeToken(b, OAP_DOUBLE);
    if (!r) r = consumeToken(b, OAP_DASH);
    if (!r) r = consumeToken(b, OAP_DIV);
    if (!r) r = consumeToken(b, " ");
    if (!r) r = consumeToken(b, OAP_DOT);
    return r;
  }

  /* ********************************************************** */
  // div? (letters | '-' )+ ( div (letters | '-')+ )*
  public static boolean wspath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSPATH, "<wspath>");
    r = wspath_0(b, l + 1);
    r = r && wspath_1(b, l + 1);
    r = r && wspath_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // div?
  private static boolean wspath_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_0")) return false;
    consumeToken(b, OAP_DIV);
    return true;
  }

  // (letters | '-' )+
  private static boolean wspath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wspath_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!wspath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wspath_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letters | '-'
  private static boolean wspath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_DASH);
    return r;
  }

  // ( div (letters | '-')+ )*
  private static boolean wspath_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wspath_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wspath_2", c)) break;
    }
    return true;
  }

  // div (letters | '-')+
  private static boolean wspath_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DIV);
    r = r && wspath_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (letters | '-')+
  private static boolean wspath_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wspath_2_0_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!wspath_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wspath_2_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letters | '-'
  private static boolean wspath_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wspath_2_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_DASH);
    return r;
  }

  /* ********************************************************** */
  // ((&'path' wsservice_path|&'port' wsservice_port|&'sessionAware' wsservice_sessionAware|&'interceptors' wsservice_interceptors) nl)*
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

  // (&'path' wsservice_path|&'port' wsservice_port|&'sessionAware' wsservice_sessionAware|&'interceptors' wsservice_interceptors) nl
  private static boolean wsservice_entries_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0(b, l + 1);
    r = r && nl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path' wsservice_path|&'port' wsservice_port|&'sessionAware' wsservice_sessionAware|&'interceptors' wsservice_interceptors
  private static boolean wsservice_entries_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_0(b, l + 1);
    if (!r) r = wsservice_entries_0_0_1(b, l + 1);
    if (!r) r = wsservice_entries_0_0_2(b, l + 1);
    if (!r) r = wsservice_entries_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path' wsservice_path
  private static boolean wsservice_entries_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_0_0(b, l + 1);
    r = r && wsservice_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'path'
  private static boolean wsservice_entries_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "path");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'port' wsservice_port
  private static boolean wsservice_entries_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_1_0(b, l + 1);
    r = r && wsservice_port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'port'
  private static boolean wsservice_entries_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "port");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'sessionAware' wsservice_sessionAware
  private static boolean wsservice_entries_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_2_0(b, l + 1);
    r = r && wsservice_sessionAware(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'sessionAware'
  private static boolean wsservice_entries_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "sessionAware");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // &'interceptors' wsservice_interceptors
  private static boolean wsservice_entries_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_entries_0_0_3_0(b, l + 1);
    r = r && wsservice_interceptors(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'interceptors'
  private static boolean wsservice_entries_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_entries_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "interceptors");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (letters | '-')+ ( dot (letters | '-')+ )*
  public static boolean wsservice_interceptor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor")) return false;
    if (!nextTokenIs(b, "<wsservice interceptor>", OAP_DASH, OAP_LETTERS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_INTERCEPTOR, "<wsservice interceptor>");
    r = wsservice_interceptor_0(b, l + 1);
    r = r && wsservice_interceptor_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (letters | '-')+
  private static boolean wsservice_interceptor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptor_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!wsservice_interceptor_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_interceptor_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letters | '-'
  private static boolean wsservice_interceptor_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_0_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_DASH);
    return r;
  }

  // ( dot (letters | '-')+ )*
  private static boolean wsservice_interceptor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wsservice_interceptor_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_interceptor_1", c)) break;
    }
    return true;
  }

  // dot (letters | '-')+
  private static boolean wsservice_interceptor_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_DOT);
    r = r && wsservice_interceptor_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (letters | '-')+
  private static boolean wsservice_interceptor_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptor_1_0_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!wsservice_interceptor_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_interceptor_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letters | '-'
  private static boolean wsservice_interceptor_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_1_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_LETTERS);
    if (!r) r = consumeToken(b, OAP_DASH);
    return r;
  }

  /* ********************************************************** */
  // leftbracket nl? wsservice_interceptor_one ( (comma|nl) wsservice_interceptor_one )* nl? rightbracket
  static boolean wsservice_interceptor_multiple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && wsservice_interceptor_multiple_1(b, l + 1);
    r = r && wsservice_interceptor_one(b, l + 1);
    r = r && wsservice_interceptor_multiple_3(b, l + 1);
    r = r && wsservice_interceptor_multiple_4(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean wsservice_interceptor_multiple_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // ( (comma|nl) wsservice_interceptor_one )*
  private static boolean wsservice_interceptor_multiple_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wsservice_interceptor_multiple_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_interceptor_multiple_3", c)) break;
    }
    return true;
  }

  // (comma|nl) wsservice_interceptor_one
  private static boolean wsservice_interceptor_multiple_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_interceptor_multiple_3_0_0(b, l + 1);
    r = r && wsservice_interceptor_one(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma|nl
  private static boolean wsservice_interceptor_multiple_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_3_0_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_COMMA);
    if (!r) r = nl(b, l + 1);
    return r;
  }

  // nl?
  private static boolean wsservice_interceptor_multiple_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptor_multiple_4")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // wsservice_interceptor
  static boolean wsservice_interceptor_one(PsiBuilder b, int l) {
    return wsservice_interceptor(b, l + 1);
  }

  /* ********************************************************** */
  // wsservice_interceptors_id_value eq (wsservice_interceptor_one|wsservice_interceptor_multiple)
  public static boolean wsservice_interceptors(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_INTERCEPTORS, "<wsservice interceptors>");
    r = wsservice_interceptors_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && wsservice_interceptors_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // wsservice_interceptor_one|wsservice_interceptor_multiple
  private static boolean wsservice_interceptors_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors_2")) return false;
    boolean r;
    r = wsservice_interceptor_one(b, l + 1);
    if (!r) r = wsservice_interceptor_multiple(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'interceptors'
  public static boolean wsservice_interceptors_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_interceptors_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_INTERCEPTORS_ID_VALUE, "<wsservice interceptors id value>");
    r = consumeToken(b, "interceptors");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace (!(rightbracket | nl rightbracket) nl wsservice_entries)? nl? rightbrace
  public static boolean wsservice_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_OBJECT, null);
    r = consumeToken(b, OAP_LEFTBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, wsservice_object_1(b, l + 1));
    r = p && report_error_(b, wsservice_object_2(b, l + 1)) && r;
    r = p && consumeToken(b, OAP_RIGHTBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (!(rightbracket | nl rightbracket) nl wsservice_entries)?
  private static boolean wsservice_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1")) return false;
    wsservice_object_1_0(b, l + 1);
    return true;
  }

  // !(rightbracket | nl rightbracket) nl wsservice_entries
  private static boolean wsservice_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_object_1_0_0(b, l + 1);
    r = r && nl(b, l + 1);
    r = r && wsservice_entries(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(rightbracket | nl rightbracket)
  private static boolean wsservice_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !wsservice_object_1_0_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // rightbracket | nl rightbracket
  private static boolean wsservice_object_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_RIGHTBRACKET);
    if (!r) r = wsservice_object_1_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl rightbracket
  private static boolean wsservice_object_1_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_1_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nl(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean wsservice_object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_object_2")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // wsservice_path_id_value eq (&leftbracket wsservice_path_multiple | wsservice_path_one )
  public static boolean wsservice_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PATH, "<wsservice path>");
    r = wsservice_path_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && wsservice_path_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::property_recover);
    return r || p;
  }

  // &leftbracket wsservice_path_multiple | wsservice_path_one
  private static boolean wsservice_path_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_2_0(b, l + 1);
    if (!r) r = wsservice_path_one(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket wsservice_path_multiple
  private static boolean wsservice_path_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_2_0_0(b, l + 1);
    r = r && wsservice_path_multiple(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &leftbracket
  private static boolean wsservice_path_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, OAP_LEFTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'path'
  public static boolean wsservice_path_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PATH_ID_VALUE, "<wsservice path id value>");
    r = consumeToken(b, "path");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbracket nl? wsservice_path_one ((comma|nl) wsservice_path_one)* nl? rightbracket
  static boolean wsservice_path_multiple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple")) return false;
    if (!nextTokenIs(b, OAP_LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OAP_LEFTBRACKET);
    r = r && wsservice_path_multiple_1(b, l + 1);
    r = r && wsservice_path_one(b, l + 1);
    r = r && wsservice_path_multiple_3(b, l + 1);
    r = r && wsservice_path_multiple_4(b, l + 1);
    r = r && consumeToken(b, OAP_RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // nl?
  private static boolean wsservice_path_multiple_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_1")) return false;
    nl(b, l + 1);
    return true;
  }

  // ((comma|nl) wsservice_path_one)*
  private static boolean wsservice_path_multiple_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!wsservice_path_multiple_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wsservice_path_multiple_3", c)) break;
    }
    return true;
  }

  // (comma|nl) wsservice_path_one
  private static boolean wsservice_path_multiple_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsservice_path_multiple_3_0_0(b, l + 1);
    r = r && wsservice_path_one(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma|nl
  private static boolean wsservice_path_multiple_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_3_0_0")) return false;
    boolean r;
    r = consumeToken(b, OAP_COMMA);
    if (!r) r = nl(b, l + 1);
    return r;
  }

  // nl?
  private static boolean wsservice_path_multiple_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_path_multiple_4")) return false;
    nl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // wspath
  static boolean wsservice_path_one(PsiBuilder b, int l) {
    return wspath(b, l + 1);
  }

  /* ********************************************************** */
  // wsservice_port_id_value eq id_value
  public static boolean wsservice_port(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_port")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PORT, "<wsservice port>");
    r = wsservice_port_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && id_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'port'
  public static boolean wsservice_port_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_port_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_PORT_ID_VALUE, "<wsservice port id value>");
    r = consumeToken(b, "port");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // wsservice_sessionAware_id_value eq bool_value
  public static boolean wsservice_sessionAware(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_sessionAware")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_SESSION_AWARE, "<wsservice session aware>");
    r = wsservice_sessionAware_id_value(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OAP_EQ));
    r = p && bool_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, OapParser::recover_to_end_of_line);
    return r || p;
  }

  /* ********************************************************** */
  // 'sessionAware'
  public static boolean wsservice_sessionAware_id_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsservice_sessionAware_id_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OAP_WSSERVICE_SESSION_AWARE_ID_VALUE, "<wsservice session aware id value>");
    r = consumeToken(b, "sessionAware");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
