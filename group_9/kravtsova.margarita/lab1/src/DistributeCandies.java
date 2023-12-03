import java.util.*;

public class DistributeCandies {
    private static int[] fillArray(int n) {
        Scanner stream = new Scanner(System.in);
        int[] newArray = new int[n];
        System.out.println("Введите номера конфет: ");
        int i = 0;
        while (i < n) {
            try {
                newArray[i] = stream.nextInt();
                if (Math.abs(newArray[i]) <= 100000) {
                    i++;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Было введено неверное значение!\nПовторите ввод:\n");
                ex.printStackTrace();
            }
        }
        return newArray;
    }

    private static int countTypesCandy(int[] candyType) {
        Set<Integer> variantsCandies = new HashSet<>();
        for (int j : candyType) {
            variantsCandies.add(j);
        }
        return variantsCandies.size();
    }

    public static int maxCountCandies(int acceptableCount, int countTypes) {
        return Math.min(acceptableCount, countTypes);
    }

    public static void main(String[] args) {
        int n;
        int[] candiesTypes;
        System.out.println("Введите число n: ");
        Scanner in = new Scanner(System.in);
        boolean error = false;
        do {
            if (error) {
                System.out.println("Введено неверное значение!\nПовторите ввод:");
            }
            n = in.nextInt();
            error = true;
        } while (n < 2 || n > 10000 || n % 2 != 0);
        candiesTypes = fillArray(n);
        int acceptableCount = n / 2;
        int countTypes = countTypesCandy(candiesTypes);
        System.out.printf("Максимальное количество типов конфет: %d\n%n", maxCountCandies(acceptableCount, countTypes));
    }
}