package tools;

import java.util.Objects;

public abstract class MetalCuttingTool extends ConstructionTool {
    private int strengthInHRC;
    private double cuttingSpeedInMetersPerMinute;

    public MetalCuttingTool(double weightInKilograms, int strengthInHRC, double cuttingSpeedInMetersPerMinute)
    {
        super(weightInKilograms);
        this.strengthInHRC = strengthInHRC;
        this.cuttingSpeedInMetersPerMinute = cuttingSpeedInMetersPerMinute;
    }

    public int getStrengthInHRC() {
        return strengthInHRC;
    }

    public void setStrengthInHRC(int strengthInHRC) {
        this.strengthInHRC = strengthInHRC;
    }

    public int getCuttingSpeedInMetersPerMinute() {
        return strengthInHRC;
    }

    public void setCuttingSpeedInMetersPerMinute(int cuttingSpeedInMetersPerMinute) {
        this.cuttingSpeedInMetersPerMinute = cuttingSpeedInMetersPerMinute;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if(!super.equals(obj)) {
            return false;
        }
        MetalCuttingTool metalCuttingTool = (MetalCuttingTool) obj;
        return this.strengthInHRC == metalCuttingTool.strengthInHRC &&
                this.cuttingSpeedInMetersPerMinute == metalCuttingTool.cuttingSpeedInMetersPerMinute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strengthInHRC, cuttingSpeedInMetersPerMinute, super.hashCode());
    }

    @Override
    public String toString() {
        return "MetalCuttingTool {" +
                "strengthInHRC=" + strengthInHRC + "; " +
                "cuttingSpeedInMetersPerMinute="+ cuttingSpeedInMetersPerMinute + "; " +
                super.toString() + "}";
    }
}
