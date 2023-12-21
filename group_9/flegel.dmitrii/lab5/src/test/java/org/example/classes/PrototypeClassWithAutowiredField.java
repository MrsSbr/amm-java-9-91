package org.example.classes;

import org.example.annotations.Autowired;
import org.example.annotations.Component;

@Component
public class PrototypeClassWithAutowiredField {
    @Autowired
    private PrototypeClass prototypeClass;

    public PrototypeClass getPrototypeClass() {
        return prototypeClass;
    }
}
