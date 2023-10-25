package classes;

import enums.FurnitureMaterial;
import enums.SizeType;
import enums.Color;

public class KitchenSet extends KitchenFurniture{

    public KitchenSet(FurnitureMaterial furnitureMaterial, SizeType sizeType, Color color,
               double price, boolean isDeliveryOrdered){
        super(furnitureMaterial, sizeType, color, price, isDeliveryOrdered);
    }

    @Override
    public void deliverByCourierService() {
        if (super.getIsDeliveryOrdered())
            System.out.println("The courier service loaded the kitchen set and took it to the designated place.");
    }

    @Override
    public void inspect() {
        System.out.println("This kitchen set is " + super.getColor().name().toLowerCase() + " in color, " +
                super.getSizeType().name().toLowerCase() + " in size, " +
                "made of " + super.getFurnitureMaterial().name().toLowerCase() +
                ", it looks good!");
    }

    @Override
    public void buy() {
        System.out.println("Parts are distributed in boxes, " +
                "the kitchen set is purchased for " + super.getPrice() + " rubles.");
    }

    @Override
    public void deliver() {
        deliverByCourierService();
        System.out.println("The kitchen furniture is delivered! It remains only to assemble it)");
    }

    @Override
    public String toString() {
        return "KitchenSet{" + super.toString() + "}";
    }
}
