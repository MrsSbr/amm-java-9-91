package input;

import java.util.Scanner;

public class InputHandler {

    public static int[] getValidArray(int minLength, int maxLength, int minValue, int maxValue) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину массива:");
        int n = getValidNumber(scanner, minLength, maxLength);

        int[] nums = new int[n];
        System.out.println("Введите элементы массива (" + n + " штук):");

        for (int i = 0; i < n; i++) {
            nums[i] = getValidNumber(scanner, minValue, maxValue);
        }

        return nums;
    }

    private static int getValidNumber(Scanner scanner, int min, int max) {
        int number;

        do {
            System.out.print("Введите число (от " + min + " до " + max + "): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Неверный формат! Пожалуйста, введите число!");
                scanner.next();
            }

            number = scanner.nextInt();

            if (number < min || number > max) {
                System.out.println("Число вне диапазона!");
            }
        } while (number < min || number > max);

        return number;
    }

}
