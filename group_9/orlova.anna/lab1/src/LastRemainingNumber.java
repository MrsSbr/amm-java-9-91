import java.util.Arrays;
public class LastRemainingNumber {
    public static int task(int n) {

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = i + 1;

        System.out.println(Arrays.toString(arr));

        boolean leftToRight = true;

        while (n > 1) {
            int[] newArr = new int[n / 2];
            int index = 0;

            if (leftToRight) {
                for (int i = 1; i < n; i += 2) {
                    newArr[index++] = arr[i];
                }
            } else {
                for (int i = n - 2; i >= 0; i -= 2) {
                    newArr[(n/2 - index++ - 1)] = arr[i];
                }
            }

            arr = newArr;
            n = arr.length;
            System.out.println(Arrays.toString(arr));
            leftToRight = !leftToRight;
        }

        return arr[0];
    }
}
