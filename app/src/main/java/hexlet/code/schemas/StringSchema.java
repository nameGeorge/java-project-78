package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        addRequirement("required", str -> str != null && !str.isBlank());
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRequirement("minLength", str -> str != null && str.length() >= minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        addRequirement("contains", str -> (str != null && str.contains(substring)) || substring.isBlank());
        return this;
    }
}
