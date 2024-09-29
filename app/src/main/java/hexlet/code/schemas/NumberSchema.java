package hexlet.code.schemas;

import hexlet.code.schemas.requirements.fornumber.NumberPositiveRequirement;
import hexlet.code.schemas.requirements.fornumber.NumberRangeRequirement;
import hexlet.code.schemas.requirements.fornumber.NumberRequiredRequirement;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        super.addRequirement("required", new NumberRequiredRequirement());
        return this;
    }

    public NumberSchema positive() {
        super.addRequirement("positive", new NumberPositiveRequirement());
        return this;
    }

    public NumberSchema range(int minNumber, int maxNumber) {
        super.addRequirement("range", new NumberRangeRequirement(minNumber, maxNumber));
        return this;
    }

    @Override
    public Integer convertType(Object value) {
        return (Integer) value;
    }
}
