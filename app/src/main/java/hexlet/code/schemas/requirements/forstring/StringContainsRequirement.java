package hexlet.code.schemas.requirements.forstring;

import hexlet.code.schemas.requirements.Requirement;

public final class StringContainsRequirement implements Requirement<String> {
    private final String substring;

    public StringContainsRequirement(String requiredSubstring) {
        this.substring = requiredSubstring;
    }

    @Override
    public boolean check(String dataForCheck) {
        return (dataForCheck != null && dataForCheck.contains(substring)) || substring.isBlank();
    }
}
