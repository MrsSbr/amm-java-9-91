package edu.collection_performance;

import edu.best_car_survey.form.BestCarForm;
import edu.best_car_survey.survey.BestCarSurvey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;

public final class CollectionPerformanceAnalyzer {
    private CollectionPerformanceAnalyzer() {
    }

    private static int SURVEY_SAMPLE_SIZE = 1500;
    private static int RUNS_COUNT = 500;

    public static void main(String[] args) {
        CollectionPerformanceAnalyzer.printSurveyMethodsAverageExecutionTime(LinkedList::new);
        System.out.println();
        CollectionPerformanceAnalyzer.printSurveyMethodsAverageExecutionTime(ArrayList::new);
        System.out.println();
        CollectionPerformanceAnalyzer.printSurveyMethodsAverageExecutionTime(Vector::new);
        System.out.println();
    }

    public static void printSurveyMethodsAverageExecutionTime(Supplier<Collection<BestCarForm>> collectionSupplier) {
        System.out.println("Тип коллекции: " + collectionSupplier.get().getClass().getSimpleName());

        long totalGenerationTime = 0;
        long totalFindingMostPopularBrandTime = 0;
        long totalFindingMostPopularBrandsByAgeTime = 0;
        long totalGettingUniqueBrandsTime = 0;

        for (int i = 0; i < RUNS_COUNT; ++i) {
            long generationStart = System.nanoTime();
            BestCarSurvey survey = BestCarSurvey.generate(SURVEY_SAMPLE_SIZE, collectionSupplier);
            long generationEnd = System.nanoTime();
            totalGenerationTime += (generationEnd - generationStart);

            totalFindingMostPopularBrandTime += measureExecutionTime(survey::findMostPopularBrand);
            totalFindingMostPopularBrandsByAgeTime += measureExecutionTime(survey::findMostPopularBrandsByAge);
            totalGettingUniqueBrandsTime += measureExecutionTime(survey::getUniqueBrands);
        }

        System.out.println("Среднее время генерации: " + totalGenerationTime / RUNS_COUNT);
        System.out.println("Среднее время нахождения самой популярной марки автомобиля: "
                + totalFindingMostPopularBrandTime / RUNS_COUNT);
        System.out.println("Среднее время нахождения самых популярных марок авто в зависимости от возраста: "
                + totalFindingMostPopularBrandsByAgeTime / RUNS_COUNT);
        System.out.println("Среднее время получения списка уникальных брендов: "
                + totalGettingUniqueBrandsTime / RUNS_COUNT);

    }

    private static <T> long measureExecutionTime(Supplier<T> method) {
        long start = System.nanoTime();
        T methodResult = method.get();
        long end = System.nanoTime();
        return end - start;
    }
}
