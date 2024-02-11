package ru.nikitaarsentev.other;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DeterminateNumberPath {
    public static final Integer MIN_NUMBER_COMPLETED_PATH = 10;

    public static int determineMaxNumberPath(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return switch (dayOfWeek) {
            case MONDAY -> 30;
            case TUESDAY, THURSDAY -> 35;
            case WEDNESDAY -> 40;
            case FRIDAY -> 25;
            case SATURDAY -> 45;
            case SUNDAY -> 50;
        };
    }
}
