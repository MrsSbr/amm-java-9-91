package org.example.performance;

public class ExecutionTime {
    private long creation;
    private long convictedPeople;
    private long yearWithHighestPercentageAcquittals;
    private long defendantAndPlaintiffPeople;

    public ExecutionTime(long creation, long convictedPeople, long yearWithHighestPercentageAcquittals, long defendantAndPlaintiffPeople) {
        this.creation = creation;
        this.convictedPeople = convictedPeople;
        this.yearWithHighestPercentageAcquittals = yearWithHighestPercentageAcquittals;
        this.defendantAndPlaintiffPeople = defendantAndPlaintiffPeople;
    }

    public long getCreation() {
        return creation;
    }

    public long getConvictedPeople() {
        return convictedPeople;
    }

    public long getYearWithHighestPercentageAcquittals() {
        return yearWithHighestPercentageAcquittals;
    }

    public long getDefendantAndPlaintiffPeople() {
        return defendantAndPlaintiffPeople;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public void setConvictedPeople(long convictedPeople) {
        this.convictedPeople = convictedPeople;
    }

    public void setYearWithHighestPercentageAcquittals(long yearWithHighestPercentageAcquittals) {
        this.yearWithHighestPercentageAcquittals = yearWithHighestPercentageAcquittals;
    }

    public void setDefendantAndPlaintiffPeople(long defendantAndPlaintiffPeople) {
        this.defendantAndPlaintiffPeople = defendantAndPlaintiffPeople;
    }
}

