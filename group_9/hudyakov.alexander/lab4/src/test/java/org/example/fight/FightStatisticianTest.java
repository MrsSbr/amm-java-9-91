package org.example.fight;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FightStatisticianTest {
    final static List<FightResult> RESULTS = List.of(
            new FightResult(1, LocalDate.of(2022, 8, 13), "Liu Kang", "Smoke", false, true),
            new FightResult(1, LocalDate.of(1992, 3, 1), "Sub-Zero", "Sonya Blade", false, false),
            new FightResult(2, LocalDate.of(2022, 8, 23), "Scorpion", "Sub-Zero", true, true),
            new FightResult(2, LocalDate.of(2022, 1, 27), "Sub-Zero", "Shang Tsung", true, true),
            new FightResult(2, LocalDate.of(1995, 11, 16), "Shang Tsung", "Sub-Zero", false, false),
            new FightResult(3, LocalDate.of(2022, 1, 14), "Sub-Zero", "Johnny Cage", false, true),
            new FightResult(4, LocalDate.of(2022, 12, 15), "Liu Kang", "Kano", true, true),
            new FightResult(4, LocalDate.of(1999, 1, 18), "Scorpion", "Shang Tsung", false, true),
            new FightResult(5, LocalDate.of(2022, 5, 22), "Liu Kang", "Jade", false, false)
    );
    final static Set<Month> MONTHS = Set.of(Month.AUGUST, Month.JANUARY);
    final static Map<String, Integer> FIGHTERS_VICTORIES = Map.of(
            "Liu Kang", 1,
            "Smoke", 1,
            "Sonya Blade", 1,
            "Scorpion", 1,
            "Sub-Zero", 2,
            "Shang Tsung", 1,
            "Jade", 1,
            "Johnny Cage", 1
    );

    final static Map<Integer, Set<String>> TOURNAMENTS_FIGHTERS = Map.of(
            1, Set.of("Liu Kang", "Smoke", "Sub-Zero", "Sonya Blade"),
            2, Set.of("Sub-Zero", "Scorpion", "Shang Tsung"),
            3, Set.of("Sub-Zero", "Johnny Cage"),
            4, Set.of("Liu Kang", "Kano", "Scorpion", "Shang Tsung"),
            5, Set.of("Liu Kang", "Jade")
    );

    final FightStatisticService fightStatisticService = new FightStatisticServiceImpl();

    @Test
    void getMonthsWithMostFatalitiesCountOverPastThreeYears() {
        Set<Month> months = fightStatisticService.getMonthsWithMostFatalitiesCountOverPastThreeYears(RESULTS);
        assertEquals(MONTHS, months);
    }

    @Test
    void getMonthsWithMostFatalitiesCountOverPastThreeYearsInEmptyCollection() {
        Set<Month> months = fightStatisticService.getMonthsWithMostFatalitiesCountOverPastThreeYears(RESULTS);
        assertTrue(months.isEmpty());
    }

    @Test
    void getFightersVictoryCount() {
        Map<String, Integer> fightersVictories = fightStatisticService.getFightersVictoryCount(RESULTS);
        assertEquals(FIGHTERS_VICTORIES.size(), fightersVictories.size());
        FIGHTERS_VICTORIES.forEach((fighter, victoriesCount) -> {
            assertTrue(fightersVictories.containsKey(fighter));
            assertEquals(victoriesCount, fightersVictories.get(fighter));
        });
    }

    @Test
    void getFightersVictoryCountInEmptyCollection() {
        Map<String, Integer> fightersVictories = fightStatisticService.getFightersVictoryCount(RESULTS);
        assertTrue(fightersVictories.isEmpty());
    }

    @Test
    void getTournamentsFighters() {
        Map<Integer, Set<String>> fighters = fightStatisticService.getTournamentsFighters(RESULTS);
        assertEquals(TOURNAMENTS_FIGHTERS.size(), fighters.size());
        TOURNAMENTS_FIGHTERS.forEach((key, expectedCollection) -> {
            assertTrue(fighters.containsKey(key));
            Collection<String> actualCollection = fighters.get(key);
            assertEquals(expectedCollection, actualCollection);
        });
    }

    @Test
    void getTournamentsFightersInEmptyCollection() {
        Map<Integer, Set<String>> fighters = fightStatisticService.getTournamentsFighters(RESULTS);
        assertTrue(fighters.isEmpty());
    }
}