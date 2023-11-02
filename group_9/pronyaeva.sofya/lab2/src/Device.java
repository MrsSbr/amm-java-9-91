import java.util.Objects;

public abstract class Device {
    final private int id;
    private boolean condition; // 0 - off, 1 - on
    private boolean connection; // 1 - connected to controller, 0 - not
    public String produced;
    public int productionYear;

    public Device (int id, boolean condition, boolean connection, String produced, int productionYear) {
        this.id = id;
        this.condition = condition;
        this.connection = connection;
        this.produced = produced;
        this.productionYear = productionYear;
    }

    public int getId() {
        return id;
    }

    public void setCondition (boolean condition) {
        this.condition = condition;
    }

    public void deleteFromSystem() {
        connection = false;
        System.out.println("Устройство удалено из системы");
    }

    public abstract void turnDeviceOn();

    public abstract void turnDeviceOff();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device device)) {
            return false;
        }
        return getId() == device.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", condition=" + condition +
                ", connection=" + connection +
                ", produced='" + produced + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
