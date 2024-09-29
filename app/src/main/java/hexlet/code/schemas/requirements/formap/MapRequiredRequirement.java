package hexlet.code.schemas.requirements.formap;

import hexlet.code.schemas.requirements.Requirement;

import java.util.Map;

public final class MapRequiredRequirement implements Requirement<Map<String, Object>> {
    @Override
    public boolean check(Map<String, Object> dataForCheck) {
        return dataForCheck != null;
    }
}
