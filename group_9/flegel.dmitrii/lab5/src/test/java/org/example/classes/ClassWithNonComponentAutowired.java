package org.example.classes;

import org.example.annotations.Autowired;

public class ClassWithNonComponentAutowired {
    @Autowired
    private PrototypeClass prototypeClass;

    public PrototypeClass getPrototypeClass() {
        return prototypeClass;
    }
}
