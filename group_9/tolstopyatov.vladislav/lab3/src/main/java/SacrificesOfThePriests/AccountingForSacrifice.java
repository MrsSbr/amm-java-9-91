package SacrificesOfThePriests;

import java.time.LocalDate;

public class AccountingForSacrifice {

    private Sacrifice victim;   // жертва
    private int numberOfDaysUntilTheNextRain; // кол-во дней до след. дождя
    private LocalDate timeOfSacrifice;  // время жертвоприношения

    public AccountingForSacrifice(Sacrifice victim, int numberOfDaysUntilTheNextRain, LocalDate timeOfSacrifice) {
        this.victim = victim;
        this.numberOfDaysUntilTheNextRain = numberOfDaysUntilTheNextRain;
        this.timeOfSacrifice = timeOfSacrifice;
    }

    public Sacrifice getVictim() {
        return victim;
    }

    public int getNumberOfDaysUntilTheNextRain() {
        return numberOfDaysUntilTheNextRain;
    }

    public LocalDate getTimeOfSacrifice() {
        return timeOfSacrifice;
    }

    public void setVictim(Sacrifice victim) {
        this.victim = victim;
    }

    public void setNumberOfDaysUntilTheNextRain(int numberOfDaysUntilTheNextRain) {
        this.numberOfDaysUntilTheNextRain = numberOfDaysUntilTheNextRain;
    }

    public void setTimeOfSacrifice(LocalDate timeOfSacrifice) {
        this.timeOfSacrifice = timeOfSacrifice;
    }
}
