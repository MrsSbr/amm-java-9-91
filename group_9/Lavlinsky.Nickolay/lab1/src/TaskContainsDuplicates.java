import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TaskContainsDuplicates {
    public static void main(String[] args) {

        System.out.println("Input size of array:");

        Scanner scan = new Scanner(System.in);

        int[] arr = new int[scan.nextInt()];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            System.out.println("Input your number:");
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {

            if (set.contains(arr[i])) {
                System.out.println("True");
                return;
            }
            set.add(arr[i]);
        }
        System.out.println("false");

    }
}
