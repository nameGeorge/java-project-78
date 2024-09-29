package hexlet.code.schemas.requirements.formap;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.requirements.Requirement;

import java.util.Map;

public class MapShapeRequirement implements Requirement<Map<String, Object>> {
    public final Map<String, Object> schemas;

    public MapShapeRequirement(Map<String, Object> schemas) {
        this.schemas = schemas;
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
