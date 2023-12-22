package org.example;

public class Gift {
    private final int year;
    private final GiftSize size;
    private final double weight;
    private final GiftType type;
    private final String color;

    public Gift(int year, GiftSize size, double weight, GiftType type, String color) {
        this.year = year;
        this.size = size;
        this.weight = weight;
        this.type = type;
        this.color = color;
    }


    public int getYear() {
        return year;
    }

    public GiftSize getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public GiftType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return year + ";" + size.name() + ";" + weight + ";" + type.name() + ";" + color;
    }
}
