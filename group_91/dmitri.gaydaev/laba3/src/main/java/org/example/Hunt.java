package org.example;

import java.time.LocalDate;

public class Hunt {
    private String hunter;
    private int weight;
    private LocalDate date;

    public Hunt(String hunter, int weight, int year, int month, int day) {
        this.hunter = hunter;
        this.weight = weight;
        this.date = LocalDate.of(year, month, day);
    }



    public String getHunter() {
        return hunter;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getDate() {
        return date;
    }
}
