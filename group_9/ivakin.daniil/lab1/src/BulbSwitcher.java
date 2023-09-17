import java.util.Scanner;

public class BulbSwitcher {

    public static void switchBulbs(boolean[] bulbs) {
        for (int i = 0; i < bulbs.length; ++i) {
            for (int j = i; j < bulbs.length; j += i + 1) {
                bulbs[j] = !bulbs[j];
            }
        }
    }

    public static int countLitBulbs(boolean[] bulbs) {
        int totalLitBulbs = 0;

        for (int i = 0; i < bulbs.length; ++i) {
            if (bulbs[i]) {
                ++totalLitBulbs;
            }
        }

        return totalLitBulbs;
    }

    public static void main(String[] args) {
        int bulbCount = 0;
        boolean[] bulbs = null;
        int litBulbsCount = 0;
        Scanner reader = new Scanner(System.in);

        System.out.print("Введите количество лампочек -> ");
        bulbCount = reader.nextInt();

        if (bulbCount == 0) {
            System.out.println("Количество включенных лампочек: 0");
            return;
        }

        bulbs = new boolean[bulbCount];

        switchBulbs(bulbs);
        litBulbsCount = countLitBulbs(bulbs);
        System.out.println("Количество включенных лампочек: " + litBulbsCount);
    }
}