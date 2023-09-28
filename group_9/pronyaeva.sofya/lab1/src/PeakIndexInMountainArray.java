import java.util.Scanner;

public class PeakIndexInMountainArray {

    public static void FillArray(int[] array, Scanner scanner){
        // заполнение массива
        System.out.print("Введите элементы массива -> ");
        for (int i = 0; i < array.length; ++i){
            array[i] = scanner.nextInt();
        }

        System.out.println();
    }
    public static int MountainPeak(){

        int peak = -1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива -> ");
        int arrayLength = scanner.nextInt();
        if (arrayLength < 3 || arrayLength > 100000){
            return -3;
        }

        int[] array = new int[arrayLength];
        FillArray(array, scanner);

        if (array[0] < 0 || array[0] > 1000000){
            return -2;
        }
        if (array[0] > array[1]){
            return -1;
        }

        for (int i = 1; i < array.length; ++i){
            if (array[i] < 0 || array[i] > 1000000) {
                return -2;
            }

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

        int mountainPeak = MountainPeak();

        if (mountainPeak == -3)
            System.out.println("Неподходящий размер!");
        else if (mountainPeak == -2)
            System.out.println("Массив не удовлетворяет ограничениям!");
        else if (mountainPeak == -1)
            System.out.println("Это не гора!");
        else
            System.out.println("Вершина горы -> " + mountainPeak);
    }
}
