
import main.FlowerBouquet;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FlowerBouquetTest {

    @Test
    public void testConstructorAndGetters() {
        String date = "2023-01-01";
        String bouquetType = "День рождения";
        List<String> bouquetComposition = Arrays.asList("Роза", "Лилия", "Тюльпан");
        double cost = 50.0;
        String deliveryType = "Доставка";

        FlowerBouquet bouquet = new FlowerBouquet(date, bouquetType, bouquetComposition, cost, deliveryType);

        assertEquals(date, bouquet.getDate());
        assertEquals(bouquetType, bouquet.getBouquetType());
        assertEquals(bouquetComposition, bouquet.getBouquetComposition());
        assertEquals(cost, bouquet.getCost(), 0.01);
        assertEquals(deliveryType, bouquet.getDeliveryType());
    }
}