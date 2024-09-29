package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private Map<String, Predicate<T>> requirements;

    public BaseSchema() {
        requirements = new HashMap<>();
    }

    /**
     * Adds a new validation requirement.
     *
     * @param name        - requirement name
     * @param requirement - validation requirement
     */
    public void addRequirement(String name, Predicate<T> requirement) {
        requirements.put(name, requirement);
    }

    /**
     * Checks the value for the validity of the scheme.
     *
     * @param dataForValidation - data for validation
     * @return - true if data is valid, else false
     */
    public boolean isValid(T dataForValidation) {
        return requirements.values().stream()
                .allMatch(requirement -> requirement.test(dataForValidation));
    }
}
