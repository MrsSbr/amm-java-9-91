import org.example.DataPlant;
import org.example.ImplementationTasksWithPlants;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {
    private final ImplementationTasksWithPlants itwp = new ImplementationTasksWithPlants();
    private final List<DataPlant> dataPlants = List.of(
            new DataPlant(LocalDate.of(2023, 10, 3), "Цветок1", 0.7, null),
            new DataPlant(LocalDate.of(2023, 10, 5), "Цветок1", 1.6, "LUX"),
            new DataPlant(LocalDate.of(2023, 10, 10), "Цветок1", 0.7, null),
            new DataPlant(LocalDate.of(2023, 10, 11), "Цветок2", 1.6, "LUX"),
            new DataPlant(LocalDate.of(2023, 10, 3), "Цветок3", 0.7, null)
    );
    private final List<DataPlant> emptyDataPlants = new ArrayList<>();

    @Test
    public void testFindPlantWithMaxWater() {
        assertEquals("Цветок1", itwp.findPlantWithMaxWater(dataPlants));
    }

    @Test
    public void testFindPlantWithMaxWaterOnEmptyList() {
        assertThrows(NoSuchElementException.class, () -> itwp.findPlantWithMaxWater(emptyDataPlants));
    }
}
