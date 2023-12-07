package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Enums.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InvalidArgsTest {
    static Stream<Arguments> getIllegalArgs() {
        Integer integerObj = 1;
        double doubleObj = 2;
        return Stream.of(
                Arguments.of(integerObj),
                Arguments.of("String"),
                Arguments.of(Color.RED),
                Arguments.of(doubleObj)
        );
    }

    @ParameterizedTest
    @MethodSource("getIllegalArgs")
    void serializerThrowsIllegalArgumentException(Object arg) {
        PojoToJsonConvertor serializer = new PojoToJsonConvertor();

        Assertions.assertThrows(IllegalArgumentException.class, () -> serializer.getJSONStr(arg));
    }

    @ParameterizedTest
    @MethodSource("getIllegalArgs")
    void deserializerThrowsIllegalArgumentException(Object arg) {
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();
        Class argType = arg.getClass();

        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.getObject(argType, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.getCollection(argType, null, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.getCollectionArray(argType, null,""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.getSimpleArray(argType, ""));
    }
}
