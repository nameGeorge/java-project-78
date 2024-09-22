package hexlet.code.schemas;

public class StringContainsRequirement implements Requirement {
    private final String substring;

    public StringContainsRequirement(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean check(Object dataForCheck) {
        String text = (String) dataForCheck;
        return (text != null && text.contains(substring)) || substring.isBlank();
    }
}
