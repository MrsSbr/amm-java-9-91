package ru.alexanderhudyakov.lab3.restaurant.repository;

import ru.alexanderhudyakov.lab3.restaurant.Dish;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryDishRepository  implements  DishRepository{
    private final List<Dish> dishes;
    public InMemoryDishRepository(Collection<Dish> dishes){
        this.dishes= List.copyOf(dishes);
    }
    @Override
    public Stream<Dish> getDishesStream() {
        return dishes.stream();
    }
}
