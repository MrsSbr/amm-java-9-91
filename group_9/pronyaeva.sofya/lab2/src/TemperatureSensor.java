import java.util.Objects;

public class TemperatureSensor extends SensorSettings implements Sensor {
    final private int minTemperature;
    final private int maxTemperature;
    private int currentTemperature;
    private int prevTemp;

    public int getPrevTemp() { return prevTemp; }

    public void setCurrentTemperature(int currentTemperature) {
        prevTemp = this.currentTemperature;
        this.currentTemperature = currentTemperature;
    }

    public TemperatureSensor(int id, String name, boolean active, int minTemp, int maxTemp, int curTemp) {
        super(id, name, active);
        this.minTemperature = minTemp;
        this.maxTemperature = maxTemp;
        this.currentTemperature = curTemp;
        this.prevTemp = curTemp;
    }

    @Override
    public String sendNotification() {
        if (currentTemperature > prevTemp) {
            return String.format("Температура повысилась на %d грудусов", currentTemperature - prevTemp);
        } else if (currentTemperature < prevTemp) {
            return String.format("Температура понизилась на %d грудусов", prevTemp - currentTemperature);
        }
        return "Температура не изменилась";
    }

    @Override
    public void blockSensor() {
        active = false;
        System.out.format("Датчик %s заблокирован\n", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TemperatureSensor that)) {
            return false;
        }
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", currentTemperature=" + currentTemperature +
                ", prevTemp=" + prevTemp +
                '}';
    }
}
