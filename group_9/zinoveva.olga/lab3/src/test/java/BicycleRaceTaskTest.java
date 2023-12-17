import org.example.BicycleRace;
import org.example.BicycleRaceTask;
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

class BicycleRaceTaskTest {
    private final BicycleRace[] bicycleRaces = {
            new BicycleRace(Map.of(1, 3, 2, 4, 3, 7, 4, 10, 5, 8, 6, 11),
                    List.of(3, 4, 8, 7, 10, 11),
                    new GregorianCalendar(2023, Calendar.JANUARY, 6)),
            new BicycleRace(Map.of(1, 6, 2, 15, 3, 7, 4, 9, 5, 21, 6, 10),
                    List.of(6, 15, 7, 9, 21, 10),
                    new GregorianCalendar(2023, Calendar.AUGUST, 21)),
            new BicycleRace(Map.of(1, 15, 2, 2, 3, 61, 4, 22, 5, 3, 6, 7, 7, 15, 8, 6),
                    List.of(15, 2, 61, 22, 3, 7, 15, 6),
                    new GregorianCalendar(2022, Calendar.MAY, 17)),
            new BicycleRace(Map.of(1, 15, 2, 61, 3, 22, 4, 3, 5, 7, 6, 4),
                    List.of(15, 61, 22, 3, 7, 4),
                    new GregorianCalendar(2021, Calendar.NOVEMBER, 16)),
            new BicycleRace(Map.of(1, 20, 2, 8, 3, 6, 4, 7, 5, 3, 6, 15),
                    List.of(20, 8, 6, 3, 7, 15),
                    new GregorianCalendar(2020, Calendar.FEBRUARY, 1)),
            new BicycleRace(Map.of(1, 5, 2, 9, 3, 10, 4, 12, 5, 7, 6, 15, 7, 3),
                    List.of(5, 9, 10, 12, 7, 3, 15),
                    new GregorianCalendar(2019, Calendar.JUNE, 7)),
            new BicycleRace(Map.of(1, 17, 2, 1, 3, 2, 4, 7, 5, 15, 6, 22, 7, 3),
                    List.of(17, 1, 2, 7, 15, 22, 3),
                    new GregorianCalendar(2018, Calendar.OCTOBER, 5))

    };
    private final List<BicycleRace> emptyBicycleRaces = Collections.emptyList();
    private final List<Supplier<Collection<BicycleRace>>> suppliers = List.of(
            LinkedList::new,
            ArrayList::new,
            HashSet::new
    );

    @Test
    void findAthletesWithPrizesInThreeYears() {
        Set<Integer> winnersThisYear = Set.of(3, 4, 7, 6, 15, 2, 61, 22);
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = Stream.of(bicycleRaces).collect(Collectors.toCollection(supplier));
            assertEquals(winnersThisYear, task.findAthletesWithPrizesInThreeYears(bicycleRaceCollection));
        }
    }

    @Test
    void countWinner() {
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = Stream.of(bicycleRaces).collect(Collectors.toCollection(supplier));
            assertEquals(6, task.countWinner(bicycleRaceCollection));
        }
    }

    @Test
    void findAthletesByCondition() {
        Set<Integer> winnersThisYear = Set.of(3, 7);
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = Stream.of(bicycleRaces).collect(Collectors.toCollection(supplier));
            assertEquals(winnersThisYear, task.findAthletesByCondition(bicycleRaceCollection));
        }
    }

    @Test
    void findAthletesWithPrizesInThreeYearsEmptyCollection() {
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = supplier.get();
            bicycleRaceCollection.addAll(emptyBicycleRaces);
            assertEquals(Set.of(), task.findAthletesWithPrizesInThreeYears(bicycleRaceCollection));
        }
    }

    @Test
    void countWinnerEmptyCollection() {
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = supplier.get();
            bicycleRaceCollection.addAll(emptyBicycleRaces);
            assertEquals(0, task.countWinner(bicycleRaceCollection));
        }
    }

    @Test
    void findAthletesByConditionEmptyCollection() {
        for (Supplier<Collection<BicycleRace>> supplier : suppliers) {
            BicycleRaceTask task = new BicycleRaceTask();
            Collection<BicycleRace> bicycleRaceCollection = supplier.get();
            bicycleRaceCollection.addAll(emptyBicycleRaces);
            assertEquals(Set.of(), task.findAthletesByCondition(bicycleRaceCollection));
        }
    }
}
