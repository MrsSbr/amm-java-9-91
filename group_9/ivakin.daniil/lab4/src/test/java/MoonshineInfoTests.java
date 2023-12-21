import moonshine.Ingredient;
import moonshine.Moonshine;
import moonshine.MoonshineInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MoonshineInfoTests {
    private static final List<Moonshine> MOONSHINE_LIST = List.of(
            new Moonshine(LocalDate.of(2021, 1, 1), "Настойка1",
                    List.of(Ingredient.LEMON, Ingredient.LIME, Ingredient.JUICE), 200, 2),
            new Moonshine(LocalDate.of(2021, 2, 2), "Настойка2",
                    List.of(Ingredient.VODKA, Ingredient.VODKA, Ingredient.VODKA, Ingredient.VODKA),
                    1000, 4),
            new Moonshine(LocalDate.of(2021, 3, 3), "Настойка3",
                    List.of(Ingredient.LEMON, Ingredient.VODKA), 150, 1),
            new Moonshine(LocalDate.of(2021, 3, 4), "Настойка1",
                    List.of(Ingredient.LEMON, Ingredient.JUICE), 150, 2),
            new Moonshine(LocalDate.of(2021, 3, 5), "Настойка1",
                    List.of(Ingredient.LEMON, Ingredient.JUICE), 500, 2),
            new Moonshine(LocalDate.of(2021, 3, 5), "Настойка1",
                    List.of(Ingredient.LEMON, Ingredient.LIME, Ingredient.JUICE), 400, 1),
            new Moonshine(LocalDate.of(2021, 3, 5), "Настойка1",
                    List.of(Ingredient.LEMON, Ingredient.LIME, Ingredient.JUICE), 150, 1),
            new Moonshine(LocalDate.of(2021, 3, 6), "Настойка1",
                    List.of(Ingredient.LIME), 150, 2),
            new Moonshine(LocalDate.of(2021, 3, 6), "Настойка4",
                    List.of(Ingredient.SYRUP, Ingredient.JUICE), 500, 0),
            new Moonshine(LocalDate.of(2021, 3, 6), "Настойка4",
                    List.of(Ingredient.SYRUP, Ingredient.JUICE), 500, 0),
            new Moonshine(LocalDate.of(2021, 3, 6), "Настойка4",
                    List.of(Ingredient.SYRUP, Ingredient.JUICE), 500, 0)
    );

    private static final Map<Ingredient, Double> AVG_BREW_TIME_INGREDIENTS = Map.of(
            Ingredient.LEMON, 1.5,
            Ingredient.LIME, 1.5,
            Ingredient.SYRUP, 0.0,
            Ingredient.JUICE, 1.0,
            Ingredient.VODKA, 3.4
    );

    private static final Month MONTH_WITH_MOST_INGREDIENTS = Month.MARCH;

    private static final Map<String, Double> TOTAL_MOONSHINE_VOLUMES = Map.of(
            "Настойка1", 1550.0,
            "Настойка2", 1000.0,
            "Настойка3", 150.0,
            "Настойка4", 1500.0
    );

    private final MoonshineInfo moonshineInfo = new MoonshineInfo();

    @Test
    void getAvgBrewTimeForEachIngredient() {
        Map<Ingredient, Double> result = moonshineInfo.getAvgBrewTimeForIngredients(MOONSHINE_LIST);
        Assertions.assertEquals(AVG_BREW_TIME_INGREDIENTS, result);
    }

    @Test
    void getAvgBrewTimeForEachIngredientFromEmptyList() {
        Map<Ingredient, Double> result = moonshineInfo.getAvgBrewTimeForIngredients(List.of());
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void getMonthWithMostIngredients() {
        Optional<Month> result = moonshineInfo.getMonthWithMaxIngredients(MOONSHINE_LIST);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(MONTH_WITH_MOST_INGREDIENTS, result.get());
    }

    @Test
    void getMonthWithMostIngredientsFromEmptyList() {
        Optional<Month> result = moonshineInfo.getMonthWithMaxIngredients(List.of());
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void getTotalVolumeForEachMoonshine() {
        Map<String, Double> result = moonshineInfo.getTotalValueForMoonshines(MOONSHINE_LIST);
        Assertions.assertEquals(TOTAL_MOONSHINE_VOLUMES, result);
    }

    @Test
    void getTotalVolumeForEachMoonshineFromEmptyList() {
        Map<String, Double> result = moonshineInfo.getTotalValueForMoonshines(List.of());
        Assertions.assertTrue(result.isEmpty());
    }
}
