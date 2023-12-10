package entities.car;

import lombok.Getter;

@Getter
public enum Type {
    SUMMER("SUMMER"),
    WINTER("WINTER");

    private final String type;

    Type(String type) {
        this.type = type;
    }
}
