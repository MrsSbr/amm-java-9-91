package converter;

import entities.SalaryRecord;
import entities.car.CarArray;
import entities.car.CarCollection;
import entities.car.Type;
import entities.car.Wheel;
import example.Cat;
import example.Gender;
import exceptions.SerializeException;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {
    private final Serializer serializer = new Serializer();
    @Test
    void simpleObjectSerializeTest() {
        var cat = new Cat("Tom", 5, Gender.MALE, "Persian", false);
        var salaryRecord = new SalaryRecord("Vrn", "Kononov Igor", 60000);

        var jsonCat = serializer.serializeJSON(cat);
        var jsonSalaryRecord = serializer.serializeJSON(salaryRecord);

        assertEquals("{\"name\":\"Tom\",\"age\":5,\"gender\":\"MALE\",\"breed\":\"Persian\",\"defertilized\":false}", jsonCat);
        assertEquals("{\"department\":\"Vrn\",\"fullName\":\"Kononov Igor\",\"salary\":60000}", jsonSalaryRecord);
    }

    @Test
    void emptyObjectSerializeTest() {
        var cat = new Cat();
        var salaryRecord = new SalaryRecord();

        var jsonCat = serializer.serializeJSON(cat);
        var jsonSalaryRecord = serializer.serializeJSON(salaryRecord);

        assertEquals("{\"name\":null,\"age\":0,\"gender\":null,\"breed\":null,\"defertilized\":false}", jsonCat);
        assertEquals("{\"department\":null,\"fullName\":null,\"salary\":0}", jsonSalaryRecord);
    }

    @Test
    void nullObjectSerializeTest() {
        var jsonCat = serializer.serializeJSON(null);
        var jsonSalaryRecord = serializer.serializeJSON(null);

        assertEquals("null", jsonCat);
        assertEquals("null", jsonSalaryRecord);
    }

    @Test
    void collectionObjectSerializeTest() {
        var size = 4;
        var wheel = new Wheel(26, Type.SUMMER);

        var list = new ArrayList<Wheel>();
        var queue = new ArrayDeque<Wheel>();
        var array = new Wheel[size];
        var primitiveList = new LinkedList<Integer>();

        for (var i = 0; i < array.length; i++) {
            list.add(wheel);
            queue.add(wheel);
            array[i] = wheel;
            primitiveList.add(i);
        }

        var listJson = serializer.serializeJSON(list);
        var queueJson = serializer.serializeJSON(queue);
        var arrayJson = serializer.serializeJSON(array);
        var primitiveListJson = serializer.serializeJSON(primitiveList);

        assertEquals("[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]", listJson);
        assertEquals("[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]", queueJson);
        assertEquals("[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]", arrayJson);
        assertEquals("[0,1,2,3]", primitiveListJson);
    }

    @Test
    void objectSerializeTest() {
        var size = 4;
        var wheel = new Wheel(26, Type.SUMMER);
        var wheels = new Wheel[size];
        for (var i = 0; i < size; i++) {
            wheels[i] = wheel;
        }

        var listCar = new CarCollection();
        listCar.setModel("Lada");
        listCar.setMark("Vesta");
        listCar.setWheels(List.of(
                wheel,
                wheel,
                wheel,
                wheel
        ));
        var arrayCar = new CarArray();
        arrayCar.setModel("Lada");
        arrayCar.setMark("Vesta");
        arrayCar.setWheels(wheels);

        var listCarJson = serializer.serializeJSON(listCar);
        var arrayCarJson = serializer.serializeJSON(arrayCar);

        assertEquals("{\"mark\":\"Vesta\",\"model\":\"Lada\",\"wheels\":[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]}", listCarJson);
        assertEquals("{\"mark\":\"Vesta\",\"model\":\"Lada\",\"wheels\":[{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"},{\"size\":26,\"tire\":\"SUMMER\"}]}", arrayCarJson);
    }

    @Test
    void illegalArgumentsSerializeTest() {
        assertThrows(SerializeException.class, () -> serializer.serializeJSON(5));
        assertThrows(SerializeException.class, () -> serializer.serializeJSON(5.0));
        assertThrows(SerializeException.class, () -> serializer.serializeJSON(false));
        assertThrows(SerializeException.class, () -> serializer.serializeJSON(Type.SUMMER));
    }
}