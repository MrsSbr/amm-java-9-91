package coffee;

import java.util.Arrays;

public enum CoffeeSort {
    ARABICA("арабика"),
    LIBERICA("либерика"),
    EXCELSA("эксцельса"),
    CANEPHORA("робуста"),
    STENOFYLLA("стенофилла");
    private final String value;

    CoffeeSort(String value) {
        this.value = value;
    }

    public static CoffeeSort fromValue(String value) throws InvalidCoffeeSortFormatException {
        return Arrays.stream(values())
                .filter(sort -> sort.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new InvalidCoffeeSortFormatException("Строка не содержит допустимый сорт кофе: " + value));
    }

}
