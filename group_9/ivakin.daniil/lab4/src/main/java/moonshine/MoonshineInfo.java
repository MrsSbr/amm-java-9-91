package moonshine;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoonshineInfo {
    public Map<Ingredient, Double> getAvgBrewTimeForIngredients(List<Moonshine> moonshines) {
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
        return moonshines.stream()
                .max(new Comparator<Moonshine>() {
                    @Override
                    public int compare(Moonshine o1, Moonshine o2) {
                        return o1.getIngredients().size() - o2.getIngredients().size();
                    }
                })
                .map(moonshine -> moonshine.getDate().getMonth());
    }

    public Map<String, Double> getTotalValueForMoonshines(List<Moonshine> moonshines) {
        return moonshines.stream()
                .collect(Collectors.groupingBy(Moonshine::getName, Collectors.summingDouble(Moonshine::getVolume)));
    }
}
