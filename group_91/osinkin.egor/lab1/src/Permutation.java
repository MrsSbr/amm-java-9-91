import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        int len;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1 <= len <= 6");
            System.out.println("Input len: ");
            len = in.nextInt();
        } while (len < 1 || len > 6);
        Set<Integer> included = new HashSet<>();
        int[] array = new int[len];
        int i = 0;
        int tmp;
        while (i < len) {
            System.out.printf("Input array[%d]: ", i);
            tmp = in.nextInt();
            if (tmp <= 10 && tmp >= -10 && !included.contains(tmp)) {
                included.add(tmp);
                array[i] = tmp;
                i++;
            } else {
                System.out.println("Error, need unic -10<=elem<=10");
            }
        }
        getPermutations(array, len, len);
    }

    public static void printArr(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void getPermutations(int[] nums, int size, int n) {
        if (size == 1) {
            printArr(nums, n);
        }
        for (int i = 0; i < size; i++) {
            getPermutations(nums, size - 1, n);
            if (size % 2 == 1) {
                int temp = nums[0];
                nums[0] = nums[size - 1];
                nums[size - 1] = temp;
            } else {
                int temp = nums[i];
                nums[i] = nums[size - 1];
                nums[size - 1] = temp;
            }
        }

    }
}