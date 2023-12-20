package test.java.org.example;

import main.java.org.example.Animal;
import main.java.org.example.ColiseumStatistics;
import main.java.org.example.Fight;
import main.java.org.example.Ludus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColiseumStatisticsTest {
    private final List<Fight> fights = List.of (
            new Fight(LocalDate.of(52, 1, 10), "Lorenzo",  Ludus.POMPEII, Animal.BEAR, true, false),
            new Fight(LocalDate.of(49, 7, 30), "Luca",  null, Animal.LEOPARD, true, false),
            new Fight(LocalDate.of(47, 6, 8), "Elia", null, Animal.LEOPARD, true, false),
            new Fight(LocalDate.of(50, 7, 11), "Luca", null, Animal.BEAR, true, false),
            new Fight(LocalDate.of(47, 9, 30), "Elia",  null, Animal.BEAR, true, false),
            new Fight(LocalDate.of(50, 11, 6), "Luca",  null, Animal.LEOPARD, true, false),
            new Fight(LocalDate.of(49, 5, 10), "Dante",  Ludus.RAVENNA, Animal.LEOPARD, true, true),
            new Fight(LocalDate.of(47, 5, 11), "Marco",  Ludus.ROME, Animal.LION, false, false),
            new Fight(LocalDate.of(53, 8, 20), "Matteo",  Ludus.VERONA, Animal.LION, true, true),
            new Fight(LocalDate.of(55, 11, 7), "Matteo",  Ludus.VERONA, Animal.LEOPARD, false, false),
            new Fight(LocalDate.of(53, 7, 15), "Lorenzo",  Ludus.POMPEII, Animal.BULL, true, true),
            new Fight(LocalDate.of(48, 10, 22), "Elia", null, Animal.TIGER, true, false),
            new Fight(LocalDate.of(49, 2, 1), "Elia",  null, Animal.LEOPARD, false, false),
            new Fight(LocalDate.of(52, 3, 15), "Luca",  null, Animal.LEOPARD, false, false)
    );
    private final List<Fight> emptyCollectionFights = Collections.emptyList();

    @Test
    void theMostMurderousAnimal() {
        ColiseumStatistics statistics = new ColiseumStatistics(fights);
        Animal animal = Animal.LEOPARD;
        assertEquals(animal, statistics.theMostMurderousAnimal());
    }

    @Test
    void theMostMurderousAnimalEmptyCollection() {
        ColiseumStatistics statistics = new ColiseumStatistics(emptyCollectionFights);
        assertNull(statistics.theMostMurderousAnimal());
    }

    @Test
    void gladiatorsListThatSurvivedThreeTimes() {
        ColiseumStatistics statistics = new ColiseumStatistics(fights);
        List<String> gladiators = List.of("Luca", "Elia");
        assertEquals(gladiators, statistics.gladiatorsListThatSurvivedThreeTimes());
    }

    @Test
    void gladiatorsListThatSurvivedThreeTimesEmptyCollection() {
        ColiseumStatistics statistics = new ColiseumStatistics(emptyCollectionFights);
        assertEquals(new ArrayList<>(), statistics.gladiatorsListThatSurvivedThreeTimes());
    }

    @Test
    void theBestLudus() {
        ColiseumStatistics statistics = new ColiseumStatistics(fights);
        Ludus ludus = Ludus.POMPEII;
        assertEquals(ludus, statistics.theBestLudus());
    }

    @Test
    void theBestLudusEmptyCollection() {
        ColiseumStatistics statistics = new ColiseumStatistics(emptyCollectionFights);
        assertNull(statistics.theBestLudus());
    }
}