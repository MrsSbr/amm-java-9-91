import java.util.Scanner;

public class RomanToInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Римская цифра: ");

        String romanNumber = scanner.nextLine();
        System.out.print("Результат: " + romanToInteger(romanNumber));
    }

    public static int romanToInteger(String s) {
        int answer = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanSymbolToInteger(s.charAt(i));
            
            if (current < previous) {
                answer -= current;
            } else {
                answer += current;
            }
            
            previous = current;
        }
        
        return answer;
    }

    public static int romanSymbolToInteger(char symbol) {
        return switch (symbol) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> throw new IllegalArgumentException("Unexpected value: " + symbol);
        };
    }
}
