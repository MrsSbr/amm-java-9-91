package ru.denismandrusenko;

public class TempleRecord {
    private final String temple;
    private final String god;
    private final String donor;
    private final int donationAmount;

    public TempleRecord(String temple, String god, String donor, int donationAmount) {
        this.temple = temple;
        this.god = god;
        this.donor = donor;
        this.donationAmount = donationAmount;
    }

    public String getTemple() {
        return temple;
    }

    public String getGod() {
        return god;
    }

    public String getDonor() {
        return donor;
    }

    public int getDonationAmount() {
        return donationAmount;
    }
}