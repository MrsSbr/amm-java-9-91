package entity;

public record OlympicStatistic(
    Country country,
    Sport sport,
    String athlete,
    Integer place
) {
}
