package hexlet.code.schemas.requirements;

import java.util.Map;

public class MapRequiredRequirement implements Requirement<Map<Object, Object>> {
    @Override
    public boolean check(Map<Object, Object> dataForCheck) {
        return dataForCheck != null;
    }
}
