package org.example.classes;

import org.example.ComponentScope;
import org.example.annotations.Component;
import org.example.annotations.Scope;

@Component
@Scope(componentScope = ComponentScope.PROTOTYPE)
public class PrototypeClass {
    private int value;

    public PrototypeClass() {
        value = 5;
    }

    public int getValue() {
        return value;
    }
}
