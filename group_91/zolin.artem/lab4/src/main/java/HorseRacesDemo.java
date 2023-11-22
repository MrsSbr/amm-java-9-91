import exceptions.WrongResultFormatException;
import horsestats.StatisticsStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raceresults.RaceResultsParser;
import java.io.IOException;

public class HorseRacesDemo {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            var inputStream = ClassLoader.getSystemResourceAsStream("example-stats.txt");
            var resultsParser = new RaceResultsParser(inputStream);
            var results = resultsParser.parse();
            var statistics = new StatisticsStorage(results);
            LOGGER.info("Статистика забегов:");
            for (var statEntry : statistics.getStats().entrySet()) {
                var name = statEntry.getKey();
                var stat = statEntry.getValue();
                LOGGER.info(name
                        + " - Всего забегов: " + stat.numberOfRaces()
                        + " Средняя позиция: " + stat.averagePlace());
            }
            LOGGER.info("Самая активно участвующая в соревнованиях лошадь: "
                    + statistics.getMostCompetingHorse().horseName());
            LOGGER.info("Самая успешная лошадь: "
                    + statistics.getMostPerformantHorse().horseName());
        } catch (IOException | WrongResultFormatException e) {
            LOGGER.error("Ошибка во время выполнения программы", e);
        }
    }

}
