package hexlet.code.schemas;

public class StringMinLengthRequirement implements Requirement {
    private final int minLength;

    public StringMinLengthRequirement(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean check(Object dataForCheck) {
        String text = (String) dataForCheck;
        return text != null && text.length() >= minLength;
    }
}
