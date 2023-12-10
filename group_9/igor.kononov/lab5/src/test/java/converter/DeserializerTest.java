package converter;

import entities.SalaryRecord;
import example.Cat;
import example.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {
    private Deserializer deserializer = new Deserializer();
    @Test
    void deserializeExample() {
        var json = "{\"name\":\"Tom\",\"age\":5,\"Gender\":\"MALE\",\"breed\":\"Persian\",\"defertilized\":false}";
        var cat = (Cat) deserializer.DeserializeJSON(json, Cat.class);

        assertEquals("Tom", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals(Gender.MALE, cat.getGender());
        assertEquals("Persian", cat.getBreed());
        assertFalse(cat.isDefertilized());
    }

    @Test
    void deserialize() {
        var json = "{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}";
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON(json, SalaryRecord.class);

        assertEquals("Vrn", salaryRecord.getDepartment());
        assertEquals("Kononov Igor", salaryRecord.getFullName());
        assertEquals(60000, salaryRecord.getSalary());
    }
}