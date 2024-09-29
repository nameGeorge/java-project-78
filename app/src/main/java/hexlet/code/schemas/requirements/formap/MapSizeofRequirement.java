package hexlet.code.schemas.requirements.formap;

import hexlet.code.schemas.requirements.Requirement;

import java.util.Map;

public class MapSizeofRequirement implements Requirement<Map<String, Object>> {
    public final int size;

    public MapSizeofRequirement(int size) {
        this.size = size;
    }

    @Override
    public boolean check(Map<String, Object> dataForCheck) {
        return dataForCheck != null && dataForCheck.size() == size;
    }
}
