import java.util.Random;

public class SmartHomeDevices {
    public static void smartHomeDevicesTest() {
        Controller controller = new Controller();

        controller.printSensorsAndDevices();
        controller.changeDoorCondition("23rhiu2r02");
        controller.changeTemperature(20);
        controller.changeLampCondition(2, true, true);

        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(0, 6);
        controller.getExtraInformationAboutRandomDevice(controller.getDevice(index));

        controller.deleteSystem();
    }

    public static void main(String[] arg) {
        smartHomeDevicesTest();
    }
}
