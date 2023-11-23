package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.RandomUtil;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PowerPlantsServiceTest {

    @ParameterizedTest
    @MethodSource("getPositiveArgumentsForCheckSizeTest")
    void checkSizeRandomPowerPlantsList(int size) {
        var powerPlantsService = new PowerPlantsService(size);
        var randomPowerPlantsList = powerPlantsService.getRandomPowerPlantsList();
        Assertions.assertThat(randomPowerPlantsList).hasSize(size);
    }

    @ParameterizedTest
    @MethodSource("getNegativeArgumentsForCheckSizeTest")
    void throwExceptionIfSizeNegative(int size) {
        var powerPlantsService = new PowerPlantsService(size);
        assertThrows(IllegalArgumentException.class, powerPlantsService::getRandomPowerPlantsList);
    }

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
}