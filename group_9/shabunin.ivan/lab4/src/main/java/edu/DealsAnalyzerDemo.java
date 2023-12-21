package edu;

import edu.deals.Deal;
import edu.deals.DealsAnalyzer;
import edu.deals.DealsParser;
import edu.deals.exceptions.DealParseException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DealsAnalyzerDemo {
    private static final Logger logger = LogManager.getLogger();
    private static final Path DEALS_FILE_PATH = Path.of("src/main/resources/deals.txt");

    public static void main(String[] args) {
        try {
            List<Deal> deals = DealsParser.parseFile(DEALS_FILE_PATH);
            DealsAnalyzer dealsAnalyzer = new DealsAnalyzer(deals);

            printMostEffectiveManagerOverPastMonth(dealsAnalyzer);

            logger.info("");
            printStatisticsOnIncomeFromEachBuyer(dealsAnalyzer);

            logger.info("");
            printMostProfitableMonthOverPastYear(dealsAnalyzer);

        } catch (IOException e) {
            logger.error("Ошибка чтения из файла " + DEALS_FILE_PATH + "!");
        } catch (DealParseException e) {
            logger.error(e.getMessage() + ". Причина: " + e.getCause());
        }
    }

    public static void printMostEffectiveManagerOverPastMonth(DealsAnalyzer analyzer) {
        analyzer.findMostEffectiveManagerOverPastMonth()
                .ifPresentOrElse(
                        manager -> logger.info("Самый эффективный менеджер за последний месяц - " + manager + "."),
                        () -> logger.info("Исходный файл не содержит информации о сделках, совершённых за последний месяц.")
                );
    }

    public static void printStatisticsOnIncomeFromEachBuyer(DealsAnalyzer analyzer) {
        Map<String, Double> incomeOfEachBuyer = analyzer.collectStatisticsOnIncomeFromEachBuyer();

        if (!incomeOfEachBuyer.isEmpty()) {
            logger.info("Статистика по доходу от каждого клиента:");
            for (var entry : incomeOfEachBuyer.entrySet()) {
                logger.info(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            logger.info("Информация о сделках отсутствует.");
        }
    }

    public static void printMostProfitableMonthOverPastYear(DealsAnalyzer analyzer) {
        analyzer.findMostProfitableMonthOverPastYear()
                .ifPresentOrElse(
                        month -> logger.info("Самый прибыльный месяц за последний год - " + month + "."),
                        () -> logger.info("В исходном файле отсутствует информация о сделках, совершённых за последний год.")
                );
    }
}
