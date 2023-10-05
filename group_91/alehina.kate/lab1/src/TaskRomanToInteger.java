import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class TaskRomanToInteger {
    public static int romanToInteger(String number) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int end = number.length() - 1;
        char[] arr = number.toCharArray();
        int arabian;
        int result = roman.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = roman.get(arr[i]);

            if (arabian < roman.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    public static boolean isRoman(String s) {
        return !s.isEmpty() && (s.length() <= 15)
                && s.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
    }

    public static void main(String[] args) {
        System.out.println("Введите римское число: ");
        Scanner in = new Scanner(System.in);
        String romanNumber = in.nextLine();

        if (isRoman(romanNumber)) {
            int arabianNumber = romanToInteger(romanNumber);
            System.out.println("Арабская число: " + arabianNumber);
        } else {
            System.out.println("Ошибка! Введено некорректное число!");
        }
    }
}