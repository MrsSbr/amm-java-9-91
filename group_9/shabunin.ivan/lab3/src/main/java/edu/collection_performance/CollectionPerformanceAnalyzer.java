package edu.collection_performance;

import edu.best_car_survey.form.BestCarForm;
import edu.best_car_survey.survey.BestCarSurvey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;

public class CollectionPerformanceAnalyzer {
    private static int SURVEY_SAMPLE_SIZE = 1500;

    Supplier<Collection<BestCarForm>> collectionSupplier;

    CollectionPerformanceAnalyzer(Supplier<Collection<BestCarForm>> collectionSupplier) {
        this.collectionSupplier = collectionSupplier;
    }

    public static void main(String[] args) {
        CollectionPerformanceAnalyzer linkedListAnalyzer = new CollectionPerformanceAnalyzer(LinkedList::new);
        CollectionPerformanceAnalyzer arrayListAnalyzer = new CollectionPerformanceAnalyzer(ArrayList::new);
        CollectionPerformanceAnalyzer vectorAnalyzer = new CollectionPerformanceAnalyzer(Vector::new);

        linkedListAnalyzer.printSurveyMethodsExecutionTime();
        System.out.println();
        arrayListAnalyzer.printSurveyMethodsExecutionTime();
        System.out.println();
        vectorAnalyzer.printSurveyMethodsExecutionTime();
        System.out.println();
    }

    public void printSurveyMethodsExecutionTime() {
        System.out.println("Тип коллекции: " + collectionSupplier.get().getClass().getSimpleName());

        long generationStart = System.nanoTime();
        BestCarSurvey survey = BestCarSurvey.generate(SURVEY_SAMPLE_SIZE, collectionSupplier);
        long generationEnd = System.nanoTime();
        System.out.println("Время генерации: " + (generationEnd - generationStart));

        System.out.println("Время нахождения самой популярной марки автомобиля: "
                + measureExecutionTime(survey::findMostPopularBrand));
        System.out.println("Время нахождения самых популярных марок авто в зависимости от возраста: "
                + measureExecutionTime(survey::findMostPopularBrandsByAge));
        System.out.println("Время получения списка уникальных брендов: "
                + measureExecutionTime(survey::getUniqueBrands));

    }

    private <T> long measureExecutionTime(Supplier<T> method) {
        long start = System.nanoTime();
        T methodResult = method.get();
        long end = System.nanoTime();
        return end - start;
    }
}
