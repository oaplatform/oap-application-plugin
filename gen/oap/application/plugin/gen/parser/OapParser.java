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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return module_$(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // '<'  any_reference_in '>'
  public static boolean any_reference(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_ANY_REFERENCE, "<any reference>");
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, any_reference_in(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTANGLE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, OapParser::recover_reference);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // &'modules' reference_modules_value_in | &'services' reference_services_in | &'kernel' reference_kernel_value_in
  public static boolean any_reference_in(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_ANY_REFERENCE_IN, "<any reference in>");
    result_ = any_reference_in_0(builder_, level_ + 1);
    if (!result_) result_ = any_reference_in_1(builder_, level_ + 1);
    if (!result_) result_ = any_reference_in_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'modules' reference_modules_value_in
  private static boolean any_reference_in_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = any_reference_in_0_0(builder_, level_ + 1);
    result_ = result_ && reference_modules_value_in(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'modules'
  private static boolean any_reference_in_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_MODULES);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'services' reference_services_in
  private static boolean any_reference_in_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = any_reference_in_1_0(builder_, level_ + 1);
    result_ = result_ && reference_services_in(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'services'
  private static boolean any_reference_in_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SERVICES);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'kernel' reference_kernel_value_in
  private static boolean any_reference_in_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = any_reference_in_2_0(builder_, level_ + 1);
    result_ = result_ && reference_kernel_value_in(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'kernel'
  private static boolean any_reference_in_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "any_reference_in_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_KERNEL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // bool
  public static boolean bool_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "bool_value")) return false;
    if (!nextTokenIs(builder_, OAP_BOOL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_BOOL);
    exit_section_(builder_, marker_, OAP_BOOL_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // class_name
  public static boolean class_name_psi(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_name_psi")) return false;
    if (!nextTokenIs(builder_, OAP_CLASS_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_CLASS_NAME);
    exit_section_(builder_, marker_, OAP_CLASS_NAME_PSI, result_);
    return result_;
  }

  /* ********************************************************** */
  // '[' config_array_item? (','? config_array_item)* ']'
  public static boolean config_array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_CONFIG_ARRAY, null);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, config_array_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, config_array_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // config_array_item?
  private static boolean config_array_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_1")) return false;
    config_array_item(builder_, level_ + 1);
    return true;
  }

  // (','? config_array_item)*
  private static boolean config_array_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!config_array_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "config_array_2", pos_)) break;
    }
    return true;
  }

  // ','? config_array_item
  private static boolean config_array_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = config_array_2_0_0(builder_, level_ + 1);
    result_ = result_ && config_array_item(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean config_array_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_2_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // &'{' config_object | key_value
  public static boolean config_array_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_item")) return false;
    if (!nextTokenIs(builder_, "<config array item>", OAP_KEY_VALUE, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_CONFIG_ARRAY_ITEM, "<config array item>");
    result_ = config_array_item_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'{' config_object
  private static boolean config_array_item_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_item_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = config_array_item_0_0(builder_, level_ + 1);
    result_ = result_ && config_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'{'
  private static boolean config_array_item_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_array_item_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '=' config_array
  static boolean config_entries_config_eq(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_entries_config_eq")) return false;
    if (!nextTokenIs(builder_, OAP_EQ)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_EQ);
    pinned_ = result_; // pin = 1
    result_ = result_ && config_array(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' indent config_key_value_array_block_item+ dedent
  static boolean config_key_value_array_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_array_block")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, config_key_value_array_block_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // config_key_value_array_block_item+
  private static boolean config_key_value_array_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_array_block_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = config_key_value_array_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!config_key_value_array_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "config_key_value_array_block_2", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' config_array_item
  static boolean config_key_value_array_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_array_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && config_array_item(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' config_key_value_value
  static boolean config_key_value_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && config_key_value_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '=' config_key_value_value
  static boolean config_key_value_eq(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_eq")) return false;
    if (!nextTokenIs(builder_, OAP_EQ)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_EQ);
    pinned_ = result_; // pin = 1
    result_ = result_ && config_key_value_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // &'[' config_array | bool_value | id_value
  static boolean config_key_value_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = config_key_value_value_0(builder_, level_ + 1);
    if (!result_) result_ = bool_value(builder_, level_ + 1);
    if (!result_) result_ = id_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'[' config_array
  private static boolean config_key_value_value_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_value_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = config_key_value_value_0_0(builder_, level_ + 1);
    result_ = result_ && config_array(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'['
  private static boolean config_key_value_value_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_key_value_value_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // config_object_brace | config_object_colon
  public static boolean config_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object")) return false;
    if (!nextTokenIs(builder_, "<config object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_CONFIG_OBJECT, "<config object>");
    result_ = config_object_brace(builder_, level_ + 1);
    if (!result_) result_ = config_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' (configuration_key_value_pair)* '}'
  static boolean config_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, config_object_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (configuration_key_value_pair)*
  private static boolean config_object_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_brace_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!config_object_brace_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "config_object_brace_1", pos_)) break;
    }
    return true;
  }

  // (configuration_key_value_pair)
  private static boolean config_object_brace_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_brace_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ':' indent (configuration_key_value_pair)* dedent
  static boolean config_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, config_object_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (configuration_key_value_pair)*
  private static boolean config_object_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_colon_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!config_object_colon_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "config_object_colon_2", pos_)) break;
    }
    return true;
  }

  // (configuration_key_value_pair)
  private static boolean config_object_colon_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "config_object_colon_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ( &'include' module_include )
  //     | key_name ('.' key_name)*
  //         (&'=' config_key_value_eq
  //          | &'{' config_object
  //          | &(':' indent '-') config_key_value_array_block
  //          | &(':' indent) config_object
  //          | config_key_value_colon)
  public static boolean configuration_key_value_pair(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair")) return false;
    if (!nextTokenIs(builder_, "<configuration key value pair>", OAP_ID_INCLUDE, OAP_KEY_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_CONFIGURATION_KEY_VALUE_PAIR, "<configuration key value pair>");
    result_ = configuration_key_value_pair_0(builder_, level_ + 1);
    if (!result_) result_ = configuration_key_value_pair_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'include' module_include
  private static boolean configuration_key_value_pair_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_0_0(builder_, level_ + 1);
    result_ = result_ && module_include(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'include'
  private static boolean configuration_key_value_pair_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_INCLUDE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // key_name ('.' key_name)*
  //         (&'=' config_key_value_eq
  //          | &'{' config_object
  //          | &(':' indent '-') config_key_value_array_block
  //          | &(':' indent) config_object
  //          | config_key_value_colon)
  private static boolean configuration_key_value_pair_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_NAME);
    result_ = result_ && configuration_key_value_pair_1_1(builder_, level_ + 1);
    result_ = result_ && configuration_key_value_pair_1_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('.' key_name)*
  private static boolean configuration_key_value_pair_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!configuration_key_value_pair_1_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "configuration_key_value_pair_1_1", pos_)) break;
    }
    return true;
  }

  // '.' key_name
  private static boolean configuration_key_value_pair_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_DOT, OAP_KEY_NAME);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'=' config_key_value_eq
  //          | &'{' config_object
  //          | &(':' indent '-') config_key_value_array_block
  //          | &(':' indent) config_object
  //          | config_key_value_colon
  private static boolean configuration_key_value_pair_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_1_2_0(builder_, level_ + 1);
    if (!result_) result_ = configuration_key_value_pair_1_2_1(builder_, level_ + 1);
    if (!result_) result_ = configuration_key_value_pair_1_2_2(builder_, level_ + 1);
    if (!result_) result_ = configuration_key_value_pair_1_2_3(builder_, level_ + 1);
    if (!result_) result_ = config_key_value_colon(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'=' config_key_value_eq
  private static boolean configuration_key_value_pair_1_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_1_2_0_0(builder_, level_ + 1);
    result_ = result_ && config_key_value_eq(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'='
  private static boolean configuration_key_value_pair_1_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_EQ);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'{' config_object
  private static boolean configuration_key_value_pair_1_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_1_2_1_0(builder_, level_ + 1);
    result_ = result_ && config_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'{'
  private static boolean configuration_key_value_pair_1_2_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &(':' indent '-') config_key_value_array_block
  private static boolean configuration_key_value_pair_1_2_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_1_2_2_0(builder_, level_ + 1);
    result_ = result_ && config_key_value_array_block(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent '-')
  private static boolean configuration_key_value_pair_1_2_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = configuration_key_value_pair_1_2_2_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ':' indent '-'
  private static boolean configuration_key_value_pair_1_2_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_COLON, OAP_INDENT, OAP_DASH);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent) config_object
  private static boolean configuration_key_value_pair_1_2_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = configuration_key_value_pair_1_2_3_0(builder_, level_ + 1);
    result_ = result_ && config_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent)
  private static boolean configuration_key_value_pair_1_2_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = configuration_key_value_pair_1_2_3_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ':' indent
  private static boolean configuration_key_value_pair_1_2_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "configuration_key_value_pair_1_2_3_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_COLON, OAP_INDENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '.' module_services_service_implementation
  static boolean dot_implementation_service(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_implementation_service")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_implementation(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '.' module_services_service_link_field
  public static boolean dot_module_services_service_link_field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_module_services_service_link_field")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_DOT_MODULE_SERVICES_SERVICE_LINK_FIELD, null);
    result_ = consumeToken(builder_, OAP_DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_link_field(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '.' java_parameter_key_value
  static boolean dot_parameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_parameters")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_DOT);
    result_ = result_ && java_parameter_key_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '.' remote_name
  public static boolean dot_remote(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_remote")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_DOT_REMOTE, null);
    result_ = consumeToken(builder_, OAP_DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && remote_name(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '.' module_services_service_supervision_entities
  static boolean dot_supervision(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_supervision")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_supervision_entities(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '.' wsservice_path
  public static boolean dot_wsservice_path(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "dot_wsservice_path")) return false;
    if (!nextTokenIs(builder_, OAP_DOT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_DOT_WSSERVICE_PATH, null);
    result_ = consumeToken(builder_, OAP_DOT);
    pinned_ = result_; // pin = 1
    result_ = result_ && wsservice_path(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '$' '{' key_value '}'
  public static boolean env_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "env_value")) return false;
    if (!nextTokenIs(builder_, OAP_DOLLAR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_DOLLAR, OAP_LEFTBRACE, OAP_KEY_VALUE, OAP_RIGHTBRACE);
    exit_section_(builder_, marker_, OAP_ENV_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // &(id_value '(') id_value '(' id_value ')'
  public static boolean function(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function")) return false;
    if (!nextTokenIs(builder_, "<function>", OAP_DOLLAR, OAP_KEY_VALUE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_FUNCTION, "<function>");
    result_ = function_0(builder_, level_ + 1);
    result_ = result_ && id_value(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OAP_LEFTPAREN));
    result_ = pinned_ && report_error_(builder_, id_value(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTPAREN) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &(id_value '(')
  private static boolean function_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = function_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // id_value '('
  private static boolean function_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = id_value(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OAP_LEFTPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // env_value id_value? | key_value id_value?
  public static boolean id_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id_value")) return false;
    if (!nextTokenIs(builder_, "<id value>", OAP_DOLLAR, OAP_KEY_VALUE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_ID_VALUE, "<id value>");
    result_ = id_value_0(builder_, level_ + 1);
    if (!result_) result_ = id_value_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // env_value id_value?
  private static boolean id_value_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id_value_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = env_value(builder_, level_ + 1);
    result_ = result_ && id_value_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // id_value?
  private static boolean id_value_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id_value_0_1")) return false;
    id_value(builder_, level_ + 1);
    return true;
  }

  // key_value id_value?
  private static boolean id_value_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id_value_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_VALUE);
    result_ = result_ && id_value_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // id_value?
  private static boolean id_value_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "id_value_1_1")) return false;
    id_value(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // parameter_key_value
  public static boolean java_parameter_key_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameter_key_value")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, OAP_JAVA_PARAMETER_KEY_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // java_parameters_object_brace | java_parameters_object_colon
  static boolean java_parameters_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object")) return false;
    if (!nextTokenIs(builder_, "", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    result_ = java_parameters_object_brace(builder_, level_ + 1);
    if (!result_) result_ = java_parameters_object_colon(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '{' java_parameters_object_entries '}'
  static boolean java_parameters_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, java_parameters_object_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' indent java_parameters_object_entries dedent
  static boolean java_parameters_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, java_parameters_object_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // java_parameter_key_value? (','? java_parameter_key_value )*
  static boolean java_parameters_object_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_entries")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = java_parameters_object_entries_0(builder_, level_ + 1);
    result_ = result_ && java_parameters_object_entries_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // java_parameter_key_value?
  private static boolean java_parameters_object_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_entries_0")) return false;
    java_parameter_key_value(builder_, level_ + 1);
    return true;
  }

  // (','? java_parameter_key_value )*
  private static boolean java_parameters_object_entries_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_entries_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!java_parameters_object_entries_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "java_parameters_object_entries_1", pos_)) break;
    }
    return true;
  }

  // ','? java_parameter_key_value
  private static boolean java_parameters_object_entries_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_entries_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = java_parameters_object_entries_1_0_0(builder_, level_ + 1);
    result_ = result_ && java_parameter_key_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean java_parameters_object_entries_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "java_parameters_object_entries_1_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // []
  //         module_name_pair
  //         ( &'enabled' module_enabled )?
  //         ( &'dependsOn' module_depends_on )?
  //         ( &'include' module_include )*
  //         ( &'services' module_services )?
  //         ( &'configurations' module_configurations )?
  static boolean module_$(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_$")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = module_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_name_pair(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, module_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_5(builder_, level_ + 1)) && result_;
    result_ = pinned_ && module_6(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, OapParser::recover_module);
    return result_ || pinned_;
  }

  // []
  private static boolean module_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // ( &'enabled' module_enabled )?
  private static boolean module_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_2")) return false;
    module_2_0(builder_, level_ + 1);
    return true;
  }

  // &'enabled' module_enabled
  private static boolean module_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_2_0_0(builder_, level_ + 1);
    result_ = result_ && module_enabled(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'enabled'
  private static boolean module_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'dependsOn' module_depends_on )?
  private static boolean module_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3")) return false;
    module_3_0(builder_, level_ + 1);
    return true;
  }

  // &'dependsOn' module_depends_on
  private static boolean module_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_3_0_0(builder_, level_ + 1);
    result_ = result_ && module_depends_on(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'dependsOn'
  private static boolean module_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_DEPENDS_ON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'include' module_include )*
  private static boolean module_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_4_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_4", pos_)) break;
    }
    return true;
  }

  // &'include' module_include
  private static boolean module_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_4_0_0(builder_, level_ + 1);
    result_ = result_ && module_include(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'include'
  private static boolean module_4_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_4_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_INCLUDE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'services' module_services )?
  private static boolean module_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_5")) return false;
    module_5_0(builder_, level_ + 1);
    return true;
  }

  // &'services' module_services
  private static boolean module_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_5_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_5_0_0(builder_, level_ + 1);
    result_ = result_ && module_services(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'services'
  private static boolean module_5_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_5_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SERVICES);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'configurations' module_configurations )?
  private static boolean module_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_6")) return false;
    module_6_0(builder_, level_ + 1);
    return true;
  }

  // &'configurations' module_configurations
  private static boolean module_6_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_6_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_6_0_0(builder_, level_ + 1);
    result_ = result_ && module_configurations(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'configurations'
  private static boolean module_6_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_6_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_CONFIGURATIONS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' module_configuration_entries '}'
  public static boolean module_configuration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATION, null);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    result_ = result_ && module_configuration_entries(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && consumeToken(builder_, OAP_RIGHTBRACE);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '-' module_configuration_entries
  public static boolean module_configuration_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_block")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATION_BLOCK, null);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_configuration_entries(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // [] module_configuration_entries_loader module_configuration_entries_config
  public static boolean module_configuration_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_entries")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES, "<module configuration entries>");
    result_ = module_configuration_entries_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_configuration_entries_loader(builder_, level_ + 1));
    result_ = pinned_ && module_configuration_entries_config(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean module_configuration_entries_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] 'config' (config_entries_config_eq | config_object)
  public static boolean module_configuration_entries_config(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_entries_config")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_CONFIG, "<module configuration entries config>");
    result_ = module_configuration_entries_config_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OAP_ID_CONFIG));
    result_ = pinned_ && module_configuration_entries_config_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean module_configuration_entries_config_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // config_entries_config_eq | config_object
  private static boolean module_configuration_entries_config_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_entries_config_2")) return false;
    boolean result_;
    result_ = config_entries_config_eq(builder_, level_ + 1);
    if (!result_) result_ = config_object(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // 'loader' ('=' | ':') class_name_psi
  public static boolean module_configuration_entries_loader(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_entries_loader")) return false;
    if (!nextTokenIs(builder_, OAP_ID_LOADER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATION_ENTRIES_LOADER, null);
    result_ = consumeToken(builder_, OAP_ID_LOADER);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_configuration_entries_loader_1(builder_, level_ + 1));
    result_ = pinned_ && class_name_psi(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_configuration_entries_loader_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configuration_entries_loader_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'configurations' ( module_configurations_eq | module_configurations_colon )
  public static boolean module_configurations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations")) return false;
    if (!nextTokenIs(builder_, OAP_ID_CONFIGURATIONS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_CONFIGURATIONS, null);
    result_ = consumeToken(builder_, OAP_ID_CONFIGURATIONS);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_configurations_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_configurations_eq | module_configurations_colon
  private static boolean module_configurations_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations_1")) return false;
    boolean result_;
    result_ = module_configurations_eq(builder_, level_ + 1);
    if (!result_) result_ = module_configurations_colon(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // ':' module_configuration_block+
  static boolean module_configurations_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_configurations_colon_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_configuration_block+
  private static boolean module_configurations_colon_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations_colon_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_configuration_block(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!module_configuration_block(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_configurations_colon_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '=' '[' module_configuration* ']'
  static boolean module_configurations_eq(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations_eq")) return false;
    if (!nextTokenIs(builder_, OAP_EQ)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_EQ, OAP_LEFTBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_configurations_eq_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_configuration*
  private static boolean module_configurations_eq_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_configurations_eq_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_configuration(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_configurations_eq_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'dependsOn' ('=' | ':') (module_depends_on_block | '[' (module_depends_on_name (','? module_depends_on_name )* )? ']' | module_depends_on_name)
  public static boolean module_depends_on(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_DEPENDS_ON, "<module depends on>");
    result_ = consumeToken(builder_, OAP_ID_DEPENDS_ON);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_depends_on_1(builder_, level_ + 1));
    result_ = pinned_ && module_depends_on_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, OapParser::recover_module);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_depends_on_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  // module_depends_on_block | '[' (module_depends_on_name (','? module_depends_on_name )* )? ']' | module_depends_on_name
  private static boolean module_depends_on_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_depends_on_block(builder_, level_ + 1);
    if (!result_) result_ = module_depends_on_2_1(builder_, level_ + 1);
    if (!result_) result_ = module_depends_on_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '[' (module_depends_on_name (','? module_depends_on_name )* )? ']'
  private static boolean module_depends_on_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    result_ = result_ && module_depends_on_2_1_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OAP_RIGHTBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (module_depends_on_name (','? module_depends_on_name )* )?
  private static boolean module_depends_on_2_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1_1")) return false;
    module_depends_on_2_1_1_0(builder_, level_ + 1);
    return true;
  }

  // module_depends_on_name (','? module_depends_on_name )*
  private static boolean module_depends_on_2_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_depends_on_name(builder_, level_ + 1);
    result_ = result_ && module_depends_on_2_1_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (','? module_depends_on_name )*
  private static boolean module_depends_on_2_1_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1_1_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_depends_on_2_1_1_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_depends_on_2_1_1_0_1", pos_)) break;
    }
    return true;
  }

  // ','? module_depends_on_name
  private static boolean module_depends_on_2_1_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1_1_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_depends_on_2_1_1_0_1_0_0(builder_, level_ + 1);
    result_ = result_ && module_depends_on_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean module_depends_on_2_1_1_0_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_2_1_1_0_1_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // indent module_depends_on_block_item+ dedent
  static boolean module_depends_on_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_block")) return false;
    if (!nextTokenIs(builder_, OAP_INDENT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_depends_on_block_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_depends_on_block_item+
  private static boolean module_depends_on_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_depends_on_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!module_depends_on_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_depends_on_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' module_depends_on_name
  static boolean module_depends_on_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_depends_on_name(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // key_value
  public static boolean module_depends_on_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_depends_on_name")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_VALUE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, marker_, OAP_MODULE_DEPENDS_ON_NAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'enabled' ('=' | ':') bool
  public static boolean module_enabled(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_enabled")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_ENABLED, "<module enabled>");
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_enabled_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_BOOL) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, OapParser::recover_module);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_enabled_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_enabled_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'include' 'required' '(' string ')'
  public static boolean module_include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_include")) return false;
    if (!nextTokenIs(builder_, OAP_ID_INCLUDE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_INCLUDE, null);
    result_ = consumeTokens(builder_, 1, OAP_ID_INCLUDE, OAP_ID_REQUIRED, OAP_LEFTPAREN, OAP_STRING, OAP_RIGHTPAREN);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // [] key_value
  public static boolean module_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_name")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_NAME, "<module name>");
    result_ = module_name_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean module_name_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] id_name (eq | colon) module_name
  public static boolean module_name_pair(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_name_pair")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_NAME_PAIR, "<module name pair>");
    result_ = module_name_pair_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OAP_ID_NAME));
    result_ = pinned_ && report_error_(builder_, module_name_pair_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && module_name(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean module_name_pair_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // eq | colon
  private static boolean module_name_pair_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_name_pair_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'services' ( module_services_brace | module_services_colon )
  public static boolean module_services(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SERVICES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES, null);
    result_ = consumeToken(builder_, OAP_ID_SERVICES);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_brace | module_services_colon
  private static boolean module_services_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_1")) return false;
    boolean result_;
    result_ = module_services_brace(builder_, level_ + 1);
    if (!result_) result_ = module_services_colon(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '{' module_services_service* '}'
  static boolean module_services_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service*
  private static boolean module_services_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_brace_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_brace_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ':' indent module_services_service* dedent
  static boolean module_services_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service*
  private static boolean module_services_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_colon_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_colon_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // service_name ( &'.' dot_implementation_service | object_service )
  public static boolean module_services_service(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE, null);
    result_ = service_name(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_implementation_service | object_service
  private static boolean module_services_service_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_1_0(builder_, level_ + 1);
    if (!result_) result_ = object_service(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_implementation_service
  private static boolean module_services_service_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_implementation_service(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'abstract' ('=' | ':') bool_value
  public static boolean module_services_service_abstract(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_abstract")) return false;
    if (!nextTokenIs(builder_, OAP_ID_ABSTRACT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_ABSTRACT, null);
    result_ = consumeToken(builder_, OAP_ID_ABSTRACT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_abstract_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_abstract_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_abstract_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'default' ('=' | ':') reference_modules_value
  public static boolean module_services_service_default(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_default")) return false;
    if (!nextTokenIs(builder_, OAP_ID_DEFAULT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEFAULT, null);
    result_ = consumeToken(builder_, OAP_ID_DEFAULT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_default_1(builder_, level_ + 1));
    result_ = pinned_ && reference_modules_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_default_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_default_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // module_services_service_dependson_id ('=' | ':') (module_services_service_dependson_block | '[' module_services_service_dependson_name? ( ','? module_services_service_dependson_name )* ']' | module_services_service_dependson_name)*
  public static boolean module_services_service_dependson(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson")) return false;
    if (!nextTokenIs(builder_, OAP_ID_DEPENDS_ON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON, null);
    result_ = module_services_service_dependson_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_dependson_1(builder_, level_ + 1));
    result_ = pinned_ && module_services_service_dependson_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_dependson_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  // (module_services_service_dependson_block | '[' module_services_service_dependson_name? ( ','? module_services_service_dependson_name )* ']' | module_services_service_dependson_name)*
  private static boolean module_services_service_dependson_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_dependson_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_service_dependson_2", pos_)) break;
    }
    return true;
  }

  // module_services_service_dependson_block | '[' module_services_service_dependson_name? ( ','? module_services_service_dependson_name )* ']' | module_services_service_dependson_name
  private static boolean module_services_service_dependson_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_dependson_block(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_dependson_2_0_1(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_dependson_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '[' module_services_service_dependson_name? ( ','? module_services_service_dependson_name )* ']'
  private static boolean module_services_service_dependson_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    result_ = result_ && module_services_service_dependson_2_0_1_1(builder_, level_ + 1);
    result_ = result_ && module_services_service_dependson_2_0_1_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OAP_RIGHTBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // module_services_service_dependson_name?
  private static boolean module_services_service_dependson_2_0_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0_1_1")) return false;
    module_services_service_dependson_name(builder_, level_ + 1);
    return true;
  }

  // ( ','? module_services_service_dependson_name )*
  private static boolean module_services_service_dependson_2_0_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0_1_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_dependson_2_0_1_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_service_dependson_2_0_1_2", pos_)) break;
    }
    return true;
  }

  // ','? module_services_service_dependson_name
  private static boolean module_services_service_dependson_2_0_1_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0_1_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_dependson_2_0_1_2_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_dependson_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean module_services_service_dependson_2_0_1_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_2_0_1_2_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // indent module_services_service_dependson_block_item+ dedent
  static boolean module_services_service_dependson_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_block")) return false;
    if (!nextTokenIs(builder_, OAP_INDENT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_dependson_block_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service_dependson_block_item+
  private static boolean module_services_service_dependson_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_dependson_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_dependson_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_service_dependson_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' module_services_service_dependson_name
  static boolean module_services_service_dependson_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_dependson_name(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'dependsOn'
  public static boolean module_services_service_dependson_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_DEPENDS_ON)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_DEPENDS_ON);
    exit_section_(builder_, marker_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // key_value
  public static boolean module_services_service_dependson_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_dependson_name")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_VALUE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, marker_, OAP_MODULE_SERVICES_SERVICE_DEPENDSON_NAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'enabled' ('=' | ':') bool_value
  public static boolean module_services_service_enabled(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_enabled")) return false;
    if (!nextTokenIs(builder_, OAP_ID_ENABLED)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_ENABLED, null);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_enabled_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_enabled_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_enabled_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
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
  static boolean module_services_service_entities(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_1(builder_, level_ + 1);
    result_ = result_ && module_services_service_implementation(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_3(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_4(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_5(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_6(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_7(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_8(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_9(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_10(builder_, level_ + 1);
    result_ = result_ && module_services_service_entities_11(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ( &'enabled' module_services_service_enabled )?
  private static boolean module_services_service_entities_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_0")) return false;
    module_services_service_entities_0_0(builder_, level_ + 1);
    return true;
  }

  // &'enabled' module_services_service_enabled
  private static boolean module_services_service_entities_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_0_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_enabled(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'enabled'
  private static boolean module_services_service_entities_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'abstract' module_services_service_abstract )?
  private static boolean module_services_service_entities_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_1")) return false;
    module_services_service_entities_1_0(builder_, level_ + 1);
    return true;
  }

  // &'abstract' module_services_service_abstract
  private static boolean module_services_service_entities_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_1_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_abstract(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'abstract'
  private static boolean module_services_service_entities_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_ABSTRACT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'dependsOn' module_services_service_dependson )?
  private static boolean module_services_service_entities_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_3")) return false;
    module_services_service_entities_3_0(builder_, level_ + 1);
    return true;
  }

  // &'dependsOn' module_services_service_dependson
  private static boolean module_services_service_entities_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_3_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_dependson(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'dependsOn'
  private static boolean module_services_service_entities_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_3_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_DEPENDS_ON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'default' module_services_service_default )?
  private static boolean module_services_service_entities_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_4")) return false;
    module_services_service_entities_4_0(builder_, level_ + 1);
    return true;
  }

  // &'default' module_services_service_default
  private static boolean module_services_service_entities_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_4_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_default(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'default'
  private static boolean module_services_service_entities_4_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_4_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_DEFAULT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'listen' module_services_service_listen )?
  private static boolean module_services_service_entities_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_5")) return false;
    module_services_service_entities_5_0(builder_, level_ + 1);
    return true;
  }

  // &'listen' module_services_service_listen
  private static boolean module_services_service_entities_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_5_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_5_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_listen(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'listen'
  private static boolean module_services_service_entities_5_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_5_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_LISTEN);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'parameters' module_services_service_parameters )?
  private static boolean module_services_service_entities_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_6")) return false;
    module_services_service_entities_6_0(builder_, level_ + 1);
    return true;
  }

  // &'parameters' module_services_service_parameters
  private static boolean module_services_service_entities_6_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_6_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_6_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_parameters(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'parameters'
  private static boolean module_services_service_entities_6_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_6_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_PARAMETERS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'link' module_services_service_link )?
  private static boolean module_services_service_entities_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_7")) return false;
    module_services_service_entities_7_0(builder_, level_ + 1);
    return true;
  }

  // &'link' module_services_service_link
  private static boolean module_services_service_entities_7_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_7_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_7_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_link(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'link'
  private static boolean module_services_service_entities_7_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_7_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_LINK);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'remote' module_services_service_remote)?
  private static boolean module_services_service_entities_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_8")) return false;
    module_services_service_entities_8_0(builder_, level_ + 1);
    return true;
  }

  // &'remote' module_services_service_remote
  private static boolean module_services_service_entities_8_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_8_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_8_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_remote(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'remote'
  private static boolean module_services_service_entities_8_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_8_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_REMOTE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'ws-service' module_services_service_wsservice)?
  private static boolean module_services_service_entities_9(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_9")) return false;
    module_services_service_entities_9_0(builder_, level_ + 1);
    return true;
  }

  // &'ws-service' module_services_service_wsservice
  private static boolean module_services_service_entities_9_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_9_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_9_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_wsservice(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'ws-service'
  private static boolean module_services_service_entities_9_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_9_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_WS_SERVICE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'ws-handler' module_services_service_wshandler)?
  private static boolean module_services_service_entities_10(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_10")) return false;
    module_services_service_entities_10_0(builder_, level_ + 1);
    return true;
  }

  // &'ws-handler' module_services_service_wshandler
  private static boolean module_services_service_entities_10_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_10_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_10_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_wshandler(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'ws-handler'
  private static boolean module_services_service_entities_10_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_10_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_WS_HANDLER);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ( &'supervision' module_services_service_supervision )?
  private static boolean module_services_service_entities_11(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_11")) return false;
    module_services_service_entities_11_0(builder_, level_ + 1);
    return true;
  }

  // &'supervision' module_services_service_supervision
  private static boolean module_services_service_entities_11_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_11_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_entities_11_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'supervision'
  private static boolean module_services_service_entities_11_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_entities_11_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SUPERVISION);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'implementation' ('=' | ':') class_name_psi
  public static boolean module_services_service_implementation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_implementation")) return false;
    if (!nextTokenIs(builder_, OAP_ID_IMPLEMENTATION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_IMPLEMENTATION, null);
    result_ = consumeToken(builder_, OAP_ID_IMPLEMENTATION);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_implementation_1(builder_, level_ + 1));
    result_ = pinned_ && class_name_psi(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_implementation_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_implementation_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'link' ( &'.' dot_module_services_service_link_field | module_services_service_link_field_object )
  public static boolean module_services_service_link(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link")) return false;
    if (!nextTokenIs(builder_, OAP_ID_LINK)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK, null);
    result_ = consumeToken(builder_, OAP_ID_LINK);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_link_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_link_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_link_1_0(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_link_field_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_module_services_service_link_field
  private static boolean module_services_service_link_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_link_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_module_services_service_link_field(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_link_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // key_name ('=' | ':') reference_modules_value
  public static boolean module_services_service_link_field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD, null);
    result_ = consumeToken(builder_, OAP_KEY_NAME);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_link_field_1(builder_, level_ + 1));
    result_ = pinned_ && reference_modules_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_link_field_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // module_services_service_link_field_object_brace | module_services_service_link_field_object_colon
  public static boolean module_services_service_link_field_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_object")) return false;
    if (!nextTokenIs(builder_, "<module services service link field object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_LINK_FIELD_OBJECT, "<module services service link field object>");
    result_ = module_services_service_link_field_object_brace(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_link_field_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' module_services_service_link_field* '}'
  static boolean module_services_service_link_field_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_link_field_object_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service_link_field*
  private static boolean module_services_service_link_field_object_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_object_brace_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_link_field(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_service_link_field_object_brace_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ':' indent module_services_service_link_field* dedent
  static boolean module_services_service_link_field_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_link_field_object_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service_link_field*
  private static boolean module_services_service_link_field_object_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_link_field_object_colon_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_link_field(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_services_service_link_field_object_colon_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'listen' ( &'.' dot_module_services_service_link_field | module_services_service_link_field_object)
  public static boolean module_services_service_listen(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_listen")) return false;
    if (!nextTokenIs(builder_, OAP_ID_LISTEN)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_LISTEN, null);
    result_ = consumeToken(builder_, OAP_ID_LISTEN);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_listen_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_module_services_service_link_field | module_services_service_link_field_object
  private static boolean module_services_service_listen_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_listen_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_listen_1_0(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_link_field_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_module_services_service_link_field
  private static boolean module_services_service_listen_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_listen_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_listen_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_module_services_service_link_field(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_listen_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_listen_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // module_services_service_parameters_id ( &'.' dot_parameters | java_parameters_object )
  public static boolean module_services_service_parameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_parameters")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PARAMETERS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_PARAMETERS, null);
    result_ = module_services_service_parameters_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_parameters_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_parameters | java_parameters_object
  private static boolean module_services_service_parameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_parameters_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_parameters_1_0(builder_, level_ + 1);
    if (!result_) result_ = java_parameters_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_parameters
  private static boolean module_services_service_parameters_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_parameters_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_parameters_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_parameters(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_parameters_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_parameters_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'parameters'
  public static boolean module_services_service_parameters_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_parameters_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PARAMETERS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_PARAMETERS);
    exit_section_(builder_, marker_, OAP_MODULE_SERVICES_SERVICE_PARAMETERS_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'remote' (&'.' dot_remote | remote_object )
  public static boolean module_services_service_remote(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_remote")) return false;
    if (!nextTokenIs(builder_, OAP_ID_REMOTE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_REMOTE, null);
    result_ = consumeToken(builder_, OAP_ID_REMOTE);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_remote_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_remote | remote_object
  private static boolean module_services_service_remote_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_remote_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_remote_1_0(builder_, level_ + 1);
    if (!result_) result_ = remote_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_remote
  private static boolean module_services_service_remote_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_remote_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_remote_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_remote(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_remote_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_remote_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'supervision' ( &'.' dot_supervision | supervision_object )
  public static boolean module_services_service_supervision(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SUPERVISION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION, null);
    result_ = consumeToken(builder_, OAP_ID_SUPERVISION);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_supervision_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_supervision | supervision_object
  private static boolean module_services_service_supervision_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_1_0(builder_, level_ + 1);
    if (!result_) result_ = supervision_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_supervision
  private static boolean module_services_service_supervision_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_supervision(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_supervision_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // &'supervise' module_services_service_supervision_entities_supervise
  //     | &'schedule' module_services_service_supervision_entities_schedule
  //     | &'thread' module_services_service_supervision_entities_thread
  //     | &'delay' module_services_service_supervision_entities_delay
  //     | &'cron' module_services_service_supervision_entities_cron
  static boolean module_services_service_supervision_entities(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_0(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_supervision_entities_1(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_supervision_entities_2(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_supervision_entities_3(builder_, level_ + 1);
    if (!result_) result_ = module_services_service_supervision_entities_4(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'supervise' module_services_service_supervision_entities_supervise
  private static boolean module_services_service_supervision_entities_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_0_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision_entities_supervise(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'supervise'
  private static boolean module_services_service_supervision_entities_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SUPERVISE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'schedule' module_services_service_supervision_entities_schedule
  private static boolean module_services_service_supervision_entities_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_1_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision_entities_schedule(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'schedule'
  private static boolean module_services_service_supervision_entities_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SCHEDULE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'thread' module_services_service_supervision_entities_thread
  private static boolean module_services_service_supervision_entities_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_2_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision_entities_thread(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'thread'
  private static boolean module_services_service_supervision_entities_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_THREAD);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'delay' module_services_service_supervision_entities_delay
  private static boolean module_services_service_supervision_entities_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_3_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision_entities_delay(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'delay'
  private static boolean module_services_service_supervision_entities_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_DELAY);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'cron' module_services_service_supervision_entities_cron
  private static boolean module_services_service_supervision_entities_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_supervision_entities_4_0(builder_, level_ + 1);
    result_ = result_ && module_services_service_supervision_entities_cron(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'cron'
  private static boolean module_services_service_supervision_entities_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_CRON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'cron' ('=' | ':') key_value
  public static boolean module_services_service_supervision_entities_cron(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_cron")) return false;
    if (!nextTokenIs(builder_, OAP_ID_CRON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_CRON, null);
    result_ = consumeToken(builder_, OAP_ID_CRON);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_supervision_entities_cron_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_KEY_VALUE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_supervision_entities_cron_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_cron_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'delay' ('=' | ':') key_value
  public static boolean module_services_service_supervision_entities_delay(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_delay")) return false;
    if (!nextTokenIs(builder_, OAP_ID_DELAY)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_DELAY, null);
    result_ = consumeToken(builder_, OAP_ID_DELAY);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_supervision_entities_delay_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_KEY_VALUE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_supervision_entities_delay_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_delay_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'schedule' ('=' | ':') bool_value
  public static boolean module_services_service_supervision_entities_schedule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_schedule")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SCHEDULE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SCHEDULE, null);
    result_ = consumeToken(builder_, OAP_ID_SCHEDULE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_supervision_entities_schedule_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_supervision_entities_schedule_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_schedule_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'supervise' (eq | colon) bool_value
  public static boolean module_services_service_supervision_entities_supervise(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_supervise")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SUPERVISE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_SUPERVISE, null);
    result_ = consumeToken(builder_, OAP_ID_SUPERVISE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_supervision_entities_supervise_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // eq | colon
  private static boolean module_services_service_supervision_entities_supervise_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_supervise_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'thread' ('=' | ':') bool_value
  public static boolean module_services_service_supervision_entities_thread(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_thread")) return false;
    if (!nextTokenIs(builder_, OAP_ID_THREAD)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_SUPERVISION_ENTITIES_THREAD, null);
    result_ = consumeToken(builder_, OAP_ID_THREAD);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_supervision_entities_thread_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean module_services_service_supervision_entities_thread_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_supervision_entities_thread_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'ws-handler' ( &'.' dot_wsservice_path | wshandler_object )
  public static boolean module_services_service_wshandler(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wshandler")) return false;
    if (!nextTokenIs(builder_, OAP_ID_WS_HANDLER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSHANDLER, null);
    result_ = consumeToken(builder_, OAP_ID_WS_HANDLER);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_wshandler_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_wsservice_path | wshandler_object
  private static boolean module_services_service_wshandler_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wshandler_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_wshandler_1_0(builder_, level_ + 1);
    if (!result_) result_ = wshandler_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_wsservice_path
  private static boolean module_services_service_wshandler_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wshandler_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_wshandler_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_wsservice_path(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_wshandler_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wshandler_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'ws-service' ( &'.' dot_wsservice_path | wsservice_object )
  public static boolean module_services_service_wsservice(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wsservice")) return false;
    if (!nextTokenIs(builder_, OAP_ID_WS_SERVICE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_MODULE_SERVICES_SERVICE_WSSERVICE, null);
    result_ = consumeToken(builder_, OAP_ID_WS_SERVICE);
    pinned_ = result_; // pin = 1
    result_ = result_ && module_services_service_wsservice_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // &'.' dot_wsservice_path | wsservice_object
  private static boolean module_services_service_wsservice_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wsservice_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_wsservice_1_0(builder_, level_ + 1);
    if (!result_) result_ = wsservice_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.' dot_wsservice_path
  private static boolean module_services_service_wsservice_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wsservice_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = module_services_service_wsservice_1_0_0(builder_, level_ + 1);
    result_ = result_ && dot_wsservice_path(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'.'
  private static boolean module_services_service_wsservice_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_services_service_wsservice_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_DOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // object_service_brace | object_service_colon
  static boolean object_service(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object_service")) return false;
    if (!nextTokenIs(builder_, "", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    result_ = object_service_brace(builder_, level_ + 1);
    if (!result_) result_ = object_service_colon(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '{' module_services_service_entities '}'
  static boolean object_service_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object_service_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_entities(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' indent module_services_service_entities dedent
  static boolean object_service_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "object_service_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_services_service_entities(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // parameter_key_value_first_id ('.' key_name)*
  //     (&'=' parameter_key_value_key_eq
  //      | &'{' parameter_key_value_key_object
  //      | &(':' indent '-') parameter_key_value_array_block
  //      | &(':' indent) parameter_key_value_key_object
  //      | parameter_key_value_key_colon)
  public static boolean parameter_key_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_PARAMETER_KEY_VALUE, null);
    result_ = parameter_key_value_first_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, parameter_key_value_1(builder_, level_ + 1));
    result_ = pinned_ && parameter_key_value_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ('.' key_name)*
  private static boolean parameter_key_value_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!parameter_key_value_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "parameter_key_value_1", pos_)) break;
    }
    return true;
  }

  // '.' key_name
  private static boolean parameter_key_value_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_DOT, OAP_KEY_NAME);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'=' parameter_key_value_key_eq
  //      | &'{' parameter_key_value_key_object
  //      | &(':' indent '-') parameter_key_value_array_block
  //      | &(':' indent) parameter_key_value_key_object
  //      | parameter_key_value_key_colon
  private static boolean parameter_key_value_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_2_0(builder_, level_ + 1);
    if (!result_) result_ = parameter_key_value_2_1(builder_, level_ + 1);
    if (!result_) result_ = parameter_key_value_2_2(builder_, level_ + 1);
    if (!result_) result_ = parameter_key_value_2_3(builder_, level_ + 1);
    if (!result_) result_ = parameter_key_value_key_colon(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'=' parameter_key_value_key_eq
  private static boolean parameter_key_value_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_2_0_0(builder_, level_ + 1);
    result_ = result_ && parameter_key_value_key_eq(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'='
  private static boolean parameter_key_value_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_EQ);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'{' parameter_key_value_key_object
  private static boolean parameter_key_value_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_2_1_0(builder_, level_ + 1);
    result_ = result_ && parameter_key_value_key_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'{'
  private static boolean parameter_key_value_2_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &(':' indent '-') parameter_key_value_array_block
  private static boolean parameter_key_value_2_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_2_2_0(builder_, level_ + 1);
    result_ = result_ && parameter_key_value_array_block(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent '-')
  private static boolean parameter_key_value_2_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = parameter_key_value_2_2_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ':' indent '-'
  private static boolean parameter_key_value_2_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_COLON, OAP_INDENT, OAP_DASH);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent) parameter_key_value_key_object
  private static boolean parameter_key_value_2_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_2_3_0(builder_, level_ + 1);
    result_ = result_ && parameter_key_value_key_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &(':' indent)
  private static boolean parameter_key_value_2_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = parameter_key_value_2_3_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ':' indent
  private static boolean parameter_key_value_2_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_2_3_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_COLON, OAP_INDENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ':' indent parameter_key_value_array_block_item+ dedent
  static boolean parameter_key_value_array_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_array_block")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, parameter_key_value_array_block_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // parameter_key_value_array_block_item+
  private static boolean parameter_key_value_array_block_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_array_block_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_array_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!parameter_key_value_array_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "parameter_key_value_array_block_2", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' parameters_array_item
  static boolean parameter_key_value_array_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_array_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && parameters_array_item(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // key_name
  public static boolean parameter_key_value_first_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_first_id")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_NAME);
    exit_section_(builder_, marker_, OAP_PARAMETER_KEY_VALUE_FIRST_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // ':' parameter_key_value_value
  static boolean parameter_key_value_key_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_key_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && parameter_key_value_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '=' parameter_key_value_value
  static boolean parameter_key_value_key_eq(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_key_eq")) return false;
    if (!nextTokenIs(builder_, OAP_EQ)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_EQ);
    pinned_ = result_; // pin = 1
    result_ = result_ && parameter_key_value_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // parameters_object
  static boolean parameter_key_value_key_object(PsiBuilder builder_, int level_) {
    return parameters_object(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // &'[' parameters_array | &'<' any_reference | function | bool_value | id_value
  static boolean parameter_key_value_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_value")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_value_0(builder_, level_ + 1);
    if (!result_) result_ = parameter_key_value_value_1(builder_, level_ + 1);
    if (!result_) result_ = function(builder_, level_ + 1);
    if (!result_) result_ = bool_value(builder_, level_ + 1);
    if (!result_) result_ = id_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'[' parameters_array
  private static boolean parameter_key_value_value_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_value_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_value_0_0(builder_, level_ + 1);
    result_ = result_ && parameters_array(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'['
  private static boolean parameter_key_value_value_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_value_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'<' any_reference
  private static boolean parameter_key_value_value_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_value_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameter_key_value_value_1_0(builder_, level_ + 1);
    result_ = result_ && any_reference(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'<'
  private static boolean parameter_key_value_value_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_key_value_value_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '[' parameters_array_item? (','? parameters_array_item)* ']'
  public static boolean parameters_array(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_PARAMETERS_ARRAY, null);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, parameters_array_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, parameters_array_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // parameters_array_item?
  private static boolean parameters_array_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_1")) return false;
    parameters_array_item(builder_, level_ + 1);
    return true;
  }

  // (','? parameters_array_item)*
  private static boolean parameters_array_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!parameters_array_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "parameters_array_2", pos_)) break;
    }
    return true;
  }

  // ','? parameters_array_item
  private static boolean parameters_array_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameters_array_2_0_0(builder_, level_ + 1);
    result_ = result_ && parameters_array_item(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean parameters_array_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_2_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // &'<' any_reference | &'{' parameters_object | function | bool_value | id_value
  public static boolean parameters_array_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_item")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_PARAMETERS_ARRAY_ITEM, "<parameters array item>");
    result_ = parameters_array_item_0(builder_, level_ + 1);
    if (!result_) result_ = parameters_array_item_1(builder_, level_ + 1);
    if (!result_) result_ = function(builder_, level_ + 1);
    if (!result_) result_ = bool_value(builder_, level_ + 1);
    if (!result_) result_ = id_value(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'<' any_reference
  private static boolean parameters_array_item_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_item_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameters_array_item_0_0(builder_, level_ + 1);
    result_ = result_ && any_reference(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'<'
  private static boolean parameters_array_item_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_item_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'{' parameters_object
  private static boolean parameters_array_item_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_item_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameters_array_item_1_0(builder_, level_ + 1);
    result_ = result_ && parameters_object(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'{'
  private static boolean parameters_array_item_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_array_item_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // parameters_object_brace | parameters_object_colon
  public static boolean parameters_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object")) return false;
    if (!nextTokenIs(builder_, "<parameters object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_PARAMETERS_OBJECT, "<parameters object>");
    result_ = parameters_object_brace(builder_, level_ + 1);
    if (!result_) result_ = parameters_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' parameters_object_entries '}'
  static boolean parameters_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, parameters_object_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' indent parameters_object_entries dedent
  static boolean parameters_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, parameters_object_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // parameter_key_value? (','? parameter_key_value )*
  static boolean parameters_object_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_entries")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameters_object_entries_0(builder_, level_ + 1);
    result_ = result_ && parameters_object_entries_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // parameter_key_value?
  private static boolean parameters_object_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_entries_0")) return false;
    parameter_key_value(builder_, level_ + 1);
    return true;
  }

  // (','? parameter_key_value )*
  private static boolean parameters_object_entries_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_entries_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!parameters_object_entries_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "parameters_object_entries_1", pos_)) break;
    }
    return true;
  }

  // ','? parameter_key_value
  private static boolean parameters_object_entries_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_entries_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = parameters_object_entries_1_0_0(builder_, level_ + 1);
    result_ = result_ && parameter_key_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean parameters_object_entries_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameters_object_entries_1_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // !( 'enabled' | 'name' | 'dependsOn' | 'include' | 'services' | 'configurations' | dedent )
  static boolean recover_module(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_module")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !recover_module_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // 'enabled' | 'name' | 'dependsOn' | 'include' | 'services' | 'configurations' | dedent
  private static boolean recover_module_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_module_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_NAME);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_DEPENDS_ON);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_INCLUDE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_SERVICES);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_CONFIGURATIONS);
    if (!result_) result_ = consumeToken(builder_, OAP_DEDENT);
    return result_;
  }

  /* ********************************************************** */
  // !('}' | ']' | ',' | '<' | 'link' | 'remote' | 'ws-service' | 'supervision' | key_name | dedent )
  static boolean recover_reference(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_reference")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !recover_reference_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // '}' | ']' | ',' | '<' | 'link' | 'remote' | 'ws-service' | 'supervision' | key_name | dedent
  private static boolean recover_reference_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_reference_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_RIGHTBRACE);
    if (!result_) result_ = consumeToken(builder_, OAP_RIGHTBRACKET);
    if (!result_) result_ = consumeToken(builder_, OAP_COMMA);
    if (!result_) result_ = consumeToken(builder_, OAP_LEFTANGLE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_LINK);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_REMOTE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_WS_SERVICE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_SUPERVISION);
    if (!result_) result_ = consumeToken(builder_, OAP_KEY_NAME);
    if (!result_) result_ = consumeToken(builder_, OAP_DEDENT);
    return result_;
  }

  /* ********************************************************** */
  // !('name' | 'url' | '}' | 'timeout' | '>' | dedent )
  static boolean recover_remote(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_remote")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !recover_remote_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // 'name' | 'url' | '}' | 'timeout' | '>' | dedent
  private static boolean recover_remote_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_remote_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_ID_NAME);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_URL);
    if (!result_) result_ = consumeToken(builder_, OAP_RIGHTBRACE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_TIMEOUT);
    if (!result_) result_ = consumeToken(builder_, OAP_RIGHTANGLE);
    if (!result_) result_ = consumeToken(builder_, OAP_DEDENT);
    return result_;
  }

  /* ********************************************************** */
  // '<' reference_kernel_value_in '>'
  public static boolean reference_kernel_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_kernel_value")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTANGLE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_KERNEL_VALUE, null);
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, reference_kernel_value_in(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTANGLE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // reference_type_kernel '.' 'self'
  public static boolean reference_kernel_value_in(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_kernel_value_in")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_KERNEL_VALUE_IN, "<reference kernel value in>");
    result_ = reference_type_kernel(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeTokens(builder_, -1, OAP_DOT, OAP_ID_SELF));
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // [] (reference_value | 'this')
  public static boolean reference_modules_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_modules_name")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_MODULES_NAME, "<reference modules name>");
    result_ = reference_modules_name_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && reference_modules_name_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_modules_name_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // reference_value | 'this'
  private static boolean reference_modules_name_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_modules_name_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_REFERENCE_VALUE);
    if (!result_) result_ = consumeToken(builder_, OAP_ID_THIS);
    return result_;
  }

  /* ********************************************************** */
  // [] reference_value
  public static boolean reference_modules_service_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_modules_service_name")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_MODULES_SERVICE_NAME, "<reference modules service name>");
    result_ = reference_modules_service_name_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_REFERENCE_VALUE);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_modules_service_name_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // '<' reference_modules_value_in '>'
  public static boolean reference_modules_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_modules_value")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTANGLE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_MODULES_VALUE, null);
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, reference_modules_value_in(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTANGLE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // reference_type_modules '.' reference_modules_name '.' reference_modules_service_name
  public static boolean reference_modules_value_in(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_modules_value_in")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_MODULES_VALUE_IN, "<reference modules value in>");
    result_ = reference_type_modules(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OAP_DOT));
    result_ = pinned_ && report_error_(builder_, reference_modules_name(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OAP_DOT)) && result_;
    result_ = pinned_ && reference_modules_service_name(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // reference_type_services '.' reference_type_services_self '.' reference_type_services_property
  public static boolean reference_services_in(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_services_in")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_SERVICES_IN, "<reference services in>");
    result_ = reference_type_services(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OAP_DOT));
    result_ = pinned_ && report_error_(builder_, reference_type_services_self(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OAP_DOT)) && result_;
    result_ = pinned_ && reference_type_services_property(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '<' reference_services_in '>'
  public static boolean reference_services_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_services_value")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTANGLE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_SERVICES_VALUE, null);
    result_ = consumeToken(builder_, OAP_LEFTANGLE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, reference_services_in(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTANGLE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // [] 'kernel'
  public static boolean reference_type_kernel(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_type_kernel")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_TYPE_KERNEL, "<reference type kernel>");
    result_ = reference_type_kernel_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_ID_KERNEL);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_type_kernel_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] 'modules'
  public static boolean reference_type_modules(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_type_modules")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_TYPE_MODULES, "<reference type modules>");
    result_ = reference_type_modules_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_ID_MODULES);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_type_modules_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] 'services'
  public static boolean reference_type_services(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_type_services")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_TYPE_SERVICES, "<reference type services>");
    result_ = reference_type_services_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_ID_SERVICES);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_type_services_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] reference_value
  public static boolean reference_type_services_property(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_type_services_property")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_TYPE_SERVICES_PROPERTY, "<reference type services property>");
    result_ = reference_type_services_property_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_REFERENCE_VALUE);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_type_services_property_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // [] 'self'
  public static boolean reference_type_services_self(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reference_type_services_self")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REFERENCE_TYPE_SERVICES_SELF, "<reference type services self>");
    result_ = reference_type_services_self_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, OAP_ID_SELF);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // []
  private static boolean reference_type_services_self_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // (&'name' remote_name | &'timeout' remote_timeout | &'url' remote_url )*
  public static boolean remote_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REMOTE_ENTRIES, "<remote entries>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!remote_entries_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "remote_entries", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // &'name' remote_name | &'timeout' remote_timeout | &'url' remote_url
  private static boolean remote_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = remote_entries_0_0(builder_, level_ + 1);
    if (!result_) result_ = remote_entries_0_1(builder_, level_ + 1);
    if (!result_) result_ = remote_entries_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'name' remote_name
  private static boolean remote_entries_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = remote_entries_0_0_0(builder_, level_ + 1);
    result_ = result_ && remote_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'name'
  private static boolean remote_entries_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_NAME);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'timeout' remote_timeout
  private static boolean remote_entries_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = remote_entries_0_1_0(builder_, level_ + 1);
    result_ = result_ && remote_timeout(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'timeout'
  private static boolean remote_entries_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_TIMEOUT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'url' remote_url
  private static boolean remote_entries_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = remote_entries_0_2_0(builder_, level_ + 1);
    result_ = result_ && remote_url(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'url'
  private static boolean remote_entries_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_entries_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_URL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'name' ('=' | ':') reference_modules_value
  public static boolean remote_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_name")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REMOTE_NAME, "<remote name>");
    result_ = consumeToken(builder_, OAP_ID_NAME);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, remote_name_1(builder_, level_ + 1));
    result_ = pinned_ && reference_modules_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, OapParser::recover_remote);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean remote_name_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_name_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // remote_object_brace | remote_object_colon
  public static boolean remote_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_object")) return false;
    if (!nextTokenIs(builder_, "<remote object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REMOTE_OBJECT, "<remote object>");
    result_ = remote_object_brace(builder_, level_ + 1);
    if (!result_) result_ = remote_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' remote_entries '}'
  static boolean remote_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, remote_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // ':' indent remote_entries dedent
  static boolean remote_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, remote_entries(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // remote_timeout_id_value (eq | colon) key_value
  public static boolean remote_timeout(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_timeout")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REMOTE_TIMEOUT, "<remote timeout>");
    result_ = remote_timeout_id_value(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, remote_timeout_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_KEY_VALUE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // eq | colon
  private static boolean remote_timeout_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_timeout_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'timeout'
  public static boolean remote_timeout_id_value(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_timeout_id_value")) return false;
    if (!nextTokenIs(builder_, OAP_ID_TIMEOUT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_TIMEOUT);
    exit_section_(builder_, marker_, OAP_REMOTE_TIMEOUT_ID_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'url' ('=' | ':') key_value
  public static boolean remote_url(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_url")) return false;
    if (!nextTokenIs(builder_, OAP_ID_URL)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_REMOTE_URL, null);
    result_ = consumeToken(builder_, OAP_ID_URL);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, remote_url_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_KEY_VALUE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean remote_url_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "remote_url_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // key_name
  public static boolean service_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "service_name")) return false;
    if (!nextTokenIs(builder_, OAP_KEY_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_KEY_NAME);
    exit_section_(builder_, marker_, OAP_SERVICE_NAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // supervision_object_brace | supervision_object_colon
  static boolean supervision_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supervision_object")) return false;
    if (!nextTokenIs(builder_, "", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    result_ = supervision_object_brace(builder_, level_ + 1);
    if (!result_) result_ = supervision_object_colon(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // '{' module_services_service_supervision_entities* '}'
  static boolean supervision_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supervision_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, supervision_object_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service_supervision_entities*
  private static boolean supervision_object_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supervision_object_brace_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_supervision_entities(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "supervision_object_brace_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ':' indent module_services_service_supervision_entities* dedent
  static boolean supervision_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supervision_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, supervision_object_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // module_services_service_supervision_entities*
  private static boolean supervision_object_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "supervision_object_colon_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!module_services_service_supervision_entities(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "supervision_object_colon_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'blocking' ('=' | ':') bool_value
  public static boolean wshandler_blocking(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_blocking")) return false;
    if (!nextTokenIs(builder_, OAP_ID_BLOCKING)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSHANDLER_BLOCKING, null);
    result_ = consumeToken(builder_, OAP_ID_BLOCKING);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wshandler_blocking_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wshandler_blocking_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_blocking_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'compression' ('=' | ':') bool_value
  public static boolean wshandler_compression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_compression")) return false;
    if (!nextTokenIs(builder_, OAP_ID_COMPRESSION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSHANDLER_COMPRESSION, null);
    result_ = consumeToken(builder_, OAP_ID_COMPRESSION);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wshandler_compression_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wshandler_compression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_compression_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // (&'path' wsservice_path | &'port' wsservice_port| &'compression' wshandler_compression | &'blocking' wshandler_blocking | &'enabled' wsservice_enabled)*
  public static boolean wshandler_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSHANDLER_ENTRIES, "<wshandler entries>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!wshandler_entries_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wshandler_entries", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // &'path' wsservice_path | &'port' wsservice_port| &'compression' wshandler_compression | &'blocking' wshandler_blocking | &'enabled' wsservice_enabled
  private static boolean wshandler_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_0(builder_, level_ + 1);
    if (!result_) result_ = wshandler_entries_0_1(builder_, level_ + 1);
    if (!result_) result_ = wshandler_entries_0_2(builder_, level_ + 1);
    if (!result_) result_ = wshandler_entries_0_3(builder_, level_ + 1);
    if (!result_) result_ = wshandler_entries_0_4(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'path' wsservice_path
  private static boolean wshandler_entries_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_0_0(builder_, level_ + 1);
    result_ = result_ && wsservice_path(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'path'
  private static boolean wshandler_entries_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_PATH);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'port' wsservice_port
  private static boolean wshandler_entries_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_1_0(builder_, level_ + 1);
    result_ = result_ && wsservice_port(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'port'
  private static boolean wshandler_entries_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_PORT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'compression' wshandler_compression
  private static boolean wshandler_entries_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_2_0(builder_, level_ + 1);
    result_ = result_ && wshandler_compression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'compression'
  private static boolean wshandler_entries_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_COMPRESSION);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'blocking' wshandler_blocking
  private static boolean wshandler_entries_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_3_0(builder_, level_ + 1);
    result_ = result_ && wshandler_blocking(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'blocking'
  private static boolean wshandler_entries_0_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_BLOCKING);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'enabled' wsservice_enabled
  private static boolean wshandler_entries_0_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wshandler_entries_0_4_0(builder_, level_ + 1);
    result_ = result_ && wsservice_enabled(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'enabled'
  private static boolean wshandler_entries_0_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_entries_0_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // wshandler_object_brace | wshandler_object_colon
  public static boolean wshandler_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_object")) return false;
    if (!nextTokenIs(builder_, "<wshandler object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSHANDLER_OBJECT, "<wshandler object>");
    result_ = wshandler_object_brace(builder_, level_ + 1);
    if (!result_) result_ = wshandler_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' wshandler_entries? '}'
  static boolean wshandler_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wshandler_object_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wshandler_entries?
  private static boolean wshandler_object_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_object_brace_1")) return false;
    wshandler_entries(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // ':' indent wshandler_entries? dedent
  static boolean wshandler_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wshandler_object_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wshandler_entries?
  private static boolean wshandler_object_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wshandler_object_colon_2")) return false;
    wshandler_entries(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // wsservice_enabled_id ('=' | ':') bool_value
  public static boolean wsservice_enabled(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_enabled")) return false;
    if (!nextTokenIs(builder_, OAP_ID_ENABLED)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_ENABLED, null);
    result_ = wsservice_enabled_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_enabled_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wsservice_enabled_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_enabled_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'enabled'
  public static boolean wsservice_enabled_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_enabled_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_ENABLED)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    exit_section_(builder_, marker_, OAP_WSSERVICE_ENABLED_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // (&'path' wsservice_path | &'port' wsservice_port| &'sessionAware' wsservice_sessionAware| &'interceptors' wsservice_interceptors | &'enabled' wsservice_enabled)*
  public static boolean wsservice_entries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_ENTRIES, "<wsservice entries>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!wsservice_entries_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wsservice_entries", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // &'path' wsservice_path | &'port' wsservice_port| &'sessionAware' wsservice_sessionAware| &'interceptors' wsservice_interceptors | &'enabled' wsservice_enabled
  private static boolean wsservice_entries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_0(builder_, level_ + 1);
    if (!result_) result_ = wsservice_entries_0_1(builder_, level_ + 1);
    if (!result_) result_ = wsservice_entries_0_2(builder_, level_ + 1);
    if (!result_) result_ = wsservice_entries_0_3(builder_, level_ + 1);
    if (!result_) result_ = wsservice_entries_0_4(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'path' wsservice_path
  private static boolean wsservice_entries_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_0_0(builder_, level_ + 1);
    result_ = result_ && wsservice_path(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'path'
  private static boolean wsservice_entries_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_PATH);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'port' wsservice_port
  private static boolean wsservice_entries_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_1_0(builder_, level_ + 1);
    result_ = result_ && wsservice_port(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'port'
  private static boolean wsservice_entries_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_PORT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'sessionAware' wsservice_sessionAware
  private static boolean wsservice_entries_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_2_0(builder_, level_ + 1);
    result_ = result_ && wsservice_sessionAware(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'sessionAware'
  private static boolean wsservice_entries_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_SESSIONAWARE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'interceptors' wsservice_interceptors
  private static boolean wsservice_entries_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_3_0(builder_, level_ + 1);
    result_ = result_ && wsservice_interceptors(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'interceptors'
  private static boolean wsservice_entries_0_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_INTERCEPTORS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // &'enabled' wsservice_enabled
  private static boolean wsservice_entries_0_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_entries_0_4_0(builder_, level_ + 1);
    result_ = result_ && wsservice_enabled(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'enabled'
  private static boolean wsservice_entries_0_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_entries_0_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_ID_ENABLED);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // indent wsservice_interceptor_block_item+ dedent
  static boolean wsservice_interceptor_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_block")) return false;
    if (!nextTokenIs(builder_, OAP_INDENT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_interceptor_block_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wsservice_interceptor_block_item+
  private static boolean wsservice_interceptor_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_interceptor_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!wsservice_interceptor_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wsservice_interceptor_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' wsservice_interceptor_one
  static boolean wsservice_interceptor_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_DASH);
    pinned_ = result_; // pin = 1
    result_ = result_ && wsservice_interceptor_one(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '[' wsservice_interceptor_one ( ','? wsservice_interceptor_one )* ']'
  static boolean wsservice_interceptor_multiple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_multiple")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACKET)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_interceptor_one(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, wsservice_interceptor_multiple_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACKET) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // ( ','? wsservice_interceptor_one )*
  private static boolean wsservice_interceptor_multiple_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_multiple_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!wsservice_interceptor_multiple_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wsservice_interceptor_multiple_2", pos_)) break;
    }
    return true;
  }

  // ','? wsservice_interceptor_one
  private static boolean wsservice_interceptor_multiple_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_multiple_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_interceptor_multiple_2_0_0(builder_, level_ + 1);
    result_ = result_ && wsservice_interceptor_one(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ','?
  private static boolean wsservice_interceptor_multiple_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_multiple_2_0_0")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // reference_modules_value
  public static boolean wsservice_interceptor_one(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptor_one")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTANGLE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = reference_modules_value(builder_, level_ + 1);
    exit_section_(builder_, marker_, OAP_WSSERVICE_INTERCEPTOR_ONE, result_);
    return result_;
  }

  /* ********************************************************** */
  // wsservice_interceptors_id ('=' | ':') (wsservice_interceptor_block | &'[' wsservice_interceptor_multiple|wsservice_interceptor_one)
  public static boolean wsservice_interceptors(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors")) return false;
    if (!nextTokenIs(builder_, OAP_ID_INTERCEPTORS)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_INTERCEPTORS, null);
    result_ = wsservice_interceptors_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_interceptors_1(builder_, level_ + 1));
    result_ = pinned_ && wsservice_interceptors_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wsservice_interceptors_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  // wsservice_interceptor_block | &'[' wsservice_interceptor_multiple|wsservice_interceptor_one
  private static boolean wsservice_interceptors_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_interceptor_block(builder_, level_ + 1);
    if (!result_) result_ = wsservice_interceptors_2_1(builder_, level_ + 1);
    if (!result_) result_ = wsservice_interceptor_one(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'[' wsservice_interceptor_multiple
  private static boolean wsservice_interceptors_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_interceptors_2_1_0(builder_, level_ + 1);
    result_ = result_ && wsservice_interceptor_multiple(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'['
  private static boolean wsservice_interceptors_2_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors_2_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // 'interceptors'
  public static boolean wsservice_interceptors_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_interceptors_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_INTERCEPTORS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_INTERCEPTORS);
    exit_section_(builder_, marker_, OAP_WSSERVICE_INTERCEPTORS_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // wsservice_object_brace | wsservice_object_colon
  public static boolean wsservice_object(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_object")) return false;
    if (!nextTokenIs(builder_, "<wsservice object>", OAP_COLON, OAP_LEFTBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_OBJECT, "<wsservice object>");
    result_ = wsservice_object_brace(builder_, level_ + 1);
    if (!result_) result_ = wsservice_object_colon(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '{' wsservice_entries? '}'
  static boolean wsservice_object_brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_object_brace")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_LEFTBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_object_brace_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_RIGHTBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wsservice_entries?
  private static boolean wsservice_object_brace_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_object_brace_1")) return false;
    wsservice_entries(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // ':' indent wsservice_entries? dedent
  static boolean wsservice_object_colon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_object_colon")) return false;
    if (!nextTokenIs(builder_, OAP_COLON)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_COLON, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_object_colon_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wsservice_entries?
  private static boolean wsservice_object_colon_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_object_colon_2")) return false;
    wsservice_entries(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // wsservice_path_id ('=' | ':') (wsservice_path_block | &'[' wsservice_path_multiple | key_value )
  public static boolean wsservice_path(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PATH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_PATH, null);
    result_ = wsservice_path_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_path_1(builder_, level_ + 1));
    result_ = pinned_ && wsservice_path_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wsservice_path_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  // wsservice_path_block | &'[' wsservice_path_multiple | key_value
  private static boolean wsservice_path_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_path_block(builder_, level_ + 1);
    if (!result_) result_ = wsservice_path_2_1(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'[' wsservice_path_multiple
  private static boolean wsservice_path_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_path_2_1_0(builder_, level_ + 1);
    result_ = result_ && wsservice_path_multiple(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // &'['
  private static boolean wsservice_path_2_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_2_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _AND_);
    result_ = consumeToken(builder_, OAP_LEFTBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // indent wsservice_path_block_item+ dedent
  static boolean wsservice_path_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_block")) return false;
    if (!nextTokenIs(builder_, OAP_INDENT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeToken(builder_, OAP_INDENT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_path_block_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_DEDENT) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // wsservice_path_block_item+
  private static boolean wsservice_path_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_block_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_path_block_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!wsservice_path_block_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wsservice_path_block_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '-' key_value
  static boolean wsservice_path_block_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_block_item")) return false;
    if (!nextTokenIs(builder_, OAP_DASH)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_);
    result_ = consumeTokens(builder_, 1, OAP_DASH, OAP_KEY_VALUE);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'path'
  public static boolean wsservice_path_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PATH)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_PATH);
    exit_section_(builder_, marker_, OAP_WSSERVICE_PATH_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // '[' key_value (!']' ','? key_value)* ']'
  static boolean wsservice_path_multiple(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_multiple")) return false;
    if (!nextTokenIs(builder_, OAP_LEFTBRACKET)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, OAP_LEFTBRACKET, OAP_KEY_VALUE);
    result_ = result_ && wsservice_path_multiple_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OAP_RIGHTBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (!']' ','? key_value)*
  private static boolean wsservice_path_multiple_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_multiple_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!wsservice_path_multiple_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "wsservice_path_multiple_2", pos_)) break;
    }
    return true;
  }

  // !']' ','? key_value
  private static boolean wsservice_path_multiple_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_multiple_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = wsservice_path_multiple_2_0_0(builder_, level_ + 1);
    result_ = result_ && wsservice_path_multiple_2_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OAP_KEY_VALUE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !']'
  private static boolean wsservice_path_multiple_2_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_multiple_2_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, OAP_RIGHTBRACKET);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ','?
  private static boolean wsservice_path_multiple_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_path_multiple_2_0_1")) return false;
    consumeToken(builder_, OAP_COMMA);
    return true;
  }

  /* ********************************************************** */
  // wsservice_port_id ('=' | ':') key_value
  public static boolean wsservice_port(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_port")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PORT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_PORT, null);
    result_ = wsservice_port_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_port_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, OAP_KEY_VALUE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wsservice_port_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_port_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'port'
  public static boolean wsservice_port_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_port_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_PORT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_PORT);
    exit_section_(builder_, marker_, OAP_WSSERVICE_PORT_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // wsservice_sessionAware_id ('=' | ':') bool_value
  public static boolean wsservice_sessionAware(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_sessionAware")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SESSIONAWARE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OAP_WSSERVICE_SESSION_AWARE, null);
    result_ = wsservice_sessionAware_id(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, wsservice_sessionAware_1(builder_, level_ + 1));
    result_ = pinned_ && bool_value(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '=' | ':'
  private static boolean wsservice_sessionAware_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_sessionAware_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, OAP_EQ);
    if (!result_) result_ = consumeToken(builder_, OAP_COLON);
    return result_;
  }

  /* ********************************************************** */
  // 'sessionAware'
  public static boolean wsservice_sessionAware_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "wsservice_sessionAware_id")) return false;
    if (!nextTokenIs(builder_, OAP_ID_SESSIONAWARE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OAP_ID_SESSIONAWARE);
    exit_section_(builder_, marker_, OAP_WSSERVICE_SESSION_AWARE_ID, result_);
    return result_;
  }

}
