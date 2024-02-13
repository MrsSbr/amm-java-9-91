package ru.nikitaarsentev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DayInRouteTest {
    private Route routeRandom;
    private DayInRoute dayInRouteRandom;
    private DayInRoute dayInRouteCustom;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        Route.resetCountRoute();
        routeRandom = new Route();
        Route routeCustom = new Route(12);
        today = LocalDate.now();
        dayInRouteRandom = new DayInRoute(routeRandom, today);
        dayInRouteCustom = new DayInRoute(routeCustom, today, 5, 10, 3);
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(dayInRouteRandom);
        assertEquals(0, dayInRouteRandom.getIdRoute());
        assertEquals(today, dayInRouteRandom.getLocalDate());
        assertTrue(dayInRouteRandom.getNumberOfBus() >= DayInRoute.MIN_NUMBER_BUSES &&
                dayInRouteRandom.getNumberOfBus() <= DayInRoute.MAX_NUMBER_BUSES);
        assertTrue(dayInRouteRandom.getAvgNewCustomerAtStop() >= DayInRoute.MIN_NUMBER_NEW_CUSTOMER_AT_STOP &&
                dayInRouteRandom.getAvgNewCustomerAtStop() <= DayInRoute.MAX_NUMBER_NEW_CUSTOMER_AT_STOP);
    }

    @Test
    void testCustomConstructor() {
        assertNotNull(dayInRouteCustom);
        assertEquals(1, dayInRouteCustom.getIdRoute());
        assertEquals(today, dayInRouteCustom.getLocalDate());
        assertEquals(5, dayInRouteCustom.getNumberOfPath());
        assertEquals(10, dayInRouteCustom.getNumberOfBus());
        assertEquals(3, dayInRouteCustom.getAvgNewCustomerAtStop());
    }

    @Test
    void testGetters() {
        assertEquals(0, dayInRouteRandom.getIdRoute());
        assertEquals(today, dayInRouteRandom.getLocalDate());
        assertEquals(5, dayInRouteCustom.getNumberOfPath());
        assertEquals(10, dayInRouteCustom.getNumberOfBus());
        assertEquals(3, dayInRouteCustom.getAvgNewCustomerAtStop());
    }

    @Test
    void testProfit() {
        dayInRouteRandom.setProfit(100);
        assertEquals(100, dayInRouteRandom.getProfit());
    }

    @Test
    void testToString() {
        String expectedString = "DayInRoute{idRoute=0, localDate=" + today +
                ", numberOfPath=" + dayInRouteRandom.getNumberOfPath() +
                ", numberOfBus=" + dayInRouteRandom.getNumberOfBus() +
                ", avgNewCustomerAtStop=" + dayInRouteRandom.getAvgNewCustomerAtStop() +
                ", profit=" + dayInRouteRandom.getProfit() + '}';
        assertEquals(expectedString, dayInRouteRandom.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        DayInRoute sameDay = new DayInRoute(routeRandom, today);
        DayInRoute differentDay = new DayInRoute(routeRandom, today.plusDays(1));

        assertEquals(dayInRouteRandom, sameDay); // Одинаковые idRoute и localDate
        assertNotEquals(dayInRouteRandom, differentDay); // Отличается localDate

        assertEquals(dayInRouteRandom.hashCode(), sameDay.hashCode());
        assertNotEquals(dayInRouteRandom.hashCode(), differentDay.hashCode());
    }
}