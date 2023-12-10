package converter;

import entities.SalaryRecord;
import example.Cat;
import example.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {
    private Serializer serializer = new Serializer();
    @Test
    void serializeExample() {
        var cat = new Cat("Tom", 5, Gender.MALE, "Persian", false);
        var json = serializer.serializeJSON(cat);
        assertEquals("{\"name\":\"Tom\",\"age\":5,\"Gender\":\"MALE\",\"breed\":\"Persian\",\"defertilized\":false}", json);
    }

    @Test
    void serialize() {
        var salaryRecord = new SalaryRecord("Vrn", "Kononov Igor", 60000);
        var json = serializer.serializeJSON(salaryRecord);
        assertEquals("{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}", json);
    }
}