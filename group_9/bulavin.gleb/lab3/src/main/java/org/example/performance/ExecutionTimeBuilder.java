package org.example.performance;


public final class ExecutionTimeBuilder {
    private long creation;
    private long convictedPeople;
    private long yearWithHighestPercentageAcquittals;
    private long defendantAndPlaintiffPeople;

    private ExecutionTimeBuilder() {
    }

    public static ExecutionTimeBuilder anExecutionTime() {
        return new ExecutionTimeBuilder();
    }

    public ExecutionTimeBuilder withCreation(long creation) {
        this.creation = creation;
        return this;
    }

    public ExecutionTimeBuilder withConvictedPeople(long convictedPeople) {
        this.convictedPeople = convictedPeople;
        return this;
    }

    public ExecutionTimeBuilder withYearWithHighestPercentageAcquittals(long yearWithHighestPercentageAcquittals) {
        this.yearWithHighestPercentageAcquittals = yearWithHighestPercentageAcquittals;
        return this;
    }

    public ExecutionTimeBuilder withDefendantAndPlaintiffPeople(long defendantAndPlaintiffPeople) {
        this.defendantAndPlaintiffPeople = defendantAndPlaintiffPeople;
        return this;
    }

    public ExecutionTime build() {
        return new ExecutionTime(creation, convictedPeople, yearWithHighestPercentageAcquittals, defendantAndPlaintiffPeople);
    }
}

