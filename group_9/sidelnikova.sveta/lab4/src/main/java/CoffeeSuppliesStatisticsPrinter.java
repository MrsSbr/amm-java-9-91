import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.ProcessingType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import statistics.CoffeeSuppliesStatistics;
import statistics.CoffeeSuppliesStatisticsImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoffeeSuppliesStatisticsPrinter {
    private static final Logger logger = LogManager.getLogger();

    private static final String RESOURCE = "coffee_supplies.txt";

    public static void main(String[] args) {
        CoffeeRecordReader reader = new CoffeeRecordReader(ClassLoader.getSystemResourceAsStream(RESOURCE));
        try {
            List<CoffeeRecord> records = reader.read();

            System.out.println("Сорта для каждого типа обработки:");
            CoffeeSuppliesStatistics statistics = new CoffeeSuppliesStatisticsImpl();
            Map<ProcessingType, Set<CoffeeSort>> sortsByProcessingType = statistics.findSortsByProcessingType(records);
            for (var entry : sortsByProcessingType.entrySet()) {
                System.out.println("Тип обработки: " + entry.getKey());
                System.out.println("Сорта, которые им обрабатываются: " + entry.getValue());
            }

            System.out.println("Страны, в которых кофе растет на высоте более 1500 м:");
            Set<String> countries = statistics.findCountriesWithMoreThanHeight(records, 1500);
            System.out.println(countries);

            System.out.println("Количество сортов для каждой фермы:");
            Map<String, Integer> sortsCountForFarms = statistics.findAllSortsCountForEachFarm(records);
            for (var entry : sortsCountForFarms.entrySet()) {
                System.out.println("Название фермы: " + entry.getKey());
                System.out.println("Количество выращиваемых сортов: " + entry.getValue());
            }

        } catch (IOException e) {
            logger.error("Ошибка чтения из " + RESOURCE);
        }

    }
}
