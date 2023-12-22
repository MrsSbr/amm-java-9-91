package entities.car;

import lombok.Data;

@Data
public class Wheel {
    private int size;
    private Type tire;

    public Wheel() {
    }

    public Wheel(int size, Type tire) {
        this.size = size;
        this.tire = tire;
    }
}
