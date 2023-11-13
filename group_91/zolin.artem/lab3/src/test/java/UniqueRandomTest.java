import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.TreeSet;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UniqueRandomTest {

    static Stream<Arguments> allNumbersInRangeShouldBeUniquelyGenerated() {
        return Stream.of(
                arguments(0, 1),
                arguments(-1, 0),
                arguments(-1, 1),
                arguments(-100, 100),
                arguments(1000, 9999),
                arguments(-99, -9)
        );
    }

    static Stream<Arguments> invalidRangeShouldThrow() {
        return Stream.of(
                arguments(0, 0),
                arguments(-1, -1),
                arguments(10, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Все числа в указанном диапазоне должны быть сгенерированы без повторений")
    void allNumbersInRangeShouldBeUniquelyGenerated(int rangeMin, int rangeMax) {
        var uniqueRandom = new UniqueRandom(rangeMin, rangeMax);
        var set = new TreeSet<Integer>();
        while (uniqueRandom.hasNext()) {
            set.add(uniqueRandom.getNext());
        }
        assertThat(set).hasSize(rangeMax - rangeMin + 1);
        assertThat(set).first().isEqualTo(rangeMin);
        assertThat(set).last().isEqualTo(rangeMax);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("При некорректных диапазонах должна выбрасываться ошибка")
    void invalidRangeShouldThrow(int rangeMin, int rangeMax) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new UniqueRandom(rangeMin, rangeMax));
    }

}
