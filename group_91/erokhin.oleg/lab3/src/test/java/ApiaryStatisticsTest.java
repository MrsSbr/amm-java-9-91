import org.example.ApiaryStatistics;
import org.example.Hive;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiaryStatisticsTest {
    private final List<Hive> populatedHives = List.of(
            new Hive(Arrays.asList(100.0, 200.0, 150.0)),
            new Hive(Arrays.asList(80.0, 120.0, 100.0)),
            new Hive(Arrays.asList(200.0, 250.0, 300.0))
    );
    private final List<Hive> zeroProductionHives = List.of(
            new Hive(Arrays.asList(0.0, 0.0, 0.0)),
            new Hive(Arrays.asList(0.0, 0.0, 0.0))
    );
    private final List<Hive> emptyHives = Collections.emptyList();

    @Test
    public void testTotalHoneyProductionByYearWithPopulatedHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, populatedHives, 3);
        List<Double> expected = Arrays.asList(380.0, 570.0, 550.0);

        List<Double> actual = stats.totalHoneyProductionByYear();

        assertEquals(expected, actual);
    }

    @Test
    public void testTotalHoneyByHiveWithPopulatedHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, populatedHives, 3);
        List<Double> expected = Arrays.asList(450.0, 300.0, 750.0);

        List<Double> actual = stats.totalHoneyByHive();

        assertEquals(expected, actual);
    }

    @Test
    public void testTotalHoneyProductionByYearWithEmptyHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, emptyHives, 3);
        List<Double> expected = Arrays.asList(0.0, 0.0, 0.0);

        List<Double> actual = stats.totalHoneyProductionByYear();

        assertEquals(expected, actual);
    }

    @Test
    public void testTotalHoneyByHiveWithEmptyHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, emptyHives, 3);
        List<Double> expected = Collections.emptyList();

        List<Double> actual = stats.totalHoneyByHive();

        assertEquals(expected, actual);
    }

    @Test
    public void testTotalHoneyProductionByYearWithZeroProductionHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, zeroProductionHives, 3);
        List<Double> expected = Arrays.asList(0.0, 0.0, 0.0);

        List<Double> actual = stats.totalHoneyProductionByYear();

        assertEquals(expected, actual);
    }

    @Test
    public void testTotalHoneyByHiveWithZeroProductionHives() {
        ApiaryStatistics stats = new ApiaryStatistics(ArrayList::new, zeroProductionHives, 3);
        List<Double> expected = Arrays.asList(0.0, 0.0);

        List<Double> actual = stats.totalHoneyByHive();

        assertEquals(expected, actual);
    }
}