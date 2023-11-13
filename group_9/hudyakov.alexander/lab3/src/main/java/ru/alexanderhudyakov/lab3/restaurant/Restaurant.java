package ru.alexanderhudyakov.lab3.restaurant;

import ru.alexanderhudyakov.lab3.restaurant.repository.DishRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Restaurant {
    private final Collection<Dish> orders;
    private final DishRepository dishRepository;

    public Restaurant(Supplier<Collection<Dish>> collectionSupplier, DishRepository dishRepository) {
        this.dishRepository = dishRepository;
        Collection<Dish> temporalCollection = dishRepository.getDishesStream()
                .collect(collectionSupplier, Collection<Dish>::add, Collection<Dish>::addAll);
        this.orders = Collections.unmodifiableCollection(temporalCollection);

    }

    public Collection<Dish> getOrders() {
        return orders;
    }

    public DishRepository getDishRepository() {
        return dishRepository;
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

        AtomicInteger max = new AtomicInteger(-1);
        dishes.forEach((key, value) -> {
            Dish dish = value.get(0);
            if (result.isEmpty() || max.get() == dish.getPrice()) {
                result.add(dish);
            } else if (max.get() < dish.getPrice()) {
                max.set(dish.getPrice());
                result.clear();
                result.add(dish);
            }
        });
        return result;
    }
}
