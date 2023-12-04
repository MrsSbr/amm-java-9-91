package org.example.classes;

import org.example.annotations.Autowired;
import org.example.annotations.Component;

@Component
public class ClassWithoutDefaultConstructor {
    @Autowired
    private SingletonClass singleton;

    public ClassWithoutDefaultConstructor(SingletonClass singleton) {
        this.singleton = singleton;
    }
}
