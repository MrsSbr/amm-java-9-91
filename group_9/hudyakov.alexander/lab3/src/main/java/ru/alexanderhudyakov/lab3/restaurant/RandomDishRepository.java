package ru.alexanderhudyakov.lab3.restaurant;

import java.util.*;
import java.util.stream.Stream;

public class RandomDishRepository implements DishRepository{

    private static final List<Dish> DISHES;

    static {
        List<Dish> tempDishes = new ArrayList<>();
        tempDishes.add(new Dish("Суши", Arrays.asList("Рис", "Рыба", "Васаби"), 300));
        tempDishes.add(new Dish("Рамен", Arrays.asList("Лапша", "Бульон", "Свинина", "Зеленый лук"), 500));
        tempDishes.add(new Dish("Темпура", Arrays.asList("Креветка", "Бобы", "Морковь", "Тесто", "Соус"), 450));
        tempDishes.add(new Dish("Такояки", Arrays.asList("Тесто", "Мини осьминог", "Имбирь"), 350));
        tempDishes.add(new Dish("Удон", Arrays.asList("Лапша удон", "Бульон", "Нори"), 400));
        tempDishes.add(new Dish("Сасими", Arrays.asList("Рыба", "Редиска даикон"), 600));
        tempDishes.add(new Dish("Онигири", Arrays.asList("Рис", "Водоросли нори", "Наполнитель"), 150));
        tempDishes.add(new Dish("Мисо-ширу", Arrays.asList("Паста мисо", "Водоросли вакаме", "Тофу"), 250));
        tempDishes.add(new Dish("Гюдон", Arrays.asList("Рис", "Говядина", "Лук", "Соус"), 480));
        tempDishes.add(new Dish("Окономияки", Arrays.asList("Капуста", "Тесто", "Морепродукты", "Соус"), 520));
        tempDishes.add(new Dish("Якитори", Arrays.asList("Куриное мясо", "Соус таре"), 320));
        tempDishes.add(new Dish("Тофу в мисо соусе", Arrays.asList("Тофу", "Мисо паста", "Лук"), 280));
        tempDishes.add(new Dish("Кацудон", Arrays.asList("Рис", "Свинина в панировке", "Яйцо", "Лук"), 490));
        tempDishes.add(new Dish("Соба", Arrays.asList("Лапша соба", "Бульон", "Зеленый лук"), 410));
        tempDishes.add(new Dish("Тонкацу", Arrays.asList("Свинина в панировке", "Соус тонкацу"), 530));
        tempDishes.add(new Dish("Чаванмуси", Arrays.asList("Яйцо", "Бульон", "Креветка", "Курица"), 270));
        tempDishes.add(new Dish("Терияки", Arrays.asList("Курица", "Соус терияки"), 510));
        tempDishes.add(new Dish("Хиояйакко", Arrays.asList("Тофу", "Лук шалот", "Соевый соус"), 210));
        tempDishes.add(new Dish("Эдамаме", Arrays.asList("Молодая соя", "Соль"), 180));
        tempDishes.add(new Dish("Куримо", Arrays.asList("Рис", "Цветные добавки", "Начинка"), 230));
        DISHES = Collections.unmodifiableList(tempDishes);
    }
    @Override
    public Stream<Dish> getDishesStream() {
        return new Random()
                .ints(0, DISHES.size())
                .mapToObj(DISHES::get)
                .map(dish -> new Dish(dish.getName(), dish.getIngredients(), dish.getPrice()));
    }
}
