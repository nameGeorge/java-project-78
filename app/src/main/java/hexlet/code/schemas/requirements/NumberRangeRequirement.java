package hexlet.code.schemas.requirements;

public class NumberRangeRequirement implements Requirement<Integer> {
    private final int minNumber;
    private final int maxNumber;

    public NumberRangeRequirement(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    @Override
    public boolean check(Integer dataForCheck) {
        return dataForCheck != null && dataForCheck >= minNumber && dataForCheck <= maxNumber;
    }
}
