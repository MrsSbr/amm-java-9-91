import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashSet;
public class Main {
    private static int [] fillArray(int n)
    {
        Scanner stream = new Scanner(System.in);
        int [] newArray = new int[n];
        System.out.println("Введите номера конфет: ");
        int i = 0;
        while (i < n) {
         try {
               newArray[i] = stream.nextInt();
               if (Math.abs(newArray[i]) <= 100000) {
                   i++;
               }
           }
        catch (InputMismatchException ex){
            System.out.println("Было введено неверное значение!\nПовторите ввод:\n");
           }
        }
        return newArray;
    }
    private static int countTypesCandy(int[]candyType){
        HashSet <Integer> variantsCandies = new HashSet<Integer>();
        for (int i = 0; i < candyType.length; i++) {
            variantsCandies.add(candyType[i]);
        }
        return variantsCandies.size();
    }
    public static int maxCountCandies(int acceptableCount, int countTypes){
        if (acceptableCount > countTypes) {
            return countTypes;
        }
        return acceptableCount;
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
        System.out.println(String.format("Максимальное количество типов конфет: %d\n", maxCountCandies(acceptableCount, countTypes)));
    }
}