package ru.nikitaarsentev.entities;

import java.util.Objects;
import java.util.Random;

public class Route {
    protected static final int PRICE_IN_RUBLES = 30;
    protected static final int MAX_NUMBER_STOPS = 25;
    protected static final int MIN_NUMBER_STOPS = 10;
    private static final Random RANDOM = new Random();
    private static int countRoute = 0;
    private final int id;
    private final int numberOfStops;

    public Route() {
        id = countRoute;
        countRoute++;
        numberOfStops = RANDOM.nextInt(MIN_NUMBER_STOPS, MAX_NUMBER_STOPS + 1);
    }

    public Route(int numberOfStops) {
        id = countRoute;
        countRoute++;
        this.numberOfStops = numberOfStops;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public static int getPriceInRubles() {
        return PRICE_IN_RUBLES;
    }

    public static int getCountRoute() {
        return countRoute;
    }

    public static void resetCountRoute() {
        countRoute = 0;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", numberOfStops=" + numberOfStops +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Route route)) {
            return false;
        }
        return Objects.equals(getId(), route.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
