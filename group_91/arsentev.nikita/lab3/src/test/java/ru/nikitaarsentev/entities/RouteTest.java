package ru.nikitaarsentev.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {
    private Route routeRandom;
    private Route routeWithStops;

    @BeforeEach
    void setUp() {
        Route.resetCountRoute();
        routeRandom = new Route();
        routeWithStops = new Route(15);
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(routeRandom);
        assertTrue(routeRandom.getNumberOfStops() >= Route.MIN_NUMBER_STOPS
                && routeRandom.getNumberOfStops() <= Route.MAX_NUMBER_STOPS);
    }

    @Test
    void testConstructorWithStops() {
        assertNotNull(routeWithStops);
        assertEquals(15, routeWithStops.getNumberOfStops());
    }

    @Test
    void testGetId() {
        assertEquals(0, routeRandom.getId());
        assertEquals(1, routeWithStops.getId());
    }

    @Test
    void testGetPriceInRubles() {
        assertEquals(Route.PRICE_IN_RUBLES, Route.getPriceInRubles());
    }

    @Test
    void testGetCountRoute() {
        assertEquals(2, Route.getCountRoute());
    }

    @Test
    void testToString() {
        String expectedDefault = "Route{id=0, numberOfStops=" + routeRandom.getNumberOfStops() + '}';
        String expectedWithStops = "Route{id=1, numberOfStops=15}";
        assertEquals(expectedDefault, routeRandom.toString());
        assertEquals(expectedWithStops, routeWithStops.toString());
    }

    @Test
    void testEquals() {
        Route sameRoute = routeRandom;
        Route anotherRouteWithDifferentId = new Route();

        assertEquals(routeRandom, sameRoute);
        assertNotEquals(routeRandom, routeWithStops);
        assertNotEquals(routeRandom, anotherRouteWithDifferentId);
    }

    @Test
    void testHashCode() {
        assertEquals(routeRandom.hashCode(), routeRandom.hashCode());
        assertNotEquals(routeRandom.hashCode(), routeWithStops.hashCode());
    }
}