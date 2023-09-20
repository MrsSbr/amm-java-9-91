import java.util.Scanner;
import java.util.ArrayList;

public class Intervals {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10000;

    /**
     *  Initializes an array of intervals according to the user's choice
     * @return initialized array of intervals
     */
    private static int[][] initIntervals() {
        System.out.print("Enter the number of intervals: ");
        var scanner = new Scanner(System.in);
        var numberOfIntervals = scanner.nextInt();

        if (numberOfIntervals < MIN_VALUE || numberOfIntervals > MAX_VALUE) {
            return null;
        }
        return new int[numberOfIntervals][2];
    }

    /**
     * Fills an array of intervals with values according to the user's choice
     */
    private static void enderIntervals(int[][] intervals) {
        System.out.println("Enter intervals: ");
        var scanner = new Scanner(System.in);

        for (int i = 0; i < intervals.length; i++) {
            System.out.print("Enter " + i + ": ");
            intervals[i][0] = Math.abs(scanner.nextInt());
            intervals[i][1] = Math.abs(scanner.nextInt());
        }
    }

    /**
     * Sorts an array of intervals by the first element
     */
    private static void sortIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Merges intersecting intervals
     * @return merged intervals
     */
    private static int[][] mergeIntervals(int[][] intervals) {
        var mergedIntervals = new ArrayList<int[]>();
        var currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            var nextInterval = intervals[i];

            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedIntervals.add(currentInterval);

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }
        return result;
    }

    /**
     * Prints intervals
     */
    private static void printIntervals(int[][] intervals) {
        System.out.println("Intervals: ");
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static void main(String[] args) {
        var intervals = initIntervals();
        if (intervals == null)
            return;

        enderIntervals(intervals);
        sortIntervals(intervals);
        printIntervals(mergeIntervals(intervals));
    }
}