package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
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
        var data = new HashMap<String, Object>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }

    @Test
    @DisplayName("validate a map with \"sizeof\" requirement")
    void testValidateMapWithSizeof() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        schema.sizeof(2);
        var data = new HashMap<String, Object>();
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
        var data = new HashMap<String, Object>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    @DisplayName("validate a shape with all requirements")
    void testValidateShapeWithoutRequirements() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        Map<String, Object> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schemas.put("age", validator.number().required().positive());
        schemas.put("phoneNumbers", validator.map().required().sizeof(2));
        schema.shapeSeveralSchemes(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        human1.put("age", 14);
        human1.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        human1.put("description", "good guy");
        assertTrue(schema.isValid(human1));
        Map<String, Object> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        human2.put("age", 14);
        human2.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        assertFalse(schema.isValid(human2));
        Map<String, Object> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        human3.put("age", 14);
        human3.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        assertFalse(schema.isValid(human3));
        Map<String, Object> human4 = new HashMap<>();
        human4.put("firstName", "John");
        human4.put("lastName", "Smith");
        human4.put("age", null);
        human4.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        assertFalse(schema.isValid(human4));
        Map<String, Object> human5 = new HashMap<>();
        human5.put("firstName", "John");
        human5.put("lastName", "Smith");
        human5.put("age", 0);
        human5.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        assertFalse(schema.isValid(human5));
        Map<String, Object> human6 = new HashMap<>();
        human6.put("firstName", "John");
        human6.put("lastName", "Smith");
        human6.put("age", -14);
        human6.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44",
                "mobileNumber", "8(555)666-77-88"));
        assertFalse(schema.isValid(human6));
        Map<String, Object> human7 = new HashMap<>();
        human7.put("firstName", "John");
        human7.put("lastName", "Smith");
        human7.put("age", 14);
        human7.put("phoneNumbers", null);
        assertFalse(schema.isValid(human7));
        Map<String, Object> human8 = new HashMap<>();
        human8.put("firstName", "John");
        human8.put("lastName", "Smith");
        human8.put("age", 14);
        human8.put("phoneNumbers", Map.of(
                "homeNumber", "8(111)222-33-44"));
        assertFalse(schema.isValid(human8));
    }

    @Test
    @DisplayName("validate a shape with all requirements (only string schema)")
    void testValidateShapeWithoutRequirementsOnlyStringSchema() throws Exception {
        var validator = new Validator();
        var schema = validator.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
