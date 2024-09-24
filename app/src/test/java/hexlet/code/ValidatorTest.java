package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    @DisplayName("validate a text string without requirements")
    void testValidateStringWithoutRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    @DisplayName("validate a text string with \"required\" requirement")
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
    @DisplayName("validate a text string with \"minLength\" requirement")
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
    @DisplayName("validate a text string with \"contains\" requirement")
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

    @Test
    @DisplayName("validate a number without requirements")
    void testValidateNumberWithoutRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-10));
    }

    @Test
    @DisplayName("validate a number with \"required\" requirement")
    void testValidateNumberWithRequired() throws Exception {
        var validator = new Validator();
        var schema = validator.number();
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(0));
        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(-10));
    }

    @Test
    @DisplayName("validate a number with \"positive\" requirement")
    void testValidateNumberWithPositive() throws Exception {
        var validator = new Validator();
        var schema = validator.number();
        schema.positive();
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(1));
        assertFalse(schema.isValid(-1));
    }

    @Test
    @DisplayName("validate a number with \"range\" requirement")
    void testValidateNumberWithRange() throws Exception {
        var validator = new Validator();
        var schema = validator.number();
        schema.range(5, 10);
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(7));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(11));
    }

    @Test
    @DisplayName("validate a number with all requirements")
    void testValidateNumberWithAllRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(7));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
        schema.range(20, 30);
        assertTrue(schema.isValid(20));
        assertTrue(schema.isValid(25));
        assertTrue(schema.isValid(30));
        assertFalse(schema.isValid(19));
        assertFalse(schema.isValid(31));
    }

    @Test
    @DisplayName("validate a map without requirements")
    void testValidateMapWithoutRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    @DisplayName("validate a map with \"required\" requirement")
    void testValidateMapWithRequired() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<Object, Object>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }

    @Test
    @DisplayName("validate a map with \"sizeof\" requirement")
    void testValidateMapWithSizeof() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        schema.sizeof(2);
        var data = new HashMap<Object, Object>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    @DisplayName("validate a map with all requirements")
    void testValidateMapWithAllRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<Object, Object>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
}
