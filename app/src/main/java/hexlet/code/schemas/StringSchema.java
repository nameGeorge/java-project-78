package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class StringSchema {
    private Map<String, Requirement> restrictions;

    public StringSchema() {
        restrictions = new HashMap<String, Requirement>();
    }

    public StringSchema required() {
        restrictions.put("required", new StringRequiredRequirement());
        return this;
    }

    public StringSchema minLength(int minLength) {
        restrictions.put("minLength", new StringMinLengthRequirement(minLength));
        return this;
    }

    public StringSchema contains(String substring) {
        restrictions.put("contains", new StringContainsRequirement(substring));
        return this;
    }

    public boolean isValid(String text) {
        return restrictions.values().stream()
                .allMatch(requirement -> requirement.check(text));
    }
}
