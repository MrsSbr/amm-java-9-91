import factory.Part;
import factory.PartType;
import factory.ProductionInfo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductionInfoTest {
    @Test
    void testGetPartTypeCount() {
        Collection<Part> parts = Arrays.asList(
                new Part(1, PartType.ENGINE_PART),
                new Part(2, PartType.ENGINE_PART),
                new Part(3, PartType.ELECTRICAL_PART),
                new Part(4, PartType.BODY_PART),
                new Part(5, PartType.ELECTRICAL_PART));

        ProductionInfo productionInfo = new ProductionInfo(parts);

        assertEquals(2, productionInfo.getPartTypeCount(PartType.ENGINE_PART));
        assertEquals(2, productionInfo.getPartTypeCount(PartType.ELECTRICAL_PART));
        assertEquals(1, productionInfo.getPartTypeCount(PartType.BODY_PART));
        assertEquals(0, productionInfo.getPartTypeCount(PartType.INTERIOR_PART));
    }

    @Test
    void testGetUniqueParts() {
        Collection<Part> parts = Arrays.asList(
                new Part(1, PartType.ENGINE_PART),
                new Part(2, PartType.ENGINE_PART),
                new Part(3, PartType.ELECTRICAL_PART),
                new Part(4, PartType.BODY_PART),
                new Part(5, PartType.ELECTRICAL_PART));

        ProductionInfo productionInfo = new ProductionInfo(parts);

        List<Part> uniqueParts = productionInfo.getUniqueParts();

        Set<Part> uniquePartsSet = new HashSet<>(uniqueParts);
        assertEquals(uniqueParts.size(), uniquePartsSet.size());

        assertTrue(parts.containsAll(uniqueParts));
    }

    @Test
    void testGetPartTypeCountWithNullCollection() {
        ProductionInfo productionInfo = new ProductionInfo(null);

        assertThrows(NullPointerException.class, () ->
                productionInfo.getPartTypeCount(PartType.ENGINE_PART));
    }

    @Test
    void testGetUniquePartsWithEmptyCollection() {
        Collection<Part> emptyCollection = Collections.emptyList();
        ProductionInfo productionInfo = new ProductionInfo(emptyCollection);

        List<Part> uniqueParts = productionInfo.getUniqueParts();
        assertEquals(0, uniqueParts.size());
    }
}
