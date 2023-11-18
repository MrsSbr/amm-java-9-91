package factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ContainerAnalysis {
    public static void main(String[] args) {
        Collection<Part> linkedList = createCollection(LinkedList::new, 1570);
        Collection<Part> arrayList = createCollection(ArrayList::new, 1570);
        Collection<Part> hashSet = createCollection(HashSet::new, 1570);

        performanceCheck("LinkedList", linkedList);

        performanceCheck("ArrayList", arrayList);

        performanceCheck("HashSet", hashSet);
    }

    private static void performanceCheck(String collectionType, Collection<Part> collection) {
        ProductionInfo productionInfo = new ProductionInfo(collection);

        long startTime = System.nanoTime();
        productionInfo.getPartTypeCount(PartType.ELECTRICAL_PART);
        productionInfo.getUniqueParts();
        long endTime = System.nanoTime();
        System.out.println(collectionType + ": " + (endTime - startTime) / 1e9 + "s");
    }

    public static <T extends Collection<Part>> T createCollection(Supplier<T> factory, int size) {
        return Stream.generate(PartFactory::generatePart)
                .limit(size)
                .collect(factory, Collection::add, Collection::addAll);
    }
}
