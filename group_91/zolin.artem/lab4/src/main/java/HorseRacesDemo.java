import exceptions.WrongResultFormatException;
import horsestats.StatisticsStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raceresults.RaceResultsParser;
import java.io.IOException;

public class HorseRacesDemo {

    public static final String EXAMPLE_STATS_PATH = "example-stats.txt";
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            var inputStream = ClassLoader.getSystemResourceAsStream(EXAMPLE_STATS_PATH);
            var resultsParser = new RaceResultsParser(inputStream);
            var results = resultsParser.parse();
            var statistics = new StatisticsStorage(results);

            logger.info("Статистика забегов:");
            for (var statEntry : statistics.getStats().entrySet()) {
                var name = statEntry.getKey();
                var stat = statEntry.getValue();
                logger.info(name
                        + " - Всего забегов: " + stat.numberOfRaces()
                        + " Средняя позиция: " + stat.averagePlace());
            }

            statistics.getMostCompetingHorse()
                    .ifPresentOrElse(
                            s -> logger.info("Самая активно участвующая в соревнованиях лошадь: " + s.horseName()),
                            () -> logger.info("Недостаточно информации для определения самой активной лошади")
                    );

            statistics.getMostPerformantHorse()
                    .ifPresentOrElse(
                            s -> logger.info("Самая успешная лошадь: " + s.horseName()),
                            () -> logger.info("Недостаточно информации для определения самой успешной лошади")
                    );

        } catch (WrongResultFormatException e) {
            logger.error("Ошибка, не удалось распарсить строку: \""
                    + e.getFailedLine()
                    + "\". Причина: \""
                    + e.getCause().getMessage()
                    + "\"");
        } catch (IOException e) {
            logger.error("Ошибка чтения из " + EXAMPLE_STATS_PATH);
        }
    }

}
