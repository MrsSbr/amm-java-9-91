package ru.alexanderhudyakov.lab3.restaurant.repository;

import ru.alexanderhudyakov.lab3.restaurant.Dish;

import java.util.stream.Stream;

public interface DishRepository {
    Stream<Dish> getDishesStream();
}
