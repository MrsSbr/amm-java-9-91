import java.util.InputMismatchException;
import java.util.Scanner;

public class Palindrome {

    private static int reverse(int number) {
        int copy = number;
        int reversed = 0;

        while (copy != 0) {
            int remainder = copy % 10;
            reversed = reversed * 10 + remainder;
            copy = copy / 10;
        }
        return reversed;
    }

    private static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your number:");
        try {
            int number = scanner.nextInt();
            System.out.println(isPalindrome(number));
        } catch (InputMismatchException exception) {
            System.out.println("Incorrect input");
        }

    }
}