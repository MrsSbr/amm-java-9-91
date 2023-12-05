package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Classes.WithInheritence.BaseClass;
import Examples.Classes.WithInheritence.ChildClass;
import Examples.Classes.WithInheritence.ChildOfChildClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WithInheritanceClassesTest {
    static Stream<Arguments> getInheritanceArgs() {
        return Stream.of(
                Arguments.of(new BaseClass()),
                Arguments.of(new ChildClass()),
                Arguments.of(new ChildOfChildClass())
        );
    }

    @ParameterizedTest
    @MethodSource("getInheritanceArgs")
    void serializeAndDeserializeTest(Object obj) {
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();
        String jsonString = PojoToJsonConvertor.getJSONStr(obj);
        Object deserializedObj = deserializer.getObject(obj.getClass(), jsonString);
        Assertions.assertEquals(obj, deserializedObj);
    }
}
