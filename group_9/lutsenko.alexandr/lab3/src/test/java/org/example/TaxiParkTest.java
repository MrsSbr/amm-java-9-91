package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxiParkTest {

    @Test
    public void testFuelConsumptionAnalysis() {
        TaxiPark taxiPark = new TaxiPark(3); // Тестирование на 3 водителя и 1 день
        taxiPark.analyzeFuelConsumption(1);

        assertEquals(0.0, taxiPark.getTotalFuelConsumption(), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 1"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 2"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 3"), 0.01);
    }
}