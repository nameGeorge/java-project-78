package hexlet.code.schemas.requirements;

public class StringContainsRequirement implements Requirement<String> {
    private final String substring;

    public StringContainsRequirement(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean check(String dataForCheck) {
        return (dataForCheck != null && dataForCheck.contains(substring)) || substring.isBlank();
    }
}
