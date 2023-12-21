package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flight {
    private Integer idFlight;
    private List<Integer> passages;
    private LocalDate date;

    public Flight(Integer number, LocalDate date, List<Integer> passages) {
        this.date = date;
        this.passages = passages;
        this.idFlight = number;
    }

    public Flight() {
        idFlight = null;
        passages = new ArrayList<Integer>();
        date = null;
    }

    public Integer getNumber() {
        return idFlight;
    }

    public void setNumber(Integer number) {
        this.idFlight = number;
    }

    public List<Integer> getPassages() {
        return passages;
    }

    public void setPassages(List<Integer> passages) {
        this.passages = passages;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(idFlight, flight.idFlight) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight, date);
    }
}
