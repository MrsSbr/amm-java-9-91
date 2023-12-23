package entity;

import lombok.Getter;

@Getter
public enum Color {
    RED("red"),
    GREEN("green"),
    BLACK("black"),
    BLUE("blue");

    private final String description;

    Color(final String description) {
        this.description = description;
    }

}
