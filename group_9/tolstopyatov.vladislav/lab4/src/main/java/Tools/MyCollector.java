package Tools;

import GameResources.Game;
import GameResources.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<Game,
        Map<Genre, List<Integer>>,
        Map<Genre, List<Integer>>> {

    @Override
    public Supplier<Map<Genre, List<Integer>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Genre, List<Integer>>, Game> accumulator() {
        return (map, game) -> {
            final var defaultList = new ArrayList<Integer>();
            final var actualList = map.getOrDefault(game.getGenre(), defaultList);
            actualList.add(game.getEstimation().getValue());
            map.put(game.getGenre(), actualList);
        };
    }

    @Override
    public BinaryOperator<Map<Genre, List<Integer>>> combiner() {
        return (map1, map2) -> {
            final var result = new HashMap<Genre, List<Integer>>();
            map2.forEach((k, v) -> {
                final var orDefault = new ArrayList<Integer>();
                final var actualList = result.getOrDefault(k, orDefault);
                actualList.addAll(v);
                result.put(k, actualList);
            });
            return result;
        };
    }

    @Override
    public Function<Map<Genre, List<Integer>>, Map<Genre, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
