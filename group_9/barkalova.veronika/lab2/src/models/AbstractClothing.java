package models;

import java.util.Objects;
import enums.Size;
import interfaces.ClothingItem;

public abstract class AbstractClothing implements ClothingItem {

    protected String color;

    protected double price;

    protected Size size;

    public AbstractClothing(String color, double price, Size size) {
        this.color = color;
        this.price = price;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public abstract void customize();

    @Override
    public void wear() {
        System.out.println("Надеваем одежду!");
    }

    @Override
    public String toString() {
        return "Цвет: " + color + ", Цена: $" + price + ", Размер: " + size;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        AbstractClothing clothing = (AbstractClothing) object;

        return price == clothing.price &&
                color.equals(clothing.color) &&
                size.equals(clothing.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price, size);
    }

}