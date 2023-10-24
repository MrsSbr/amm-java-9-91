package ru.alexanderhudyakov.lab3.restaurant.performance;

public final class ExecutionTimeBuilder {
    private long creation;
    private long uniqueDishes;
    private long totalIncome;
    private long mostExpensiveDishes;
    private ExecutionTimeBuilder() {
    }
    public static ExecutionTimeBuilder anExecutionTime() {
        return new ExecutionTimeBuilder();
    }

    public ExecutionTimeBuilder withCreation(long creation) {
        this.creation = creation;
        return this;
    }
    public ExecutionTimeBuilder withUniqueDishes(long uniqueDishes) {
        this.uniqueDishes = uniqueDishes;
        return this;
    }
    public ExecutionTimeBuilder withTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
        return this;
    }
    public ExecutionTimeBuilder withMostExpensiveDishes(long mostExpensiveDishes) {
        this.mostExpensiveDishes = mostExpensiveDishes;
        return this;
    }
    public ExecutionTime build() {
        return new ExecutionTime(creation, uniqueDishes, totalIncome, mostExpensiveDishes);
    }
}
