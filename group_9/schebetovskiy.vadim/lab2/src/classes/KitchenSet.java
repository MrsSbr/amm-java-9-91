package classes;

import enums.FurnitureMaterial;
import enums.SizeType;
import enums.Color;

public class KitchenSet extends Furniture {

    public KitchenSet(FurnitureMaterial furnitureMaterial, SizeType sizeType, Color color,
                      double price, boolean deliveryOrdered) {
        super(furnitureMaterial, sizeType, color, price, deliveryOrdered);
    }

    @Override
    public void deliverByCourierService() {
        System.out.println("The courier service loaded the kitchen set and took it to the designated place." +
                " The buyer paid " + DeliverableByOrder.PRICE + " rubles for courier delivery.");
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
        if (getDeliveryOrdered())
            deliverByCourierService();
        System.out.println("The kitchen furniture is delivered! It remains only to assemble it.");
    }

    @Override
    public String toString() {
        return "KitchenSet{" + super.toString() + "}";
    }
}
