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

    public static String mergeIntervals(int[] intervals) throws IllegalArgumentException  {

        if (intervals.length % 2 == 1) {
            throw new IllegalArgumentException ("There are not an even number of intervals");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        int startOfTheCurrentInterval = intervals[0];   // Первый элемент интервала
        int endOfTheCurrentInterval = intervals[1];   // Второй элемент интервала
        int startOfTheNextInterval = intervals[2];   // Первый элемент последующего интервала

        int endOfTheCurrentIntervalIndex = 1;
        int startOfTheNextIntervalIndex = 2;

        while (endOfTheCurrentIntervalIndex < intervals.length - 1) {

            if (startOfTheNextInterval <= endOfTheCurrentInterval) {
                endOfTheCurrentIntervalIndex += 2;
                endOfTheCurrentInterval = intervals[endOfTheCurrentIntervalIndex];
                startOfTheNextIntervalIndex += 2;
                startOfTheNextInterval = intervals[startOfTheNextIntervalIndex];
            }
            else {
                stringBuilder.append("[");
                stringBuilder.append(startOfTheCurrentInterval);
                stringBuilder.append(",");
                stringBuilder.append(endOfTheCurrentInterval);
                stringBuilder.append("]");
                stringBuilder.append(", ");
                startOfTheCurrentInterval = intervals[startOfTheNextIntervalIndex];

                startOfTheNextIntervalIndex += 2;
                endOfTheCurrentIntervalIndex += 2;

                if (startOfTheNextIntervalIndex != intervals.length) {
                    endOfTheCurrentInterval = intervals[endOfTheCurrentIntervalIndex];
                    startOfTheNextInterval = intervals[startOfTheNextIntervalIndex];
                }
                else {
                    stringBuilder.append("[");
                    stringBuilder.append(startOfTheCurrentInterval);
                    stringBuilder.append(",");
                    endOfTheCurrentInterval = intervals[endOfTheCurrentIntervalIndex];
                    stringBuilder.append(endOfTheCurrentInterval);
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
        try {
            var intervals = enterIntervals();
            System.out.println("Merged intervals:");
            System.out.println(mergeIntervals(intervals));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}

