package tools;

public class MillingСutters extends MetalCuttingTool {
    public MillingСutters(double weightInKilograms, int strengthInHRC, double cuttingSpeedInMetersPerMinute) {
        super(weightInKilograms, strengthInHRC, cuttingSpeedInMetersPerMinute);
    }

    @Override
    public String toString() {
        return "MillingСutters: " + super.toString();
    }

    @Override
    public void work() {
        System.out.printf("Резец %s обрабатывает деталь\n", getId().toString());
    }
}
