package models;

import enums.Size;

public class Shirt extends AbstractClothing {

    public Shirt(String color, double price, Size size) {
        super(color, price, size);
    }

    @Override
    public void wear() {
        System.out.println("Надеваем рубашку!");
    }

    @Override
    public void customize() {
        System.out.println("Кастомизируем рубашку!");
    }

    public void fold() {
        System.out.println("Складываем рубашку!");
    }

    @Override
    public String toString() {
        return "Рубашка: " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}