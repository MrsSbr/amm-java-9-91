package ru.nikitadenisov.deals;

import java.time.LocalDate;

public class Deal {
    private String manager;
    private String buyer;
    private double dealAmount;
    private LocalDate serviceDate;

    public Deal(String manager, String buyer, double dealAmount, LocalDate serviceDate) {
        this.manager = manager;
        this.buyer = buyer;
        this.dealAmount = dealAmount;
        this.serviceDate = serviceDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(double dealAmount) {
        this.dealAmount = dealAmount;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }
}
