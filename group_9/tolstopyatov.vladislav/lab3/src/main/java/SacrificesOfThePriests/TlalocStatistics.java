package SacrificesOfThePriests;

import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Supplier;

public class TlalocStatistics {
    private final Collection<AccountingForSacrifice> sacrifices;

    public TlalocStatistics(Supplier<Collection<AccountingForSacrifice>> collectionSupplier,
                            Collection<AccountingForSacrifice> accountingForSacrificesCollection) {
        Collection<AccountingForSacrifice> temporalCollection = accountingForSacrificesCollection.stream()
                .collect(collectionSupplier, Collection<AccountingForSacrifice>::add,
                        Collection<AccountingForSacrifice>::addAll);
        this.sacrifices = Collections.unmodifiableCollection(temporalCollection);
    }

    public Collection<AccountingForSacrifice> getSacrifices() {
        return sacrifices;
    }

    public int theNumberOfSacrificesAfterWhichRainFellTheNextDay() {
        return (int) sacrifices.stream().filter(x -> x.getNumberOfDaysUntilTheNextRain() == 1).count();
    }

    public Month theLastMonthInWhichThereWereNoAnimalSacrifices() {
        return Collections.max(sacrifices.stream().filter(x -> !Objects.equals(x.getVictim().getTypeOfVictim(), "животное")).
                map(AccountingForSacrifice::getTimeOfSacrifice).toList()).getMonth();

    }

    public boolean IsTheHumanSacrificesIsMoreEffectiveThanAnimal() {
        int daysWithoutRainAfterHumanSacrifice = sacrifices.stream().filter(x -> !Objects.equals(x.getVictim().getTypeOfVictim(), "животное")).
                mapToInt(AccountingForSacrifice::getNumberOfDaysUntilTheNextRain).sum();
        int daysWithoutRainAfterAnimalSacrifice = sacrifices.stream().filter(x -> !Objects.equals(x.getVictim().getTypeOfVictim(), "человек")).
                mapToInt(AccountingForSacrifice::getNumberOfDaysUntilTheNextRain).sum();

        return daysWithoutRainAfterAnimalSacrifice > daysWithoutRainAfterHumanSacrifice;
    }
}
