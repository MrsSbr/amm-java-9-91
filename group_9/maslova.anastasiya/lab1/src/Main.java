import java.util.Arrays;

public class Main {
    public static int numBoats(int[] people, int limit) {
        if (people.length < 1 || people.length > 5 * Math.pow(10, 4)) {
            return -1;
        }

        for (int p : people) {
            if (p < 1 || p > limit || limit > 3 * Math.pow(10, 4)) {
                return -1;
            }
        }

        Arrays.sort(people);

        int num = 0;
        int i = 0, j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            num++;
        }

        return num;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2};
        int limit1 = 3;
        System.out.println("Test №1:");
        System.out.println(numBoats(test1, limit1));

        int[] test2 = {3, 2, 2, 1};
        int limit2 = 3;
        System.out.println("Test №2:");
        System.out.println(numBoats(test2, limit2));

        int[] test3 = {3, 5, 3, 4};
        int limit3 = 5;
        System.out.println("Test №3:");
        System.out.println(numBoats(test3, limit3));
    }
}