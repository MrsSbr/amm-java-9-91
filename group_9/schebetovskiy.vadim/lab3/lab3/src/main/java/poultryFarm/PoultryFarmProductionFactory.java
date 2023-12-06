package poultryFarm;

import java.time.LocalDate;
import java.util.Random;

public class PoultryFarmProductionFactory {
    private static final int MIN_NUMBER_OF_EGGS_PRODUCED = 1;
    private static final int MAX_NUMBER_OF_EGGS_PRODUCED = 20;
    private static final BirdType[] BIRD_TYPES = BirdType.values();

    public static PoultryFarmProduction getPoultryFarmProduction() {
        Random rand = new Random();
        return new PoultryFarmProduction(BIRD_TYPES[rand.nextInt(BIRD_TYPES.length)],
                rand.nextInt(MIN_NUMBER_OF_EGGS_PRODUCED, MAX_NUMBER_OF_EGGS_PRODUCED),
                getRandomDate());
    }

    private static LocalDate getRandomDate() {
        Random rand = new Random();
        long minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = minDay + rand.nextLong() % (maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
