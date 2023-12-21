package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

// дата выполнения заказа; наименование торта; масса; стоимость
public record Order(LocalDate date, String name, double weight, BigDecimal cost) {

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
    public String toString() {
        return "Заказ: " +
                "название = '" + name + '\'' +
                ", вес = " + weight +
                ", стоимость = " + cost;
    }
}
