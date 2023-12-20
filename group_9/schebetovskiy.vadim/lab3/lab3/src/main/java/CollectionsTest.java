import performance.PerformanceTester;
import performance.TimeMeasurement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

public class CollectionsTest {
    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester();
        printResults(tester.testCollection(ArrayList::new), "ArrayList");
        printResults(tester.testCollection(LinkedList::new), "LinkedList");
        printResults(tester.testCollection(HashSet::new), "HashSet");
    }

    private static void printResults(TimeMeasurement timeMeasurement, String collectionName) {
        System.out.printf("Результаты коллекции %s:\n", collectionName);
        System.out.println("\nВремя создания: " + timeMeasurement.getCreation() + " наносекунд");
        System.out.println("\nВремя нахождения списка типов птиц, которые хотя бы один раз произвели больше 20 яиц за последние 3 недели: "
                + timeMeasurement.getBirdTypesByCond() + " наносекунд");
        System.out.println("\nВремя нахождения самого продуктивного месяца: "
                + timeMeasurement.getTheMostProductiveMonth() + " наносекунд");
        System.out.println("\nВремя нахождения общего количества произведенных яиц: "
                + timeMeasurement.getTotalNumberOfEggsProduced() + " наносекунд\n\n");
    }
}