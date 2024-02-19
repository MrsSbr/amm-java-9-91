package org.example;
import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private LocalDate date;
    private String courier;
    private String restaurant;
    private String items;
    private int deliveryTime;

    public Order(LocalDate date, String courier, String restaurant, String items, int deliveryTime) {
        this.date = date;
        this.courier = courier;
        this.restaurant = restaurant;
        this.items = items;
        this.deliveryTime = deliveryTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(date, order.date) &&
                Objects.equals(courier, order.courier) &&
                Objects.equals(restaurant, order.restaurant) &&
                Objects.equals(items, order.items) &&
                Objects.equals(deliveryTime, order.deliveryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, courier, restaurant, items, deliveryTime);
    }
}