package hexlet.code.schemas.requirements.forstring;

import hexlet.code.schemas.requirements.Requirement;

public final class StringMinLengthRequirement implements Requirement<String> {
    private final int minLength;

    public StringMinLengthRequirement(int minLengthOfString) {
        this.minLength = minLengthOfString;
    }

    @Override
    public boolean check(String dataForCheck) {
        return dataForCheck != null && dataForCheck.length() >= minLength;
    }
}
