package hexlet.code.schemas;

import hexlet.code.schemas.requirements.formap.MapRequiredRequirement;
import hexlet.code.schemas.requirements.formap.MapShapeRequirement;
import hexlet.code.schemas.requirements.formap.MapSizeofRequirement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapSchema extends BaseSchema<Map<String, Object>> {
    public MapSchema required() {
        super.addRequirement("required", new MapRequiredRequirement());
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addRequirement("required", new MapSizeofRequirement(size));
        return this;
    }

    public MapSchema shape(Map<String, Object> schemas) {
        super.addRequirement("required", new MapShapeRequirement(schemas));
        return this;
    }

    @Override
    public Map<String, Object> convertType(Object value) {
        Map<?, ?> untypedMap = (Map<?, ?>) value;
        Map<String, Object> typedMap = null;
        if (untypedMap != null) {
            typedMap = new HashMap<>();
            for (Entry<?, ?> keyValue : untypedMap.entrySet()) {
                typedMap.put((String) keyValue.getKey(), keyValue.getValue());
            }
        }
        return typedMap;
    }
}
