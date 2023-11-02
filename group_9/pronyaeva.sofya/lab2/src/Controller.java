import java.util.ArrayList;
import java.util.List;

public class Controller {
        TemperatureSensor temperatureSensor;
        List<MotionSensor> motionSensors = new ArrayList<>(5);
        List<Device> devices = new ArrayList<>(7);
        
        Controller() {
            temperatureSensor = new TemperatureSensor(1, "tempSensor", true,
                    1, 50, 25);
            initMotionSensors();
            devices.add(new AirConditioner(7, false, true,
                    "SONY", 2015, 20));
            initLamps();
            devices.add(new Door(13, false, true, "SONY", 2020,
                    "23rhiu2r02"));
        }

        public Device getDevice(int index) {
            return devices.get(index);
        }
        
        public void printSensorsAndDevices() {
           System.out.println("\nПодключение системы:");
           System.out.println(temperatureSensor);
           for (MotionSensor motionSensor : motionSensors) {
               System.out.println(motionSensor);
            }
           for (Device device : devices) {
               System.out.println(device);
           }
        }

        public void changeTemperature(int curTemp) {
            System.out.println();
            temperatureSensor.setCurrentTemperature(curTemp);
            System.out.format("Температура воздуха сейчас = %d С\n", curTemp);

            int prevTemp = temperatureSensor.getPrevTemp();
            String notification = temperatureSensor.sendNotification();

            System.out.format("Температура воздуха раньше = %d С\n", prevTemp);
            System.out.println(notification);
            if (!notification.equals("Температура не изменилась")) {
                devices.get(0).turnDeviceOn();
                ((AirConditioner)devices.get(0)).setOperatingTemperature(prevTemp + prevTemp - curTemp);
            }
            System.out.format("Температура кондиционера сейчас = %d С\n",
                    ((AirConditioner)devices.get(0)).getOperatingTemperature());
        }

        public void changeLampCondition(int lampIndex, boolean personMovement, boolean nightMode) {
            System.out.println();
            motionSensors.get(lampIndex).setPersonMovement(personMovement);
            if (motionSensors.get(lampIndex).getPersonMovement()) {
                devices.get(lampIndex).turnDeviceOn();
                ((Lamp)devices.get(lampIndex)).setNightMode(nightMode);
                System.out.format("Режим %s\n", nightMode ? "ночной" : "дневной");
            } else {
                devices.get(lampIndex).turnDeviceOff();
            }
        }

        public void changeDoorCondition(String password) {
            System.out.println();
            if (password.equals(((Door)devices.get(6)).getPassword())) {
                System.out.print("Пароль верный. ");
                devices.get(6).turnDeviceOn();
            } else {
                System.out.print("Неверный пароль! ");
                devices.get(6).turnDeviceOff();
            }
        }

        public void deleteSystem() {
            System.out.println("\nУдаление системы:");
            temperatureSensor.blockSensor();
            for (MotionSensor motionSensor : motionSensors) {
                motionSensor.blockSensor();
            }
            for (Device device : devices) {
                device.deleteFromSystem();
            }
        }

        public void getExtraInformationAboutRandomDevice(Device device) {
            System.out.println();
            if (device instanceof  AirConditioner) {
                System.out.println("Температура = " + ((AirConditioner) device).getOperatingTemperature());
            }
            if (device instanceof Door) {
                System.out.println("Пароль = " + ((Door) device).getPassword());
            }
            if (device instanceof Lamp) {
                String message = ((Lamp) device).getNightMode() ? "Ночной режим" : "Дневной режим";
                System.out.println(message);
            }
        }

        private void initMotionSensors() {
            for (int i = 0; i < 5; ++i) {
                motionSensors.add(new MotionSensor(i + 2, "motionSensor", true, false));
            }
        }

        private void initLamps() {
            for (int i = 0; i < 5; ++i) {
                devices.add(new Lamp(i + 8, false, true, "SONY", 2021,
                        false));
            }
        }
}
