package classes;

import enums.Color;
import enums.PlateClassification;
import enums.SizeType;
import enums.TablewareMaterial;

public class Plate extends Tableware {

    private final int diameter;
    private final PlateClassification plateClassification;

    public Plate(TablewareMaterial tablewareMaterial, SizeType sizeType, int diameter,
                 Color color, PlateClassification plateClassification, double price) {
        super(tablewareMaterial, sizeType, color, price);
        this.diameter = diameter;
        this.plateClassification = plateClassification;
    }

    public int getDiameter() {
        return diameter;
    }

    public PlateClassification getPlateClassification() {
        return plateClassification;
    }

    @Override
    public void inspect() {
        System.out.println("This plate is " + super.getColor().name().toLowerCase() + " in color, " +
                super.getSizeType().name().toLowerCase() + " in size, " +
                diameter + " cm in diameter, " +
                "made of " + super.getTablewareMaterial().name().toLowerCase() + ", " +
                plateClassification.name().toLowerCase() + " plate by appointment, " +
                "it's nice to eat from it!");
    }

    @Override
    public void buy() {
        System.out.println("The plate is packed in a box and purchased for " + super.getPrice() + " rubles.");
    }

    @Override
    public void deliver() {
        System.out.println("The plate is delivered! Now the owner eats from it!");
    }

    @Override
    public String toString() {
        return "Plate{" + super.toString() + "}";
    }

}
