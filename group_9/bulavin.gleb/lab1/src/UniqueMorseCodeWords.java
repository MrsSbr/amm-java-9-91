import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueMorseCodeWords {
    private final static String[] MORSE_CODE_LIST = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private static String morseCodeOfSymbol(final char symbol) {
        return MORSE_CODE_LIST[symbol - 'a'];
    }

    private static String morseCodeOfWords(final String word) {
        StringBuilder builder = new StringBuilder();
        for (char symbol : word.toCharArray()) {
            builder.append(morseCodeOfSymbol(symbol));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        System.out.println("Введите слово (пустая строка для завершения ввода):");
        String word = scanner.nextLine();
        while (!word.isEmpty()) {
            set.add(morseCodeOfWords(word));
            word = scanner.nextLine();
        }
        System.out.printf("Количество различных преобразований среди всех слов: %d", set.size());
    }
}
