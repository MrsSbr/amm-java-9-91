package Tests;

import Serialization.Deserializer;
import Serialization.Serializer;
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
        Serializer serializer = new Serializer();

        Assertions.assertThrows(IllegalArgumentException.class, () -> serializer.serialize(arg));
    }

    @ParameterizedTest
    @MethodSource("getIllegalArgs")
    void deserializerThrowsIllegalArgumentException(Object arg) {
        Deserializer deserializer = new Deserializer();
        Class argType = arg.getClass();

        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.deserializeObject(argType, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.deserializeCollection(argType, null, ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.deserializeCollectionArray(argType, null,""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> deserializer.deserializeSimpleArray(argType, ""));
    }
}
