import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Logger;
import parser.ParserImpl;
import reader.FileLineReaderImpl;
import service.SolverServiceImpl;

public class ServiceRunner {

    private static final String FILE_NAME = "data.txt";

    private static final Logger logger = Logger.getLogger(ServiceRunner.class.getName()); //jul здесь хватит с головой

    public static void main(String[] args) {
        logger.info(String.format("%s start", ServiceRunner.class.getName()));

        try {
            final var path = Paths.get(Objects.requireNonNull(ServiceRunner.class.getResource(FILE_NAME)).toURI());


            final FileLineReaderImpl fileLineReader = new FileLineReaderImpl();
            final ParserImpl parser = new ParserImpl();

            try {
                final var list = fileLineReader.readAllLines(path, parser);

                logger.info("Read data: " + list);

                final var solverService = new SolverServiceImpl();
                final var top3BestCountries = solverService.getTop3BestCountries(list);
                final var athletesBySport = solverService.getAthletesBySport(list);
                final var bestAthlete = solverService.getBestAthlete(list);

                logger.info("Топ 3 страны медального зачета: " + top3BestCountries);
                logger.info("Страны и списки медалистов: " + athletesBySport);
                bestAthlete.ifPresentOrElse(
                    result -> logger.info("Лучший спортсмен медального зачета: " + result),
                    () -> logger.warning("Лучший спортсмен медального зачета не найден: "));
            } catch (RuntimeException runtimeException) {
                logger.severe(runtimeException.getMessage());
            }
        } catch (Exception exception) {
            logger.severe(String.format("Ошибка при чтении ресурса %s", FILE_NAME));
        }
        logger.info(String.format("%s end", ServiceRunner.class.getName()));
    }
}
