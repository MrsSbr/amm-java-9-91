package ru.nikitaarsentev.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nikitaarsentev.entities.DayInRoute;
import ru.nikitaarsentev.entities.Route;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProfitTest {
    private Route routeMock;
    private DayInRoute dayInRouteMock1;
    private DayInRoute dayInRouteMock2;

    @BeforeEach
    void setUp() {
        routeMock = mock(Route.class);
        dayInRouteMock1 = mock(DayInRoute.class);
        dayInRouteMock2 = mock(DayInRoute.class);

        when(routeMock.getNumberOfStops()).thenReturn(10);

        when(dayInRouteMock1.getAvgNewCustomerAtStop()).thenReturn(5);
        when(dayInRouteMock1.getNumberOfPath()).thenReturn(3);
        when(dayInRouteMock1.getNumberOfBus()).thenReturn(2);

        when(dayInRouteMock2.getAvgNewCustomerAtStop()).thenReturn(4);
        when(dayInRouteMock2.getNumberOfPath()).thenReturn(4);
        when(dayInRouteMock2.getNumberOfBus()).thenReturn(3);
    }

    @Test
    void testCountProfitSingleDay() {
        List<DayInRoute> dayInRouteList = Collections.singletonList(dayInRouteMock1);
        // numberOfStops * avgNewCustomerAtStop * priceInRubles * numberOfPath * numberOfBus
        long expectedProfit = (long) 10 * 5 * 30 * 3 * 2;
        assertEquals(expectedProfit, Profit.countProfit(dayInRouteList, routeMock));
    }

    @Test
    void testCountProfitMultipleDays() {
        List<DayInRoute> dayInRouteList = Arrays.asList(dayInRouteMock1, dayInRouteMock2);
        long expectedProfit = (long) 10 * 5 * 30 * 3 * 2 + (long) 10 * 4 * 30 * 4 * 3;
        assertEquals(expectedProfit, Profit.countProfit(dayInRouteList, routeMock));
    }

    @Test
    void testCountProfitNoBuses() {
        when(dayInRouteMock1.getNumberOfBus()).thenReturn(0);
        List<DayInRoute> dayInRouteList = Collections.singletonList(dayInRouteMock1);
        assertEquals(0, Profit.countProfit(dayInRouteList, routeMock));
    }

    @Test
    void testCountProfitNoPaths() {
        when(dayInRouteMock1.getNumberOfPath()).thenReturn(0);
        List<DayInRoute> dayInRouteList = Collections.singletonList(dayInRouteMock1);
        assertEquals(0, Profit.countProfit(dayInRouteList, routeMock));
    }

    @Test
    void testCountProfitNoCustomers() {
        when(dayInRouteMock1.getAvgNewCustomerAtStop()).thenReturn(0);
        List<DayInRoute> dayInRouteList = Collections.singletonList(dayInRouteMock1);
        assertEquals(0, Profit.countProfit(dayInRouteList, routeMock));
    }

}