package models;

import enums.Size;
import java.util.Objects;

public class Pants extends AbstractClothing {
    private final double length;

    public Pants(String color, double price, Size size, double length) {
        super(color, price, size);
        this.length = length;
    }

    @Override
    public void wear() {
        System.out.println("Надеваем штаны!");
    }

    @Override
    public void customize() {
        System.out.println("Кастомизируем штаны!");
    }

    public void iron() {
        System.out.println("Гладим штаны!");
    }

    @Override
    public String toString() {
        return "Штаны: " + super.toString() + " Длина: " + length;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }

        Pants pants = (Pants) object;

        return length == pants.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }

}