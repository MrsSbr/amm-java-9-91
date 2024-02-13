package ru.nikitaarsentev.analysis;

import ru.nikitaarsentev.entities.DayInRoute;
import ru.nikitaarsentev.entities.PeriodInRoute;
import ru.nikitaarsentev.factories.CompanyFactory;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

public class AnalysisOfContainerCreation {
    public static int DURABILITY_FOR_TEST = 300;
    public static int COUNT_ROUTES_FOR_TEST = 30;
    public static int COUNT_CREATE = 5000;

    public static void main(String[] args) {
        double temp = 0;
        final int countPerformance = 5;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(LinkedList::new, LinkedList::new, LinkedList::new);
        }
        temp /= countPerformance;
        System.out.println("LinkedList::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(ArrayList::new, ArrayList::new, ArrayList::new);
        }
        temp /= countPerformance;
        System.out.println("ArrayList::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(HashSet::new, HashSet::new, HashSet::new);
        }
        temp /= countPerformance;
        System.out.println("HashSet::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(LinkedHashSet::new, LinkedHashSet::new, LinkedHashSet::new);
        }
        temp /= countPerformance;
        System.out.println("LinkedHashSet::new = " + temp);
        temp = 0;
        for (int i = 0; i < countPerformance; ++i) {
            temp += performance(Vector::new, Vector::new, Vector::new);
        }
        temp /= countPerformance;
        System.out.println("Vector::new = " + temp);
    }

    private static <T1 extends Collection<PeriodInRoute>,
            T2 extends Collection<DayInRoute>,
            T3 extends Collection<LocalDate>>
    double performance(Supplier<T1> factoryForPeriodInRoute,
                       Supplier<T2> factoryForDayInRoute,
                       Supplier<T3> factoryForLocalDate) {
        long finalTime = 0;
        long startTime;
        long endTime;
        for (int i = 0; i < COUNT_CREATE; ++i) {
            startTime = System.nanoTime();
            CompanyFactory.generateCompany(DURABILITY_FOR_TEST, COUNT_ROUTES_FOR_TEST,
                    factoryForPeriodInRoute, factoryForDayInRoute, factoryForLocalDate);
            endTime = System.nanoTime();
            finalTime += endTime - startTime;
        }
        double nanoToMile = 1e6;
        return finalTime / (COUNT_CREATE * nanoToMile);
    }
}
