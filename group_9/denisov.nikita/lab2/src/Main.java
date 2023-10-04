import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Vehicle[] vehicles = {
                new Car("Audi", "A1", 100),
                new Motorbike("BMW", "F850 GS"),
        };
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.print("""
                    ГЛАВНОЕ МЕНЮ

                    [1]. Работа с автомобилем
                    [2]. Работа с мотоциклом
                    [0]. Завершить работу
                    Введите действие:\s""");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1, 2 -> print(vehicles[choice - 1]);
                case 0 -> {
                    scanner.close();
                    System.out.print("Работа программы завершена.");
                }
                default -> {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                    scanner.nextLine();
                }
            }
        } while (choice != 0);
    }

    public static void print(VehicleInterface vehicle) {
        System.out.println();

        vehicle.start();
        vehicle.stop();

        System.out.println();
    }
}
