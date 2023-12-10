package org.example.bench;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BenchmarkInvocationHandler implements InvocationHandler {
    private final Object target;
    private final Stat stats = new Stat(new HashMap<>());

    public BenchmarkInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Benchmarked.class)) {
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            long duration = System.currentTimeMillis() - start;
            stats.stats().put(method.getName(), stats.stats().getOrDefault(method.getName(), 0L) + duration);
            return result;
        } else {
            return method.invoke(target, args);
        }
    }

    public Stat getStats() {
        return stats;
    }
}
