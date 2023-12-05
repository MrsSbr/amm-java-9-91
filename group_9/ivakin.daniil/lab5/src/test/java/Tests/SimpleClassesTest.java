package Tests;

import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Examples.Classes.Simple.ManyEnumOnly;
import Examples.Classes.Simple.ManyStringOnly;
import Examples.Classes.Simple.MixedAll;
import Examples.Classes.Simple.MixedPrimWrap;
import Examples.Classes.Simple.OneEnumOnly;
import Examples.Classes.Simple.OneStringOnly;
import Examples.Classes.Simple.PrimitiveOnly;
import Examples.Classes.Simple.SuperSimple;
import Examples.Classes.Simple.WrappedOnly;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SimpleClassesTest {

    static Stream<Arguments> getSimpleArgs() {
        return Stream.of(
                Arguments.of(new SuperSimple()),
                Arguments.of(new PrimitiveOnly()),
                Arguments.of(new WrappedOnly()),
                Arguments.of(new OneEnumOnly()),
                Arguments.of(new OneStringOnly()),
                Arguments.of(new ManyEnumOnly()),
                Arguments.of(new ManyStringOnly()),
                Arguments.of(new MixedPrimWrap()),
                Arguments.of(new MixedAll())
        );
    }

    @ParameterizedTest
    @MethodSource("getSimpleArgs")
    void serializeAndDeserializeTest(Object obj) {
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();
        String jsonString = PojoToJsonConvertor.getJSONStr(obj);
        Object deserializedObj = deserializer.getObject(obj.getClass(), jsonString);
        Assertions.assertEquals(obj, deserializedObj);
    }
}
