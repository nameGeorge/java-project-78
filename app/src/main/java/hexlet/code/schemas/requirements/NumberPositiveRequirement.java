package hexlet.code.schemas.requirements;

public class NumberPositiveRequirement implements Requirement<Integer> {
    @Override
    public boolean check(Integer dataForCheck) {
        return dataForCheck == null || dataForCheck > 0;
    }
}
