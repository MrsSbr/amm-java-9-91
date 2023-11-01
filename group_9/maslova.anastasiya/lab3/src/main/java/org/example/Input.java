package org.example;

import java.util.Scanner;

public class Input {
    public static int getInt() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(in.next());
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
                System.out.println("Некорректный ввод. Повторите!");
            }
        }
    }

    public static int getIntInRange(int left, int right) {
        int result = 0;

        while (true) {
            result = getInt();
            if (result >= left && result <= right) {
                return result;
            } else {
                System.out.println("Число должно быть в диапазоне [" + left + ";" + right + "]");
            }
        }
    }
}