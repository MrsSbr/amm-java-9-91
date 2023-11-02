package collectors;

import classes.ConstructionVehicle;
import utils.ConstructionVehicleUtil;

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

public class CollectorByClassName implements Collector<ConstructionVehicle,
        Map<String, List<ConstructionVehicle>>,
        Map<String, List<ConstructionVehicle>>> {

    @Override
    public Supplier<Map<String, List<ConstructionVehicle>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, List<ConstructionVehicle>>, ConstructionVehicle> accumulator() {
        return (map, element) -> {
            String type = ConstructionVehicleUtil.getNameClassConstructionMachine(element);
            List<ConstructionVehicle> orDefault = new ArrayList<>();
            List<ConstructionVehicle> constructionVehicles = map.getOrDefault(type, orDefault);
            constructionVehicles.add(element);
            map.put(type, constructionVehicles);
        };
    }

    @Override
    public BinaryOperator<Map<String, List<ConstructionVehicle>>> combiner() {
        return (map1, map2) -> {
            Map<String, List<ConstructionVehicle>> result = new HashMap<>(map1);
            map2.forEach((k, v) -> {
                List<ConstructionVehicle> newList = new ArrayList<>(v);
                List<ConstructionVehicle> list = result.getOrDefault(k, newList);
                result.put(k, list);
            });
            return result;
        };
    }

    @Override
    public Function<Map<String, List<ConstructionVehicle>>, Map<String, List<ConstructionVehicle>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
    }
}
