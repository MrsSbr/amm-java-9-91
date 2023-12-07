package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Classes.Complex.ArrayInCollection;
import Examples.Classes.Complex.CollectionInArray;
import Examples.Classes.Complex.CollectionInCollection;
import Examples.Classes.Complex.CollectionOfCollectionInArray;
import Examples.Classes.Simple.MixedAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ComplexClassesTest {
    static Stream<Arguments> getComplexArgs() {
        Map<String, List<Class>> arrInColMap = new HashMap<>();
        arrInColMap.put("listOfArr", List.of(MixedAll[].class));

        Map<String, List<Class>> colInArrMap = new HashMap<>();
        colInArrMap.put("arrOfList", List.of(MixedAll.class));

        Map<String, List<Class>> colInColMap = new HashMap<>();
        colInColMap.put("listOfList", List.of(List.class, MixedAll.class));

        Map<String, List<Class>> colOfcolInArrMap = new HashMap<>();
        colOfcolInArrMap.put("list", List.of(List[].class, MixedAll.class));

        return Stream.of(
                Arguments.of(new ArrayInCollection(), arrInColMap),
                Arguments.of(new CollectionInArray(), colInArrMap),
                Arguments.of(new CollectionInCollection(), colInColMap),
                Arguments.of(new CollectionOfCollectionInArray(), colOfcolInArrMap)
        );
    }

    @ParameterizedTest
    @MethodSource("getComplexArgs")
    void serializeAndDeserializeTest(Object obj, Map<String, List<Class>> mapper) {
        PojoToJsonConvertor serializer = new PojoToJsonConvertor();
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor(mapper);

        String jsonString = serializer.getJSONStr(obj);
        Object deserializedObj = deserializer.getObject(obj.getClass(), jsonString);

        Assertions.assertEquals(obj, deserializedObj);
    }
}
