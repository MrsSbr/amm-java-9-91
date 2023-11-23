import java.util.Arrays;
import java.util.Scanner;

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

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("""
                    ГЛАВНОЕ МЕНЮ

                    [1]. Построить самое большое число
                    [0]. Завершить работу

                    Выберите действие:\s""");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1' -> {
                    System.out.print("Введите количество чисел в массиве: ");
                    int arraySize = scanner.nextInt();
                    int[] array = new int[arraySize];

                    for (int i = 0; i < array.length; i++) {
                        System.out.print("Введите число " + (i + 1) + ": ");
                        array[i] = scanner.nextInt();
                    }
                    System.out.println(largestNumber(array));
                }
                case '0' -> {
                    scanner.close();
                    System.out.print("Работа программы завершена.");
                }
                default -> System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        } while (choice != '0');
    }
    public static void main(String[] args)
    {
        menu();
    }
}