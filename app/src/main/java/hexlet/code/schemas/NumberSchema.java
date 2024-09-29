package hexlet.code.schemas;


public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addRequirement("required", num -> num != null);
        return this;
    }

    public NumberSchema positive() {
        addRequirement("positive", num -> num == null || num > 0);
        return this;
    }

    public NumberSchema range(int minNumber, int maxNumber) {
        addRequirement("range", num -> num != null && num >= minNumber && num <= maxNumber);
        return this;
    }
}
