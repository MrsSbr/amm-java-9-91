import main.FloristApp;
import main.FloristRecord;
import main.FlowerBouquet;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FloristAppTest {

    @Test
    public void testFindMostDiverseMonth() {
        FloristRecord floristRecord = new FloristRecord();
        floristRecord.addRecord(new FlowerBouquet("2023-01-01", "Букет1", Arrays.asList("Роза", "Лилия"), 50.0, "Доставка"));
        floristRecord.addRecord(new FlowerBouquet("2023-02-01", "Букет2", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Самовывоз"));
        floristRecord.addRecord(new FlowerBouquet("2023-01-15", "Букет3", Arrays.asList("Роза", "Тюльпан", "Лилия"), 70.0, "Доставка"));

        String result = FloristApp.findMostDiverseMonth(floristRecord);

        assertEquals("01", result);
    }

    @Test
    public void testCalculateEarningsByBouquetType() {
        FloristRecord floristRecord = new FloristRecord();
        floristRecord.addRecord(new FlowerBouquet("2023-01-01", "Букет1", Arrays.asList("Роза", "Лилия"), 50.0, "Доставка"));
        floristRecord.addRecord(new FlowerBouquet("2023-02-01", "Букет2", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Самовывоз"));
        floristRecord.addRecord(new FlowerBouquet("2023-01-15", "Букет3", Arrays.asList("Роза", "Тюльпан", "Лилия"), 70.0, "Доставка"));

        Map<String, Double> result = FloristApp.calculateEarningsByBouquetType(floristRecord);

        assertEquals(Optional.of(120.0), result.get("Букет1"));
        assertEquals(Optional.of(40.0), result.get("Букет2"));
    }

    void testDetermineDeliveryPreferenceForEachFlower() {
        FloristRecord floristRecord = new FloristRecord();
        floristRecord.addRecord(new FlowerBouquet("2023-01-01", "Букет1", Arrays.asList("Роза", "Лилия"), 50.0, "Доставка"));
        floristRecord.addRecord(new FlowerBouquet("2023-02-01", "Букет2", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Самовывоз"));
        floristRecord.addRecord(new FlowerBouquet("2023-01-15", "Букет3", Arrays.asList("Роза", "Тюльпан", "Лилия"), 70.0, "Доставка"));

        Map<String, String> result = FloristApp.determineDeliveryPreferenceForEachFlower(floristRecord);

        assertEquals("Доставка", result.get("Роза"));
        assertEquals("Самовывоз", result.get("Тюльпан"));
        assertEquals("Доставка", result.get("Лилия"));
        assertEquals("Самовывоз", result.get("Дейзи"));
    }
}
