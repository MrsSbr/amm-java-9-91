package tools;

import java.util.UUID;

public abstract class ConstructionTool implements Tool {
    private double weightInKilograms;
    private final UUID id;
    public ConstructionTool(double weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
        id = UUID.randomUUID();
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public void setWeightInKilograms(double weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ConstructionTool measuringInstrument = (ConstructionTool) obj;
        return this.weightInKilograms == measuringInstrument.weightInKilograms &&
                this.id.equals(measuringInstrument.id);
    }

    @Override
    public String toString() {
        return "ConstructionTool{" +
                "weightInKilograms=" + weightInKilograms +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weightInKilograms);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + id.hashCode();
        return result;
    }
}
