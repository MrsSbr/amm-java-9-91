package entities;

import java.util.Arrays;
import java.util.Optional;

public enum Drinks {
    RISTRETTO("ристретто", 100.0),
    CAPPUCCINO("каппучино", 120.0),
    LATTE("латте", 150.0),
    AMERICANO("американо", 90.0),
    CORTADO("кортадо", 140.0),
    ESPRESSO("эспрессо", 80.0);

    private final String name;
    private final double price;

    Drinks(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

