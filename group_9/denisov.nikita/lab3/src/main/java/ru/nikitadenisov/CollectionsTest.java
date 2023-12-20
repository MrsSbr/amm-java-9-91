package ru.nikitadenisov;

import ru.nikitadenisov.analyzer.DemographicAnalyzer;
import ru.nikitadenisov.analyzer.Student;
import ru.nikitadenisov.analyzer.StudentFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CollectionsTest {
    public static void main(String[] args) {
        Collection<Student> arrayList = createCollection(ArrayList::new, 1200);
        Collection<Student> linkedList = createCollection(LinkedList::new, 1200);
        Collection<Student> vector = createCollection(Vector::new, 1200);

        performance(arrayList);
        performance(linkedList);
        performance(vector);
    }

    private static <T extends Collection<Student>> T createCollection(Supplier<T> factory, int size) {
        return Stream.generate(StudentFactory::generateStudent)
                .limit(size)
                .collect(factory, Collection::add, Collection::addAll);
    }

    private static void performance(Collection<Student> collection) {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(collection);

        int number = 1000;
        long finalTime = 0;
        long startTime;
        long endTime;

        for (int i = 0; i < number; ++i) {
            startTime = System.nanoTime();

            demographicAnalyzer.numberStudentsBornInMonths();
            demographicAnalyzer.monthsWithMoreFemalesThanMales();

            endTime = System.nanoTime();

            finalTime += endTime - startTime;
        }

        double nanosecondsToMilliseconds = 1e6;
        double timeToMilliseconds = finalTime / (number * nanosecondsToMilliseconds);

        System.out.println(collection.getClass().getSimpleName() + ": " + timeToMilliseconds + " миллисекунд.");
    }
}
