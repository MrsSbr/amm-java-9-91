package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Classes.WithSimpleArrays.ArrayObject;
import Examples.Classes.WithSimpleArrays.ArraySimple;
import Examples.Classes.WithSimpleArrays.MatrixObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WithSimpleArraysClassesTest {
    static Stream<Arguments> getArrArgs() {
        return Stream.of(
                Arguments.of(new ArraySimple()),
                Arguments.of(new ArrayObject()),
                Arguments.of(new MatrixObject())
        );
    }

    @ParameterizedTest
    @MethodSource("getArrArgs")
    void serializeAndDeserializeTest(Object obj) {
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();
        String jsonString = PojoToJsonConvertor.getJSONStr(obj);
        System.out.println(jsonString);
        Object deserializedObj = deserializer.getObject(obj.getClass(), jsonString);
        System.out.println();
        System.out.println(PojoToJsonConvertor.getJSONStr(deserializedObj));
        Assertions.assertEquals(obj, deserializedObj);
    }
}
