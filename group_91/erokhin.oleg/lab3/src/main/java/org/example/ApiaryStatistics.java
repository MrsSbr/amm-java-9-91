package org.example;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApiaryStatistics {
    private final Collection<Hive> hives;
    private final int years;

    public ApiaryStatistics(Supplier<Collection<Hive>> supplier, List<Hive> hives, int years) {
        this.hives = supplier.get();
        this.hives.addAll(hives);
        this.years = years;
    }

    public List<Double> totalHoneyProductionByYear() {
        return IntStream.range(0, years)
                .mapToObj(year -> hives
                        .stream()
                        .mapToDouble(hive -> hive.getHoneyProductions().get(year))
                        .sum())
                .collect(Collectors.toList());
    }

    public List<Double> totalHoneyByHive() {
        return hives.stream()
                .map(hive -> hive
                        .getHoneyProductions()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .sum())
                .collect(Collectors.toList());
    }
}
