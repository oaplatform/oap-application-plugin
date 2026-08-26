package oap.application.plugin.completion

import com.intellij.codeInsight.completion.CompletionType
import oap.application.plugin.OapFixtureTestCase
import org.assertj.core.api.Assertions.assertThat
import java.io.File

class WsValidateCompletionTest : OapFixtureTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    protected override fun setUp() {
        super.setUp()
        myFixture.configureByFile("oap/ws/validate/WsValidate.java")
        myFixture.configureByFile("oap/ws/validate/ValidationErrors.java")
    }

    // Primitive-only signatures - this light test fixture has no JDK attached (see
    // WsValidateInspectionTest), so a real JDK type would be unresolvable noise here.
    fun testMethodLevelCompletion() {
        val file = myFixture.configureByText(
            "MethodLevelCompletion.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class MethodLevelCompletion {
                @WsValidate("<caret>")
                public int call(int requiredParameter) {
                    return requiredParameter;
                }

                public ValidationErrors goodValidator(int requiredParameter) {
                    return ValidationErrors.empty();
                }

                public ValidationErrors badValidatorWrongParam(int notAParam) {
                    return ValidationErrors.empty();
                }

                public boolean badValidatorWrongReturnType(int requiredParameter) {
                    return true;
                }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.complete(CompletionType.BASIC)

        val suggestions = myFixture.lookupElementStrings!!
        assertThat(suggestions).contains("goodValidator")
        assertThat(suggestions).doesNotContain("badValidatorWrongParam", "badValidatorWrongReturnType")
    }

    fun testMethodLevelArrayFormCompletion() {
        val file = myFixture.configureByText(
            "MethodLevelArrayFormCompletion.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class MethodLevelArrayFormCompletion {
                @WsValidate({ "<caret>" })
                public int call(int requiredParameter) {
                    return requiredParameter;
                }

                public ValidationErrors goodValidator(int requiredParameter) {
                    return ValidationErrors.empty();
                }

                public ValidationErrors badValidatorWrongParam(int notAParam) {
                    return ValidationErrors.empty();
                }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.complete(CompletionType.BASIC)

        val suggestions = myFixture.lookupElementStrings!!
        assertThat(suggestions).contains("goodValidator")
        assertThat(suggestions).doesNotContain("badValidatorWrongParam")
    }

    fun testMethodLevelArrayFormSecondElementCompletion() {
        val file = myFixture.configureByText(
            "MethodLevelArrayFormSecondElement.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class MethodLevelArrayFormSecondElement {
                @WsValidate({ "goodValidator", "<caret>" })
                public int call(int requiredParameter) {
                    return requiredParameter;
                }

                public ValidationErrors goodValidator(int requiredParameter) {
                    return ValidationErrors.empty();
                }

                public ValidationErrors anotherGoodValidator(int requiredParameter) {
                    return ValidationErrors.empty();
                }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.complete(CompletionType.BASIC)

        val suggestions = myFixture.lookupElementStrings!!
        assertThat(suggestions).contains("goodValidator", "anotherGoodValidator")
    }

    // Regression test: real-world WS classes commonly extend a shared base class holding common
    // validators. candidateValidatorMethods() must search the whole hierarchy (like resolve()'s
    // findMethodsByName(name, checkBases=true) already does for navigation), not just this
    // class's own declared methods, or an inherited validator silently never gets suggested.
    fun testInheritedValidatorCompletion() {
        val file = myFixture.configureByText(
            "InheritedValidatorCompletion.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            class BaseWs {
                public ValidationErrors inheritedValidator(int requiredParameter) {
                    return ValidationErrors.empty();
                }
            }

            public class InheritedValidatorCompletion extends BaseWs {
                @WsValidate("<caret>")
                public int call(int requiredParameter) {
                    return requiredParameter;
                }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.complete(CompletionType.BASIC)

        val suggestions = myFixture.lookupElementStrings!!
        assertThat(suggestions).contains("inheritedValidator")
    }

    fun testParameterLevelCompletion() {
        val file = myFixture.configureByText(
            "ParameterLevelCompletion.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class ParameterLevelCompletion {
                public int call(@WsValidate("<caret>") int oddParam, int other) {
                    return oddParam;
                }

                public ValidationErrors goodValidator(int oddParam) {
                    return ValidationErrors.empty();
                }

                public ValidationErrors badValidatorTwoParams(int oddParam, int other) {
                    return ValidationErrors.empty();
                }
            }
        """.trimIndent()
        )
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.complete(CompletionType.BASIC)

        val suggestions = myFixture.lookupElementStrings!!
        assertThat(suggestions).contains("goodValidator")
        assertThat(suggestions).doesNotContain("badValidatorTwoParams")
    }
}
