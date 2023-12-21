import entities.PreparedDrinkAccounting;
import entities.PreparedDrinkAccountingFactory;
import service.SolverService;
import service.SolverServiceImpl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceRunner {
    private static final Logger LOGGER = Logger.getLogger(SolverServiceImpl.class.getName());
    private static final JsonUtils UTILS = new JsonUtils();
    private static final int MAX_NUMBER_OF_ACCOUNTINGS = 10000;
    private static final String FILE_NAME = "accountings.json";

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Solving started");
        try {
            Path filePath = Paths.get(Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(FILE_NAME)
                    .toURI());

            PreparedDrinkAccountingFactory accountingFactory = new PreparedDrinkAccountingFactory();
            UTILS.createJsonFile(Stream.generate(accountingFactory::getPreparedDrinkAccounting)
                    .limit(MAX_NUMBER_OF_ACCOUNTINGS)
                    .collect(Collectors.toList()), filePath);
            LOGGER.log(Level.FINE, "File written successfully");

            List<PreparedDrinkAccounting> accountings = UTILS.readJsonFile(filePath);
            System.out.println();
            LOGGER.log(Level.FINE, "File read successfully");

            SolverService solverService = new SolverServiceImpl();
            System.out.println("Для каждого напитка среднее время приготовления:\n" +
                    solverService.getAvgTimeOfPrepForEachDrink(accountings) + "\n");
            System.out.println("Самый загруженный час по будням\n" +
                    solverService.getTheBusiestHourOnRoutineDays(accountings) + "\n");
            System.out.println("Напитки, которые чаще всего заказывают с 7 до 12 утра:\n" +
                    solverService.getMostOftenOrderedDrinksByCond(accountings) + "\n");
            System.out.println("Напиток с наилучшим соотношением цена/время:\n" +
                    solverService.getDrinkWithTheBestRatio(accountings) + "\n");

            LOGGER.log(Level.FINE, "Solved successfully");

        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "File " + FILE_NAME + " not found", e);
            System.out.println("File " + FILE_NAME + " not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        LOGGER.log(Level.INFO, "Solving ended");
    }
}
