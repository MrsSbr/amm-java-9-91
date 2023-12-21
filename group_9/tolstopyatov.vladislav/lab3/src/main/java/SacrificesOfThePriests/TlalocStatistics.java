package SacrificesOfThePriests;

import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

public class TlalocStatistics {
    private final Collection<AccountingForSacrifice> sacrifices;

    public TlalocStatistics(Supplier<Collection<AccountingForSacrifice>> collectionSupplier,
                            Collection<AccountingForSacrifice> collection) {
        this.sacrifices = collectionSupplier.get();
        this.sacrifices.addAll(collection);
    }

    public Collection<AccountingForSacrifice> getSacrifices() {
        return sacrifices;
    }

    public int theNumberOfSacrificesAfterWhichRainFellTheNextDay() {
        return (int) sacrifices.stream().filter(x -> x.getNumberOfDaysUntilTheNextRain() == 1).count();
    }

    public Month theLastMonthInWhichThereWereNoAnimalSacrifices() {
        return Collections.max(sacrifices.stream().filter(x -> x.getVictimType() != VictimType.ANIMAL).
                map(AccountingForSacrifice::getTimeOfSacrifice).toList()).getMonth();
    }

    public boolean isTheHumanSacrificesIsMoreEffectiveThanAnimal() {
        int daysWithoutRainAfterHumanSacrifice = sacrifices.stream().filter(x -> x.getVictimType() != VictimType.ANIMAL).
                mapToInt(AccountingForSacrifice::getNumberOfDaysUntilTheNextRain).sum();
        int daysWithoutRainAfterAnimalSacrifice = sacrifices.stream().filter(x -> x.getVictimType() != VictimType.PERSON).
                mapToInt(AccountingForSacrifice::getNumberOfDaysUntilTheNextRain).sum();

        return daysWithoutRainAfterAnimalSacrifice > daysWithoutRainAfterHumanSacrifice;
    }
}
