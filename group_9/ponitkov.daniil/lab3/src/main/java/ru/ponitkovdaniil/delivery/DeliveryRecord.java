package ru.ponitkovdaniil.delivery;

import java.time.LocalDate;

public class DeliveryRecord {
    private final LocalDate orderDate;
    private final double weight;
    private final int deliveryTime;  // предполагаемое время доставки в часах

    public DeliveryRecord(LocalDate orderDate, double weight, int deliveryTime) {
        this.orderDate = orderDate;
        this.weight = weight;
        this.deliveryTime = deliveryTime;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getWeight() {
        return weight;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }
}
