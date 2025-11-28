package oap.application.plugin;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestJavaService {
    public final String finalStringField = "1";
    public final Map<String, String> finalMap = new HashMap<>();
    public final CopyOnWriteArrayList<String> finalList = new CopyOnWriteArrayList<>();
    public final LinkedHashSet<String> finalSet;

    public String stringField;
    public int intField;
    public Integer integerField;
    private String privateStringField;

    public TestJavaService(String constructor1StringField) {
        finalSet = new LinkedHashSet<>();
    }

    public TestJavaService(String constructor2StringField, String constructor2IntField) {
        finalSet = new LinkedHashSet<>();
    }

    public void setSetterMethodString(String setterMethod) {
    }
}
