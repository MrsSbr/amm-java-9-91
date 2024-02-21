package org.example.plants;

import java.util.Objects;

public class PlantSaleEntry {
    private final String plantName;
    private final String plantType;
    private final String potSize;
    private final double price;
    private final String saleDate;

    public PlantSaleEntry(String plantName, String plantType, String potSize, double price, String saleDate) {
        this.plantName = plantName;
        this.plantType = plantType;
        this.potSize = potSize;
        this.price = price;
        this.saleDate = saleDate;
    }

    public String getName() {
        return plantName;
    }

    public String getType() {
        return plantType;
    }

    public String getPotSize() {
        return potSize;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantSaleEntry that = (PlantSaleEntry) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(plantName, that.plantName) &&
                Objects.equals(plantType, that.plantType) &&
                Objects.equals(potSize, that.potSize) &&
                Objects.equals(saleDate, that.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantName, plantType, potSize, price, saleDate);
    }
}
