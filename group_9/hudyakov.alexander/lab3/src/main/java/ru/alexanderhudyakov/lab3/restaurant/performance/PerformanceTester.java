package ru.alexanderhudyakov.lab3.restaurant.performance;

import ru.alexanderhudyakov.lab3.restaurant.Dish;
import ru.alexanderhudyakov.lab3.restaurant.repository.RandomDishRepository;
import ru.alexanderhudyakov.lab3.restaurant.Restaurant;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PerformanceTester {
    private final static int ORDER_COUNT = 2431;
    private final Supplier<Collection<Dish>> collectionSupplier;
    private final String collectionName;
    private Restaurant restaurant;

    public PerformanceTester(Supplier<Collection<Dish>> collectionSupplier, String collectionName) {
        this.collectionSupplier = collectionSupplier;
        this.collectionName = collectionName;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public long getUniqueDishesExecutionTime() {
        return getMethodExecutionTime(restaurant::getUniqueDishes);
    }

    public long getTotalIncomeExecutionTime() {
        return getMethodExecutionTime(restaurant::getTotalIncome);
    }

    public long getMostExpensiveDishesExecutionTime() {
        return getMethodExecutionTime(restaurant::getMostExpensiveDishes);
    }

    public long getCreationTime() {
        return getMethodExecutionTime(() -> restaurant = new Restaurant(collectionSupplier, new RandomDishRepository(ORDER_COUNT)));
    }

    public ExecutionTime getAverageExecutionTime(int count) {

        long creation = 0;
        long totalIncome = 0;
        long uniqueDishes = 0;
        long mostExpensive = 0;
        for (int i = 0; i < count; i++) {
            creation += getCreationTime();
            totalIncome += getTotalIncomeExecutionTime();
            uniqueDishes += getUniqueDishesExecutionTime();
            mostExpensive += getMostExpensiveDishesExecutionTime();
        }
        return ExecutionTimeBuilder
                .anExecutionTime()
                .withCreation(creation / count)
                .withTotalIncome(totalIncome / count)
                .withUniqueDishes(uniqueDishes / count)
                .withMostExpensiveDishes(mostExpensive / count)
                .build();

    }

    private long getMethodExecutionTime(Runnable runnable) {
        long timeBeforeExecution = System.nanoTime();
        runnable.run();
        return System.nanoTime() - timeBeforeExecution;
    }
}
