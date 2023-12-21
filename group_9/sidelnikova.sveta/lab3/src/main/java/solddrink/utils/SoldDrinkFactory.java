package solddrink.utils;

import drinks.DrinkType;
import drinks.SoldDrink;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Random;

public final class SoldDrinkFactory {
    private final static Random RANDOM = new Random();

    private final static DrinkType[] POSSIBLE_DRINKS = DrinkType.values();

    private final static long MIN_EPOCH_DAY = LocalDate.of(2023, Month.JUNE, 1).toEpochDay();

    private final static long MAX_EPOCH_DAY = LocalDate.now().toEpochDay();

    private final static int OPENING_TIME_IN_SECONDS = LocalTime.of(10, 0, 0).toSecondOfDay();

    private final static int CLOSING_TIME_IN_SECONDS = LocalTime.of(20, 0, 0).toSecondOfDay();

    public static SoldDrink generateSoldDrinkRecord() {
        return new SoldDrink(POSSIBLE_DRINKS[RANDOM.nextInt(POSSIBLE_DRINKS.length)],
                LocalDate.ofEpochDay(RANDOM.nextLong(MIN_EPOCH_DAY, MAX_EPOCH_DAY)),
                LocalTime.ofSecondOfDay(RANDOM.nextInt(OPENING_TIME_IN_SECONDS, CLOSING_TIME_IN_SECONDS)));
    }
}
