package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskFlightTest {
    private final Flight[] Flights = {
            new Flight(1, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 5, 9, 5, 2, 3, 7)),
            new Flight(2, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 5, 9, 13, 2, 3, 7)),
            new Flight(3, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 4, 7)),
            new Flight(4, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(5, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(6, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(7, LocalDate.of(2021, 2, 5),
                    List.of(1, 7, 8, 9, 5, 2, 3, 7)),
            new Flight(8, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(9, LocalDate.of(2021, 2, 5),
                    List.of(1, 5, 8, 9, 5, 2, 3, 7)),
            new Flight(10, LocalDate.of(2021, 2, 5),
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
        LocalDate date = LocalDate.of(2021, 2, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(405, TaskFlight.taskCount(date, FlightsCollection));
        }
    }

    @Test
    void findCountPassagesOfDateEmptyCollection() {
        LocalDate date = LocalDate.of(2021, 2, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(0, TaskFlight.taskCount(date, emptyFlights));
        }
    }

    @Test
    void findCountPassagesOfDateUnknownDate() {
        LocalDate date = LocalDate.of(2021, 3, 5);
        for (Supplier<Collection<Flight>> supplier : suppliers) {
            Collection<Flight> FlightsCollection = Stream.of(Flights).collect(Collectors.toCollection(supplier));
            assertEquals(0, TaskFlight.taskCount(date, emptyFlights));
        }
    }
}
