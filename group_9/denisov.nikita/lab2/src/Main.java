import Vehicle.Car;
import Vehicle.Motorbike;
import Vehicle.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[]{
                new Car("Audi", "A1", 100),
                new Car("Toyota", "Corolla", 120),
                new Motorbike("Kawasaki", "Ninja 300", 10),
                new Motorbike("Honda", "CBR1000RR", 20),
                new Car("Mercedes", "C-Class", 140),
                new Motorbike("BMW", "F850 GS", 15),
        };

        menu(vehicles);
    }

    public static void menu(Vehicle[] vehicles) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.print("""
                    ГЛАВНОЕ МЕНЮ

                    [1]. Работа с транспортным средством
                    [0]. Завершить работу
                    Введите действие:\s""");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1 -> print(vehicles);
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

    public static void print(Vehicle[] vehicles) {
        for (Vehicle it : vehicles) {
            System.out.println();

            if (it instanceof Car car) {
                car.start();
                car.stop();
            } else if (it instanceof Motorbike motorbike) {
                System.out.println(motorbike.getFuelCapacity());

                motorbike.start();
                motorbike.stop();
            }
            System.out.println();
        }
    }
}
