package statistics;

import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.ProcessingType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CoffeeSuppliesStatisticsImpl implements CoffeeSuppliesStatistics {
    @Override
    public Map<ProcessingType, Set<CoffeeSort>> findSortsByProcessingType(List<CoffeeRecord> records) {
        if (records == null) {
            return new HashMap<>();
        }
        return records.stream()
                .collect(Collectors.groupingBy(CoffeeRecord::processingType,
                        Collectors.mapping(CoffeeRecord::sort, Collectors.toSet())));
    }

    @Override
    public Set<String> findCountriesWithMoreThanHeight(List<CoffeeRecord> records, double height) {
        if (records == null) {
            return new HashSet<>();
        }
        return records.stream()
                .filter((coffeeRecord -> coffeeRecord.heightOfGrowth() > height))
                .map(CoffeeRecord::country)
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> findAllSortsCountForEachFarm(List<CoffeeRecord> records) {
        if (records == null) {
            return new HashMap<>();
        }
        return records.stream()
                .collect(Collectors.groupingBy(CoffeeRecord::farm,
                        Collectors.collectingAndThen(
                                Collectors.mapping(CoffeeRecord::sort, Collectors.toSet()),
                                Set::size)));
    }
}
