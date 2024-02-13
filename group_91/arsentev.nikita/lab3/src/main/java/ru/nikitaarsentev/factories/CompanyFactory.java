package ru.nikitaarsentev.factories;

import ru.nikitaarsentev.entities.Company;
import ru.nikitaarsentev.entities.DayInRoute;
import ru.nikitaarsentev.entities.PeriodInRoute;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Supplier;

public class CompanyFactory {
    public static <T1 extends Collection<PeriodInRoute>,
            T2 extends Collection<DayInRoute>,
            T3 extends Collection<LocalDate>>
    Company generateCompany(int durability, int count_routes,
                            Supplier<T1> factoryForPeriodInRoute,
                            Supplier<T2> factoryForDayInRoute,
                            Supplier<T3> factoryForLocalDate) {
        return new Company(durability, count_routes, factoryForPeriodInRoute, factoryForDayInRoute, factoryForLocalDate);
    }

    public static <T1 extends Collection<PeriodInRoute>,
            T2 extends Collection<DayInRoute>,
            T3 extends Collection<LocalDate>>
    Company generateCompany(Supplier<T1> factoryForPeriodInRoute,
                            Supplier<T2> factoryForDayInRoute,
                            Supplier<T3> factoryForLocalDate) {
        return new Company(factoryForPeriodInRoute, factoryForDayInRoute, factoryForLocalDate);
    }
}
