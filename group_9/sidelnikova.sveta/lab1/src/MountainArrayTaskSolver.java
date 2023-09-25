import java.util.Scanner;

public class MountainArrayTaskSolver {
    public static void main(String[] args) {
        int[] numbers;
        System.out.print("Enter array size: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        numbers = new int[size];
        System.out.print("Enter " + (size) + " elements: ");
        for (int i = 0; i < size; i++) {
            if (scanner.hasNextInt()) {
                numbers[i] = scanner.nextInt();
            }
            else {
                numbers[i] = 0;
                scanner.next();
            }
        }
        System.out.print("Input: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("]");
        System.out.print("Output: " + (findLongestMountainInArray(numbers)));
    }

    public static int findLongestMountainInArray(int[] array) {
        int size = array.length;
        int counter = 0;
        if (size > 3) {
            int left = 0, right = 0;
            while (left < size - 1) {
                right = left + 1;
                if (array[left] < array[left + 1]) {
                    while (right < size - 1 && array[right] < array[right + 1])
                        right++;
                    if (right < size - 1 && array[right] > array[right + 1]) {
                        while (right < size - 1 && array[right] > array[right + 1])
                            right++;
                        counter = Math.max((right - left) + 1, counter);
                    }
                }
                left = right;
            }
        }
        return counter;
    }
}
