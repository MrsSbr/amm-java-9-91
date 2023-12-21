import org.junit.jupiter.api.Test;
import ru.ponitkovdaniil.delivery.DeliveryAnalysis;
import ru.ponitkovdaniil.delivery.DeliveryRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryAnalysisTest {

    @Test
    public void testCalculateAverageDeliveryTime() {
        DeliveryRecord record1 = new DeliveryRecord(LocalDate.now(), 5.0, 2);
        DeliveryRecord record2 = new DeliveryRecord(LocalDate.now(), 7.0, 3);
        DeliveryRecord record3 = new DeliveryRecord(LocalDate.now(), 3.0, 1);

        Collection<DeliveryRecord> records = Arrays.asList(record1, record2, record3);

        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(records);
        double averageDeliveryTime = deliveryAnalysis.calculateAverageDeliveryTime();

        assertEquals((1 + 2 + 3) / 3, averageDeliveryTime, 0.01);
    }

    @Test
    void testCalculateTotalWeight() {
        DeliveryRecord record1 = new DeliveryRecord(LocalDate.now(), 5.0, 2);
        DeliveryRecord record2 = new DeliveryRecord(LocalDate.now(), 7.0, 3);
        DeliveryRecord record3 = new DeliveryRecord(LocalDate.now(), 3.0, 1);

        Collection<DeliveryRecord> records = Arrays.asList(record1, record2, record3);

        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(records);
        double totalWeight = deliveryAnalysis.calculateTotalWeight();

        assertEquals(5.0 + 7.0 + 3.0, totalWeight, 0.01);
    }

    @Test
    void testCalculateAverageDeliveryTimeWithEmptyCollection() {
        Collection<DeliveryRecord> records = new ArrayList<>();
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(records);
        double averageDeliveryTime = deliveryAnalysis.calculateAverageDeliveryTime();
        assertEquals(0, averageDeliveryTime, 0.01);
    }

    @Test
    void testCalculateAverageDeliveryTimeWithNullCollection() {
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(null);
        assertThrows(NullPointerException.class, deliveryAnalysis::calculateAverageDeliveryTime);
    }

    @Test
    void testFindMaxOrderDaysLastMonthWithEmptyCollection() {
        Collection<DeliveryRecord> records = new ArrayList<>();
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(records);
        List<LocalDate> maxOrderDays = deliveryAnalysis.findMaxOrderDaysLastMonth();
        assertTrue(maxOrderDays.isEmpty());
    }

    @Test
    void testFindMaxOrderDaysLastMonthWithNullCollection() {
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(null);
        assertThrows(NullPointerException.class, deliveryAnalysis::findMaxOrderDaysLastMonth);
    }

    @Test
    void testCalculateTotalWeightWithEmptyCollection() {
        Collection<DeliveryRecord> records = new ArrayList<>();
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(records);
        double totalWeight = deliveryAnalysis.calculateTotalWeight();
        assertEquals(0, totalWeight, 0.01);
    }

    @Test
    void testCalculateTotalWeightWithNullCollection() {
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(null);
        assertThrows(NullPointerException.class, deliveryAnalysis::calculateTotalWeight);
    }
}

