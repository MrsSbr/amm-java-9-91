import java.util.Scanner;

public class BulbSwitcher {

    public static int readBulbsCount() {
        Scanner reader = new Scanner(System.in);

        System.out.print("Введите количество лампочек -> ");
        while (!reader.hasNextInt()) {
            System.out.print("Вввод не распознан. Пвоторите ввод -> ");
            reader.nextLine();
        }

        return reader.nextInt();
    }

    public static int countLitBulbs(int bulbsCount) {
        return (int) Math.floor(Math.sqrt(bulbsCount));
    }

    public static void main(String[] args) {
        int bulbsCount;
        int litBulbsCount;

        bulbsCount = readBulbsCount();
        if (bulbsCount < 0) {
            System.out.println("Введенное значение не может быть количеством лампочек.");
            return;
        }

        litBulbsCount = countLitBulbs(bulbsCount);
        System.out.println("Количество включенных лампочек: " + litBulbsCount);
    }
}