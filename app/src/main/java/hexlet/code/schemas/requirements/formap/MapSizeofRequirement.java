package hexlet.code.schemas.requirements.formap;

import hexlet.code.schemas.requirements.Requirement;

import java.util.Map;

public final class MapSizeofRequirement implements Requirement<Map<String, Object>> {
    private final int size;

    public MapSizeofRequirement(int sizeForMap) {
        this.size = sizeForMap;
    }

    @Override
    public boolean check(Map<String, Object> dataForCheck) {
        return dataForCheck != null && dataForCheck.size() == size;
    }
}
