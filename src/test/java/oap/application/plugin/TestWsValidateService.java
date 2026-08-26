package oap.application.plugin;

import oap.ws.validate.ValidationErrors;
import oap.ws.validate.WsValidate;

public class TestWsValidateService {
    @WsValidate("isValid")
    public String methodLevelValid(String skipDeprecated) {
        return skipDeprecated;
    }

    public ValidationErrors isValid(String skipDeprecated) {
        return ValidationErrors.empty();
    }

    public String parameterLevelValid(@WsValidate("oddParamValidator") int oddParam) {
        return String.valueOf(oddParam);
    }

    public ValidationErrors oddParamValidator(int oddParam) {
        return ValidationErrors.empty();
    }

    @WsValidate("noSuchValidator")
    public String methodLevelUnresolved(String requiredParameter) {
        return requiredParameter;
    }
}
