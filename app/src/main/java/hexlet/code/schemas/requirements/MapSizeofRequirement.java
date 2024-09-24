package hexlet.code.schemas.requirements;

import java.util.Map;

public class MapSizeofRequirement implements Requirement<Map<Object, Object>> {
    public final int size;

    public MapSizeofRequirement(int size) {
        this.size = size;
    }

    @Override
    public boolean check(Map<Object, Object> dataForCheck) {
        return dataForCheck != null && dataForCheck.size() == size;
    }
}
