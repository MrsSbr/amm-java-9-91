package org.example;

import java.lang.reflect.*;
import java.util.*;

public class Benchmark {
    private static final Map<Object, Stat> stats = new HashMap<>();

    public static <T> T track(T service) {
        Class<?> clazz = service.getClass();
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();
                        try {
                            return method.invoke(service, args);
                        } finally {
                            long end = System.currentTimeMillis();
                            if (method.isAnnotationPresent(Benchmarked.class)) {
                                stats.computeIfAbsent(proxy, k -> new Stat()).record(end - start);
                            }
                        }
                    }
                }
        );
    }

    public static Stat getStat(Object trackedService) {
        return stats.get(trackedService);
    }
}
