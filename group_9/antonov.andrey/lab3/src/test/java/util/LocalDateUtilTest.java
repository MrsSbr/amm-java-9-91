package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateUtilTest {

    @ParameterizedTest
    @MethodSource("getArgumentsForDateTest")
    void checkDate(LocalDate localDate, int month, boolean result) {
        var actualResult = LocalDateUtil.dateIsCorrectMonth(localDate, month);
        assertEquals(result, actualResult);
    }


    static Stream<Arguments> getArgumentsForDateTest() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, 11, 2), 2, true),
                Arguments.of(LocalDate.of(2023, 7, 2), 2, false),
                Arguments.of(LocalDate.of(2023, 7, 2), 12, true),
                Arguments.of(LocalDate.of(2022, 7, 2), 12, false),
                Arguments.of(LocalDate.of(2021, 7, 2), 36, true));
    }
}
