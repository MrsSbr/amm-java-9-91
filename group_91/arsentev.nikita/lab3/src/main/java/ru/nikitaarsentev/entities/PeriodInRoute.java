package ru.nikitaarsentev.entities;

import ru.nikitaarsentev.factories.DayFactory;
import ru.nikitaarsentev.factories.DaysInRouteFactory;
import ru.nikitaarsentev.factories.RouteFactory;
import ru.nikitaarsentev.other.Profit;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Supplier;

import static java.util.concurrent.ThreadLocalRandom.current;

public class PeriodInRoute {
    public final Collection<DayInRoute> daysInRouteList;
    public final Route route;
    protected static final LocalDate START_DATE = LocalDate.of(2000, 1, 1);
    protected static final LocalDate END_DATE = LocalDate.of(2010, 1, 1);
    protected static final int DEFAULT_DURABILITY = 7;
    private static final LocalDate date = determineDate();
    private final int durability;

    public <T1 extends Collection<DayInRoute>, T2 extends Collection<LocalDate>>
    PeriodInRoute(int durability, Supplier<T1> fabricForDayInRoute, Supplier<T2> fabricForLocalDate) {
        this.durability = durability;
        route = RouteFactory.generateRoute();
        Collection<LocalDate> localDateList = DayFactory.generateDays(fabricForLocalDate, date, this.durability);
        daysInRouteList = DaysInRouteFactory.generateDaysInRoute(fabricForDayInRoute, route, localDateList);
    }

    public <T1 extends Collection<DayInRoute>, T2 extends Collection<LocalDate>>
    PeriodInRoute(Supplier<T1> fabricForDayInRoute, Supplier<T2> fabricForLocalDate) {
        durability = DEFAULT_DURABILITY;
        route = RouteFactory.generateRoute();
        Collection<LocalDate> localDateList = DayFactory.generateDays(fabricForLocalDate, date, durability);
        daysInRouteList = DaysInRouteFactory.generateDaysInRoute(fabricForDayInRoute, route, localDateList);
    }

    public int getDurability() {
        return durability;
    }

    private static LocalDate determineDate() {
        long startDay = START_DATE.toEpochDay();
        long endDay = END_DATE.toEpochDay();
        long randomDay = current().nextLong(startDay, endDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public long countSumOnPeriod() {
        return Profit.countProfit(daysInRouteList, route);
    }
}
