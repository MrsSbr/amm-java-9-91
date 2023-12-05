package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Classes.Simple.MixedAll;
import Examples.Classes.WithCollections.CollectionObject;
import Examples.Classes.WithCollections.CollectionSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class WithCollectionClassesTest {
    static Stream<Arguments> getCollectionArgs() {
        Map<String, List<Class>> simpleMap = new HashMap<>();
        simpleMap.put("listInteger", List.of(Integer.class));
        simpleMap.put("queueString", List.of(String.class));

        Map<String, List<Class>> objectMap = new HashMap<>();
        objectMap.put("listMixed", List.of(MixedAll.class));

        return Stream.of(
                Arguments.of(new CollectionSimple(), simpleMap),
                Arguments.of(new CollectionObject(), objectMap)
        );
    }

    @ParameterizedTest
    @MethodSource("getCollectionArgs")
    void serializeAndDeserializeTest(Object obj, Map<String, List<Class>> mapper) {
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor(mapper);
        String jsonString = PojoToJsonConvertor.getJSONStr(obj);
        Object deserializedObj = deserializer.getObject(obj.getClass(), jsonString);
        Assertions.assertEquals(obj, deserializedObj);
    }
}
