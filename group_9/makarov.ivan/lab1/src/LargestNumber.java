import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        // Преобразуем числа в строки для сравнения
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]); // Преобразуем числа в строки
        }

        // Определение сравнения для сортировки
        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));
        // Сортировка массива строк в порядке, который обеспечит наибольшее число
        // Сравниваем строки, объединяя их в разных порядках и сортируем по убыванию


        // Объединяем отсортированные строки в результат
        StringBuilder result = new StringBuilder();
        for (String num : numsStr) {
            result.append(num); // Объединяем строки в одну
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 2};
        System.out.println(largestNumber(nums1)); // Вывод: "210"

        int[] nums2 = {0, 3, 0, 30, 34, 0, 5, 9, 0};
        System.out.println(largestNumber(nums2)); // Вывод: "9534330"
    }
}