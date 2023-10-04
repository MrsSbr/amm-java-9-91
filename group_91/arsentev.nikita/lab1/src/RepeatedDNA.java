import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class RepeatedDNA {
    private final static String  CHARS = "ACGT";
    private final static int LENGTH = 10;
    private final static int EXCEPTION_SIZE = 100000;
    private static List<String> findRepeatedDNASequences(String s){
        Map<String, Integer> mapStrings = new HashMap<>();
        final int end = s.length() - LENGTH;
        for(int i = 0; i <= end; i++){
            String string = s.substring(i, i + LENGTH);
            mapStrings.put(string, mapStrings.getOrDefault(string, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mapStrings.entrySet()){
            if(entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
    private static StringBuilder fillString(int count){
        StringBuilder result = new StringBuilder(count);
        final int[] array = new Random().ints(count, 0, CHARS.length() ).toArray();
        for(int i = 0; i < count; i++){
            result.insert(i, CHARS.charAt(array[i]));
        }
        return result;
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("How to fill string\n0 - Console, other - Random");
        try {
            final int var = in.nextInt();
            StringBuilder s = new StringBuilder();
            if(var == 0){
                System.out.println("Print string:");
                String tmp = in.nextLine();
                tmp = in.nextLine();
                if(tmp.isEmpty() || tmp.length() > EXCEPTION_SIZE || !tmp.matches("[" + CHARS + "]+"))
                    throw new InputMismatchException();
                s.append(tmp);
            }
            else{
                System.out.println("Enter length of string -> ");
                final int size = in.nextInt();
                if(size < 1 || size > EXCEPTION_SIZE)
                    throw new InputMismatchException();
                s = fillString(size);
            }
            System.out.println("DNA Sequences:\n" + s);
            List<String> result = findRepeatedDNASequences(s.toString());
            if(!result.isEmpty()){
                StringBuilder print = new StringBuilder();
                print.append("[ ").append(result.get(0));
                for(int i = 1; i < result.size();++i){
                    print.append(", ").append(result.get(i));
                }
                print.append("]");
                System.out.println("Result:\n" + result);
            }
            else
                System.out.println("there are no repeated substrings");
        }
        catch (InputMismatchException exception){
            System.out.println("Incorrect input");
        }
    }
}
