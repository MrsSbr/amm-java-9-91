package org.bouquets.order;

import java.time.LocalDate;
import java.util.List;

public class OrderBuilder {
    private LocalDate datePurchase;
    private BouquetType bouquetType;
    private List<String> flowers;
    private int price;
    private ReceivingType receivingType;
    public OrderBuilder setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
        return this;
    }
    public OrderBuilder setBouquetType(BouquetType bouquetType) {
        this.bouquetType = bouquetType;
        return this;
    }
    public OrderBuilder setFlowers(List<String> flowers) {
        this.flowers = flowers;
        return this;
    }
    public OrderBuilder setPrice(int price) {
        this.price = price;
        return this;
    }
    public OrderBuilder setReceivingType(ReceivingType receivingType) {
        this.receivingType = receivingType;
        return this;
    }
    public Order buildOrder() {
        return new Order(datePurchase, bouquetType, flowers, price, receivingType);
    }
}