package org.example.classes;

import org.example.annotations.Autowired;
import org.example.annotations.Component;

@Component
public class ClassWithNonComponentAutowired {
    @Autowired
    private int value;

    public ClassWithNonComponentAutowired() {
    }
}
