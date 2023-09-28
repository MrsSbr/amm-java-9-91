package ships;

import java.util.Objects;

public class Ferry extends Ship implements CivilShip {

    private int passengers;

    public Ferry(String name, int displacement) {
        super(name, displacement);
    }

    public void addPassengers(int count) {
        passengers += count;
    }

    public int getPassengersCount() {
        return passengers;
    }

    @Override
    public String getDescription() {
        return "Паром";
    }

    @Override
    public void sail() {
        System.out.println("Паром " + getName() + " отправлятеся в плавание. Пассажиров на борту: " + passengers);
        if (passengers > 10) {
            passengers -= 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ferry ferry = (Ferry) o;
        return passengers == ferry.passengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengers);
    }

    @Override
    public String toString() {
        return "Ferry{" +
                "passengers=" + passengers +
                "} " + super.toString();
    }

}
