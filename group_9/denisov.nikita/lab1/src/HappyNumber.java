import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("""
                    ГЛАВНОЕ МЕНЮ

                    [1]. Проверка числа (является ли оно счастливым)
                    [0]. Завершить работу

                    Выберите действие:\s""");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1' -> {
                    task(scanner);
                }
                case '0' -> {
                    scanner.close();
                    System.out.print("Работа программы завершена.");
                }
                default -> {
                    System.out.println("Ошибка ввода. Попробуйте снова.");
                }
            }
        } while (choice != '0');
    }

    public static void task(Scanner scanner) {
        System.out.print("Введите число: ");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            System.out.println("Является ли число " + number + " счастливым: " + isHappy(number));
        } else {
            System.out.println("Ошибка ввода. Попробуйте снова.");
            scanner.next(); // Считываем некорректный ввод, чтобы очистить буфер.
        }
    }

    public static boolean isHappy(int number) {
        Set<Integer> numbers = new HashSet<>();

        // Число не является счастливым, если в процессе работы алгоритма появляется бесконечный цикл.
        // 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16...
        // Проверяем, содержится ли в последовательности число, которое мы получили в результате работы алгоритма.
        while (number != 1 && !numbers.contains(number)) {
            numbers.add(number);
            number = nextNumber(number);
        }

        return number == 1;
    }

    private static int nextNumber(int number) {
        int result = 0;
        int digit;

        while (number > 0) {
            digit = number % 10;
            result += digit * digit;
            number /= 10;
        }

        return result;
    }
}