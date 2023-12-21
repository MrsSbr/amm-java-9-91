import Court.performance.PerformanceTester;
import Court.performance.TimeMeasurement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class CollectionsTest {
    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester();
        printResults(tester.testCollection(ArrayList::new), "ArrayList");
        printResults(tester.testCollection(LinkedList::new), "LinkedList");
        printResults(tester.testCollection(Vector::new), "Vector");
        printResults(tester.testCollection(HashSet::new), "HashSet");
        printResults(tester.testCollection(LinkedHashSet::new), "LinkedHashSet");
    }

    private static void printResults(TimeMeasurement result, String collection_name) {
        System.out.printf("Результаты коллекции %s:\n", collection_name);
        System.out.printf("Время создания: %d\n", result.getCreation());
        System.out.printf("Время подсчета участников суда без осуждений: %d\n", result.getUnsuitedPeopleCount());
        System.out.printf("Время нахождения участников суда по более чем по 1 статье за последние 10 лет: %d\n", result.getPeopleWithClausesInTenYears());
        System.out.printf("Время нахождения истцов, которые подавали в суд больше 1 раза за последние 3 года: %d\n\n", result.getPeopleWithSuitsInThreeYears());
    }
}