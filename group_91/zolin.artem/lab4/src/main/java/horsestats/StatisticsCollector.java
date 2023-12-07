package horsestats;

import raceresults.RaceResult;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StatisticsCollector {

    private StatisticsCollector() {
    }

    public static Collector<RaceResult, ?, Map<String, HorseStatistics>> create() {
        return Collector.of(
                HashMap::new,
                StatisticsCollector::combine,
                StatisticsCollector::merge,
                StatisticsCollector::finish,
                Collector.Characteristics.UNORDERED
        );
    }

    private static void addRace(Map<String, IntermediateHorseStat> map, String name, int position) {
        var stat = map.get(name);
        if (stat == null) {
            map.put(name, new IntermediateHorseStat(position));
        } else {
            ++stat.racesCount;
            stat.positionAccumulator += position;
        }
    }

    private static void combine(Map<String, IntermediateHorseStat> map, RaceResult result) {
        addRace(map, result.nameOfFirst(), 1);
        addRace(map, result.nameOfSecond(), 2);
        addRace(map, result.nameOfThird(), 3);
    }

    private static Map<String, IntermediateHorseStat> merge(
            Map<String, IntermediateHorseStat> m1,
            Map<String, IntermediateHorseStat> m2
    ) {
        var result = new HashMap<>(m1);
        for (var e : m2.entrySet()) {
            result.merge(e.getKey(), e.getValue(), (stat1, stat2) -> {
                stat1.racesCount += stat2.racesCount;
                stat1.positionAccumulator += stat2.positionAccumulator;
                return stat1;
            });
        }
        return result;
    }

    private static Map<String, HorseStatistics> finish(Map<String, IntermediateHorseStat> stat) {
        return stat.entrySet().stream()
                .map(e -> {
                    var name = e.getKey();
                    int races = e.getValue().racesCount;
                    double averagePlace = e.getValue().positionAccumulator / (double) races;
                    return new HorseStatistics(name, races, averagePlace);
                })
                .collect(Collectors.toMap(HorseStatistics::horseName, Function.identity()));
    }

    private static class IntermediateHorseStat {
        private int racesCount = 1;
        private int positionAccumulator;

        private IntermediateHorseStat(int position) {
            positionAccumulator = position;
        }
    }

}
