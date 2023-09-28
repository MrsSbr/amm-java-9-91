import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;

public class CoinChange {
    public static int getPositiveNum() {
        int res = -1;
        while (res < 0) {
            System.out.print("Введите положительное число: ");
            try {
                Scanner in = new Scanner(System.in);
                res = in.nextInt();
                if (res < 0) {
                    System.out.println("Введено невозможное значение");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Введено некорректное значение");
            }
        }
        return res;
    }

    public static void getArrayCoins(int[] array, int size) {
        boolean arrayNotCorrectFull = true; //Флаг ошибки заполнения массива

        while (arrayNotCorrectFull) {
            System.out.print("Введите " + size + " значений номинала через пробел: ");
            arrayNotCorrectFull = false; //Сброс флага для попытки заполнения
            Scanner in = new Scanner(System.in);
            String[] str = in.nextLine().split(" "); //чтение строки и разбиение её по " "
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = Integer.parseInt(str[i]);
                    if (array[i] < 1 || array[i] > (Math.pow(2, 31) - 1)) {
                        System.out.println("Ошибка. В списке есть некорректное значение");
                        i = size;
                        arrayNotCorrectFull = true;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Ошибка. В списке есть некорректное значение");
                    i = size;
                    arrayNotCorrectFull = true;
                }
            }
        }
    }

    public static int minCountCoins(int[] coins, int size, int amount) {
        Map<Integer, Integer> interimRes = new HashMap<>(); //словарь для промежуточных сумм в подсчёте рекурсии
        int res = recursMinCountCoins(coins, size, amount + 1, amount, interimRes);
        if (res > amount) {
            res = -1;
        }
        return res;
    }

    private static int recursMinCountCoins(int[] coins, int size, int impossibleCount, int amount, Map<Integer, Integer> interimRes) { //impossibleCount - значение большее суммы размена
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return impossibleCount;
        }
        if (interimRes.containsKey(amount)) {
            return interimRes.get(amount);
        }
        int res = impossibleCount;
        for (int i = 0; i < size; i++) {
            res = Math.min(res, recursMinCountCoins(coins, size, impossibleCount, amount - coins[i], interimRes) + 1);
        }
        interimRes.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        //Размер массива
        int size = 0;
        System.out.println("Ожидается ввод количества вариантов номиналов монет");
        while (size < 1 || size > 12) {
            System.out.println("Количество вариантов не может быть меньше 1 и больше 12");
            size = getPositiveNum();
        }

        //Массив номиналов монет
        int[] coins = new int[size];
        getArrayCoins(coins, size);

        //Общая сумма монет
        int amount = -1;
        System.out.println("Ожидается ввод общей суммы");
        while (amount < 0 || amount > 10000) {
            System.out.println("Сумма не может быть меньше 0 и больше 10000");
            amount = getPositiveNum();
        }

        int res = minCountCoins(coins, size, amount);
        //Красивый вывод
        /* if (res != -1) {
            System.out.println("Количество монет необходимых для размена суммы = " + amount + ": " + res);
        } else{
            System.out.println("Невозможно разменять сумму = " + amount);
        }*/
        System.out.println("Ответ: " + res);
    }
}