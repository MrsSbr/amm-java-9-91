package ru.nikitaarsentev.entities;

import ru.nikitaarsentev.other.DeterminateNumberPath;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class DayInRoute {
    protected static final int MAX_NUMBER_BUSES = 20;
    protected static final int MIN_NUMBER_BUSES = 3;
    protected static final int MAX_NUMBER_NEW_CUSTOMER_AT_STOP = 5;
    protected static final int MIN_NUMBER_NEW_CUSTOMER_AT_STOP = 2;
    public final int idRoute;
    public final LocalDate localDate;
    private final int numberOfPath;
    private final int numberOfBus;
    private final int avgNewCustomerAtStop;
    private static final Random RANDOM = new Random();
    private int profit;

    public DayInRoute(Route route, LocalDate localDate) {
        this.idRoute = route.getId();
        this.localDate = localDate;
        numberOfBus = RANDOM.nextInt(MIN_NUMBER_BUSES, MAX_NUMBER_BUSES + 1);
        avgNewCustomerAtStop = RANDOM.nextInt(MIN_NUMBER_NEW_CUSTOMER_AT_STOP,
                MAX_NUMBER_NEW_CUSTOMER_AT_STOP + 1);
        numberOfPath = RANDOM.nextInt(DeterminateNumberPath.MIN_NUMBER_COMPLETED_PATH,
                DeterminateNumberPath.determineMaxNumberPath(localDate) + 1);
    }

    public DayInRoute(Route route, LocalDate localDate, int numberOfPath, int numberOfBus, int avgNewCustomerAtStop) {
        this.idRoute = route.getId();
        this.localDate = localDate;
        this.numberOfPath = numberOfPath;
        this.numberOfBus = numberOfBus;
        this.avgNewCustomerAtStop = avgNewCustomerAtStop;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getNumberOfPath() {
        return numberOfPath;
    }

    public int getNumberOfBus() {
        return numberOfBus;
    }

    public int getAvgNewCustomerAtStop() {
        return avgNewCustomerAtStop;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "DayInRoute{" +
                "idRoute=" + idRoute +
                ", localDate=" + localDate +
                ", numberOfPath=" + numberOfPath +
                ", numberOfBus=" + numberOfBus +
                ", avgNewCustomerAtStop=" + avgNewCustomerAtStop +
                ", profit=" + profit +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DayInRoute that)) {
            return false;
        }
        return getIdRoute() == that.getIdRoute()
                && Objects.equals(getLocalDate(), that.getLocalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRoute(), getLocalDate());
    }
}
