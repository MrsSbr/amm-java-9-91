package tasks;

import drinks.DrinkType;
import drinks.SoldDrink;
import solddrink.utils.SoldDrinkCollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;

public class CollectionPerformanceAnalyzer {
    private final Supplier<Collection<SoldDrink>> collectionSupplier;
    private Collection<SoldDrink> collection;
    private final int TEST_COUNT = 100;

    public CollectionPerformanceAnalyzer(Supplier<Collection<SoldDrink>> supplier) {
        this.collectionSupplier = supplier;
        this.collection = generateCollection();
    }
    public CollectionPerformanceAnalyzer(Supplier<Collection<SoldDrink>> supplier, Collection<SoldDrink> collection) {
        this.collectionSupplier = supplier;
        this.collection = collection;
        this.collection = createCollection();
    }

    public String getCollectionName() {
        return collection.getClass().getName();
    }
    public Collection<SoldDrink> getCollection() {
        return collection;
    }

    private Collection<SoldDrink> generateCollection() {
        return SoldDrinkCollectionUtils.fill(collectionSupplier, 10000);
    }

    private Collection<SoldDrink> createCollection() {
        return SoldDrinkCollectionUtils.wrap(collection, collectionSupplier);
    }

    public double getCollectionCreatingTotalTime() {
        //считается время без учета работы рандома.
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            collection = createCollection();

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }


    public double getMorningDrinksTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            Set<DrinkType> morningDrinks = SoldDrinkCollectionAnalyzer.getMorningDrinks(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }

    public double getNotOrderedDrinksLastThreeMonthsTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            Set<DrinkType> notOrderedDrinksLastThreeMonths =
                    SoldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;

    }

    public double getCappuccinoOrdersCountTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            int cappuccinoOrdersCount = SoldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }
}
