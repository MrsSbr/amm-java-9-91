package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaxiParkTest {

    @Test
    public void testFuelConsumptionAnalysis() {
        TaxiPark taxiPark = new TaxiPark(3);
        taxiPark.analyzeFuelConsumption(1);
        taxiPark.resetFuelConsumption();

        assertEquals(0.0, taxiPark.getTotalFuelConsumption(), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 1"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 2"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 3"), 0.01);
    }

    @Test
    public void testFuelConsumptionAnalysisMultipleDays() {
        TaxiPark taxiPark = new TaxiPark(5);
        taxiPark.analyzeFuelConsumption(3);
        taxiPark.resetFuelConsumption();

        assertEquals(0.0, taxiPark.getTotalFuelConsumption(), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 1"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 2"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 3"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 4"), 0.01);
        assertEquals(0.0, taxiPark.getDriverFuelConsumption("Driver 5"), 0.01);
    }

    @Test
    public void testFuelConsumptionAnalysisZeroDrivers() {
        TaxiPark taxiPark = new TaxiPark(0);
        taxiPark.analyzeFuelConsumption(1);
        taxiPark.resetFuelConsumption();

        assertEquals(0.0, taxiPark.getTotalFuelConsumption(), 0.01);
    }
}