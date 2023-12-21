package org.example.classes;

import org.example.annotations.Autowired;
import org.example.annotations.Component;

@Component
public class ClassWithAutowired {
    @Autowired
    private PrototypeClass prototypeClass;
    @Autowired
    private SingletonClass singletonClass;

    public ClassWithAutowired(){

    }

    public PrototypeClass getPrototypeClass() {
        return prototypeClass;
    }

    public SingletonClass getSingletonClass() {
        return singletonClass;
    }
}
