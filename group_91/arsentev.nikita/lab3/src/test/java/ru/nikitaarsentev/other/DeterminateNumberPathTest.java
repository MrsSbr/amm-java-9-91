package ru.nikitaarsentev.other;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DeterminateNumberPathTest {
    @Test
    void testDetermineMaxNumberPathMonday() {
        LocalDate monday = LocalDate.of(2024, 2, 5); // Это понедельник
        assertEquals(30, DeterminateNumberPath.determineMaxNumberPath(monday));
    }

    @Test
    void testDetermineMaxNumberPathTuesday() {
        LocalDate tuesday = LocalDate.of(2024, 2, 6); // Это вторник
        assertEquals(35, DeterminateNumberPath.determineMaxNumberPath(tuesday));
    }

    @Test
    void testDetermineMaxNumberPathWednesday() {
        LocalDate wednesday = LocalDate.of(2024, 2, 7); // Это среда
        assertEquals(40, DeterminateNumberPath.determineMaxNumberPath(wednesday));
    }

    @Test
    void testDetermineMaxNumberPathThursday() {
        LocalDate thursday = LocalDate.of(2024, 2, 8); // Это четверг
        assertEquals(35, DeterminateNumberPath.determineMaxNumberPath(thursday));
    }

    @Test
    void testDetermineMaxNumberPathFriday() {
        LocalDate friday = LocalDate.of(2024, 2, 9); // Это пятница
        assertEquals(25, DeterminateNumberPath.determineMaxNumberPath(friday));
    }

    @Test
    void testDetermineMaxNumberPathSaturday() {
        LocalDate saturday = LocalDate.of(2024, 2, 10); // Это суббота
        assertEquals(45, DeterminateNumberPath.determineMaxNumberPath(saturday));
    }

    @Test
    void testDetermineMaxNumberPathSunday() {
        LocalDate sunday = LocalDate.of(2024, 2, 11); // Это воскресенье
        assertEquals(50, DeterminateNumberPath.determineMaxNumberPath(sunday));
    }
}