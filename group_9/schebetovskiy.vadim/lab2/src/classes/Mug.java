package classes;

import enums.SizeType;
import enums.TablewareMaterial;
import enums.Color;

public class Mug extends Tableware{
    public Mug(TablewareMaterial tablewareMaterial, SizeType sizeType, Color color, double price){
        super(tablewareMaterial, sizeType, color, price);
    }

    @Override
    public void inspect() {
        System.out.println("This mug is " + super.getColor().name().toLowerCase() + " in color, " +
                super.getSizeType().name().toLowerCase() + " in size, " +
                "made of " + super.getTablewareMaterial().name().toLowerCase() +
                ", it's nice to hold it in your hand!");
    }

    @Override
    public void buy() {
        System.out.println("The mug is packed in a box and purchased for " + super.getPrice() + " rubles.");
    }

    @Override
    public void deliver() {
        System.out.println("The mug is delivered! Now the owner drinks from it!");
    }

    @Override
    public String toString() {
        return "Mug{" + super.toString() + "}";
    }
}
