package GameResources;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GameStatistics {

    private static final Logger logger = Logger.getLogger(GameStatistics.class.getName());


    // найти жанр, игры в котором получили самый высокий средний балл
    public Genre genreWithTheHighestAverageEstimation(List<Game> gamesList) {
        logger.info("Вызов метода genreWithTheHighestAverageEstimation");

        Map<Genre, Double> genreAverages1 = gamesList.stream()
                .collect(Collectors.groupingBy(Game::getGenre,
                        Collectors.averagingDouble(Game -> Game.getEstimation().getValue())));

        return genreAverages1.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        // ------------------------------------------------------------------

        /* 2 способ решения
        // создаем собственный коллектор
        Collector<Game,
                Map<Genre,List<Integer>>,
                Map<Genre, List<Integer>>> collector = new MyCollector();

        // получаем Map с ключом - жанр, со значением - список оценок игр в этом жанре
        Map<Genre,List<Integer>> map = gamesList.stream().collect(collector);

        // преобразуем map в map с ключом жанр и значением ср. арифм. оценка игр в этом жанре
        Map<Genre, Double> genreAverages = map.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().
                                stream().mapToInt(Integer::intValue).
                                average().orElse(0.0)
                ));

        // выбираем жанр(ключ) с наибольшим значением(наиб. ср. арифм. балл)

        return genreAverages.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

         */
    }

    // найти в какой месяц, Иннокентий потратил больше время времени на игры;
    public Month monthWithTheHighestInnocentisGameActivity(List<Game> gamesList) {
        logger.info("Вызов метода monthWithTheHighestInnocentisGameActivity");

        // сначала делаем Map, где ключом будет месяц, а значение - суммарное время,
        // проведенное Инокентием в данный месяц

        Map<Month, Integer> findGenre = (gamesList.stream().
                collect(Collectors.groupingBy(Game -> Game.getDateOfCompletion().getMonth(),
                        Collectors.summingInt(Game::getGameTimeInHours))));

        // вытаскиваем месяц по макс. ключу
        return findGenre.entrySet().
                stream().max(Map.Entry.comparingByValue()).
                get().getKey();
    }

    // найти все игры, которые Иннокентий проходил больше 1 раза;
    public List<String> gamesGamingMoreThanOnce(List<Game> gamesList) {
        logger.info("Вызов метода gamesGamingMoreThanOnce");

        // сначала делаем Map, где ключом будет игра,а значением - сколько раз
        // в нее играл Инокентий

        Map<String, Long> map = gamesList.stream().
                collect(Collectors.groupingBy(Game::getTitle, Collectors.counting()));

        // затем вытаскиваем, преобразуя в список, игры, которые встретились в map
        // больше 1 раза

        return map.entrySet().
                stream().
                filter(entry -> entry.getValue() > 1).
                map(Map.Entry::getKey).toList();
    }
}

