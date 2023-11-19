package test.java;

import main.java.org.example.TeaPackage;
import main.java.org.example.TeaPlantationFunctionality;
import main.java.org.example.TeaType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TeaPlantationFunctionalityTest {
    private final TeaPackage[] tp = {
            new TeaPackage(TeaType.FUXI_HUANGSHAN_MAOFENG, 2018, 600),
            new TeaPackage(TeaType.FUXI_HUANGSHAN_MAOFENG, 2018, 700),
            new TeaPackage(TeaType.FUXI_HUANGSHAN_MAOFENG, 2021, 1200),
            new TeaPackage(TeaType.FUXI_HUANGSHAN_MAOFENG, 2020, 1100),
            new TeaPackage(TeaType.QIMEN_HUANGSHAN_MAOFENG, 2019, 1000),
            new TeaPackage(TeaType.QIMEN_HUANGSHAN_MAOFENG, 2018, 800),
            new TeaPackage(TeaType.QIMEN_HUANGSHAN_MAOFENG, 2019, 800),
            new TeaPackage(TeaType.QIMEN_HUANGSHAN_MAOFENG, 2018, 900),
            new TeaPackage(TeaType.YUAN_GUAPIAN, 2018, 700),
            new TeaPackage(TeaType.YUAN_GUAPIAN, 2023, 1500),
            new TeaPackage(TeaType.YUAN_GUAPIAN, 2019, 1000),
            new TeaPackage(TeaType.YUAN_GUAPIAN, 2018, 700),
            new TeaPackage(TeaType.TAIPING_HOUKUI, 2021, 600),
            new TeaPackage(TeaType.TAIPING_HOUKUI, 2019, 500),
            new TeaPackage(TeaType.TAIPING_HOUKUI, 2019, 500),
            new TeaPackage(TeaType.TAIPING_HOUKUI, 2022, 600)
    };
    private final List<Supplier<Collection<TeaPackage>>> suppliers =
            List.of(ArrayList::new, LinkedList::new, HashSet::new);

    @Test
    void findTheMostPlenteousYearsTest() {
        TeaPlantationFunctionality tpf = new TeaPlantationFunctionality();
        List<Integer> years = Stream.of(2018, 2019, 2023, 2019)
                .collect(Collectors.toList());

        for(Supplier<Collection<TeaPackage>> supplier : suppliers) {
            Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
            assertEquals(years, (tpf.findTheMostPlenteousYears(teaPackages)));
        }
    }

    @Test
    void findTeaTypesHarvestedIn2018Test() {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();
        List<TeaType> teaTypes = Stream.of(TeaType.FUXI_HUANGSHAN_MAOFENG, TeaType.QIMEN_HUANGSHAN_MAOFENG,
                TeaType.YUAN_GUAPIAN).collect(Collectors.toList());

        for(Supplier<Collection<TeaPackage>> supplier : suppliers) {
            Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
            assertEquals(teaTypes, tpf.findTeaTypesHarvestedIn2018(teaPackages));
        }
    }

    @Test
    void findMaxWeightForEachTeaTypeTest() {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();
        List<Integer> weights = Stream.of(1200, 1000, 1500, 600)
                .collect(Collectors.toList());

        for(Supplier<Collection<TeaPackage>> supplier : suppliers) {
            Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
            assertEquals(weights, tpf.findMaxWeightForEachTeaType(teaPackages));
        }
    }
}