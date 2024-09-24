package hexlet.code.schemas;

import hexlet.code.schemas.requirements.Requirement;

import java.util.HashMap;
import java.util.Map;

public class BaseSchema<T> {
    private Map<String, Requirement<T>> requirements;

    public BaseSchema() {
        requirements = new HashMap<String, Requirement<T>>();
    }

    public void addRequirement(String name, Requirement<T> requirement) {
        requirements.put(name, requirement);
    }

    public boolean isValid(T dataForValidation) {
        return requirements.values().stream()
                .allMatch(requirement -> requirement.check(dataForValidation));
    }
}
