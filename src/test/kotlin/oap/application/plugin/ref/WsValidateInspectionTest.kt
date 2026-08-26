package oap.application.plugin.ref

import com.intellij.psi.PsiFile
import oap.application.plugin.OapFixtureTestCase
import java.io.File

class WsValidateInspectionTest : OapFixtureTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/java").absolutePath
    }

    protected override fun setUp() {
        super.setUp()
        myFixture.enableInspections(ValidWsValidateInspection::class.java)
        myFixture.configureByFile("oap/ws/validate/WsValidate.java")
        myFixture.configureByFile("oap/ws/validate/ValidationErrors.java")
    }

    // Deliberately primitive-only signatures below (no java.lang.String etc.) - this light test
    // fixture has no JDK attached, so any real JDK type would show up as a spurious "Cannot
    // resolve symbol" error unrelated to what these tests are actually checking.
    private fun check(fileName: String, text: String) {
        val file: PsiFile = myFixture.configureByText(fileName, text.trimIndent())
        myFixture.openFileInEditor(file.virtualFile)
        myFixture.checkHighlighting()
    }

    fun testValidMethodLevel() {
        check(
            "MethodLevelValid.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class MethodLevelValid {
                @WsValidate("isValid")
                public int call(int skipDeprecated) {
                    return skipDeprecated;
                }

                public ValidationErrors isValid(int skipDeprecated) {
                    return ValidationErrors.empty();
                }
            }
        """
        )
    }

    fun testValidParameterLevel() {
        check(
            "ParameterLevelValid.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class ParameterLevelValid {
                public int call(@WsValidate("oddParamValidator") int oddParam) {
                    return oddParam;
                }

                public ValidationErrors oddParamValidator(int oddParam) {
                    return ValidationErrors.empty();
                }
            }
        """
        )
    }

    fun testMismatchedParameterName() {
        check(
            "MismatchedParamName.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class MismatchedParamName {
                @WsValidate(<error descr="Validator 'validator' parameter(s) missedParam not supplied by 'call'">"validator"</error>)
                public int call(int requiredParameter) {
                    return requiredParameter;
                }

                public ValidationErrors validator(int missedParam) {
                    return ValidationErrors.empty();
                }
            }
        """
        )
    }

    fun testWrongArgCountOnParameterLevel() {
        check(
            "WrongArgCount.java", """
            import oap.ws.validate.ValidationErrors;
            import oap.ws.validate.WsValidate;

            public class WrongArgCount {
                public int call(@WsValidate(<error descr="Validator 'validator' must take exactly one parameter for a parameter-level @WsValidate">"validator"</error>) int oddParam, int other) {
                    return oddParam;
                }

                public ValidationErrors validator(int oddParam, int other) {
                    return ValidationErrors.empty();
                }
            }
        """
        )
    }

    fun testWrongReturnType() {
        check(
            "WrongReturnType.java", """
            import oap.ws.validate.WsValidate;

            public class WrongReturnType {
                @WsValidate(<error descr="Validator 'validator' must return oap.ws.validate.ValidationErrors">"validator"</error>)
                public int call(int requiredParameter) {
                    return requiredParameter;
                }

                public boolean validator(int requiredParameter) {
                    return true;
                }
            }
        """
        )
    }
}
