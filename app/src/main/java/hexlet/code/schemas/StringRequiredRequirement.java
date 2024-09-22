package hexlet.code.schemas;

public class StringRequiredRequirement implements Requirement {
    @Override
    public boolean check(Object dataForCheck) {
        String text = (String) dataForCheck;
        return text != null && !text.isBlank();
    }
}
