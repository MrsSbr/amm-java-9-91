package classes;

import enums.CraneBrand;
import enums.CraneStrokeType;
import enums.TypeCraneConstruction;

import java.util.Objects;

public class Crane extends ConstructionMachine {

    private static final String BUILDING_MESSAGE = "Я помогаю поднимать грузы!";

    private final CraneBrand craneBrand;
    private final TypeCraneConstruction typeCraneConstruction;
    private final CraneStrokeType craneStrokeType;

    public Crane(CraneBrand craneBrand, TypeCraneConstruction typeCraneConstruction, CraneStrokeType craneStrokeType, int loadCapacity) {
        super(loadCapacity);
        this.craneBrand = craneBrand;
        this.typeCraneConstruction = typeCraneConstruction;
        this.craneStrokeType = craneStrokeType;
    }

    @Override
    public void build() {
        System.out.println(this + " - " + BUILDING_MESSAGE);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Crane crane = (Crane) object;
        return craneBrand == crane.craneBrand && typeCraneConstruction == crane.typeCraneConstruction && craneStrokeType == crane.craneStrokeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(craneBrand, typeCraneConstruction, craneStrokeType);
    }

    @Override
    public String toString() {
        return "classes.Crane{" +
               "craneBrand=" + craneBrand +
               ", typeCraneConstruction=" + typeCraneConstruction +
               ", craneStrokeType=" + craneStrokeType +
               ", loadCapacity=" + super.getLoadCapacity() +
               '}';
    }
}
