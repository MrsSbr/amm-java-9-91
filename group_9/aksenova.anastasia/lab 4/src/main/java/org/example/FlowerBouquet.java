package org.example;

import java.util.List;

public class FlowerBouquet {
    private String date;
    private String bouquetType;
    private List<String> bouquetComposition;
    private double cost;
    private String deliveryType;

    public FlowerBouquet(String date, String bouquetType, List<String> bouquetComposition, double cost, String deliveryType) {
        this.date = date;
        this.bouquetType = bouquetType;
        this.bouquetComposition = bouquetComposition;
        this.cost = cost;
        this.deliveryType = deliveryType;
    }

    public String getDate() {

        return date;
    }

    public String getBouquetType() {

        return bouquetType;
    }

    public List<String> getBouquetComposition() {

        return bouquetComposition;
    }

    public double getCost() {
        return cost;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
}
