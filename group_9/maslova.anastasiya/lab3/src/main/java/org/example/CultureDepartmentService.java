package org.example;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.example.StudentStatistics.addStudents;
import static org.example.StudentStatistics.randomAddStudents;

public class CultureDepartmentService {
    private static final int CNT_OF_TEST = 50;

    public static void printMainMenu() {
        System.out.println("\n\n1. Проверка работы");
        System.out.println("2. Ввод случайных чисел и сравнение коллекций");
        System.out.println("0. Выход");
    }

    public static void testing() {
        List<Student> studentList = addStudents();// заполнение студентами

        StudentStatistics studentStatistics = new StudentStatistics(studentList);

        printNumberOfTickets(studentStatistics);
        printTheMostPopularShows(studentStatistics);
        printShowsForWhichTicketsWerePurchased(studentStatistics);
    }

    private static void printNumberOfTickets(StudentStatistics stats) {
        System.out.println("Количество билетов, заказанных на каждый спектакль");
        List<Integer> numberOfTickets = stats.numberOfTicketsBookedForEachShow();
        IntStream.range(0, numberOfTickets.size())
                .mapToObj(i -> "Спектакль " + ShowName.values()[i].getShowTitle() + " кол-во билетов: " + numberOfTickets.get(i))
                .forEach(System.out::println);
    }

    private static void printTheMostPopularShows(StudentStatistics stats) {
        System.out.println("\nСамый популярный спектакль (следует учесть вариант, что может быть несколько таких спектаклей)");
        stats.theMostPopularShow()
                .stream()
                .map(showName -> showName.getShowTitle() + " ")
                .forEach(System.out::print);
    }

    private static void printShowsForWhichTicketsWerePurchased(StudentStatistics stats) {
        System.out.println("\n\nСпектакль (спектакли), на который решили приобрести билеты");
        stats.showForWhichPurchasedTickets()
                .stream()
                .map(showName -> showName.getShowTitle() + "; ")
                .forEach(System.out::print);
    }

    public static void performanceTest() {
        testAndPrintPerformance(HashSet::new, "HashSet");
        testAndPrintPerformance(LinkedList::new, "LinkedList");
        testAndPrintPerformance(ArrayList::new, "ArrayList");
    }

    private static void testAndPrintPerformance(Supplier<Collection<Student>> collectionSupplier, String collectionName) {
        long averageTime = compare(collectionSupplier);
        System.out.println("\nСреднее время выполнения для " + collectionName + ": " + averageTime + " наносекунд");
    }

    private static long compare(Supplier<Collection<Student>> collectionSupplier) {
        long totalTime = 0;
        Collection<Student> studentCollection = randomAddStudents(collectionSupplier);

        StudentStatistics studentStatistics = new StudentStatistics(studentCollection);
        for (int i = 0; i < CNT_OF_TEST; i++) {
            long startTime = System.currentTimeMillis();

            studentStatistics.numberOfTicketsBookedForEachShow();
            studentStatistics.theMostPopularShow();
            studentStatistics.showForWhichPurchasedTickets();

            long endTime = System.currentTimeMillis();
            totalTime = totalTime + (endTime - startTime);
        }
        return totalTime / CNT_OF_TEST;
    }
}

