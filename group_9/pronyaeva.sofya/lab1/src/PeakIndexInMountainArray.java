import java.util.Scanner;

public class PeakIndexInMountainArray {

    public static int[] fillArray(int arrayLength, Scanner scanner) {
        // заполнение массива
        int[] array = new int[arrayLength];
        System.out.print("Введите элементы массива -> ");
        for (int i = 0; i < array.length; ++i){
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            } else {
                array[i] = 1;
            }
        }
        return array;
    }
    public static int arrayValidation(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[0] < 0 || array[0] > 1000000) {
                return -2;
            }
        }
        return 1;
    }
    public static int mountainPeak() {

        int peak = -1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива -> ");

        int arrayLength;
        if (scanner.hasNextInt()) {
            arrayLength = scanner.nextInt();
        } else {
            return -3;
        }
        if (arrayLength < 3 || arrayLength > 100000) {
            return -3;
        }

        int[] array = fillArray(arrayLength, scanner);
        if (arrayValidation(array) == -2) {
            return -2;
        }

        if (array[0] > array[1]) {
            return -1;
        }
        for (int i = 1; i < array.length; ++i) {
            if (peak == -1 && array[i-1] > array[i]) {
                peak = i - 1;
            }
            if (peak > 0 && array[i] > array[i-1]) {
                return -1;
            }
        }
        return peak;
    }
    public static void main(String[] args) {

        int mountainPeak = mountainPeak();

        if (mountainPeak == -3) {
            System.out.println("Неподходящий размер!");
        } else if (mountainPeak == -2) {
            System.out.println("Массив не удовлетворяет ограничениям!");
        } else if (mountainPeak == -1) {
            System.out.println("Это не гора!");
        } else {
            System.out.println("Вершина горы -> " + mountainPeak);
        }
    }
}
