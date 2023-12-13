package converter;

import entities.SalaryRecord;
import entities.car.CarArray;
import entities.car.CarCollection;
import entities.car.Type;
import entities.car.Wheel;
import example.Cat;
import example.Gender;
import org.junit.jupiter.api.Test;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {
    private final Deserializer deserializer = new Deserializer();
    @Test
    void simpleObjectDeserializeTest() {
        var catJson = "{\"name\":\"Tom\",\"age\":5,\"gender\":\"MALE\",\"breed\":\"Persian\",\"defertilized\":false}";
        var salaryRecordJson = "{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}";

        var cat = (Cat) deserializer.DeserializeJSON(catJson, Cat.class);
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON(salaryRecordJson, SalaryRecord.class);

        assertEquals("Tom", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals(Gender.MALE, cat.getGender());
        assertEquals("Persian", cat.getBreed());
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

        assertEquals(null, cat.getName());
        assertEquals(0, cat.getAge());
        assertEquals(null, cat.getGender());
        assertEquals(null, cat.getBreed());
        assertFalse(cat.isDefertilized());

        assertEquals(null, salaryRecord.getDepartment());
        assertEquals(null, salaryRecord.getFullName());
        assertEquals(0, salaryRecord.getSalary());
    }

    @Test
    void nullObjectDeserializeTest() {
        var cat = (Cat) deserializer.DeserializeJSON("null", Cat.class);
        var salaryRecord = (SalaryRecord) deserializer.DeserializeJSON("null", SalaryRecord.class);

        assertEquals(null, cat);
        assertEquals(null, salaryRecord);
    }

    @Test
    void collectionObjectDeserializeTest() {
        var json = "[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]";
        var primitiveListJson = "[0,1,2,3]";

        var size = 4;
        var wheel = new Wheel(26, Type.SUMMER);

        var list = new ArrayList<Wheel>();
        var queue = new ArrayDeque<Wheel>();
        var array = new Wheel[size];
        var primitiveList = new int[size];

        for (var i = 0; i < array.length; i++) {
            list.add(wheel);
            queue.add(wheel);
            array[i] = wheel;
            primitiveList[i] = i;
        }

        var deserializedPrimitiveList = (Integer[]) deserializer.DeserializeJSON(primitiveListJson, Integer[].class);
        //var deserializedList = (ArrayList<?>) deserializer.DeserializeJSON(json, ArrayList.class);
        //var deserializedQueue = (ArrayDeque<?>) deserializer.DeserializeJSON(json, ArrayDeque.class);
        //var deserializedArray = (Wheel[]) deserializer.DeserializeJSON(json, Wheel[].class);

        for (var i = 0; i < size; i++) {
            assertEquals(primitiveList[i], deserializedPrimitiveList[i]);
            //assertEquals(array[i], deserializedArray[i]);
        }
//        assertEquals(list, deserializedList);
//        assertEquals(queue, deserializedQueue);
    }

    @Test
    void objectDeserializeTest() {
        var json = "{\"mark\":\"Vesta\",\"model\":\"Lada\",\"wheels\":[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]}";

        var wheel = new Wheel(26, Type.SUMMER);
        var wheels = new ArrayList<>();
        wheels.add(wheel);
        wheels.add(wheel);
        wheels.add(wheel);
        wheels.add(wheel);

        var listCar = new CarCollection();
        listCar.setModel("Lada");
        listCar.setMark("Vesta");
        listCar.setWheels(List.of(
                wheel,
                wheel,
                wheel,
                wheel
        ));
        var arrayCar = new CarCollection();
        arrayCar.setModel("Lada");
        arrayCar.setMark("Vesta");
        arrayCar.setWheels(wheels);


        //var deserializedListCar = (CarCollection) deserializer.DeserializeJSON(json, CarCollection.class);
        //var deserializedArratCar = (CarArray) deserializer.DeserializeJSON(json, CarArray.class);

        //assertEquals(1, 1);
    }

    @Test
    void illegalArgumentsDeserializeTest() {
        assertThrows(IllegalArgumentException.class, () -> deserializer.DeserializeJSON("5", Integer.class));
        assertThrows(IllegalArgumentException.class, () -> deserializer.DeserializeJSON("5.0", Double.class));
        assertThrows(IllegalArgumentException.class, () -> deserializer.DeserializeJSON("false", Boolean.class));
        assertThrows(IllegalArgumentException.class, () -> deserializer.DeserializeJSON("SUMMER", Type.class));
    }
}