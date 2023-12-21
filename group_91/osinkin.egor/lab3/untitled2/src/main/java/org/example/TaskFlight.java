package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class TaskFlight {
    public static int getCount(Flight flight) {
        List<Integer> passages = flight.getPassages();
        int summ = 0;
        for (Integer passage : passages) {
            summ += passage;
        }
        return summ;
    }

    public static int taskCount(LocalDate date, Collection<Flight> flights) {
        var wrapper = new Object() {
            int counter = 0;
        };
        flights.stream()
                .filter(elem -> elem.getDate().equals(date))
                .forEach(elem -> wrapper.counter += getCount(elem));
        return wrapper.counter;
    }

    public static void task() {
        int day, month, year;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите день рейса:");
        day = in.nextInt();
        System.out.println("Введите месяц рейса:");
        month = in.nextInt();
        System.out.println("Введите год рейса:");
        year = in.nextInt();

        LocalDate date = LocalDate.of(year, month, day);
        Collection<Flight> flights = new ArrayList<Flight>();
        GeneratePassages.generateFlights(flights);
        System.out.println("Количество пассажиров в этот день: " + taskCount(date, flights));
    }

//    public static boolean isEqualDate(LocalDate date1, LocalDate date2) {
//        return date1.equals();
//    }
}
