import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.SocketOption;
import java.util.Scanner;

public class Main {

    public static int[] arrayRes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        while(true){
            System.out.println("Введите элементы массива:");
            for(int i=0; i<size; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean flag = true;

            for(int i=0; i<size-1; i++){
                if (nums[i] > nums[i+1]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println("Массив отсортированный!");
                break;
            }
            else{
                System.out.println("Массив не отсортирован! Введите значения заново.");
            }
        }
        return nums;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] nums = arrayRes();
        System.out.println("Введите число для поиска места:");
        int target = scanner.nextInt();

        System.out.println("Позиция числа " + target + " = " + searchInsert(nums, target));
    }
}
