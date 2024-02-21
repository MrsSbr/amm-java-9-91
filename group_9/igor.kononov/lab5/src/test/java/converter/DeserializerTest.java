package converter;

import entities.SalaryRecord;
import entities.car.Type;
import entities.car.Wheel;
import example.Cat;
import example.Gender;
import exceptions.DeserializeException;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {
    private final Deserializer deserializer = new Deserializer();

    @Test
    void simpleObjectDeserializeTest() {
        var catJson = "{\"name\":\"Tom\\\"\",\"age\":5,\"gender\":\"MALE\",\"breed\":\"Per\\\"sian\",\"defertilized\":false}";
        var salaryRecordJson = "{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}";

        var cat = (Cat) deserializer.DeserializeJSON(catJson, Cat.class);
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON(salaryRecordJson, SalaryRecord.class);

        assertEquals("Tom\"", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals(Gender.MALE, cat.getGender());
        assertEquals("Per\"sian", cat.getBreed());
        assertFalse(cat.isDefertilized());

        assertEquals("Vrn", salaryRecord.getDepartment());
        assertEquals("Kononov Igor", salaryRecord.getFullName());
        assertEquals(60000, salaryRecord.getSalary());
    }

    @Test
    void emptyObjectDeserializeTest() {
        var catJson = "{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}";
        var salaryRecordJson = "{\"department\":null,\"fullName\":null,\"salary\":0}";

        var cat = (Cat) deserializer.DeserializeJSON(catJson, Cat.class);
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON(salaryRecordJson, SalaryRecord.class);

        assertNull(cat.getName());
        assertEquals(0, cat.getAge());
        assertNull(cat.getGender());
        assertNull(cat.getBreed());
        assertFalse(cat.isDefertilized());

        assertNull(salaryRecord.getDepartment());
        assertNull(salaryRecord.getFullName());
        assertEquals(0, salaryRecord.getSalary());
    }

    @Test
    void nullObjectDeserializeTest() {
        var cat = (Cat) deserializer.DeserializeJSON("null", Cat.class);
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON("null", SalaryRecord.class);

        assertNull(cat);
        assertNull(salaryRecord);
    }

    @Test
    void arrayPrimitiveDeserializeTest() {
        var primitiveListJson = "[0, 1, 2, 3]";
        var size = 4;

        var primitiveArray = new int[size];

        for (var i = 0; i < size; i++) {
            primitiveArray[i] = i;
        }

        var deserializedPrimitiveList = (Integer[]) deserializer.DeserializeJSON(primitiveListJson, Integer[].class);

        for (var i = 0; i < size; i++) {
            assertEquals(primitiveArray[i], deserializedPrimitiveList[i]);
        }
    }

    @Test
    void collectionPrimitiveDeserializeTest() {
        var primitiveListJson = "[0, 1, 2, 3]";
        var size = 4;

        var primitiveList = List.of(0, 1, 2, 3);

        //var deserializedPrimitiveList = (List<Integer>) deserializer.DeserializeJSON(primitiveListJson, Collection.class);
        var deserializedPrimitiveList = (List<Integer>) deserializer.DeserializeJSON(primitiveListJson, primitiveList.getClass(), List.of(Integer.class));

        for (var i = 0; i < size; i++) {
            assertEquals(primitiveList.get(i), deserializedPrimitiveList.get(i));
        }
    }

    @Test
    void illegalArgumentsDeserializeTest() {
        assertThrows(DeserializeException.class, () -> deserializer.DeserializeJSON("5", Integer.class));
        assertThrows(DeserializeException.class, () -> deserializer.DeserializeJSON("5.0", Double.class));
        assertThrows(DeserializeException.class, () -> deserializer.DeserializeJSON("false", Boolean.class));
        assertThrows(DeserializeException.class, () -> deserializer.DeserializeJSON("SUMMER", Type.class));
    }


    @Test
    void collectionObjectDeserializeTest() {
        var json = "[{\"size\":26,\"tire\":\"SUMMER\"}, {\"size\":26,\"tire\":\"SUMMER\"}, {\"size\":26,\"tire\":\"SUMMER\"}, {\"size\":26,\"tire\":\"SUMMER\"}]";

        var size = 4;
        var wheel = new Wheel(26, Type.SUMMER);

        var array = new Wheel[size];
        var list = new ArrayList<Wheel>();


        Arrays.fill(array, wheel);

        for (var i = 0; i < size; i++) {
            list.add(wheel);
        }

        var deserializedList = (ArrayList<?>) deserializer.DeserializeJSON(json, ArrayList.class, List.of(Wheel.class));
        var deserializedArray = (Wheel[]) deserializer.DeserializeJSON(json, Wheel[].class);

        for (var i = 0; i < size; i++) {
            assertEquals(array[i], deserializedArray[i]);
        }
        assertEquals(list, deserializedList);
    }
}