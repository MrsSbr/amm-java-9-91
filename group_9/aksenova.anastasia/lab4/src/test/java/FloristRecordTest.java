package test.java;
import main.java.FloristRecord;
import main.java.FlowerBouquet;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FloristRecordTest {

    @Test
    public void testAddRecord() {
        FloristRecord floristRecord = new FloristRecord();

        FlowerBouquet bouquet1 = new FlowerBouquet("2023-01-01", "День рождения", Arrays.asList("Роза", "Лилия", "Тюльпан"), 50.0, "Доставка");
        FlowerBouquet bouquet2 = new FlowerBouquet("2023-02-15", "Юбилей", Arrays.asList("Роза", "Гвоздика"), 60.0, "Самовывоз");

        floristRecord.addRecord(bouquet1);
        floristRecord.addRecord(bouquet2);

        List<FlowerBouquet> records = floristRecord.getRecords();
        assertEquals(2, records.size());
        assertEquals(bouquet1, records.get(0));
        assertEquals(bouquet2, records.get(1));
    }
}
