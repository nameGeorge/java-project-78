package hexlet.code.schemas.requirements;

public class StringRequiredRequirement implements Requirement<String> {
    @Override
    public boolean check(String dataForCheck) {
        return dataForCheck != null && !dataForCheck.isBlank();
    }
}
