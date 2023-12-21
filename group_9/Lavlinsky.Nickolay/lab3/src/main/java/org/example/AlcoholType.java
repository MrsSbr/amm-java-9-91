import java.util.Random;

public enum AlcoholType {
    VODKA, WINE, BEER, WHISKEY;

    public static AlcoholType getByNumber(int number) {
        if (number < 0 || number >= values().length) {
            throw new IllegalArgumentException("Неправильное число: " + number);
        }
        return values()[number];
    }

    public static AlcoholType getRandomType() {
        return values()[new Random().nextInt(values().length)];
    }
}
