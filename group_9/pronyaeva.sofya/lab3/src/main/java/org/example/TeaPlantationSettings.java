package main.java.org.example;

import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class TeaPlantationSettings {
    private static final int PACKAGES_AMOUNT = 10000;

    public Collection<TeaPackage> createPlantation(Supplier<Collection<TeaPackage>> supplier) {

        Collection<TeaPackage> teaPackages = supplier.get();
        Random random = new Random(System.currentTimeMillis());

        IntStream.range(0,PACKAGES_AMOUNT).mapToObj(x -> new TeaPackage(
                TeaType.values()[random.nextInt(TeaType.values().length)],
                random.nextInt(2010,2023),
                random.nextInt(200,1000)
        )).forEach(teaPackages::add);
        return teaPackages;
    }
}
