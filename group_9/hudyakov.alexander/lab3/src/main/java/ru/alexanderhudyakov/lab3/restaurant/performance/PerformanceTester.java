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
    public PerformanceTester(Supplier<Collection<Dish>> collectionSupplier, String collectionName){
        this.collectionSupplier = collectionSupplier;
        this.collectionName = collectionName;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public String getCollectionName() {
        return collectionName;
    }
    public long getUniqueDishesExecutionTime()
    {
        return getMethodExecutionTime(restaurant::getUniqueDishes);
    }
    public long getTotalIncomeExecutionTime()
    {
        return  getMethodExecutionTime(restaurant::getTotalIncome);
    }
    public long getMostExpensiveDishesExecutionTime()
    {
        return  getMethodExecutionTime(restaurant::getMostExpensiveDishes);
    }
    public long getCreationTime(){
        return getMethodExecutionTime(()->restaurant = new Restaurant(collectionSupplier, new RandomDishRepository(ORDER_COUNT)));
    }
    public ExecutionTime getExecutionTime(){
        return ExecutionTimeBuilder
                .anExecutionTime()
                .withCreation(getCreationTime())
                .withUniqueDishes(getUniqueDishesExecutionTime())
                .withTotalIncome(getTotalIncomeExecutionTime())
                .withMostExpensiveDishes(getMostExpensiveDishesExecutionTime())
                .build();
    }
    public ExecutionTime getAverageExecutionTime(int count){
        return Stream.generate(this::getExecutionTime)
                .limit(count)
                .reduce((x, y) ->
                    ExecutionTimeBuilder
                            .anExecutionTime()
                            .withCreation(x.getCreation() + y.getCreation())
                            .withUniqueDishes(x.getUniqueDishes() + y.getUniqueDishes())
                            .withTotalIncome(x.getTotalIncome() + y.getTotalIncome())
                            .withMostExpensiveDishes(x.getMostExpensiveDishes() + y.getMostExpensiveDishes())
                            .build()
                )
                .map(x-> {
                    x.setCreation(x.getCreation() / count);
                    x.setTotalIncome(x.getTotalIncome() / count);
                    x.setUniqueDishes(x.getUniqueDishes() / count);
                    x.setMostExpensiveDishes(x.getMostExpensiveDishes() / count);
                    return x;
                })
                .orElseGet(()->new ExecutionTime(0,0,0,0));
    }
    private long getMethodExecutionTime(Runnable runnable)
    {
        long timeBeforeExecution = System.nanoTime();
        runnable.run();
        return System.nanoTime() - timeBeforeExecution;
    }
}
