import org.example.plants.PlantSaleEntryReader;
import org.example.plants.PlantSaleEntry;
import org.example.plants.PlantShopAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlantShopAnalyzerTest {

    @Test
    public void testFindMostBloomingMonth() {
        List<PlantSaleEntry> salesData = Arrays.asList(
                new PlantSaleEntry("Rose", "Flowering", "Medium", 20.0, "2023-01-15"),
                new PlantSaleEntry("Tulip", "Flowering", "Small", 15.0, "2023-01-20"),
                new PlantSaleEntry("Sunflower", "Non-Flowering", "Large", 25.0, "2023-01-10"),
                new PlantSaleEntry("Lily", "Flowering", "Medium", 18.0, "2023-02-15"),
                new PlantSaleEntry("Daisy", "Flowering", "Small", 12.0, "2023-02-25")
        );

        String result = PlantShopAnalyzer.findMostBloomingMonth(salesData);
        assertEquals("01", result);
    }

    @Test
    public void testFindPotSizesForPlants() {
        List<PlantSaleEntry> salesData = Arrays.asList(
                new PlantSaleEntry("Rose", "Flowering", "Medium", 20.0, "2023-01-15"),
                new PlantSaleEntry("Tulip", "Flowering", "Small", 15.0, "2023-01-20"),
                new PlantSaleEntry("Sunflower", "Non-Flowering", "Large", 25.0, "2023-02-10"),
                new PlantSaleEntry("Lily", "Flowering", "Medium", 18.0, "2023-02-15"),
                new PlantSaleEntry("Daisy", "Flowering", "Small", 12.0, "2023-02-25")
        );

        Map<String, List<String>> result = PlantShopAnalyzer.findPotSizesForPlants(salesData);

        assertEquals(5, result.size());
        assertEquals(List.of("Medium"), result.get("Rose"));
        assertEquals(List.of("Small"), result.get("Tulip"));
        assertEquals(List.of("Large"), result.get("Sunflower"));
        assertEquals(List.of("Medium"), result.get("Lily"));
        assertEquals(List.of("Small"), result.get("Daisy"));
    }

    @Test
    public void testFindLeastProfitablePlant() {
        List<PlantSaleEntry> salesData = Arrays.asList(
                new PlantSaleEntry("Rose", "Flowering", "Medium", 20.0, "2023-01-15"),
                new PlantSaleEntry("Tulip", "Flowering", "Small", 15.0, "2023-01-20"),
                new PlantSaleEntry("Sunflower", "Non-Flowering", "Large", 25.0, "2023-02-10"),
                new PlantSaleEntry("Lily", "Flowering", "Medium", 18.0, "2023-02-15"),
                new PlantSaleEntry("Daisy", "Flowering", "Small", 12.0, "2023-02-25")
        );

        String result = PlantShopAnalyzer.findLeastProfitablePlant(salesData);
        assertEquals("Daisy", result);
    }
}
