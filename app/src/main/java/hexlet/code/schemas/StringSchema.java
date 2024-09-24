package hexlet.code.schemas;

import hexlet.code.schemas.requirements.StringContainsRequirement;
import hexlet.code.schemas.requirements.StringMinLengthRequirement;
import hexlet.code.schemas.requirements.StringRequiredRequirement;

public class StringSchema extends BaseSchema<String> {
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
}
