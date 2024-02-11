package ru.nikitaarsentev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private int countRoutes;

    @BeforeEach
    void setUp() {
        final int durability = 7;
        countRoutes = 5;
        Supplier<Collection<PeriodInRoute>> periodInRouteSupplier = ArrayList::new;
        Supplier<Collection<DayInRoute>> dayInRouteSupplier = ArrayList::new;
        Supplier<Collection<LocalDate>> localDateSupplier = ArrayList::new;
        company = new Company(durability, countRoutes, periodInRouteSupplier, dayInRouteSupplier, localDateSupplier);
    }

    @Test
    void testCompanyConstructorWithParameters() {
        assertNotNull(company);
        assertEquals(countRoutes, company.getCountRoutes());
    }

    @Test
    void testCompanyConstructorWithoutParameters() {
        Supplier<Collection<PeriodInRoute>> periodInRouteSupplier = ArrayList::new;
        Supplier<Collection<DayInRoute>> dayInRouteSupplier = ArrayList::new;
        Supplier<Collection<LocalDate>> localDateSupplier = ArrayList::new;

        Company defaultCompany = new Company(periodInRouteSupplier, dayInRouteSupplier, localDateSupplier);
        assertNotNull(defaultCompany);
        assertEquals(Company.DEFAULT_COUNT_ROUTES, defaultCompany.getCountRoutes());
    }

    @Test
    void testCountResult() {
        Supplier<List<Long>> factory = ArrayList::new;
        company.countResult(factory);
        // Проверка, что был получен результат для каждого маршрута
        assertNotNull(company.getAmounts());
        assertEquals(countRoutes, company.getAmounts().size());
    }
}