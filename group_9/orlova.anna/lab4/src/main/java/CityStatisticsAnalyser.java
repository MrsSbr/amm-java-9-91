import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CityStatisticsAnalyser {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                    .getResource("answers.json")).toURI());
            List<CityStatisticsEntry> statistics = CityStatisticsEntryJsonReader.readJsonFile(path);

            System.out.println("Наиболее популярный ответ для городов, название которых начинается на 'А': " +
                    CityStatistics.mostPopularAnswerForCitiesStartingWithA(statistics));

            System.out.println("Город, в котором дали больше всего разнообразных ответов: " +
                    CityStatistics.cityWithMostDiverseAnswers(statistics));

            System.out.println("Города, где отвечали так же, как наиболее часто отвечали в Москве: " +
                    CityStatistics.citiesWithMatchingAnswersAsMoscow(statistics));
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
