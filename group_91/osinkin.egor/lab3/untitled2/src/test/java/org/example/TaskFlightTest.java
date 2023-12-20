package org.example;

import org.example.Flight;
import org.example.TaskFlight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskFlightTest {
    private final Flight[] Flights = {
            new Flight(1, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 5, 9, 5, 2, 3, 7)),
            new Flight(2, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 5, 9, 13, 2, 3, 7)),
            new Flight(3, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 4, 7)),
            new Flight(4, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(5, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(6, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(7, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 7, 8, 9, 5, 2, 3, 7)),
            new Flight(8, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(9, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(10, new GregorianCalendar(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7))
    };
    private final List<Flight> emptyFlights = Collections.emptyList();
    private final List<Supplier<Collection<Flight>>> suppliers = List.of(
            LinkedList::new,
            ArrayList::new,
            HashSet::new
    );

    @Test
    void findCountPassagesOfDate() {
        Calendar date = new GregorianCalendar(2021, 2, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(405, TaskFlight.taskCount(date, FlightsCollection));
        }
    }

    @Test
    void findCountPassagesOfDateEmptyCollection() {
        Calendar date = new GregorianCalendar(2021, 2, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(0, TaskFlight.taskCount(date, emptyFlights));
        }
    }

    @Test
    void findCountPassagesOfDateUnknownDate(){
        Calendar date = new GregorianCalendar(2021, 3, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(0, TaskFlight.taskCount(date, emptyFlights));
        }
    }
}
