package hexlet.code.schemas.requirements.forstring;

import hexlet.code.schemas.requirements.Requirement;

public final class StringRequiredRequirement implements Requirement<String> {
    @Override
    public boolean check(String dataForCheck) {
        return dataForCheck != null && !dataForCheck.isBlank();
    }
}
