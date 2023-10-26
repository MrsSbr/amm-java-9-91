package classes;

import enums.SizeType;
import enums.FurnitureMaterial;
import enums.Color;

import java.util.Objects;

public abstract class KitchenFurniture extends Furniture implements DeliverableByOrder {

    private final boolean isDeliveryOrdered;

    public KitchenFurniture(FurnitureMaterial furnitureMaterial, SizeType sizeType,
                            Color color, double price, boolean isDeliveryOrdered) {
        super(furnitureMaterial, sizeType, color, price);
        this.isDeliveryOrdered = isDeliveryOrdered;
        if (isDeliveryOrdered)
            super.setPrice(price + DeliverableByOrder.PRICE);
    }


    public boolean getIsDeliveryOrdered() {
        return isDeliveryOrdered;
    }


    public abstract void deliverByCourierService();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        KitchenFurniture kitchenFurniture = (KitchenFurniture) object;
        return isDeliveryOrdered == kitchenFurniture.isDeliveryOrdered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isDeliveryOrdered);
    }

    @Override
    public String toString() {
        return "classes.KitchenFurniture{" +
                "isDeliveryOrdered='" + isDeliveryOrdered + '\'' +
                "} " + super.toString();
    }
}
