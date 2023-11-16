package ru.alexanderhudyakov.lab3.restaurant;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Restaurant {
    private final Collection<Dish> orders;

    public Restaurant(Supplier<Collection<Dish>> collectionSupplier, Collection<Dish> dishCollection) {
        Collection<Dish> temporalCollection = dishCollection.stream()
                .collect(collectionSupplier, Collection<Dish>::add, Collection<Dish>::addAll);
        this.orders = Collections.unmodifiableCollection(temporalCollection);

    }

    public Collection<Dish> getOrders() {
        return orders;
    }

    public Collection<Dish> getUniqueDishes() {
        return orders.stream()
                .collect(Collectors.toMap(Dish::getName, Function.identity(), (e, r) -> e))
                .values();
    }

    public int getTotalIncome() {
        return orders.stream()
                .mapToInt(Dish::getPrice)
                .sum();
    }

    public Collection<Dish> getMostExpensiveDishes() {
        List<Dish> result = new ArrayList<>();

        Map<String, List<Dish>> dishes = orders.stream()
                .collect(Collectors.groupingBy(Dish::getName));

        dishes.forEach((key, value) -> {
            Dish dish = value.get(0);
            if (result.isEmpty() || result.get(0).getPrice() == dish.getPrice()) {
                result.add(dish);
            } else if (result.get(0).getPrice() < dish.getPrice()) {
                result.clear();
                result.add(dish);
            }
        });
        return result;
    }
}
