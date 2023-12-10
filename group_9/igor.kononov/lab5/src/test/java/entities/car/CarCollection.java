package entities.car;

import lombok.Data;

import java.util.Collection;

@Data
public class CarCollection {
    private String mark;
    private String model;
    private Collection<Object> wheels;
}

