package entity;

public enum TypePowerPlant {
    ATOMIC("Атомная электростанция"),
    HYDRO("Гидроэлектростанция"),
    SOLAR("Солнечная электростанция");

    private final String description;

    TypePowerPlant(String description) {
        this.description = description;
    }
}
