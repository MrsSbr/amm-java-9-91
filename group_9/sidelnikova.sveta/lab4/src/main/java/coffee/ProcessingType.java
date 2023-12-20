package coffee;

import java.util.Arrays;

public enum ProcessingType {
    NATURAL("натуральная"),
    WET("мытая"),
    WASHED("полумытая"),
    HONEY("хани");
    private final String value;

    ProcessingType(String value) {
        this.value = value;
    }

    public static ProcessingType fromValue(String value) throws InvalidProcessingTypeFormatException {
        return Arrays.stream(values())
                .filter(processingType -> processingType.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new InvalidProcessingTypeFormatException("Строка не содержит допустимый тип обработки кофе: "
                                + value));
    }
}
