package org.example.classes;

import org.example.ComponentScope;
import org.example.annotations.Component;
import org.example.annotations.Scope;

@Component
@Scope(componentScope = ComponentScope.SINGLETON)
public class SingletonClass {
    private int value;

    public SingletonClass() {
        value = 5;
    }

    public int getValue() {
        return value;
    }
}
