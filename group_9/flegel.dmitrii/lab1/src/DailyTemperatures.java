import java.util.Stack;
import java.util.Scanner;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество дней: ");
        int n = scanner.nextInt();
        int[] temperatures = new int[n];

        System.out.println("Введите температуры для каждого дня:");
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }

        scanner.close();

        int[] result = solution.dailyTemperatures(temperatures);

        System.out.print("Результат: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}