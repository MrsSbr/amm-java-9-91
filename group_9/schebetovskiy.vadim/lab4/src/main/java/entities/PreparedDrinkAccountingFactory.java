package entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class PreparedDrinkAccountingFactory {
    private static final int MIN_TIME_OF_PREPARATION_IN_SECONDS = 10;
    private static final int MAX_TIME_OF_PREPARATION_IN_SECONDS = 100;
    private static final int HOUR_OF_START_OF_WORK = 7;
    private static final int HOUR_OF_END_OF_WORK = 18;
    private static final int FIRST_YEAR_OF_WORK = 2020;
    private static final int LAST_YEAR_OF_WORK = 2023;
    private static final Drinks[] DRINKS = Drinks.values();
    public PreparedDrinkAccounting getPreparedDrinkAccounting() {
        Random rand = new Random();
        Drinks drink = DRINKS[rand.nextInt(Drinks.values().length)];
        return new PreparedDrinkAccounting(drink.getName(),
                getRandomDateOfPreparation(),
                getRandomTimeOfPreparation(),
                drink.getPrice());
    }
    private static LocalDateTime getRandomDateOfPreparation() {
        Random rand = new Random();

        int year = rand.nextInt(LAST_YEAR_OF_WORK - FIRST_YEAR_OF_WORK + 1) + FIRST_YEAR_OF_WORK;
        int month = rand.nextInt(12) + 1;
        int day = rand.nextInt(28) + 1;
        int hour = rand.nextInt(HOUR_OF_END_OF_WORK - HOUR_OF_START_OF_WORK + 1) + HOUR_OF_START_OF_WORK;
        int minute = rand.nextInt(60);
        int second = rand.nextInt(60);

        return LocalDateTime.of(year, month, day, hour, minute, second).truncatedTo(ChronoUnit.SECONDS);

    }
    private static int getRandomTimeOfPreparation() {
        Random rand = new Random();
        return rand.nextInt(MAX_TIME_OF_PREPARATION_IN_SECONDS - MIN_TIME_OF_PREPARATION_IN_SECONDS + 1)
                + MIN_TIME_OF_PREPARATION_IN_SECONDS;
    }
}
