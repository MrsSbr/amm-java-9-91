package test.java;

import main.java.org.example.TeaPackage;
import main.java.org.example.TeaPlantationFunctionality;
import main.java.org.example.TeaType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
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
    private final List<TeaPackage> emptyCollectionTP = Collections.emptyList();

    private static final List<Supplier<Collection<TeaPackage>>> suppliers =
            List.of(HashSet::new, ArrayList::new, LinkedList::new);

    private static Stream<Arguments> supplierOption() {
        return Stream.of(
                Arguments.of(suppliers.get(0)),
                Arguments.of(suppliers.get(1)),
                Arguments.of(suppliers.get(2))
        );
    }

    @ParameterizedTest
    @MethodSource("supplierOption")
    void findTheMostPlenteousYearsTest(Supplier<Collection<TeaPackage>> supplier) {

        TeaPlantationFunctionality tpf = new TeaPlantationFunctionality();
        List<Integer> years = List.of(2018, 2019, 2023, 2019);

        Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
        assertEquals(years, (tpf.findTheMostPlenteousYears(teaPackages)));

    }
    @ParameterizedTest
    @MethodSource("supplierOption")
    void findTheMostPlenteousYearsTestEmptyCollection(Supplier<Collection<TeaPackage>> supplier) {
        TeaPlantationFunctionality tpf = new TeaPlantationFunctionality();
        List<Integer> years = List.of(0, 0, 0, 0);
        Collection<TeaPackage> teaPackages = supplier.get();
        teaPackages.addAll(emptyCollectionTP);
        assertEquals(years, (tpf.findTheMostPlenteousYears(teaPackages)));
    }

    @ParameterizedTest
    @MethodSource("supplierOption")
    void findTeaTypesHarvestedIn2018Test(Supplier<Collection<TeaPackage>> supplier) {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();
        List<TeaType> teaTypes = List.of(TeaType.FUXI_HUANGSHAN_MAOFENG, TeaType.QIMEN_HUANGSHAN_MAOFENG,
                TeaType.YUAN_GUAPIAN);

        Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
        assertEquals(teaTypes, tpf.findTeaTypesHarvestedIn2018(teaPackages));
    }

    @ParameterizedTest
    @MethodSource("supplierOption")
    void findTeaTypesHarvestedIn2018TestEmptyCollection(Supplier<Collection<TeaPackage>> supplier) {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();

        Collection<TeaPackage> teaPackages = supplier.get();
        teaPackages.addAll(emptyCollectionTP);
        assertEquals(Collections.emptyList(), (tpf.findTeaTypesHarvestedIn2018(teaPackages)));
    }

    @ParameterizedTest
    @MethodSource("supplierOption")
    void findMaxWeightForEachTeaTypeTest(Supplier<Collection<TeaPackage>> supplier) {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();
        List<Integer> weights = List.of(1200, 1000, 1500, 600);

        Collection<TeaPackage> teaPackages = Stream.of(tp).collect(Collectors.toCollection(supplier));
        assertEquals(weights, tpf.findMaxWeightForEachTeaType(teaPackages));
    }

    @ParameterizedTest
    @MethodSource("supplierOption")
    void findMaxWeightForEachTeaTypeTestEmptyCollection(Supplier<Collection<TeaPackage>> supplier) {
        TeaPlantationFunctionality tpf= new TeaPlantationFunctionality();
        List<Integer> weights = List.of(0, 0, 0, 0);
        Collection<TeaPackage> teaPackages = supplier.get();
        teaPackages.addAll(emptyCollectionTP);
        assertEquals(weights, (tpf.findMaxWeightForEachTeaType(teaPackages)));
    }
}