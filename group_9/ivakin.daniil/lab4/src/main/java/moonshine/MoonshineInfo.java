package moonshine;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MoonshineInfo {
    private static final Logger logger = Logger.getLogger(MoonshineInfo.class.getName());

    public Map<Ingredient, Double> getAvgBrewTimeForIngredients(List<Moonshine> moonshines) {
        logger.log(Level.INFO, "Вызов метода, находящего среднее время настаивания для ингредиентов");
        class HelperIngredientBrewTime {
            private final Ingredient ingredient;
            private final double brewTimeDays;

            public HelperIngredientBrewTime(Ingredient ingredient, double brewTimeDays) {
                this.ingredient = ingredient;
                this.brewTimeDays = brewTimeDays;
            }

            public Ingredient getIngredient() {
                return ingredient;
            }

            public double getBrewTimeDays() {
                return brewTimeDays;
            }
        }

        return moonshines.stream()
                .flatMap(moonshine -> moonshine.getIngredients().stream()
                        .map(ingredient -> new HelperIngredientBrewTime(ingredient, moonshine.getBrewTimeDays())))
                .collect(Collectors.groupingBy(HelperIngredientBrewTime::getIngredient,
                        Collectors.averagingDouble(HelperIngredientBrewTime::getBrewTimeDays)));
    }

    public Optional<Month> getMonthWithMaxIngredients(List<Moonshine> moonshines) {
        logger.log(Level.INFO, "Вызов метода, находящего месяц с наибольшим количеством ингредиентов");

        class HelperMonthIngredientCount {
            private final Month month;
            private final int ingredientCount;

            public HelperMonthIngredientCount(Month month, int ingredientCount) {
                this.month = month;
                this.ingredientCount = ingredientCount;
            }

            public Month getMonth() {
                return month;
            }

            public int getIngredientCount() {
                return ingredientCount;
            }
        }

        return moonshines.stream()
                .map(moonshine -> new HelperMonthIngredientCount(moonshine.getDate().getMonth(),
                        moonshine.getIngredients().size()))
                .collect(Collectors.groupingBy(HelperMonthIngredientCount::getMonth,
                        Collectors.summingInt(HelperMonthIngredientCount::getIngredientCount)))
                .entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

    public Map<String, Double> getTotalValueForMoonshines(List<Moonshine> moonshines) {
        logger.log(Level.INFO, "Вызов метода, находящего общий объём для каждой настойки");
        return moonshines.stream()
                .collect(Collectors.groupingBy(Moonshine::getName, Collectors.summingDouble(Moonshine::getVolume)));
    }
}
