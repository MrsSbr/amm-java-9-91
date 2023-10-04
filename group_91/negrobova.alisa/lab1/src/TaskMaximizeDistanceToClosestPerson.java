import java.util.Scanner;
import java.util.InputMismatchException;
public class TaskMaximizeDistanceToClosestPerson {
    public static int getPlaceNumber(){
        int res = -1;
        while (res < 2) {
            System.out.print("Введите число больше 1: ");
            try {
                Scanner in = new Scanner(System.in);
                res = in.nextInt();
                if (res < 2){
                    System.out.println("Введено значение меньше 2");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Введено некорректное значение");
            }
        }
        return res;
    }

    public static void getIsPlaceFree(int[] array, int size) {
        boolean arrayCorrectFull = false;

        while (!arrayCorrectFull) {
            System.out.print("Введите рассадку людей (" + size + " мест через пробел): ");
            arrayCorrectFull = true;
            Scanner in = new Scanner(System.in);
            String[] str = in.nextLine().split(" ");

            for (int i = 0; i < size; i++) {
                try {
                    array[i] = Integer.parseInt(str[i]);
                    if (array[i] != 0 && array[i] != 1) {
                        System.out.println("Ошибка. Cписок некорректен");
                        i = size;
                        arrayCorrectFull = false;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Ошибка. Cписок некорректен");
                    i = size;
                    arrayCorrectFull = false;
                }
            }
        }
    }

    public static int getMaxDistance(int[] array, int size){

        boolean isFirstPerson = true;
        int distance = 0;
        int maxDistance = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] == 0)
                distance++;
            else
            {
                if (isFirstPerson) {
                    maxDistance = distance;
                    isFirstPerson = false;
                }
                else
                    maxDistance = Math.max(maxDistance,(distance + 1) / 2);
                distance=0;
            }
        }
        maxDistance = Math.max(maxDistance, distance);
        return maxDistance;
    }
    public static void main(String[] args) {
        System.out.println("Количество мест в ряду");
        int size = getPlaceNumber();
        System.out.println("Введите 0, если место свободно, иначе введите 1");
        int[] places = new int[size];
        getIsPlaceFree(places, size);
        int maxDistance = getMaxDistance(places, size);
        if (maxDistance == 0)
            System.out.println("Свободных мест нет");
        else
            System.out.println("Максимальное расcтояние: " + maxDistance);
    }
}