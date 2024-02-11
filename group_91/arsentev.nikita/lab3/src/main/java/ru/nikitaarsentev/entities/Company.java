package ru.nikitaarsentev.entities;

import ru.nikitaarsentev.other.LongToMoney;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Company {
    protected static final int DEFAULT_COUNT_ROUTES = 10;
    private final int countRoutes;
    private final Collection<PeriodInRoute> periodInRoutes;
    private Collection<Long> amounts;

    public <T1 extends Collection<PeriodInRoute>, T2 extends Collection<DayInRoute>, T3 extends Collection<LocalDate>>
    Company(int durability, int countRoutes, Supplier<T1> factoryForPeriodInRoute,
            Supplier<T2> factoryForDayInRoute, Supplier<T3> factoryForLocalDate) {
        this.countRoutes = countRoutes;
        periodInRoutes = IntStream.range(0, this.countRoutes)
                .mapToObj(i -> new PeriodInRoute(durability, factoryForDayInRoute, factoryForLocalDate))
                .collect(factoryForPeriodInRoute, Collection::add, Collection::addAll);
    }

    public <T1 extends Collection<PeriodInRoute>, T2 extends Collection<DayInRoute>, T3 extends Collection<LocalDate>>
    Company(Supplier<T1> factoryForPeriodInRoute,
            Supplier<T2> factoryForDayInRoute, Supplier<T3> factoryForLocalDate) {
        countRoutes = DEFAULT_COUNT_ROUTES;
        periodInRoutes = IntStream.range(0, countRoutes)
                .mapToObj(i -> new PeriodInRoute(factoryForDayInRoute, factoryForLocalDate))
                .collect(factoryForPeriodInRoute, Collection::add, Collection::addAll);
    }

    public int getCountRoutes() {
        return countRoutes;
    }

    public Collection<Long> getAmounts() {
        return amounts;
    }

    private <T extends Collection<Long>> void moneyReceiptsToCompany(Supplier<T> factory) {
        amounts = periodInRoutes.stream()
                .map(PeriodInRoute::countSumOnPeriod)
                .collect(factory, Collection::add, Collection::addAll);
    }

    public <T extends Collection<Long>> void countResult(Supplier<T> factory) {
        moneyReceiptsToCompany(factory);
    }

    public void outputResultWithRoute() {
        List<PeriodInRoute> copyPeriod = List.copyOf(periodInRoutes);
        List<Long> copyAmounts = List.copyOf(amounts);
        IntStream.range(0, copyPeriod.size())
                .mapToObj(i -> copyPeriod.get(i).route + " = " +
                        LongToMoney.transformationLongToMoney(copyAmounts.get(i)))
                .forEach(System.out::println);
    }

    public void outputResultWithoutRoute() {
        int i = 0;
        for (long num : amounts) {
            System.out.println(i + " = " + LongToMoney.transformationLongToMoney(num));
            i++;
        }
    }
}
