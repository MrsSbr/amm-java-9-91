package ru.alexanderhudyakov.lab3.restaurant;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Restaurant {
    private final int ordersCount;
    private final Collection<Dish> orders;
    private final DishRepository dishRepository;
    public Restaurant(int ordersCount, Supplier<Collection<Dish>> collectionSupplier, DishRepository dishRepository) {
        this.ordersCount = ordersCount;
        this.dishRepository = dishRepository;
        Collection<Dish> temporalCollection = dishRepository
                .getDishesStream()
                .limit(ordersCount)
                .collect(collectionSupplier, Collection<Dish>::add, Collection<Dish>::addAll);
        this.orders = Collections.unmodifiableCollection(temporalCollection);

    }
    public int getOrdersCount() {
        return ordersCount;
    }
    public Collection<Dish> getOrders() {
        return orders;
    }
    public DishRepository getDishRepository() {
        return dishRepository;
    }
    public List<String> getUniqueDishes(){
        return orders
                .stream()
                .map(Dish::getName)
                .distinct()
                .collect(Collectors.toList());
    }
    public int getTotalIncome() {
        return  orders
                .stream()
                .mapToInt(Dish::getPrice)
                .sum();
    }
    public List<Dish> getMostExpensiveDishes(){
        return  orders
                .stream()
                .max(Comparator.comparingInt(Dish::getPrice))
                .map(max->orders
                        .stream()
                        .filter(x->x.getPrice()==max.getPrice())
                        .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }
}
