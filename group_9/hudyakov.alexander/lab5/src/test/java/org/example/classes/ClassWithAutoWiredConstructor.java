package org.example.classes;

import org.example.annotations.Autowired;
import org.example.annotations.Component;

@Component
public class ClassWithAutoWiredConstructor {
    private final PrototypeClass prototypeClass;
    private final SingletonClass singletonClass;

    @Autowired
    public ClassWithAutoWiredConstructor(PrototypeClass prototypeClass, SingletonClass singletonClass) {
        this.prototypeClass = prototypeClass;
        this.singletonClass = singletonClass;
    }

    public PrototypeClass getPrototypeClass() {
        return prototypeClass;
    }

    public SingletonClass getSingletonClass() {
        return singletonClass;
    }
}
