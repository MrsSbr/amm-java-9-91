package entity;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class TypeToCapacity<F, S> {
    TypePowerPlant type;
    double list;
}
