package tasks;

import drinks.DrinkType;
import drinks.SoldDrink;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Set;

public interface SoldDrinkCollectionAnalyzer {
    Set<DrinkType> getMorningDrinks(@NotNull Collection<SoldDrink> collection);

    Set<DrinkType> getNotOrderedDrinksLastThreeMonths(@NotNull Collection<SoldDrink> collection);

    long getCappuccinoOrdersCount(@NotNull Collection<SoldDrink> collection);
}
