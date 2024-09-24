package hexlet.code.schemas;

import hexlet.code.schemas.requirements.MapRequiredRequirement;
import hexlet.code.schemas.requirements.MapSizeofRequirement;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<Object, Object>> {
    public MapSchema required() {
        super.addRequirement("required", new MapRequiredRequirement());
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addRequirement("required", new MapSizeofRequirement(size));
        return this;
    }
}
