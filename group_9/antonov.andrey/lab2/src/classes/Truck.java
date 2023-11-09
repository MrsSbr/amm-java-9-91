package classes;

import enums.BodyType;
import enums.FuelType;
import enums.TruckBrand;

import java.util.Objects;

public class Truck extends ConstructionMachine {

    private static final String BUILDING_MESSAGE = "Я перевожу тяжелые грузы!";

    private final TruckBrand truckBrand;
    private final FuelType fuelType;
    private final BodyType bodyType;

    public Truck(TruckBrand truckBrand, FuelType fuelType, BodyType bodyType, int loadCapacity) {
        super(loadCapacity);
        this.truckBrand = truckBrand;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
    }

    @Override
    public void build() {
        System.out.println(this + " - " + BUILDING_MESSAGE);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Truck truck = (Truck) object;
        return truckBrand == truck.truckBrand && fuelType == truck.fuelType && bodyType == truck.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(truckBrand, fuelType, bodyType);
    }

    @Override
    public String toString() {
        return "classes.Truck{" +
               "truckBrand=" + truckBrand +
               ", fuelType=" + fuelType +
               ", bodyType=" + bodyType +
               ", loadCapacity=" + super.getLoadCapacity() +
               '}';
    }
}
