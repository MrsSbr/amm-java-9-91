package com.mycompany.delivery;

import java.util.Objects;

public abstract class AbstractDelivery implements Delivery {
    protected String packageCode;
    protected String destination;

    public AbstractDelivery(String packageCode, String destination) {
        this.packageCode = packageCode;
        this.destination = destination;
    }

    // Абстрактный метод класса, который будет реализован в подклассах
    public abstract String deliver();

    @Override
    public String toString() {
        return "AbstractDelivery{" +
                "packageCode='" + packageCode + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDelivery)) return false;
        AbstractDelivery that = (AbstractDelivery) o;
        return Objects.equals(packageCode, that.packageCode) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageCode, destination);
    }
}
