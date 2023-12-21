package org.example;

import org.example.annotations.Autowired;
import org.example.annotations.Component;
import org.example.annotations.Scope;
import org.example.exceptions.ClassInstantiationException;
import org.example.exceptions.ConstructorNotFoundException;
import org.example.exceptions.NotComponentException;

import java.lang.reflect.Constructor;
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

        ComponentScope componentScope = Optional.ofNullable(clazz.getAnnotation(Scope.class))
                .map(Scope::componentScope)
                .orElse(ComponentScope.PROTOTYPE);

        return switch (componentScope) {
            case SINGLETON -> getSingleton(clazz);
            case PROTOTYPE -> createObject(clazz);
        };
    }

    private <T> T getSingleton(Class<T> clazz) {
        return clazz.cast(singletons.computeIfAbsent(clazz, this::createObject));
    }

    private <T> T createObject(Class<T> clazz) {
        Constructor<T> constructor = getAutowiredConstructor(clazz);
        Object[] parameters = Arrays.stream(constructor.getParameterTypes())
                .map(this::getInstance)
                .toArray();

        try {
            T result = constructor.newInstance(parameters);
            populateObject(result);
            return result;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ClassInstantiationException(e, clazz);
        }
    }

    private void populateObject(Object object) {
        Class<?> clazz = object.getClass();
        Arrays.stream(clazz.getDeclaredFields())
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

    private <T> Constructor<T> getAutowiredConstructor(Class<T> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new ConstructorNotFoundException(clazz);
        }

        Constructor<?> autowiredConstructor = Arrays.stream(constructors)
                .filter(c -> c.isAnnotationPresent(Autowired.class))
                .findFirst()
                .orElseGet(() -> getDefaultConstructor(clazz));

        return (Constructor<T>) autowiredConstructor;
    }

    private <T> Constructor<T> getDefaultConstructor(Class<T> clazz) {
        try {
            Constructor<T> defaultConstructor = clazz.getConstructor();
            if (defaultConstructor.getParameterCount() > 0) {
                throw new ConstructorNotFoundException(clazz);
            }
            return defaultConstructor;
        } catch (NoSuchMethodException e) {
            throw new ConstructorNotFoundException(e, clazz);
        }
    }

}
