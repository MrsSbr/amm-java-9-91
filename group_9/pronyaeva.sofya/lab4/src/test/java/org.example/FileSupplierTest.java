package org.example;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileSupplierTest {
    private static final Path PATH_TO_EXISTING_FILE = Path.of("lab4/src/test/resources/fights.test.txt");
    private static final Path PATH_TO_NONEXISTING_FILE = Path.of("lab4/src/test/resources/fights.non.test.txt");
    private static final Path PATH_TO_EMPTY_FILE = Path.of("lab4/src/test/resources/fights.test.empty.txt");

    private static final FileSupplier fileSupplier = new FileSupplier();

    @Test
    void readFightsListFromFile() {
        List<Fight> fights = List.of(
                new Fight(LocalDate.of(52, 1, 10), "Lorenzo",  Ludus.POMPEII, Animal.BEAR, true, false),
                new Fight(LocalDate.of(49, 7, 30), "Luca", null, Animal.LEOPARD, true, false)
        );
        List<Fight> actualList = fileSupplier.readFightsListFromFile(PATH_TO_EXISTING_FILE);
        assertEquals(fights, actualList);
    }

    @Test
    void readFightsListFromNonExistingFile() {
        assertThrows(RuntimeException.class, () -> fileSupplier.readFightsListFromFile(PATH_TO_NONEXISTING_FILE));
    }

    @Test
    void readFightsListEmptyFile() {
          assertEquals(0, fileSupplier.readFightsListFromFile(PATH_TO_EMPTY_FILE).size());
    }
}