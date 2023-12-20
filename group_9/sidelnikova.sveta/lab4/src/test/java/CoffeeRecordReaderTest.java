import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.ProcessingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CoffeeRecordReaderTest {

    private static final String RESOURCE_WITH_ERRORS = "coffee_supplies_with_errors.txt";

    private static final String EMPTY_RESOURCE = "empty.txt";

    private static final String CORRECT_RESOURCE = "coffee_supplies.txt";

    private static final CoffeeRecord expectedFirstRecord = new CoffeeRecord(CoffeeSort.ARABICA,
            "Бразилия", "Ферма №123", ProcessingType.WET, 1200);

    @Test
    public void readerShouldReadInformationContainsErrors() throws IOException {
        CoffeeRecordReader reader =
                new CoffeeRecordReader(ClassLoader.getSystemResourceAsStream(RESOURCE_WITH_ERRORS));
        List<CoffeeRecord> records = reader.read();
        Assertions.assertEquals(4, records.size());
    }

    @Test
    public void readerShouldReadEmptyInformation() throws IOException {
        CoffeeRecordReader reader =
                new CoffeeRecordReader(ClassLoader.getSystemResourceAsStream(EMPTY_RESOURCE));
        List<CoffeeRecord> records = reader.read();
        Assertions.assertEquals(0, records.size());
    }

    @Test
    public void readerShouldReadInformationCorrectly() throws IOException {
        CoffeeRecordReader reader =
                new CoffeeRecordReader(ClassLoader.getSystemResourceAsStream(CORRECT_RESOURCE));
        List<CoffeeRecord> records = reader.read();
        Assertions.assertEquals(31, records.size());

        Assertions.assertEquals(expectedFirstRecord, records.get(0));
    }
}
