package hexlet.code.schemas.requirements.formap;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.requirements.Requirement;

import java.util.Map;

public final class MapShapeRequirement implements Requirement<Map<String, Object>> {
    private final Map<String, Object> schemas;

    public MapShapeRequirement(Map<String, Object> validationSchemas) {
        this.schemas = validationSchemas;
    }

    @Override
    public boolean check(Map<String, Object> dataForCheck) {
        return dataForCheck.entrySet().stream()
                .allMatch(entry -> {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Object schema = schemas.getOrDefault(key, null);
                    if (schema == null) {
                        return true;
                    }
                    BaseSchema<?> typedSchema = (BaseSchema<?>) schema;
                    return typedSchema.isValid(value);
                });
    }
}
