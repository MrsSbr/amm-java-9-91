import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Заполним первое множество уникальными элементами из nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Заполним второе множество уникальными элементами из nums2
        for (int num : nums2) {
            set2.add(num);
        }

        // Найдем пересечение множеств
        set1.retainAll(set2);

        // Преобразуем результат в массив
        int[] result = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);

        System.out.print("Уникальное пересечение: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}