package classes;

import enums.SizeType;
import enums.FurnitureMaterial;
import enums.Color;

import java.util.Objects;

public abstract class Furniture extends Product {

    private final FurnitureMaterial furnitureMaterial;
    private final SizeType sizeType;

    Furniture(FurnitureMaterial furnitureMaterial, SizeType sizeType, Color color, double price) {
        super(color, price);
        this.furnitureMaterial = furnitureMaterial;
        this.sizeType = sizeType;
    }

    public FurnitureMaterial getFurnitureMaterial() {
        return furnitureMaterial;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Furniture furniture = (Furniture) object;
        return furnitureMaterial == furniture.furnitureMaterial && sizeType == furniture.sizeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureMaterial, sizeType);
    }

    @Override
    public String toString() {
        return "classes.Tableware{" +
                "material=" + furnitureMaterial +
                ", sizeType=" + sizeType +
                ", color=" + super.getColor() +
                ", price=" + super.getPrice() +
                '}';
    }
}
