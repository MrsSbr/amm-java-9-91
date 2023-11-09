package devices;

public class AirConditioner extends Device {
    private int operatingTemperature;

    public int getOperatingTemperature() {
        return operatingTemperature;
    }

    public void setOperatingTemperature(int operatingTemperature) {
        this.operatingTemperature = operatingTemperature;
    }

    public AirConditioner(int id, boolean condition, boolean connection, String produced, int productionYear,
                          int operatingTemperature) {
        super(id, condition, connection, produced, productionYear);
        this.operatingTemperature = operatingTemperature;
    }

    @Override
    public void deleteFromSystem() {
        System.out.println("Кондиционер удалён из системы");
    }

    @Override
    public void turnDeviceOn() {
        setCondition(true);
        System.out.println("Включить кондиционер");
    }

    @Override
    public void turnDeviceOff() {
        setCondition(false);
        System.out.println("Выключить кондиционер");
    }

    @Override
    public String toString() {
        return "devices.AirConditioner{" +
                "operatingTemperature=" + operatingTemperature +
                "} " + super.toString();
    }
}
