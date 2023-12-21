package SacrificesOfThePriests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomAccountingOfTheSacrificesFactory {
    private final RandomAccountingForSacrificeFactory factory = new RandomAccountingForSacrificeFactory();
    private final int count;

    public RandomAccountingOfTheSacrificesFactory(int count) {
        this.count = count;
    }

    public List<AccountingForSacrifice> getAccountingForSacrificeList() {
        return Stream.generate(factory::getAccountingForSacrifice)
                .limit(count)
                .collect(Collectors.toList());
    }
}
