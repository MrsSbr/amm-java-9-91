/*
Вам дано целое число n — количество команд в турнире со следующими правилами:
Если текущее количество команд четное, команды разбиваются на пары. Всего будет сыграно n/2 матчей,
и n/2 команд проходят в следующий раунд.
Если текущее количество команд нечетное, одна команда случайным образом продвигается на следующий этап турнира,
а остальные распределяются по парам. Всего сыграно (n - 1) / 2 матчей, и (n - 1) / 2 + 1 команд проходят в следующий раунд.
Нужно вернуть количество матчей, сыгранных в турнире, до определения победителя.
*/
import java.util.Scanner;

public class TournamentMatchCounter {
    public static int countOfMatches(int n) {
        int result = 0;

        while (n > 1) { // пока не останется только одна команда (победитель)
            if (n % 2 == 0) {
                result += n / 2;
                n /= 2;
            }
            else {
                result += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print("Введите целое число n (от 1 до 200) - количество команд в турнире: ");
        int n = InputWithChecks.inputIntValue(1, 200);
        System.out.println("Количество матчей в турнире - " + countOfMatches(n));
    }

    public static class InputWithChecks {
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
}
