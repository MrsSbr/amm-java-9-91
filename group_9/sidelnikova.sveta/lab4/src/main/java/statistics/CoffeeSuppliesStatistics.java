package statistics;

import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.ProcessingType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CoffeeSuppliesStatistics {
    Map<ProcessingType, Set<CoffeeSort>> findSortsByProcessingType(List<CoffeeRecord> records);

    Set<String> findCountriesWithMoreThanHeight(List<CoffeeRecord> records, double height);

    Map<String, Integer> findAllSortsCountForEachFarm(List<CoffeeRecord> records);
}
