package hexlet.code.schemas.requirements;

public class NumberRequiredRequirement implements Requirement<Integer> {
    @Override
    public boolean check(Integer dataForCheck) {
        return dataForCheck != null;
    }
}
