package ru.glebbulavin;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

public class DataParserTest extends TestCase {
    public void testNotFindFile() {
        String filePath = "";

        DataParser parser = new DataParser();
        try {
            parser.parseFile(filePath);
            fail();
        } catch (FileNotFoundException ignored) {
        } catch (Exception e) {
            fail();
        }
    }

    public void testEmptyFile() throws IOException {
        String filePath = "src/test/java/ru/glebbulavin/test_files/empty_file.txt";
        DataParser parser = new DataParser();
        Collection<SaleRecord> records = parser.parseFile(filePath);
        assertTrue(records.isEmpty());
    }

    public void testCompletedFile() throws IOException {
        String filePath = "src/test/java/ru/glebbulavin/test_files/completed_file.txt";
        DataParser parser = new DataParser();
        Collection<SaleRecord> records = parser.parseFile(filePath);
        assertEquals(1, records.size());
        SaleRecord record = records.stream().toList().get(0);
        assertEquals(record.getDate(), LocalDate.of(2024, 9, 25));
        assertEquals("Дилер 3", record.getDealershipName());
        assertEquals("Автомобиль B", record.getCarName());
        assertEquals("Расширенная", record.getConfiguration());
        assertEquals(record.getMarkup(), new BigDecimal(8500));
    }
}