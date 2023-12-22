package benchmark;

import statistics.Statistics;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Benchmark {
    private static final HashMap<Object, Statistics> statistic = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T track(T service) {
        Class<?> clazz = service.getClass();
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new BenchmarkHandler(service, statistic));
    }

    public static Statistics getStatistics(Object trackedService) {
        return statistic.get(trackedService);
    }
}
