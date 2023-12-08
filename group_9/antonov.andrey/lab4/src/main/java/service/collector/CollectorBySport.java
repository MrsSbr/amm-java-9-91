package service.collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import entity.OlympicStatistic;
import entity.Sport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CollectorBySport implements Collector<OlympicStatistic,
    Map<Sport, List<String>>,
    Map<Sport, List<String>>> {

    private final Predicate<OlympicStatistic> predicate;

    @Override
    public Supplier<Map<Sport, List<String>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Sport, List<String>>, OlympicStatistic> accumulator() {
        return (map, olympicStatistic) -> {
            if (predicate.test(olympicStatistic)) {
                final var defaultList = new ArrayList<String>();
                final var actualList = map.getOrDefault(olympicStatistic.getSport(), defaultList);
                actualList.add(olympicStatistic.getAthlete());
                map.put(olympicStatistic.getSport(), actualList);
            }
        };
    }

    @Override
    public BinaryOperator<Map<Sport, List<String>>> combiner() {
        return (map1, map2) -> {
            final var result = new HashMap<Sport, List<String>>();
            map2.forEach((k, v) -> {
                final var orDefault = new ArrayList<String>();
                final var actualList = result.getOrDefault(k, orDefault);
                actualList.addAll(v);
                result.put(k, actualList);
            });
            return result;
        };
    }

    @Override
    public Function<Map<Sport, List<String>>, Map<Sport, List<String>>> finisher() {
        return (map) -> {
            final var result = new HashMap<Sport, List<String>>();
            map.forEach((key, value) -> {
                final var distinctSortedNames = value
                    .stream()
                    .distinct()
                    .sorted()
                    .toList();
                result.put(key, distinctSortedNames);
            });
            return result;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
