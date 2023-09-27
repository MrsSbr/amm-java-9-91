import java.util.Arrays;
import java.util.Scanner;

public class Robbery {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 1000;
    private static final int MAX_LENGTH = 100;
    private static final int MIN_LENGTH = 1;

    private static int[] InitArray() {
        System.out.print("Enter the number of houses: ");
        var scanner = new Scanner(System.in);
        var numberOfHouses = scanner.nextInt();

        if (numberOfHouses < MIN_LENGTH || numberOfHouses > MAX_LENGTH) {
            return null;
        }
        return new int[numberOfHouses];
    }

    private static void FillArray(int[]array) {
        System.out.println("Fill array:");
        var scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            var sumAtHome = scanner.nextInt();

            if(sumAtHome < MIN_VALUE || sumAtHome > MAX_VALUE) {
                array[i] = MIN_VALUE;
            }
            else {
                array[i] = sumAtHome;
            }
        }
    }

    private static int MaxSum(int[]array) {
        if(array.length == 1) {
            return array[0];
        }

        if(array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        int sumIgnoringLastHouse = 0;
        int sumStartingFromSecondHouse = 0;
        int sumIgnoringFirstHouse = 0;

        for (int i = 0; i < array.length-1; i += 2) {
            sumIgnoringLastHouse += array[i];
        }

        for(int i = 1; i < array.length; i += 2) {
            sumStartingFromSecondHouse += array[i];
        }

        for(int i = array.length-1; i > 0; i -= 2) {
            sumIgnoringFirstHouse += array[i];
        }

        return Math.max(sumIgnoringLastHouse,Math.max(sumStartingFromSecondHouse,
                sumIgnoringFirstHouse));
    }


    public static void main(String[] args) {
        var array = InitArray();

        if(array == null) {
            System.out.println("Uncorrect input");
            return;
        }

        FillArray(array);

        int maxSumRobbery = MaxSum(array);
        System.out.println("Максимальное количество награбленных денег: "  + maxSumRobbery);
    }
}