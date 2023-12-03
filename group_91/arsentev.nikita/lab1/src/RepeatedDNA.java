import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class RepeatedDNA {
    private final static String CHARS = "ACGT";
    private final static int EXCEPTION_SIZE = 100000;
    private final static int LENGTH = 10;

    private static List<String> findRepeatedDNASequences(String s) {
        Map<String, Integer> mapStrings = new HashMap<>();
        final int end = s.length() - LENGTH;
        for (int i = 0; i <= end; i++) {
            String string = s.substring(i, i + LENGTH);
            mapStrings.merge(string, 1, Integer::sum);//upd: replaced put with merge
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapStrings.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private static String fillString(int count) {
        StringBuilder result = new StringBuilder(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            result.insert(i, CHARS.charAt(random.nextInt(CHARS.length())));//upd:generate a number in each iteration
        }
        return result.toString();//upd: return String
    }

    private static String getString() {//upd: added a line enter function
        System.out.println("How to fill string\n0 - Console, other - Random");
        Scanner in = new Scanner(System.in);
        final int number = in.nextInt();//upd: change name of variable
        String s;
        if (number == 0) {
            System.out.println("Print string:");
            in.nextLine();
            s = in.nextLine();
            if (s.isEmpty() || s.length() > EXCEPTION_SIZE || !s.matches("[" + CHARS + "]+")) {
                throw new InputMismatchException("Incorrect input");
            }
        } else {
            System.out.println("Enter length of string -> ");
            final int size = in.nextInt();
            if (size < 1 || size > EXCEPTION_SIZE) {
                throw new InputMismatchException("Incorrect input");
            }
            s = fillString(size);
        }
        return s;
    }

    public static void main(String[] args) {
        try {
            String s = getString();
            System.out.println("DNA Sequences:\n" + s);
            List<String> result = findRepeatedDNASequences(s);
            if (!result.isEmpty()) {
                System.out.println("Result:\n" + result);//upd: change output of list
            } else {
                System.out.println("There are no repeated substrings");
            }
        } catch (InputMismatchException exception) {
            System.out.println(exception.getMessage());//upd: add output exception
        }
    }
}
