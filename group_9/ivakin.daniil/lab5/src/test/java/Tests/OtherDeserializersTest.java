package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherDeserializersTest {

    @Test
    void serializeAndDeserializeCollectionTest() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(null);
        intList.add(3);

        PojoToJsonConvertor serializer = new PojoToJsonConvertor();
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();

        String jsonString = serializer.getJSONStr(intList);
        Object deserializedList = deserializer.getCollection(intList.getClass(), List.of(Integer.class), jsonString);

        Assertions.assertEquals(intList, deserializedList);
    }

    @Test
    void serializeAndDeserializeSimpleArrayTest() {
        Integer[] intArr = new Integer[3];
        intArr[0] = 1;
        intArr[1] = null;
        intArr[2] = 1;

        PojoToJsonConvertor serializer = new PojoToJsonConvertor();
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();

        String jsonString = serializer.getJSONStr(intArr);
        Object deserializedArr = deserializer.getSimpleArray(intArr.getClass(), jsonString);

        Assertions.assertTrue(Arrays.equals(intArr, (Integer[]) deserializedArr));
    }

    @Test
    void serializeAndDeserializeCollectionArrayTest() {
        List<Integer>[] listArr = new List[3];

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(null);

        List<Integer> list2 = new ArrayList<>();

        listArr[0] = list1;
        listArr[1] = null;
        listArr[2] = list2;

        PojoToJsonConvertor serializer = new PojoToJsonConvertor();
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();

        String jsonString = serializer.getJSONStr(listArr);
        Object deserializedArr = deserializer.getCollectionArray(listArr.getClass(), List.of(Integer.class), jsonString);

        Assertions.assertTrue(Arrays.equals(listArr, (List<Integer>[]) deserializedArr));
    }
}
