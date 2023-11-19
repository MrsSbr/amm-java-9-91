package main.java.org.example;

public class TeaPackage {
    private final TeaType teaType;
    private final int harvestingYear;
    private final int weight; // grams

    public TeaPackage(TeaType teaType, int harvestingYear, int weight) {
        this.teaType = teaType;
        this.harvestingYear = harvestingYear;
        this.weight = weight;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public int getHarvestingYear() {
        return harvestingYear;
    }

    public int getWeight() {
        return weight;
    }
}
