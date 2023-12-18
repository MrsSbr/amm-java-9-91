package main.java;
import java.util.ArrayList;
import java.util.List;

public class FloristRecord {
    private List<FlowerBouquet> records = new ArrayList<>();

    public void addRecord(FlowerBouquet bouquet) {
        records.add(bouquet);
    }

    public List<FlowerBouquet> getRecords() {
        return records;
    }
}