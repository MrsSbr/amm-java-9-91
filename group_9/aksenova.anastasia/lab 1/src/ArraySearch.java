import java.util.Scanner;

public class ArraySearch {
    public static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        while (true) {
            System.out.println("Введите элементы массива:");

            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean sorted = true;

            for (int i = 0; i < size - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                System.out.println("Массив отсортирован!");
                return nums;
            }

            System.out.println("Массив не отсортирован! Введите значения заново.");
        }
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = createArray();
        System.out.println("Введите число для поиска места:");
        int target = scanner.nextInt();
        System.out.println("Позиция числа " + target + " = " + searchInsert(nums, target));
    }

}
