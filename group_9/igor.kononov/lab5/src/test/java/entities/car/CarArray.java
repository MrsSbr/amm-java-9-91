package entities.car;

import lombok.Data;

import java.util.Collection;

@Data
public class CarArray {
    private String mark;
    private String model;
    private Object[] wheels;
}
