package tasks;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.Set;

import drinks.DrinkType;
import drinks.SoldDrink;
import solddrink.utils.SoldDrinkCollectionUtils;

public class CollectionPerformanceAnalyzer {
    private final String collectionName;
    private final Supplier<Collection<SoldDrink>> collectionSupplier;
    private Collection<SoldDrink> collection;

    public CollectionPerformanceAnalyzer(String collectionName, Supplier<Collection<SoldDrink>> supplier) {
        this.collectionName = collectionName;
        this.collectionSupplier = supplier;
        this.collection = generateCollection();
    }

    public String getCollectionName() {
        return collectionName;
    }

    private Collection<SoldDrink> generateCollection() {
        return SoldDrinkCollectionUtils.fill(Collections.emptyList(), collectionSupplier);
    }

    private Collection<SoldDrink> createCollection() {
        return SoldDrinkCollectionUtils.wrap(collection, collectionSupplier);
    }

    public long getCollectionCreatingTotalTime() {
        //считается время без учета работы рандома.
        long startTime = System.currentTimeMillis();

        collection = createCollection();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getMorningDrinksTaskTotalTime() {
        long startTime = System.currentTimeMillis();

        Set<DrinkType> morningDrinks = SoldDrinkCollectionAnalyzer.getMorningDrinks(collection);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getNotOrderedDrinksLastThreeMonthsTaskTotalTime() {
        long startTime = System.currentTimeMillis();

        Set<DrinkType> notOrderedDrinksLastThreeMonths = SoldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(collection);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getCappuccinoOrdersCountTaskTotalTime() {
        long startTime = System.currentTimeMillis();

        int cappuccinoOrdersCount = SoldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(collection);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
