package hexlet.code.schemas;

import hexlet.code.schemas.requirements.forstring.StringContainsRequirement;
import hexlet.code.schemas.requirements.forstring.StringMinLengthRequirement;
import hexlet.code.schemas.requirements.forstring.StringRequiredRequirement;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        super.addRequirement("required", new StringRequiredRequirement());
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.addRequirement("minLength", new StringMinLengthRequirement(minLength));
        return this;
    }

    public StringSchema contains(String substring) {
        super.addRequirement("contains", new StringContainsRequirement(substring));
        return this;
    }

    @Override
    public String convertType(Object value) {
        return (String) value;
    }
}
