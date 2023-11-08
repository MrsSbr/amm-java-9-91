package tools;
import java.util.Objects;
public abstract class MeasuringTool extends ConstructionTool {
    private double measurementAccuracy;
    private double maxMeasurementInMeters;

    public MeasuringTool(double weightInKilograms, double measurementAccuracy, double maxMeasurementInMeters) {
        super(weightInKilograms);
        this.measurementAccuracy = measurementAccuracy;
        this.maxMeasurementInMeters = maxMeasurementInMeters;
    }

    public double getMeasurementAccuracy() {
        return measurementAccuracy;
    }

    public void setMeasurementAccuracy(double measurementAccuracy) {
        this.measurementAccuracy = measurementAccuracy;
    }

    public double getMaxMeasurementInMeters() {
        return maxMeasurementInMeters;
    }

    public void setMaxMeasurementInMeters(double maxMeasurementInMeters) {
        this.maxMeasurementInMeters = maxMeasurementInMeters;
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
        MeasuringTool measuringInstrument = (MeasuringTool) obj;
        return this.measurementAccuracy == measuringInstrument.measurementAccuracy &&
                this.maxMeasurementInMeters == measuringInstrument.maxMeasurementInMeters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementAccuracy, maxMeasurementInMeters, super.hashCode());
    }

    @Override
    public String toString() {
        return "MeasuringInstrument {" +
                "measurementAccuracy = " + measurementAccuracy + "; " +
                "maxMeasurementInMeters = "+ maxMeasurementInMeters + "; " +
                super.toString() + "}";
    }
}
