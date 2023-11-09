package makeup;
import java.util.Objects;

public class Mascara extends CosmeticProduct {
    private boolean isWaterproof;

    public Mascara(String name, double price, boolean isWaterproof) {
        super(name, price);
        this.isWaterproof = isWaterproof;
    }

    @Override
    public void describe() {
        System.out.println("Это тушь. Водостойкая: " + isWaterproof);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mascara mascara = (Mascara) obj;
        return Double.compare(mascara.price, price) == 0 &&
                Objects.equals(name, mascara.name) &&
                mascara.isWaterproof == isWaterproof;
    }
}
