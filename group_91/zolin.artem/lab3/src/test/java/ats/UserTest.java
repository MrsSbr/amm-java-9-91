package ats;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UserTest {

    static Stream<Arguments> userCreationWithInvalidArgumentsShouldThrow() {
        return Stream.of(
                arguments(-1, 0),
                arguments(100, 0),
                arguments(0, -1),
                arguments(0, 100000)
        );
    }

    static Stream<Arguments> rangeCreationWithInvalidArgumentsShouldThrow() {
        return Stream.of(
                arguments(1, 0),
                arguments(100, 10)
        );
    }

    @ParameterizedTest
    @MethodSource
    void userCreationWithInvalidArgumentsShouldThrow(int atsId, int id) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User("test", atsId, id));
    }

    @ParameterizedTest
    @MethodSource
    void rangeCreationWithInvalidArgumentsShouldThrow(int start, int end) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new AtsNumbersRange(0, start, end));
    }

}
