package classes;

import enums.Color;

public abstract class Product {
    private double price;
    private final Color color;

    public Product(Color color, double price) {
        this.price = price;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public abstract void inspect();

    public abstract void buy();

    public abstract void deliver();

}
