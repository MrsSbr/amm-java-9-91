package entities;

import java.time.LocalDateTime;

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
}
