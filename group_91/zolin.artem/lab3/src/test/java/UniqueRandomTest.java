import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UniqueRandomTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "-1, 0",
            "-1, 1",
            "-100, 100",
            "1000, 9999",
            "-99, -9"
    })
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
    @CsvSource({
            "0, 0",
            "-1, -1",
            "10, 1",
    })
    @DisplayName("При некорректных диапазонах должна выбрасываться ошибка")
    void invalidRangeShouldThrow(int rangeMin, int rangeMax) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new UniqueRandom(rangeMin, rangeMax));
    }

}
