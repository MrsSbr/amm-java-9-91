package ru.nikitaarsentev.analysis;

import ru.nikitaarsentev.entities.Company;
import ru.nikitaarsentev.factories.CompanyFactory;

import java.util.*;
import java.util.function.Supplier;

public class AnalysisOfTask {
    public static void main(String[] args) {
        double temp = 0;
        final int countPerformance = 5;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(LinkedList::new);
        }
        temp /= countPerformance;
        System.out.println("LinkedList::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(ArrayList::new);
        }
        temp /= countPerformance;
        System.out.println("ArrayList::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(HashSet::new);
        }
        temp /= countPerformance;
        System.out.println("HashSet::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(LinkedHashSet::new);
        }
        temp /= countPerformance;
        System.out.println("LinkedHashSet::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(Vector::new);
        }
        temp /= countPerformance;
        System.out.println("Vector::new = " + temp);
    }

    private static <T extends Collection<Long>>
    double performance(Supplier<T> factoryForNumber) {
        final int count_iteration = 100000;
        long finalTime = 0;
        long startTime;
        long endTime;
        for (int i = 0; i < count_iteration; ++i) {
            startTime = System.nanoTime();
            Company company = CompanyFactory.generateCompany(ArrayList::new, ArrayList::new, ArrayList::new);
            company.countResult(factoryForNumber);
            //company.outputResultWithoutRoute();
            endTime = System.nanoTime();
            finalTime += endTime - startTime;
        }
        double nanoToMile = 1e6;
        return finalTime / (count_iteration * nanoToMile);
    }
}
