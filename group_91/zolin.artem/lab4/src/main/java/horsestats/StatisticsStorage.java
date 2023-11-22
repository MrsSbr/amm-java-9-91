package horsestats;

import raceresults.RaceResult;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StatisticsStorage {

    private final Map<String, HorseStatistics> stats;
    private final HorseStatistics mostCompetingHorse;
    private final HorseStatistics mostPerformantHorse;

    public StatisticsStorage(List<RaceResult> results) {
        stats = results.stream().collect(StatisticsCollector.create());
        mostCompetingHorse = stats.values().stream()
                .max(Comparator.comparing(HorseStatistics::numberOfRaces))
                .orElse(null);
        mostPerformantHorse = stats.values().stream()
                .min(Comparator.comparing(HorseStatistics::averagePlace))
                .orElse(null);
    }

    public Map<String, HorseStatistics> getStats() {
        return Collections.unmodifiableMap(stats);
    }

    public HorseStatistics getHorseStat(String name) {
        return stats.getOrDefault(name, null);
    }

    public HorseStatistics getMostCompetingHorse() {
        return mostCompetingHorse;
    }

    public HorseStatistics getMostPerformantHorse() {
        return mostPerformantHorse;
    }

}
