package hexlet.code.schemas.requirements.fornumber;

import hexlet.code.schemas.requirements.Requirement;

public final class NumberRequiredRequirement implements Requirement<Integer> {
    @Override
    public boolean check(Integer dataForCheck) {
        return dataForCheck != null;
    }
}
