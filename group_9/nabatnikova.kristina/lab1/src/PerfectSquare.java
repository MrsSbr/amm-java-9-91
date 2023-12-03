import java.util.Scanner;

public class PerfectSquare {
    public static boolean isPerfectValid(int num) {
        int i = 1;
        while (i <= num / 2) {
            if (i * i == num) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                System.out.println(isPerfectValid(num));
            } else {
                System.out.println("Некорректный ввод!");
            }
        } else {
            System.out.println("Некорректный ввод!");
        }
    }
}
