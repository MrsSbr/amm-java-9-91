package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    private static final Logger logger = LogManager.getLogger(Input.class);

    public static int getInt() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(in.next());
            } catch (NumberFormatException exception) {
                System.out.println("Некорректный ввод. Повторите!");
                logger.error(exception + "\n" + Arrays.toString(exception.getStackTrace()));
            }
        }
    }

    public static int getIntInRange(int left, int right) {
        while (true) {
            int result = getInt();
            if (result >= left && result <= right) {
                return result;
            } else {
                logger.info("Число должно быть в диапазоне [" + left + ";" + right + "]");
                System.out.println("Число должно быть в диапазоне [" + left + ";" + right + "]");
            }
        }
    }
}
