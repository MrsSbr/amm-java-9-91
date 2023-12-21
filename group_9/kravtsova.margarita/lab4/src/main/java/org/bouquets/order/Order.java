package org.bouquets.order;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final LocalDate datePurchase;
    private final BouquetType bouquetType;
    private final List<FlowersType> flowers;
    private final int price;
    private final ReceivingType receivingType;
    public Order(LocalDate datePurchase, BouquetType bouquetType, List<FlowersType> flowers, int price, ReceivingType receivingType) {
        this.datePurchase = datePurchase;
        this.bouquetType = bouquetType;
        this.flowers = flowers;
        this.price = price;
        this.receivingType = receivingType;
    }
    public LocalDate getDatePurchase() {
        return datePurchase;
    }
    public BouquetType getBouquetType() {
        return bouquetType;
    }
    public List<FlowersType> getFlowers() {
        return flowers;
    }
    public int getPrice() {
        return price;
    }
    public ReceivingType getReceivingType() {
        return receivingType;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        if (price != order.price) return false;
        if (!datePurchase.equals(order.datePurchase)) return false;
        if (bouquetType != order.bouquetType) return false;
        if (!flowers.equals(order.flowers)) return false;
        return receivingType == order.receivingType;
    }
    @Override
    public int hashCode() {
        int result = datePurchase.hashCode();
        result = 31 * result + bouquetType.hashCode();
        result = 31 * result + flowers.hashCode();
        result = 31 * result + price;
        result = 31 * result + receivingType.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Order{" +
                "datePurchase=" + datePurchase +
                ", bouquetType=" + bouquetType +
                ", flowers=" + flowers +
                ", price=" + price +
                ", receivingType=" + receivingType +
                '}';
    }
}
