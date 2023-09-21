import java.util.Arrays;
import java.util.Scanner;

public class JumpGame {

    private static int findMinimumJumps(int[] numbers) {
        int jumps = 0;
        int farthestReachableIndex = 0;
        int currentJumpMaxIndex = 0;

        for (int i = 0; i < numbers.length - 1; ++i) {
            if (i + numbers[i] > farthestReachableIndex) {
                farthestReachableIndex = i + numbers[i];
            }
            if (i == currentJumpMaxIndex) {
                ++jumps;
                currentJumpMaxIndex = farthestReachableIndex;
            }
        }

        return jumps;
    }

    private static int[] readArrayFromConsole() {
        var scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.print("Введите массив: ");
        int[] numbers = readArrayFromConsole();
        int minimumJumps = findMinimumJumps(numbers);
        System.out.println("Минимальное количество прыжков: " + minimumJumps);
    }

}