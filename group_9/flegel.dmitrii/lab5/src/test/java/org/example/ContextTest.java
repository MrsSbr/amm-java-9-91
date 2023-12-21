package org.example;

import org.example.classes.ClassWithAutoWiredConstructor;
import org.example.classes.ClassWithAutowired;
import org.example.classes.ClassWithNonComponentAutowired;
import org.example.classes.ClassWithoutDefaultConstructor;
import org.example.classes.PrototypeClass;
import org.example.classes.PrototypeClassWithAutowiredField;
import org.example.classes.SingletonClass;
import org.example.exceptions.ConstructorNotFoundException;
import org.example.exceptions.NotComponentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContextTest {

    @Test
    void getSingletonInstance() {
        Context context = new Context();
        SingletonClass firstSingleton = context.getInstance(SingletonClass.class);
        SingletonClass secondSingleton = context.getInstance(SingletonClass.class);
        assertEquals(firstSingleton, secondSingleton);
        assertEquals(firstSingleton.getValue(), 3);
    }

    @Test
    void getPrototypeInstance() {
        Context context = new Context();
        PrototypeClass firstPrototype = context.getInstance(PrototypeClass.class);
        PrototypeClass secondPrototype = context.getInstance(PrototypeClass.class);
        assertNotEquals(firstPrototype, secondPrototype);
        assertEquals(firstPrototype.getValue(), 3);
        assertEquals(secondPrototype.getValue(), 3);
    }

    @Test
    void getClassWithAutowiredInstance() {
        Context context = new Context();
        ClassWithAutowired obj1 = context.getInstance(ClassWithAutowired.class);
        ClassWithAutowired obj2 = context.getInstance(ClassWithAutowired.class);
        assertNotNull(obj1.getPrototypeClass());
        assertNotNull(obj1.getSingletonClass());
        assertNotNull(obj2.getPrototypeClass());
        assertNotNull(obj2.getSingletonClass());
        assertEquals(obj1.getSingletonClass(), obj2.getSingletonClass());
        assertNotEquals(obj1.getPrototypeClass(), obj2.getPrototypeClass());
        assertEquals(obj1.getSingletonClass().getValue(), 3);
        assertEquals(obj2.getSingletonClass().getValue(), 3);
    }

    @Test
    void getClassWithAutoWiredConstructorInstance() {
        Context context = new Context();
        ClassWithAutoWiredConstructor obj1 = context.getInstance(ClassWithAutoWiredConstructor.class);
        ClassWithAutoWiredConstructor obj2 = context.getInstance(ClassWithAutoWiredConstructor.class);
        assertNotNull(obj1.getPrototypeClass());
        assertNotNull(obj1.getSingletonClass());
        assertNotNull(obj2.getPrototypeClass());
        assertNotNull(obj2.getSingletonClass());
        assertEquals(obj1.getSingletonClass(), obj2.getSingletonClass());
        assertNotEquals(obj1.getPrototypeClass(), obj2.getPrototypeClass());
        assertEquals(obj1.getSingletonClass().getValue(), 3);
        assertEquals(obj2.getSingletonClass().getValue(), 3);
    }

    @Test
    void getClassWithNonComponentAutowiredInstance() {
        Context context = new Context();
        assertThrows(NotComponentException.class, () -> context.getInstance(ClassWithNonComponentAutowired.class));
    }

    @Test
    void getNonComponentInstance() {
        Context context = new Context();
        assertThrows(NotComponentException.class, () -> context.getInstance(int.class));
    }

    @Test
    void getClassWithoutDefaultConstructorInstance() {
        Context context = new Context();
        assertThrows(ConstructorNotFoundException.class,
                () -> context.getInstance(ClassWithoutDefaultConstructor.class));
    }

    @Test
    void getPrototypeInstanceWithFieldAutowired() {
        Context context = new Context();
        PrototypeClassWithAutowiredField obj1 = context.getInstance(PrototypeClassWithAutowiredField.class);
        PrototypeClassWithAutowiredField obj2 = context.getInstance(PrototypeClassWithAutowiredField.class);
        assertNotNull(obj1.getPrototypeClass());
        assertNotNull(obj2.getPrototypeClass());
        assertNotSame(obj1, obj2, "Instances should be different for Prototype scope");
    }
}
