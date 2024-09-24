package hexlet.code.schemas.requirements;

public class StringMinLengthRequirement implements Requirement<String> {
    private final int minLength;

    public StringMinLengthRequirement(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean check(String dataForCheck) {
        return dataForCheck != null && dataForCheck.length() >= minLength;
    }
}
