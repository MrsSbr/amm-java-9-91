package ru.nikitadenisov.deals;

import java.time.LocalDate;

public class Deal {
    private final String manager;
    private final String buyer;
    private final double dealAmount;
    private final LocalDate serviceDate;

    public Deal(String manager, String buyer, double dealAmount, LocalDate serviceDate) {
        this.manager = manager;
        this.buyer = buyer;
        this.dealAmount = dealAmount;
        this.serviceDate = serviceDate;
    }

    public String getManager() {
        return manager;
    }

    public String getBuyer() {
        return buyer;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }
}
