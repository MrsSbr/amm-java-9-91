import java.util.Scanner;

public class InputWithChecks {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputIntValue(int lowerLimit, int upperLimit) {
        int value = 0;

        boolean correctInput = false;
        do {
            try {
                value = scanner.nextInt();
                if (value >= lowerLimit && value <= upperLimit)
                    correctInput = true;
                else
                    System.out.print("Введённое Вами n не входит в требуемый диапазон (от " + lowerLimit + " до " + upperLimit + ")! Повторите попытку: ");
            } catch (java.util.InputMismatchException e) {
                System.out.print("Вы ввели некорректное значение. Повторите попытку: ");
                scanner.nextLine();
            }
        } while (!correctInput);

        return value;
    }
}
