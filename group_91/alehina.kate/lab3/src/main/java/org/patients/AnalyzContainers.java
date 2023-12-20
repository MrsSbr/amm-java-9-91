package org.patients;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AnalyzContainers {
    public static void main(String[] args) {
        List<Supplier<Collection<Patient>>> suppliersCollections = List.of(
                LinkedList::new,
                ArrayList::new,
                HashSet::new
        );
        List<String> namesCollections = List.of("LinkedList", "ArrayList", "HashSet");
        int indexCollection = 0;
        final int countTest = 10;
        for (Supplier<Collection<Patient>> supplier : suppliersCollections) {
            PatientTask task = new PatientTask(supplier, getGeneratedListPatients(1200));
            //List<Long> timeMethods = new ArrayList<>(List.of(0L, 0L, 0L));
            long time = System.nanoTime();
            for (int i = 0; i < countTest; ++i) {
                task.countHealthyPatients();
                task.lastThreeYearsPatients();
                task.lastFiveNotLastTwoPatients();
            }
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) +
                    " составило в среднем " + time / countTest + " наносекунд");
            indexCollection++;
        }
    }

    public static List<Patient> getGeneratedListPatients(int countPatients) {
        return Stream.generate(RandomPatient::generatePatient)
                .limit(countPatients)
                .toList();
    }
}