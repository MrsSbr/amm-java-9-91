package org.example;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BicycleRace {
    private final List<Integer> numbersParticipant;
    //private final Calendar dateRace;
    private final LocalDate dateRace;
    private final Map<Integer, Integer> finalList;

    public BicycleRace(Map<Integer, Integer> finalList, List<Integer> numbersParticipant, LocalDate dateRace) {
        this.finalList = finalList;
        this.numbersParticipant = numbersParticipant;
        this.dateRace = dateRace;
    }

    public Map<Integer, Integer> getFinalList() {
        return finalList;
    }

    public List<Integer> getNumbersParticipant() {
        return numbersParticipant;
    }

    public LocalDate getDateRace() {
        return dateRace;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BicycleRace bicycleRace = (BicycleRace) object;
        return finalList == bicycleRace.finalList && numbersParticipant == bicycleRace.numbersParticipant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalList, dateRace, numbersParticipant);
    }

    @Override
    public String toString() {
        return "BicycleRace{" +
                "finalList=" + finalList +
                ", numbersParticipant=" + numbersParticipant +
                ", dateRace=" + dateRace +
                '}';
    }
}