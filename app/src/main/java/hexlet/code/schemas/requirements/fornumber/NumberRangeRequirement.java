package hexlet.code.schemas.requirements.fornumber;

import hexlet.code.schemas.requirements.Requirement;

public final class NumberRangeRequirement implements Requirement<Integer> {
    private final int minNumber;
    private final int maxNumber;

    public NumberRangeRequirement(int minNumberOfRange, int maxNumberOfRange) {
        this.minNumber = minNumberOfRange;
        this.maxNumber = maxNumberOfRange;
    }

    @Override
    public boolean check(Integer dataForCheck) {
        return dataForCheck != null && dataForCheck >= minNumber && dataForCheck <= maxNumber;
    }
}
