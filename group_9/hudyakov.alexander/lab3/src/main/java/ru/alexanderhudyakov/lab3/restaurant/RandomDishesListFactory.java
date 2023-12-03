package ru.alexanderhudyakov.lab3.restaurant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomDishesListFactory {
    private final RandomDishFactory factory = new RandomDishFactory();
    private final int count;

    public RandomDishesListFactory(int count) {
        this.count = count;
    }

    public List<Dish> getDishesList() {
        return Stream.generate(factory::getDish)
                .limit(count)
                .collect(Collectors.toList());
    }
}
