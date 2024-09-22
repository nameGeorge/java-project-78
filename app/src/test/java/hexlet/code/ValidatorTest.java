package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    @DisplayName("validate a text string without requirements")
    void testValidateStringWithoutRequirement() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    @DisplayName("validate a text string with required requirement")
    void testValidateStringWithRequired() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    @DisplayName("validate a text string with minimum length requirement")
    void testValidateStringWithMinLength() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        schema.minLength(7);
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("hexlet"));
        schema.minLength(6);
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    @DisplayName("validate a text string with contains requirement")
    void testValidateStringWithContains() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        schema.contains("wh");
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        schema.contains("hex");
        assertFalse(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    @DisplayName("validate a text string with all requirements")
    void testValidateStringWithAllRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        schema.required().contains("hex").minLength(6);
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
        schema.contains("what").minLength(7);
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("hexlet"));
        assertFalse(schema.isValid("what"));
        schema.minLength(100);
        assertFalse(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("hexlet"));
        schema.contains("").minLength(80).minLength(5);
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }
}
