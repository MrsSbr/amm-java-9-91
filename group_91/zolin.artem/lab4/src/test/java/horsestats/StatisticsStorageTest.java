package horsestats;

import org.junit.jupiter.api.Test;
import raceresults.RaceResult;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsStorageTest {

    static final List<RaceResult> RESULTS = List.of(
            new RaceResult(LocalDate.now(), "Horse1", "Horse2", "Horse8"),
            new RaceResult(LocalDate.now(), "Horse4", "Horse5", "Horse6"),
            new RaceResult(LocalDate.now(), "Horse7", "Horse9", "Horse3"),
            new RaceResult(LocalDate.now(), "Horse6", "Horse9", "Horse2"),
            new RaceResult(LocalDate.now(), "Horse9", "Horse2", "Horse1"),
            new RaceResult(LocalDate.now(), "Horse4", "Horse9", "Horse1"),
            new RaceResult(LocalDate.now(), "Horse8", "Horse9", "Horse6"),
            new RaceResult(LocalDate.now(), "Horse1", "Horse7", "Horse2"),
            new RaceResult(LocalDate.now(), "Horse7", "Horse1", "Horse2"),
            new RaceResult(LocalDate.now(), "Horse5", "Horse4", "Horse1"),
            new RaceResult(LocalDate.now(), "Horse7", "Horse4", "Horse10")
    );
    static final List<HorseStatistics> EXPECTED_STATISTICS = List.of(
            new HorseStatistics("Horse1", 6, 13.0 / 6),
            new HorseStatistics("Horse2", 5, 13.0 / 5),
            new HorseStatistics("Horse3", 1, 3.0),
            new HorseStatistics("Horse4", 4, 6.0 / 4),
            new HorseStatistics("Horse5", 2, 3.0 / 2),
            new HorseStatistics("Horse6", 3, 7.0 / 3),
            new HorseStatistics("Horse7", 4, 5.0 / 4),
            new HorseStatistics("Horse8", 2, 4.0 / 2),
            new HorseStatistics("Horse9", 5, 9.0 / 5),
            new HorseStatistics("Horse10", 1, 3.0)
    );
    static final HorseStatistics EXPECTED_MOST_COMPETING_HORSE = EXPECTED_STATISTICS.get(0);
    static final HorseStatistics EXPECTED_MOST_PERFORMANT_HORSE = EXPECTED_STATISTICS.get(6);

    @Test
    void horseStatsShouldBeCalculatedCorrectly() {
        var storage = new StatisticsStorage(RESULTS);
        assertThat(storage.getStats().values()).containsExactlyInAnyOrderElementsOf(EXPECTED_STATISTICS);
        assertThat(storage.getMostCompetingHorse()).contains(EXPECTED_MOST_COMPETING_HORSE);
        assertThat(storage.getMostPerformantHorse()).contains(EXPECTED_MOST_PERFORMANT_HORSE);
    }

    @Test
    void emptyStorageShouldContainNulls() {
        var storage = new StatisticsStorage(List.of());
        assertThat(storage.getStats()).isEmpty();
        assertThat(storage.getMostPerformantHorse()).isEmpty();
        assertThat(storage.getMostCompetingHorse()).isEmpty();
    }

}
