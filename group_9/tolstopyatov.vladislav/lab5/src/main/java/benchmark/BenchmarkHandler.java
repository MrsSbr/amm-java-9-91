package benchmark;

import statistics.MethodStat;
import statistics.FullStat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkHandler implements InvocationHandler {

    private final Object object;
    private final FullStat fullStat;

    public BenchmarkHandler(Object object, FullStat fullStat) {
        this.object = object;
        this.fullStat = fullStat;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(object, args);
        long endTime = System.nanoTime();
        if (method.isAnnotationPresent(Benchmarked.class)) {
            ArrayList<MethodStat> list = fullStat.getStatistics().get(proxy);
            if (list == null) {
                ArrayList<MethodStat> listNew = new ArrayList<>();
                fullStat.getStatistics().put(proxy, listNew);
                listNew.add(new MethodStat(endTime - startTime, method));
            } else {
                list.add(new MethodStat(endTime - startTime, method));
            }
        }
        return result;
    }
}
