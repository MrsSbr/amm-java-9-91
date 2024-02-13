package ru.nikitaarsentev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PeriodInRouteTest {
    private PeriodInRoute periodInRouteWithCustomDurability;
    private PeriodInRoute periodInRouteDefault;

    @BeforeEach
    void setUp() {
        Route.resetCountRoute();
        periodInRouteWithCustomDurability = new PeriodInRoute(10, ArrayList::new, ArrayList::new);
        periodInRouteDefault = new PeriodInRoute(ArrayList::new, ArrayList::new);
    }

    @Test
    void testCustomDurabilityConstructor() {
        assertNotNull(periodInRouteWithCustomDurability);
        assertNotNull(periodInRouteWithCustomDurability.daysInRouteList);
        assertNotNull(periodInRouteWithCustomDurability.route);
        assertEquals(10, periodInRouteWithCustomDurability.getDurability());
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(periodInRouteDefault);
        assertNotNull(periodInRouteDefault.daysInRouteList);
        assertNotNull(periodInRouteDefault.route);
        assertEquals(PeriodInRoute.DEFAULT_DURABILITY, periodInRouteDefault.getDurability());
    }
}
