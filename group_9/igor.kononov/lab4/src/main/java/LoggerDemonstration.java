import accounting.Accounting;
import common.FileProvider;
import exceptions.InvalidDataException;

import java.nio.file.Paths;
import java.util.logging.Logger;

public class LoggerDemonstration {
    private static final String FILE_NAME = "salary_records.json";
    private static final Logger logger = Logger.getLogger(FileProvider.class.getName());

    public static void main(String[] args) {
        logger.info("The beginning of the demonstration work");

        var accounting = new Accounting();
        logger.info("Created \"Accounting\"");
        var fileProvider = new FileProvider();
        logger.info("Created \"FileProvider\"");

        try {
            var path = Paths.get(LoggerDemonstration.class.getResource(FILE_NAME).toURI());
            logger.info("Created path to file");

            try {
                var records = fileProvider.readFile(path);
                accounting.setSalaryRecords(records);

            } catch (InvalidDataException ex) {
                logger.severe(ex.getMessage());
            }

            logger.info("Demonstration of how the methods work");

            accounting.groupTheRecordsByDepartments();

            var averageSalary = accounting.findDepartmentWithHighestAverageSalary();
            logger.info("Department with highest average salary is " + averageSalary);

            var totalSalary = accounting.findDepartmentWithHighestTotalPayout();
            logger.info("Department with highest highest total payout is " + totalSalary);

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
