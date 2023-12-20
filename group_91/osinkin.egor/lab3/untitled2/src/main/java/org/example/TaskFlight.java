package org.example;

import java.util.*;

public class TaskFlight {
    public static int getCount(Flight flight) {
        List<Integer> passages = flight.getPassages();
        int summ = 0;
        for (Integer passage : passages) {
            summ += passage;
        }
        return summ;
    }

    public static int taskCount(Calendar date, Collection<Flight> flights) {
        var wrapper = new Object() {
            int counter = 0;
        };
        flights.stream()
                .filter(elem -> isEqualDate(elem.getDate(),date))
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

        Calendar date = new GregorianCalendar(year, month, day);
        Collection<Flight> flights = new ArrayList<Flight>();
        GeneratePassages.generateFlights(flights);
        System.out.println("Количество пассажиров в этот день: " + taskCount(date, flights));
    }
    public static boolean isEqualDate(Calendar date1, Calendar date2){
        return date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)&&
                date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH)&&
                date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH);
    }
}
