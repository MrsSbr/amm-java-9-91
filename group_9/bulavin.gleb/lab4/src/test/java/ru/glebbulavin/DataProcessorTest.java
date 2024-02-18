package ru.glebbulavin;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataProcessorTest extends TestCase {
    Collection<SaleRecord> records = List.of(new SaleRecord(LocalDate.of(2022,3, 15),
                    "Дилер 1","Автомобиль A","Базовая",new BigDecimal(5000)),
            new SaleRecord(LocalDate.of(2022,4,20),"Дилер 2",
                    "Автомобиль B","Расширенная",new BigDecimal(7000)),
            new SaleRecord(LocalDate.of(2023,5,25),"Дилер 1",
                    "Автомобиль A","Премиум",new BigDecimal(8000)),
            new SaleRecord(LocalDate.of(2023,6,30),"Дилер 3",
                    "Автомобиль C","Базовая",new BigDecimal(4500)),
            new SaleRecord(LocalDate.of(2024,7,15),"Дилер 2",
                    "Автомобиль A","Базовая",new BigDecimal(5500)),
            new SaleRecord(LocalDate.of(2024,8,20),"Дилер 1",
                    "Автомобиль B","Премиум",new BigDecimal(9500)),
            new SaleRecord(LocalDate.of(2024,9,25),"Дилер 3",
                    "Автомобиль B","Расширенная",new BigDecimal(8500)),
            new SaleRecord(LocalDate.of(2024,10,30),"Дилер 2",
                    "Автомобиль C","Премиум",new BigDecimal(9000)));
    @DisplayName("Find max markup in empty collection")
    public void testEmptyFindMaxMarkupDealershipPerCar(){
        DataProcessor processor = new DataProcessor(List.of());
        assertEquals(processor.findMaxMarkupDealershipPerCar(), Map.of());
    }
    @DisplayName("Find max markup in completed collection")
    public void testFindMaxMarkupDealershipPerCar() {
        DataProcessor processor = new DataProcessor(records);
        Map<String, String> result = processor.findMaxMarkupDealershipPerCar();
        assertEquals(result.size(), 3);
        assertEquals(result.get("Автомобиль A"), "Дилер 1");
        assertEquals(result.get("Автомобиль B"), "Дилер 1");
        assertEquals(result.get("Автомобиль C"), "Дилер 2");
    }
    @DisplayName("Find dealership with most unique configurations in empty collection")
    public void testEmptyFindDealershipWithMostUniqueConfigurations() {
        DataProcessor processor = new DataProcessor(List.of());
        assertNull(processor.findDealershipWithMostUniqueConfigurations());
    }
    @DisplayName("Find dealership with most unique configurations in completed collection")
    public void testFindDealershipWithMostUniqueConfigurations() {
        DataProcessor processor = new DataProcessor(records);
        String result = processor.findDealershipWithMostUniqueConfigurations();
        assertEquals(result, "Дилер 1");
    }
    @DisplayName("Calculate total earnings in empty collection")
    public void testEmptyCalculateTotalEarningsPerDealership() {
        DataProcessor processor = new DataProcessor(List.of());
        assertTrue(processor.calculateTotalEarningsPerDealership().isEmpty());
    }
    @DisplayName("Calculate total earnings in completed collection")
    public void testCalculateTotalEarningsPerDealership() {
        DataProcessor processor = new DataProcessor(records);
        Map<String, BigDecimal> result = processor.calculateTotalEarningsPerDealership();
        assertEquals(result.size(), 3);
        assertEquals(result.get("Дилер 1"), new BigDecimal(22500));
        assertEquals(result.get("Дилер 2"), new BigDecimal(21500));
        assertEquals(result.get("Дилер 3"), new BigDecimal(13000));
    }
}