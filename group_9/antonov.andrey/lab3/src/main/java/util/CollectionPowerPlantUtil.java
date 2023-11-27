package util;

import entity.PowerPlant;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

@UtilityClass
public class CollectionPowerPlantUtil {

    public static Collection<PowerPlant> generateCollectionBySupplier(Supplier<Collection<PowerPlant>> supplier, int size) {
        return Stream.generate(PowerPlantUtil::getRandomPowerPlant)
                .limit(size)
                .collect(supplier, Collection::add, Collection::addAll);
    }

    //чтобы не прописывать для каждой коллекции самому
    public static String getTypeCollection(Collection<PowerPlant> collection) {
        return collection.getClass().getSimpleName();
    }
}
