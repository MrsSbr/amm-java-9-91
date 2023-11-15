package classes;

import enums.SizeType;
import enums.FurnitureMaterial;
import enums.Color;

import java.util.Objects;

public abstract class Furniture extends Product {
    private final FurnitureMaterial furnitureMaterial;
    private final SizeType sizeType;
    private boolean deliveryOrdered;

    Furniture(FurnitureMaterial furnitureMaterial, SizeType sizeType, Color color, double price, boolean deliveryOrdered) {
        super(color, price);
        this.furnitureMaterial = furnitureMaterial;
        this.sizeType = sizeType;
        this.deliveryOrdered = deliveryOrdered;
    }

    public FurnitureMaterial getFurnitureMaterial() {
        return furnitureMaterial;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    public boolean isDeliveryOrdered() {
        return deliveryOrdered;
    }

    public void setDeliveryOrdered(boolean deliveryOrdered) {
        this.deliveryOrdered = deliveryOrdered;
    }

    public abstract void deliverByCourierService();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Furniture furniture = (Furniture) object;
        return furnitureMaterial == furniture.furnitureMaterial && sizeType == furniture.sizeType &&
                deliveryOrdered == furniture.deliveryOrdered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureMaterial, sizeType, deliveryOrdered);
    }


    @Override
    public String toString() {
        return "classes.Tableware{" +
                "material=" + furnitureMaterial +
                ", sizeType=" + sizeType +
                ", color=" + super.getColor() +
                ", price=" + super.getPrice() +
                ", deliveryOrdered=" + deliveryOrdered +
                '}';
    }

}
