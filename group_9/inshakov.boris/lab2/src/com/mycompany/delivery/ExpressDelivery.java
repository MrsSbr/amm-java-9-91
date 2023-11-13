package com.mycompany.delivery;

public class ExpressDelivery extends AbstractDelivery {

    private double price;

    public ExpressDelivery(String packageCode, String destination, double price) {
        super(packageCode, destination);
        this.price = price;
    }

    @Override
    public String deliver() {
        return "Express Delivery (price $" + price + ") to " + destination + " with package code " + packageCode;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "ExpressDelivery{" +
                "packageCode='" + packageCode + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    // Геттер для price
    public double getPrice() {
        return price;
    }

    // Сеттер для price
    public void setPrice(double price) {
        this.price = price;
    }

}