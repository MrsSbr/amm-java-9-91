package ru.nikitadenisov;

import ru.nikitadenisov.deals.Deal;
import ru.nikitadenisov.deals.DealAnalysis;
import ru.nikitadenisov.deals.DealReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    private static final Logger LOGGER = Logger.getLogger(Demo.class.getSimpleName());
    private static final Path PATH = Path.of("src", "main", "resources", "deals.txt");

    public static void main(String[] args) {
        try {
            List<Deal> deals = DealReader.read(PATH);
            DealAnalysis dealAnalysis = new DealAnalysis(deals);

            System.out.println("Самый эффективный менеджер за последний месяц: " + dealAnalysis.findMostEffectiveManagerOverPastMonth());

            Map<String, Double> incomeByClient = dealAnalysis.calculateIncomeByClient();
            System.out.println("Статистика по доходу от каждого клиента: ");

            incomeByClient.forEach((client, income) -> {
                System.out.println("Клиент: " + client + ", доход: " + income);
            });

            System.out.println("Самый прибыльный месяц за последний год:" + dealAnalysis.findMostProfitableMonthLastYear());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
