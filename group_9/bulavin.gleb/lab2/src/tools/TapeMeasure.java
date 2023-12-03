package tools;

public class TapeMeasure extends MeasuringTool {

    public TapeMeasure(double weightInKilograms, double measurementAccuracy, double maxMeasurementInMeters) {
        super(weightInKilograms, measurementAccuracy, maxMeasurementInMeters);
    }

    @Override
    public void work() {
        System.out.printf("Рулетка %s измеряет длину\n", getId().toString());
    }
    @Override
    public String toString() {
        return "TapeMeasure: " + super.toString();
    }
}
