package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        addRequirement("required", map -> map != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        addRequirement("sizeof", map -> map != null && map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addRequirement("shape", map -> map.entrySet().stream()
                .allMatch(entry -> {
                    BaseSchema<String> schema = schemas.get(entry.getKey());
                    if (schema == null) {
                        return true;
                    } else {
                        return schema.isValid(entry.getValue());
                    }
                }));
        return this;
    }
}
