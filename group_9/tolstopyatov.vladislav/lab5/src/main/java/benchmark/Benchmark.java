package benchmark;

import statistics.FullStat;
import statistics.Stat;

import java.lang.reflect.Proxy;

public class Benchmark {
    private static final FullStat FULL_STAT = new FullStat();

    @SuppressWarnings("unchecked")
    public static <T> T track(T service) {
        Class<?> clazz = service.getClass();
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new BenchmarkHandler(service, FULL_STAT));
    }

    public static Stat getStatistics(Object trackedService) {
        return new Stat(FULL_STAT.getStatistics().get(trackedService));
    }
}
