package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private Map<String, Predicate<T>> requirements;

    public BaseSchema() {
        requirements = new HashMap<>();
    }

    public void addRequirement(String name, Predicate<T> requirement) {
        requirements.put(name, requirement);
    }

    public boolean isValid(T dataForValidation) {

        return requirements.values().stream()
                .allMatch(requirement -> requirement.test(dataForValidation));
    }
}
