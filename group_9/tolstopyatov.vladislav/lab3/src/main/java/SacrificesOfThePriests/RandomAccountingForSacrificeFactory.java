package SacrificesOfThePriests;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

public class RandomAccountingForSacrificeFactory {
    private static final int MIN_DAYS_UNTIL_THE_NEXT_RAIN = 1;
    private static final int MAX_DAYS_UNTIL_THE_NEXT_RAIN = 1000;

    Random rand = new Random();

    private static final RandomSacrificeFactory SacrificeFactory = new RandomSacrificeFactory();

    public AccountingForSacrifice getAccountingForSacrifice() {

        return new AccountingForSacrifice(SacrificeFactory.getSacrifice(),
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
