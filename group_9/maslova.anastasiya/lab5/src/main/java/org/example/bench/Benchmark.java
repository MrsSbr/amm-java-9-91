package org.example.bench;

import java.lang.reflect.Proxy;

public class Benchmark {
    public static <T> T track(T target) {
        if (target == null) {
            throw new IllegalArgumentException("Объект null");
        }
        BenchmarkInvocationHandler handler = new BenchmarkInvocationHandler(target);
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        return (T) proxy;
    }

    public static Stat getStat(Object proxy) {
        if (Proxy.isProxyClass(proxy.getClass()) &&
                Proxy.getInvocationHandler(proxy) instanceof BenchmarkInvocationHandler
        ) {
            return ((BenchmarkInvocationHandler) Proxy.getInvocationHandler(proxy)).getStats();
        }
        throw new IllegalArgumentException("Объект не является прокси с BenchmarkInvocationHandler");
    }
}
