package ru.alexanderhudyakov.lab3.restaurant;

import java.util.stream.Stream;

public interface DishRepository {
    Stream<Dish> getDishesStream();
}
