package edu;

import edu.deals.Deal;
import edu.deals.DealsAnalyzer;
import edu.deals.DealsParser;
import edu.deals.exceptions.DealParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DealsAnalyzerDemo {
    private static final Logger logger = LogManager.getLogger(DealsAnalyzerDemo.class);
    private static final Path DEALS_FILE_PATH = Path.of("src/main/resources/deals.txt");

    public static void main(String[] args) {
        logger.info("Начало демонстрации.");

        try {
            List<Deal> deals = DealsParser.parseFile(DEALS_FILE_PATH);
            DealsAnalyzer dealsAnalyzer = new DealsAnalyzer(deals);

            dealsAnalyzer.findMostEffectiveManagerOverPastMonth()
                    .ifPresentOrElse(
                            manager -> System.out.println("Самый эффективный менеджер за последний месяц - " + manager + "."),
                            () -> System.out.println(
                                    "Исходный файл не содержит информации о сделках, совершённых за последний месяц.")
                    );

            Map<String, Double> incomeOfEachBuyer = dealsAnalyzer.collectStatisticsOnIncomeFromEachBuyer();
            if (!incomeOfEachBuyer.isEmpty()) {
                System.out.println("Статистика по доходу от каждого клиента:");
                for (var entry : incomeOfEachBuyer.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            } else {
                System.out.println("Информация о сделках отсутствует.");
            }

            dealsAnalyzer.findMostProfitableMonthOverPastYear()
                    .ifPresentOrElse(
                            month -> System.out.println("Самый прибыльный месяц за последний год - " + month + "."),
                            () -> System.out.println(
                                    "В исходном файле отсутствует информация о сделках, совершённых за последний год.")
                    );

        } catch (IOException e) {
            logger.error("Ошибка чтения из файла \"" + e.getMessage() + "\".");
        } catch (DealParseException e) {
            logger.error(e.getMessage() + ". Причина: " + e.getCause());
        }

        logger.info("Конец демонстрации.");
    }
}
