package SacrificesOfThePriests;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomAccountingForSacrificeFactory {
    private static final int MIN_DAYS_UNTIL_THE_NEXT_RAIN = 1;
    private static final int MAX_DAYS_UNTIL_THE_NEXT_RAIN = 1000;
    private static final Random rand = new Random();
    private static final VictimType[] VICTIM_TYPES = VictimType.values();

    public AccountingForSacrifice getAccountingForSacrifice() {

        return new AccountingForSacrifice(VICTIM_TYPES[rand.nextInt(VICTIM_TYPES.length)],
                rand.nextInt(MIN_DAYS_UNTIL_THE_NEXT_RAIN, MAX_DAYS_UNTIL_THE_NEXT_RAIN),
                getRandLocalDate());
    }

    private LocalDate getRandLocalDate() {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }
}
