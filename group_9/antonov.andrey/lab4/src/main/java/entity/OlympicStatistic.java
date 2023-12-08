package entity;

import lombok.Value;

@Value(staticConstructor = "of")
public class OlympicStatistic {
    Country country;
    Sport sport;
    String athlete;
    Integer place;
}
