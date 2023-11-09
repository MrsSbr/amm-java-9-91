package sensors;

import java.util.Objects;

public class MotionSensor extends SensorSettings implements Sensor {
    private boolean personMovement;

    public boolean getPersonMovement() {
        return personMovement;
    }

    public void setPersonMovement(boolean personMovement) {
        this.personMovement = personMovement;
    }

    public MotionSensor(int id, String name, boolean active, boolean personMovement) {
        super(id, name, active);
        this.personMovement = personMovement;
    }

    @Override
    public String sendNotification() {
        if (personMovement) {
            return "Обнаружено движение человека";
        }
        return "Движение человека не обнаружено";
    }

    @Override
    public void blockSensor() {
        active = false;
        System.out.format("Датчик %s %d заблокирован\n", name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MotionSensor that)) {
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
        return "sensors.MotionSensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", personMovement=" + personMovement +
                '}';
    }
}
