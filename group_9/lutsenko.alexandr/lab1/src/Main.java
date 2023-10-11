/**
 * Дан целочисленный массив nums,
 * вернуть true, если его можно сделать строго возрастающим после удаления ровно одного элемента,
 * или false в противном случае. Если массив уже строго возрастающий, вернуть true.
 *
 * @author          ПММ 9 группа 3 курс Луценко Александр
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean mayIncrease(ArrayList<Integer> nums) {
        int count = 0; // Счетчик элементов, которые можно удалить
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                count++;
                if (count > 1) {
                    return false; // Если более одного элемента надо удалить, вернуть false
                }
                if (i > 1 && nums.get(i) <= nums.get(i - 2)) {
                    nums.set(i, nums.get(i - 1)); // Удалить текущий элемент, сделав его равным предыдущему
                }
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите числа (для завершения введите -1): ");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                break; // Если введено -1, завершаем ввод
            }
            nums.add(num);
        }

        System.out.println("Содержимое массива:");
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        boolean result = mayIncrease(nums);
        System.out.println("Массив можно сделать строго возрастающим после удаления одного элемента: " + result);
    }
}