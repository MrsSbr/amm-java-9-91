/*
        Есть массив arr целых чисел в диапазоне [1, n], отсортированный в строго возрастающем порядке.

        Применяется следующий алгоритм:

        1. Начиная слева направо, удаляйте первое число,
        а затем каждое второе число, пока не дойдете до конца списка.

        2. Повторите предыдущий шаг еще раз, но на этот раз справа налево,
        удалите самое правое число и каждое второе число из оставшихся чисел.

        3. Продолжайте повторять шаги снова, чередуя слева направо и справа налево,
        пока не останется одно

        Необходимо по целому числу n, вернуть последнее число, оставшееся в arr
*/

import java.util.Scanner;

public class EliminationGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input: n = ");
        int n = in.nextInt();
        System.out.println("Output: " + LastRemainingNumber.taskEliminationGame(n));
    }
}