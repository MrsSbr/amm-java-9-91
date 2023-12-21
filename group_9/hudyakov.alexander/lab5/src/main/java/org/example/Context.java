package org.example;

import org.example.annotations.Autowired;
import org.example.annotations.Component;
import org.example.annotations.Scope;
import org.example.exceptions.ClassInstantiationException;
import org.example.exceptions.ConstructorNotFoundException;
import org.example.exceptions.NotComponentException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Context {
    private final Map<Class<?>, Object> singletons = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Component.class)) {
            throw new NotComponentException(clazz);
        }

        Scope scope = clazz.getAnnotation(Scope.class);
        ComponentScope componentScope = Optional.ofNullable(scope)
                .map(Scope::componentScope)
                .orElse(ComponentScope.PROTOTYPE);
        switch (componentScope) {
            case SINGLETON -> {
                return getSingleton(clazz);
            }
            case PROTOTYPE -> {
                return createObject(clazz);
            }
            default -> {
                throw new ClassInstantiationException(clazz);
            }
        }
    }

    private <T> T getSingleton(Class<T> clazz) {
        T obj = (T) singletons.get(clazz);
        if (obj == null) {
            obj = createObject(clazz);
            singletons.put(clazz, obj);
        }
        return obj;
    }

    private <T> T createObject(Class<T> clazz) {
        Constructor<T> constructor = getConstructor(clazz);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] parameters = Arrays.stream(parameterTypes)
                .map(this::getInstance)
                .toArray();
        try {
            Object result = constructor.newInstance(parameters);
            populateObject(result);
            return (T) result;

        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new ClassInstantiationException(e, clazz);
        }
    }

    private void populateObject(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fileds = clazz.getDeclaredFields();
        Arrays.stream(fileds)
                .filter(f -> f.isAnnotationPresent(Autowired.class))
                .forEach(f -> {
                    try {
                        f.setAccessible(true);
                        f.set(object, this.getInstance(f.getType()));
                    } catch (IllegalAccessException e) {
                        throw new ClassInstantiationException(e, clazz);
                    }
                });
    }

    private <T> Constructor<T> getConstructor(Class<T> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> constructor = Arrays.stream(constructors)
                .filter(c -> c.isAnnotationPresent(Autowired.class))
                .findFirst()
                .orElseGet(() -> {
                    try {
                        return clazz.getConstructor();
                    } catch (NoSuchMethodException e) {
                        throw new ConstructorNotFoundException(e, clazz);
                    }
                });
        return (Constructor<T>) constructor;
    }
}
