package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class WorkingWhithUser {
    private static final Logger logger = LogManager.getLogger(TaskPlants.class);

    public static void menuInstructions() {
        System.out.println("\nВыберите действие:\n");
        System.out.println("1. Для каждого цветка найти среднюю чистоту полива.\n");
        System.out.println("2. Для каждого удобрения найти цветы, им удобренные.\n");
        System.out.println("3. Найти цветок, в который вылили больше всего воды.\n");
        System.out.println("4. Завершить выполнение задач\n");
    }

    public static int inputIntInRange(int lower, int top) {
        int inputInt;
        while (true) {
            inputInt = inputInt();
            if (inputInt <= top && inputInt >= lower) {
                return inputInt;
            } else {
                logger.info("Число не удовлетворяет условию: " + lower + " <= " + inputInt + " <= " + top);
            }
        }
    }

    private static int inputInt() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод\n");
                logger.error(e + "\n" + Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
