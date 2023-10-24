package ru.alexanderhudyakov.lab3.restaurant;

import ru.alexanderhudyakov.lab3.restaurant.repository.DishRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Restaurant {
    private final Collection<Dish> orders;
    private final DishRepository dishRepository;
    public Restaurant(Supplier<Collection<Dish>> collectionSupplier, DishRepository dishRepository) {
        this.dishRepository = dishRepository;
        Collection<Dish> temporalCollection = dishRepository
                .getDishesStream()
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
        return orders
                .stream()
                .collect(Collectors.toMap(Dish::getName, Function.identity(), (e, r) -> e))
                .values();
    }
    public int getTotalIncome() {
        return orders
                .stream()
                .mapToInt(Dish::getPrice)
                .sum();
    }
    public Collection<Dish> getMostExpensiveDishes() {
        return orders
                .stream()
                .max(Comparator.comparingInt(Dish::getPrice))
                .map(max -> orders
                        .stream()
                        .filter(x -> x.getPrice() == max.getPrice())
                        .collect(Collectors.toMap(Dish::getName, Function.identity(), (e, r) -> e))
                        .values()
                )
                .orElseGet(Collections::emptyList);
    }
}
