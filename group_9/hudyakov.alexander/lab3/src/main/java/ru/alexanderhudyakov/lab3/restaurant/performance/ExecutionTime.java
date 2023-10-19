package ru.alexanderhudyakov.lab3.restaurant.performance;

public class ExecutionTime {
    private long creation;
    private long uniqueDishes;
    private long totalIncome;
    private long mostExpensiveDishes;

    public ExecutionTime(long creation, long uniqueDishes, long totalIncome, long mostExpensiveDishes) {
        this.creation = creation;
        this.uniqueDishes = uniqueDishes;
        this.totalIncome = totalIncome;
        this.mostExpensiveDishes = mostExpensiveDishes;
    }
    public long getCreation() {
        return creation;
    }
    public long getUniqueDishes() {
        return uniqueDishes;
    }
    public long getTotalIncome() {
        return totalIncome;
    }
    public long getMostExpensiveDishes() {
        return mostExpensiveDishes;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public void setUniqueDishes(long uniqueDishes) {
        this.uniqueDishes = uniqueDishes;
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setMostExpensiveDishes(long mostExpensiveDishes) {
        this.mostExpensiveDishes = mostExpensiveDishes;
    }
}
