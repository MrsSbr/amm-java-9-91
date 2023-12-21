package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class PreparedDrinkAccounting {
    public String drinkName;
    public LocalDateTime dateOfPreparation;
    public int timeOfPreparationInSeconds;
    public double price;

    public PreparedDrinkAccounting(String drinkName, LocalDateTime dateOfPreparation,
                                   int timeOfPreparationInSeconds, double price) {
        this.drinkName = drinkName;
        this.dateOfPreparation = dateOfPreparation;
        this.timeOfPreparationInSeconds = timeOfPreparationInSeconds;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public LocalDateTime getDateOfPreparation() {
        return dateOfPreparation;
    }

    public void setDateOfPreparation(LocalDateTime dateOfPreparation) {
        this.dateOfPreparation = dateOfPreparation;
    }

    public int getTimeOfPreparationInSeconds() {
        return timeOfPreparationInSeconds;
    }

    public void setTimeOfPreparationInSeconds(int timeOfPreparationInSeconds) {
        this.timeOfPreparationInSeconds = timeOfPreparationInSeconds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreparedDrinkAccounting that = (PreparedDrinkAccounting) o;
        return timeOfPreparationInSeconds == that.timeOfPreparationInSeconds
                && Double.compare(price, that.price) == 0
                && Objects.equals(drinkName, that.drinkName)
                && Objects.equals(dateOfPreparation, that.dateOfPreparation);
    }

    @Override
    public String toString() {
        return "PreparedDrinkAccounting{" +
                "drinkName='" + drinkName + '\'' +
                ", dateOfPreparation=" + dateOfPreparation +
                ", timeOfPreparationInSeconds=" + timeOfPreparationInSeconds +
                ", price=" + price +
                '}';
    }
}
