package ru.alexanderhudyakov.lab3.restaurant.repository;

import ru.alexanderhudyakov.lab3.restaurant.Dish;

import java.util.*;
import java.util.stream.Stream;

public class RandomDishRepository implements DishRepository{
    private static final List<Dish> DISHES;
    static {
        DISHES = List.of(
                new Dish("Суши", Arrays.asList("Рис", "Рыба", "Васаби"), 300),
                new Dish("Рамен", Arrays.asList("Лапша", "Бульон", "Свинина", "Зеленый лук"), 500),
                new Dish("Темпура", Arrays.asList("Креветка", "Бобы", "Морковь", "Тесто", "Соус"), 450),
                new Dish("Такояки", Arrays.asList("Тесто", "Мини осьминог", "Имбирь"), 350),
                new Dish("Удон", Arrays.asList("Лапша удон", "Бульон", "Нори"), 400),
                new Dish("Сасими", Arrays.asList("Рыба", "Редиска даикон"), 600),
                new Dish("Онигири", Arrays.asList("Рис", "Водоросли нори", "Наполнитель"), 150),
                new Dish("Мисо-ширу", Arrays.asList("Паста мисо", "Водоросли вакаме", "Тофу"), 250),
                new Dish("Гюдон", Arrays.asList("Рис", "Говядина", "Лук", "Соус"), 480),
                new Dish("Окономияки", Arrays.asList("Капуста", "Тесто", "Морепродукты", "Соус"), 520),
                new Dish("Якитори", Arrays.asList("Куриное мясо", "Соус таре"), 320),
                new Dish("Тофу в мисо соусе", Arrays.asList("Тофу", "Мисо паста", "Лук"), 280),
                new Dish("Кацудон", Arrays.asList("Рис", "Свинина в панировке", "Яйцо", "Лук"), 490),
                new Dish("Соба", Arrays.asList("Лапша соба", "Бульон", "Зеленый лук"), 410),
                new Dish("Тонкацу", Arrays.asList("Свинина в панировке", "Соус тонкацу"), 530),
                new Dish("Чаванмуси", Arrays.asList("Яйцо", "Бульон", "Креветка", "Курица"), 270),
                new Dish("Терияки", Arrays.asList("Курица", "Соус терияки"), 510),
                new Dish("Хиояйакко", Arrays.asList("Тофу", "Лук шалот", "Соевый соус"), 210),
                new Dish("Эдамаме", Arrays.asList("Молодая соя", "Соль"), 180),
                new Dish("Куримо", Arrays.asList("Рис", "Цветные добавки", "Начинка"), 230)
        );
    }
    private final int count;
    public RandomDishRepository(int count) {
        this.count = count;
    }
    @Override
    public Stream<Dish> getDishesStream() {
        return new Random()
                .ints(0, DISHES.size())
                .mapToObj(DISHES::get)
                .map(dish -> new Dish(dish.getName(), dish.getIngredients(), dish.getPrice()))
                .limit(count);
    }
}
