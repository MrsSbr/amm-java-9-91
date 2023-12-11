package tasks;

import drinks.DrinkType;
import drinks.SoldDrink;
import org.jetbrains.annotations.NotNull;
import solddrink.utils.SoldDrinkFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CollectionPerformanceAnalyzer {
    private final SoldDrinkCollectionAnalyzer soldDrinkCollectionAnalyzer;
    private Collection<SoldDrink> collection;
    private final int TEST_COUNT = 100;

    public CollectionPerformanceAnalyzer(@NotNull Collection<SoldDrink> base) {
        base.clear();
        this.collection = base;
        this.collection = generateCollection();
        soldDrinkCollectionAnalyzer = new SoldDrinkCollectionAnalyzerImpl();
    }

    public CollectionPerformanceAnalyzer(@NotNull Collection<SoldDrink> base,
                                         @NotNull Collection<SoldDrink> collection) {
        base.clear();
        this.collection = base;
        this.collection = createCollectionFromAnother(collection);
        soldDrinkCollectionAnalyzer = new SoldDrinkCollectionAnalyzerImpl();
    }

    public String getCollectionName() {
        return collection.getClass().getName();
    }

    public Collection<SoldDrink> getCollection() {
        return collection;
    }

    private Collection<SoldDrink> generateCollection() {
        Collection<SoldDrink> newCollection = collection;
        for (int i = 0; i < 10000; i++) {
            newCollection.add(SoldDrinkFactory.generateSoldDrinkRecord());
        }
        return newCollection;
    }

    private Collection<SoldDrink> createCollectionFromAnother(Collection<SoldDrink> source) {
        Collection<SoldDrink> newCollection = collection;
        newCollection.addAll(source);
        return newCollection;
    }

    public double getCollectionCreatingTotalTime() {
        //считается время без учета работы рандома.
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            Collection<SoldDrink> imitationSource = new ArrayList<>(collection);
            collection.clear();
            long startTime = System.currentTimeMillis();

            collection = createCollectionFromAnother(imitationSource);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }


    public double getMorningDrinksTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            soldDrinkCollectionAnalyzer.getMorningDrinks(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }

    public double getNotOrderedDrinksLastThreeMonthsTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            soldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;

    }

    public double getCappuccinoOrdersCountTaskTotalTime() {
        double totalTime = 0;
        for (int i = 0; i < TEST_COUNT; i++) {
            long startTime = System.currentTimeMillis();

            soldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(collection);

            long endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime / TEST_COUNT;
    }
}
