package benchmark;

import statistics.Statistics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BenchmarkHandler implements InvocationHandler {

    private final Object object;
    private final HashMap<Object, Statistics> statistic;

    public BenchmarkHandler(Object object, HashMap<Object, Statistics> statistic) {
        this.object = object;
        this.statistic = statistic;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(object, args);
        long endTime = System.nanoTime();
        if (method.isAnnotationPresent(Benchmarked.class)) {
            statistic.computeIfAbsent(proxy, k -> new Statistics(endTime - startTime));
        }
        return result;
    }
}
