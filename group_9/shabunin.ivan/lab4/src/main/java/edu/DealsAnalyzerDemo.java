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

            dealsAnalyzer.findMostEffectiveManagerOverPastMonth()
                    .ifPresentOrElse(
                            manager -> logger.info("Самый эффективный менеджер за последний месяц - " + manager + "."),
                            () -> logger.info("Исходный файл не содержит информации о сделках, совершённых за последний месяц.")
                    );

            Map<String, Double> incomeOfEachBuyer = dealsAnalyzer.collectStatisticsOnIncomeFromEachBuyer();
            if (!incomeOfEachBuyer.isEmpty()) {
                logger.info("Статистика по доходу от каждого клиента:");
                for (var entry : incomeOfEachBuyer.entrySet()) {
                    logger.info(entry.getKey() + " - " + entry.getValue());
                }
            } else {
                logger.info("Информация о сделках отсутствует.");
            }

            dealsAnalyzer.findMostProfitableMonthOverPastYear()
                    .ifPresentOrElse(
                            month -> logger.info("Самый прибыльный месяц за последний год - " + month + "."),
                            () -> logger.info("В исходном файле отсутствует информация о сделках, совершённых за последний год.")
                    );

        } catch (IOException e) {
            logger.error("Ошибка чтения из файла " + DEALS_FILE_PATH + "!");
        } catch (DealParseException e) {
            logger.error(e.getMessage() + ". Причина: " + e.getCause());
        }
    }
}
