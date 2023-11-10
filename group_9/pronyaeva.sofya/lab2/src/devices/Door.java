package devices;

public class Door extends Device {
    final private String password;
    public String getPassword() {
        return password;
    }

    public Door(int id, boolean condition, boolean connection, String produced, int productionYear, String password) {
        super(id, condition, connection, produced, productionYear);
        this.password = password;
    }

    @Override
    public void deleteFromSystem() {
        System.out.println("Дверь удалена из системы");
    }

    @Override
    public void turnDeviceOn() {
        System.out.println("Открыть дверь");
    }

    @Override
    public void turnDeviceOff() {
        System.out.println("Заркыть дверь");
    }

    @Override
    public String toString() {
        return "devices.Door{" +
                "password='" + password + '\'' +
                "} " + super.toString();
    }
}
