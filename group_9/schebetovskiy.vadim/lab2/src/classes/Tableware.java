package classes;

import enums.SizeType;
import enums.TablewareMaterial;
import enums.Color;

import java.util.Objects;

public abstract class Tableware extends Product {
    private final TablewareMaterial tablewareMaterial;
    private final SizeType sizeType;

    public Tableware(TablewareMaterial tablewareMaterial, SizeType sizeType, Color color, double price) {
        super(color, price);
        this.tablewareMaterial = tablewareMaterial;
        this.sizeType = sizeType;
    }

    public TablewareMaterial getTablewareMaterial() {
        return tablewareMaterial;
    }

    public SizeType getSizeType() {
        return sizeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Tableware tableware = (Tableware) object;
        return tablewareMaterial == tableware.tablewareMaterial && sizeType == tableware.sizeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tablewareMaterial, sizeType);
    }

    @Override
    public String toString() {
        return "classes.Tableware{" +
                "material=" + tablewareMaterial +
                ", sizeType=" + sizeType +
                ", color=" + super.getColor() +
                ", price=" + super.getPrice() +
                '}';
    }
}
