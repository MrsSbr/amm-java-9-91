import java.util.Scanner;

public class Intervals {
    public static int[] enterIntervals() {

        System.out.println("Введите интервалы: ");
        var scanner = new Scanner(System.in);

        String tempString = scanner.nextLine();
        String[] numbers = tempString.split(", ");

        var result = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    public static String mergeIntervals(int[] intervals) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        int a = intervals[0];   // Первый элемент интервала
        int b = intervals[1];   // Второй элемент интервала
        int c = intervals[2];   // Первый элемент последующего интервала


        int bIndex = 1;
        int cIndex = 2;
        while (bIndex < intervals.length - 1) {
            if (c <= b) {
                bIndex += 2;
                b = intervals[bIndex];
                cIndex += 2;
                c = intervals[cIndex];
            }
            else {
                stringBuilder.append("[");
                stringBuilder.append(a);
                stringBuilder.append(",");
                stringBuilder.append(b);
                stringBuilder.append("]");
                stringBuilder.append(", ");
                a = intervals[cIndex];

                cIndex += 2;
                bIndex += 2;

                if (cIndex != intervals.length) {
                    b = intervals[bIndex];
                    c = intervals[cIndex];
                }
                else {
                    stringBuilder.append("[");
                    stringBuilder.append(a);
                    stringBuilder.append(",");
                    b = intervals[bIndex];
                    stringBuilder.append(b);
                    stringBuilder.append("]");
                }
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // 1, 2, 5, 6, 5, 10, 11, 15, 14, 20, 21, 22
    // 1, 3, 2, 6, 8, 10, 15, 18
    public static void main(String[] args) {
        var intervals = enterIntervals();
        System.out.println("Merged intervals:");
        System.out.println(mergeIntervals(intervals));
    }
}