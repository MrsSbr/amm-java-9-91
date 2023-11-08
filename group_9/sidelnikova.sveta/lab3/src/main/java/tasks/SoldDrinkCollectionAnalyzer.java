package tasks;

import drinks.DrinkType;
import drinks.SoldDrink;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public final class SoldDrinkCollectionAnalyzer {
    public static Set<DrinkType> getMorningDrinks(@NotNull Collection<SoldDrink> collection) {
        return collection.stream()
                .filter(soldDrink -> soldDrink.saleTime().getHour() >= 7
                        && soldDrink.saleTime().getHour() <= 9)
                .map(SoldDrink::type)
                .collect(Collectors.toSet());
    }

    public static Set<DrinkType> getNotOrderedDrinksLastThreeMonths(@NotNull Collection<SoldDrink> collection) {
        Set<DrinkType> orderedDrinkTypes = collection.stream()
                .filter((soldDrink) -> {
                    return soldDrink.saleDate().compareTo(LocalDate.now().minusMonths(3)) >= 0;
                })
                .map(SoldDrink::type)
                .collect(Collectors.toSet());
        return Arrays.stream(DrinkType.values())
                .filter(drinkType -> !orderedDrinkTypes.contains(drinkType))
                .collect(Collectors.toSet());
    }

    public static int getCappuccinoOrdersCount(@NotNull Collection<SoldDrink> collection) {
        return (int) collection.stream()
                .filter(soldDrink -> soldDrink.type().equals(DrinkType.CAPPUCCINO))
                .count();
    }

}
