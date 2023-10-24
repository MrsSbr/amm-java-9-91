package ru.alexanderhudyakov.lab3.restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alexanderhudyakov.lab3.restaurant.repository.DishRepository;
import ru.alexanderhudyakov.lab3.restaurant.repository.InMemoryDishRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class RestaurantTest {

    private final static List<Supplier<Collection<Dish>>> COLLECTIONS;
    private final static DishRepository REPOSITORY;

    private static final Set<String> UNIQUE;

    private static final Set<String> MOST_EXPENSIVE;

    private static final int TOTAL_PRICE;

    static {
        REPOSITORY = new InMemoryDishRepository(List.of(
                new Dish("Суши", Arrays.asList("Рис", "Рыба", "Васаби"), 300),
                new Dish("Рамен", Arrays.asList("Лапша", "Бульон", "Свинина", "Зеленый лук"), 500),
                new Dish("Темпура", Arrays.asList("Креветка", "Бобы", "Морковь", "Тесто", "Соус"), 500),
                new Dish("Такояки", Arrays.asList("Тесто", "Мини осьминог", "Имбирь"), 350),
                new Dish("Удон", Arrays.asList("Лапша удон", "Бульон", "Нори"), 400),
                new Dish("Удон", Arrays.asList("Лапша удон", "Бульон", "Нори"), 400)
        ));

        UNIQUE = Set.of(
                "Суши", "Рамен", "Темпура", "Такояки", "Удон"
        );
        MOST_EXPENSIVE = Set.of(
                "Рамен", "Темпура"
        );
        TOTAL_PRICE = 300 + 500 + 500 + 350 + 400 + 400;

        COLLECTIONS = List.of(
                ArrayList::new,
                LinkedList::new,
                Vector::new,
                HashSet::new,
                LinkedHashSet::new,
                () -> new TreeSet<>((d1, d2) ->
                {
                    if (d1 == d2) return 0;
                    if (d1.getPrice() < d2.getPrice()) return -1;
                    return 1;
                })
        );
    }
    @Test
    @DisplayName("Find unique dishes")
    void getUniqueDishes() {
        COLLECTIONS
                .stream()
                .map(x -> new Restaurant(x, REPOSITORY))
                .map(Restaurant::getUniqueDishes)
                .map(x -> x.stream().map(Dish::getName).collect(Collectors.toList()))
                .forEach(x -> assertTrue(x.containsAll(UNIQUE) && UNIQUE.containsAll(x)));
    }

    @Test
    @DisplayName("Count total income")
    void getTotalIncome() {
        COLLECTIONS
                .stream()
                .map(x->new Restaurant(x,REPOSITORY))
                .map(Restaurant::getTotalIncome)
                .forEach(x->assertEquals(TOTAL_PRICE, x));
    }

    @Test
    @DisplayName("Find most expensive dishes")
    void getMostExpensiveDishes() {
        COLLECTIONS
                .stream()
                .map(x->new Restaurant(x,REPOSITORY))
                .map(Restaurant::getMostExpensiveDishes)
                .map(x -> x.stream().map(Dish::getName).collect(Collectors.toList()))
                .forEach(x -> assertTrue(x.containsAll(MOST_EXPENSIVE) && MOST_EXPENSIVE.containsAll(x)));
    }
}