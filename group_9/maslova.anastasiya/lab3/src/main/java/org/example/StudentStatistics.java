package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StudentStatistics {
    private final List<Student> students;
    public static final int TOTAL_STUDENTS = 100000;

    public StudentStatistics(List<Student> students) {
        this.students = students;
    }


    // количество билетов, заказанных на каждый спектакль;
    public List<Integer> numberOfTicketsBookedForEachShow() {
        // создаём список-счётчик для всех спектаклей
        List<Integer> numberOfTickets = new ArrayList<>(Collections.nCopies(ShowName.values().length, 0));

        students.forEach(st -> st.getShowsName() // проходим по каждому ученику
                .forEach(show -> { // проходим по спектаклям на которые приобрел билет ученик
                    int index = Arrays.asList(ShowName.values()).indexOf(show); // получаем индекс необходимого спектакля
                    if (index != -1) { // если найден, то увеличиваем счётчик
                        numberOfTickets.set(index, numberOfTickets.get(index) + 1);
                    }
                }));

        return numberOfTickets;
    }

    // самый популярный спектакль (следует учесть вариант, что может быть несколько таких спектаклей);
    public List<ShowName> theMostPopularShow() {
        List<Integer> numberOfTickets = numberOfTicketsBookedForEachShow();
        int max = Collections.max(numberOfTickets);

        return IntStream.range(0, numberOfTickets.size()).filter(i -> numberOfTickets.get(i) == max) // добавление в список спектаклей у которых максимальное кол-во билетов
                .mapToObj(i -> ShowName.values()[i]) // преобразуем поток индексов в поток спектакль
                .collect(Collectors.toList());
    }

    // спектакль (спектакли), на который решили приобрести билеты
    public List<ShowName> showForWhichPurchasedTickets() {
        List<Integer> numberOfTickets = numberOfTicketsBookedForEachShow();

        return IntStream.range(0, numberOfTickets.size()).filter(i -> numberOfTickets.get(i) > 0)// добавление в список спектаклей у которых куплен хоть 1 билет
                .mapToObj(i -> ShowName.values()[i]) // преобразуем поток индексов в поток спектакль
                .collect(Collectors.toList());
    }
}