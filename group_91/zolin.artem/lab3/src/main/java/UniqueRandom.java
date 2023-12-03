import java.util.Random;

public class UniqueRandom {

    private final int min;
    private final int[] values;
    private final Random rng = new Random();
    private int upperBound;

    public UniqueRandom(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("max must be grater than min");
        }
        this.min = min;
        this.values = new int[max - min + 1];
        reset();
    }

    public boolean hasNext() {
        return upperBound != -1;
    }

    public int getNext() {
        if (upperBound == -1) {
            return values[0];
        }
        int index = rng.nextInt(0, upperBound + 1);
        int tmp = values[index];
        values[index] = values[upperBound];
        --upperBound;
        return tmp;
    }

    public void reset() {
        for (int i = 0; i < values.length; ++i) {
            values[i] = min + i;
        }
        upperBound = values.length - 1;
    }

}
