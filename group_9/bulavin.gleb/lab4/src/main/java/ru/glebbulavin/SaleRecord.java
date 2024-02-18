package ru.glebbulavin;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleRecord {
    private LocalDate date;
    private String dealershipName;
    private String carName;
    private String configuration;
    private BigDecimal markup;

    public SaleRecord(LocalDate date, String dealershipName, String carName, String configuration, BigDecimal markup) {
        this.date = date;
        this.dealershipName = dealershipName;
        this.carName = carName;
        this.configuration = configuration;
        this.markup = markup;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public String getCarName() {
        return carName;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public BigDecimal getMarkup() {
        return markup;
    }
}
