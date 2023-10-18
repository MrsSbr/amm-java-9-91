public class Lamp extends Device {
    private boolean nightMode;

    public void setNightMode(boolean nightMode) {
        this.nightMode = nightMode;
    }

    public Lamp(int id, boolean condition, boolean connection, String produced, int productionYear,
                 boolean nightMode) {
        super(id, condition, connection, produced, productionYear);
        setNightMode(nightMode);
    }

    @Override
    public void deleteFromSystem() {
        System.out.format("Лампа %d удалена из системы\n", getId());
    }

    @Override
    public void turnDeviceOn() {
        System.out.format("Включить лампу %d\n", getId());
    }

    @Override
    public void turnDeviceOff() {
        System.out.format("Выключить лампу %d\n", getId());
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "nightMode=" + nightMode +
                "} " + super.toString();
    }
}
