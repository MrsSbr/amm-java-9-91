package SacrificesOfThePriests;

import java.time.LocalDate;

public class AccountingForSacrifice {
    private VictimType victimType;   // тип жертвы
    private int numberOfDaysUntilTheNextRain; // кол-во дней до след. дождя
    private LocalDate timeOfSacrifice;  // время жертвоприношения

    public AccountingForSacrifice(VictimType victimType, int numberOfDaysUntilTheNextRain, LocalDate timeOfSacrifice) {
        this.victimType = victimType;
        this.numberOfDaysUntilTheNextRain = numberOfDaysUntilTheNextRain;
        this.timeOfSacrifice = timeOfSacrifice;
    }

    public VictimType getVictimType() {
        return victimType;
    }

    public void setVictimType(VictimType victimType) {
        this.victimType = victimType;
    }

    public int getNumberOfDaysUntilTheNextRain() {
        return numberOfDaysUntilTheNextRain;
    }

    public void setNumberOfDaysUntilTheNextRain(int numberOfDaysUntilTheNextRain) {
        this.numberOfDaysUntilTheNextRain = numberOfDaysUntilTheNextRain;
    }

    public LocalDate getTimeOfSacrifice() {
        return timeOfSacrifice;
    }

    public void setTimeOfSacrifice(LocalDate timeOfSacrifice) {
        this.timeOfSacrifice = timeOfSacrifice;
    }
}
