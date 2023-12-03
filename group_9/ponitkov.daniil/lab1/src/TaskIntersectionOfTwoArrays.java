import java.util.HashSet;
import java.util.Set;

public class TaskIntersectionOfTwoArrays {
    public static Integer[] intersection(Integer[] nums1, Integer[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Заполним первое множество уникальными элементами из nums1
        for (Integer num : nums1) {
            set1.add(num);
        }

        // Заполним второе множество уникальными элементами из nums2
        for (Integer num : nums2) {
            set2.add(num);
        }

        // Найдем пересечение множеств
        set1.retainAll(set2);

        // Преобразуем результат в массив с использованием метода toArray
        return set1.toArray(new Integer[set1.size()]);
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 2, 2, 1};
        Integer[] nums2 = {2, 2};
        Integer[] result = intersection(nums1, nums2);

        System.out.println("Уникальное пересечение: ");
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}