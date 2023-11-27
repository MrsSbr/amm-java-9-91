package util;

import entity.PowerPlant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.CollectionPowerPlantUtil.generateCollectionBySupplier;

public class PowerPlantUtilTest {

    private final Supplier<Collection<PowerPlant>> DEFAULT_SUPPLIER = ArrayList::new;

    static Stream<Integer> getNegativeArgumentsForCheckSizeTest() {
        return Stream.of(
                RandomUtil.getNext() * -1,
                RandomUtil.getNext() * -1,
                RandomUtil.getNext() * -1
        );
    }

    static Stream<Integer> getPositiveArgumentsForCheckSizeTest() {
        return Stream.of(
                RandomUtil.getNext(),
                RandomUtil.getNext(),
                RandomUtil.getNext());
    }

    @ParameterizedTest
    @MethodSource("getPositiveArgumentsForCheckSizeTest")
    void checkSizeRandomPowerPlantsList(int size) {
        var powerPlants = generateCollectionBySupplier(DEFAULT_SUPPLIER, size);
        assertEquals(powerPlants.size(), size);
    }

    @ParameterizedTest
    @MethodSource("getNegativeArgumentsForCheckSizeTest")
    void throwExceptionIfSizeNegative(int size) {
        assertThrows(IllegalArgumentException.class, () -> generateCollectionBySupplier(DEFAULT_SUPPLIER, size));
    }
}

