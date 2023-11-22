package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

// дата выполнения заказа; наименование торта; масса; стоимость
public class Order {
    private final LocalDate date;
    private final String name;
    private final double weight;
    private final BigDecimal cost;

    public Order(LocalDate date, String name, double weight, BigDecimal cost) {
        this.date = date;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Double.compare(order.weight, weight) == 0 &&
                Objects.equals(date, order.date) &&
                Objects.equals(name, order.name) &&
                Objects.equals(cost, order.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, weight, cost);
    }

    @Override
    public String toString() {
        return "Заказ: " +
                "название = '" + name + '\'' +
                ", вес = " + weight +
                ", стоимость = " + cost;
    }
}

