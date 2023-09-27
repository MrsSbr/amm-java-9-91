import java.util.Arrays;

public class Main {

    private static final int MIN_PEOPLE = 1;
    private static final int MAX_PEOPLE = 50000;
    private static final int MAX_LIMIT = 30000;

    /**
     * This method calculates the minimum number of boats required to carry people.
     *
     * @param people - array of weights of the people
     * @param limit - weight limit of the boat
     * @return minimum number of boats required
     * @throws IllegalArgumentException if input is invalid
     */
    public static int calculateMinimumBoats(int[] people, int limit) {

        if (people.length < MIN_PEOPLE || people.length > MAX_PEOPLE) {
            throw new IllegalArgumentException("Number of people must be between " +
                    MIN_PEOPLE + " and " + MAX_PEOPLE);
        }

        for (int weight : people) {
            if (weight < MIN_PEOPLE || weight > limit || limit > MAX_LIMIT) {
                throw new IllegalArgumentException("Each person's weight and the limit must be between " +
                        MIN_PEOPLE + " and " + MAX_LIMIT);
            }
        }

    Arrays.sort(people);

    int boatCount = 0;
    int leftIndex = 0;
    int rightIndex = people.length - 1;

        while (leftIndex <= rightIndex) {
        if (people[leftIndex] + people[rightIndex] <= limit) {
            leftIndex = leftIndex + 1;
        }
        rightIndex = rightIndex - 1;
        boatCount = boatCount + 1;
    }

        return boatCount;
    }

    /**
     * This method runs a test with given inputs and expected result.
     *
     * @param people - array of weights of the people
     * @param limit - weight limit of the boat
     */
    public static void runTest(int[] people, int limit) {
        try {
            int result = calculateMinimumBoats(people, limit);
            System.out.println("Test with input " + Arrays.toString(people) + " and limit " + limit + ":");
            System.out.println("Expected: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        runTest(new int[]{1, 2}, 3);
        runTest(new int[]{3, 2, 2, 1}, 3);
        runTest(new int[]{3, 5, 3, 4}, 5);
        runTest(new int[]{2, 2, 2 ,2}, 2);
        runTest(new int[]{2, 2, 2 ,2}, 1);
        runTest(new int[]{}, 3);
        runTest(new int[]{5, 6, 3, 50}, 3);
    }
}




