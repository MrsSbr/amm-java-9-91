import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.ProcessingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import statistics.CoffeeSuppliesStatistics;
import statistics.CoffeeSuppliesStatisticsImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoffeeSuppliesStatisticsTest {
    private static CoffeeSuppliesStatistics statistics;

    private static List<CoffeeRecord> records;

    @BeforeAll
    public static void setUpStatistics() {
        statistics = new CoffeeSuppliesStatisticsImpl();
        records = new ArrayList<>() {{
            add(new CoffeeRecord(CoffeeSort.ARABICA,
                    "Бразилия", "Ферма StenoGuatemala", ProcessingType.WET, 1200));
            add(new CoffeeRecord(CoffeeSort.STENOFYLLA,
                    "Вьетнам", "Ферма RobustaValley", ProcessingType.WET, 1600));
            add(new CoffeeRecord(CoffeeSort.ARABICA,
                    "Индонезия", "Ферма ExcelFarms", ProcessingType.WET, 1500));
            add(new CoffeeRecord(CoffeeSort.EXCELSA,
                    "Индия", "Ферма №123", ProcessingType.NATURAL, 1800));
            add(new CoffeeRecord(CoffeeSort.ARABICA,
                    "Филиппины", "Ферма RobustaIndia", ProcessingType.HONEY, 2300));
            add(new CoffeeRecord(CoffeeSort.CANEPHORA,
                    "Индия", "Ферма №123", ProcessingType.HONEY, 1800));
        }};
    }

    @Test
    public void testFindSortsByProcessingType() {
        Map<ProcessingType, Set<CoffeeSort>> result = statistics.findSortsByProcessingType(records);

        Map<ProcessingType, Set<CoffeeSort>> expected = new HashMap<>() {{
            put(ProcessingType.NATURAL, new HashSet<>() {{
                add(CoffeeSort.EXCELSA);
            }});
            put(ProcessingType.HONEY, new HashSet<>() {{
                add(CoffeeSort.ARABICA);
                add(CoffeeSort.CANEPHORA);
            }});
            put(ProcessingType.WET, new HashSet<>() {{
                add(CoffeeSort.STENOFYLLA);
                add(CoffeeSort.ARABICA);
            }});
        }};

        Assertions.assertEquals(expected.entrySet(), result.entrySet());
    }

    @Test
    public void testFindCountriesWithMoreThanHeight() {
        Set<String> result = statistics.findCountriesWithMoreThanHeight(records, 1500);

        Set<String> expected = new HashSet<>() {{
            add("Вьетнам");
            add("Индия");
            add("Филиппины");
        }};

        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertTrue(result.containsAll(expected));

    }

    @Test
    public void testFindAllSortsCountForEachFarm() {
        Map<String, Integer> result = statistics.findAllSortsCountForEachFarm(records);

        Map<String, Integer> expected = new HashMap<>() {{
            put("Ферма StenoGuatemala", 1);
            put("Ферма RobustaValley", 1);
            put("Ферма ExcelFarms", 1);
            put("Ферма №123", 2);
            put("Ферма RobustaIndia", 1);
        }};

        Assertions.assertTrue(expected.keySet().containsAll(result.keySet()));
        Assertions.assertEquals(expected.keySet().size(), result.keySet().size());
        for (var key : expected.keySet()) {
            Assertions.assertEquals(expected.get(key), result.get(key));
        }

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testAllMethodsWithNullAndEmptyArray(List<CoffeeRecord> source) {
        Map<ProcessingType, Set<CoffeeSort>> result = statistics.findSortsByProcessingType(source);
        Assertions.assertEquals(0, result.size());

        Set<String> result2 = statistics.findCountriesWithMoreThanHeight(source, 1500);
        Assertions.assertEquals(0, result2.size());

        Map<String, Integer> result3 = statistics.findAllSortsCountForEachFarm(source);
        Assertions.assertEquals(0, result3.size());

    }
}
