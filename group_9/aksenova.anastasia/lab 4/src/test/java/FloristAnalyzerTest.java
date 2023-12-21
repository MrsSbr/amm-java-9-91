
import main.FloristAnalyzer;
import main.FloristRecord;
import main.FlowerBouquet;
import org.junit.Test;
import java.util.Arrays;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class FloristAnalyzerTest {

    @Test
    public void testFindMostDiverseMonth() {
        FloristRecord floristRecord = new FloristRecord();

        FlowerBouquet bouquet1 = new FlowerBouquet("2023-01-01", "День рождения", Arrays.asList("Роза", "Лилия", "Тюльпан"), 50.0, "Доставка");
        FlowerBouquet bouquet2 = new FlowerBouquet("2023-01-15", "Юбилей", Arrays.asList("Роза", "Гвоздика"), 60.0, "Самовывоз");
        FlowerBouquet bouquet3 = new FlowerBouquet("2023-02-05", "День рождения", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Доставка");

        floristRecord.addRecord(bouquet1);
        floristRecord.addRecord(bouquet2);
        floristRecord.addRecord(bouquet3);

        FloristAnalyzer floristAnalyzer = new FloristAnalyzer(floristRecord);
        String mostDiverseMonth = floristAnalyzer.findMostDiverseMonth();

        assertEquals("01", mostDiverseMonth);
    }

    @Test
    public void testCalculateEarningsByBouquetType() {
        FloristRecord floristRecord = new FloristRecord();

        FlowerBouquet bouquet1 = new FlowerBouquet("2023-01-01", "День рождения", Arrays.asList("Роза", "Лилия", "Тюльпан"), 50.0, "Доставка");
        FlowerBouquet bouquet2 = new FlowerBouquet("2023-01-15", "Юбилей", Arrays.asList("Роза", "Гвоздика"), 60.0, "Самовывоз");
        FlowerBouquet bouquet3 = new FlowerBouquet("2023-02-05", "День рождения", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Доставка");

        floristRecord.addRecord(bouquet1);
        floristRecord.addRecord(bouquet2);
        floristRecord.addRecord(bouquet3);

        FloristAnalyzer floristAnalyzer = new FloristAnalyzer(floristRecord);
        Map<String, Double> earningsByBouquetType = floristAnalyzer.calculateEarningsByBouquetType();

        assertEquals(90.0, earningsByBouquetType.get("День рождения"), 0.01);
        assertEquals(60.0, earningsByBouquetType.get("Юбилей"), 0.01);
    }

    @Test
    public void testDetermineDeliveryPreferenceForEachFlower() {
        FloristRecord floristRecord = new FloristRecord();

        FlowerBouquet bouquet1 = new FlowerBouquet("2023-01-01", "День рождения", Arrays.asList("Роза", "Лилия", "Тюльпан"), 50.0, "Доставка");
        FlowerBouquet bouquet2 = new FlowerBouquet("2023-01-15", "Юбилей", Arrays.asList("Роза", "Гвоздика"), 60.0, "Самовывоз");
        FlowerBouquet bouquet3 = new FlowerBouquet("2023-02-05", "День рождения", Arrays.asList("Тюльпан", "Дейзи"), 40.0, "Доставка");

        floristRecord.addRecord(bouquet1);
        floristRecord.addRecord(bouquet2);
        floristRecord.addRecord(bouquet3);

        FloristAnalyzer floristAnalyzer = new FloristAnalyzer(floristRecord);
        Map<String, String> deliveryPreference = floristAnalyzer.determineDeliveryPreferenceForEachFlower();

        assertEquals("Доставка", deliveryPreference.get("День рождения"));
        assertEquals("Самовывоз", deliveryPreference.get("Юбилей"));
    }
}
