package org.example;

import org.example.classes.*;
import org.example.exceptions.ConstructorNotFoundException;
import org.example.exceptions.NotComponentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextTest {

    @Test
    void getSingletonInstance() {
        Context context = new Context();
        SingletonClass firstSingleton = context.getInstance(SingletonClass.class);
        SingletonClass secondSingleton = context.getInstance(SingletonClass.class);
        assertEquals(firstSingleton, secondSingleton);
        assertEquals(firstSingleton.getValue(), 5);
    }

    @Test
    void getPrototypeInstance() {
        Context context = new Context();
        PrototypeClass firstPrototype = context.getInstance(PrototypeClass.class);
        PrototypeClass secondPrototype = context.getInstance(PrototypeClass.class);
        assertNotEquals(firstPrototype, secondPrototype);
        assertEquals(firstPrototype.getValue(), 5);
        assertEquals(secondPrototype.getValue(), 5);
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
        assertEquals(obj1.getSingletonClass().getValue(), 5);
        assertEquals(obj2.getSingletonClass().getValue(), 5);
        assertEquals(obj2.getSingletonClass().getValue(), 5);
    }

    @Test
    void getClassWithAutowiredConstructorInstance() {
        Context context = new Context();
        ClassWithAutoWiredConstructor obj1 = context.getInstance(ClassWithAutoWiredConstructor.class);
        ClassWithAutoWiredConstructor obj2 = context.getInstance(ClassWithAutoWiredConstructor.class);
        assertNotNull(obj1.getPrototypeClass());
        assertNotNull(obj1.getSingletonClass());
        assertNotNull(obj2.getPrototypeClass());
        assertNotNull(obj2.getSingletonClass());
        assertEquals(obj1.getSingletonClass(), obj2.getSingletonClass());
        assertNotEquals(obj1.getPrototypeClass(), obj2.getPrototypeClass());
        assertEquals(obj1.getSingletonClass().getValue(), 5);
        assertEquals(obj2.getSingletonClass().getValue(), 5);
        assertEquals(obj2.getSingletonClass().getValue(), 5);
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
        assertThrows(ConstructorNotFoundException.class, () -> context.getInstance(ClassWithoutDefaultConstructor.class));
    }
}