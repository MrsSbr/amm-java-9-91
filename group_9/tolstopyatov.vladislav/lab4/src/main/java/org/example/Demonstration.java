package org.example;


/*
    Геймер Иннокентий ведет учет своих успехов, записывая в файл информацию в следующем виде:
    название игры;жанр;дата прохождения;время, потраченное на прохождение игры;оценка по 5ти бальной шкале
    Необходимо найти следующую информацию:
    - жанр, игры в котором получили самый высокий средний балл;
    - в какой месяц, Иннокентий потратил больше время времени на игры;
    - все игры, которые Иннокентий проходил больше 1 раза;
    В задаче должны использоваться элементы функционального программирования
    Задача должна быть представлена в виде maven-проекта
    Задача должна быть покрыта тестами с помощью JUnit
    Должно использоваться логгирование
*/

import GameResources.Game;
import GameResources.GameStatistics;
import Tools.FileReader;

import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

public class Demonstration {


    private static final Path path = Path.of("src/main/java/Resources/data.txt");
    private static final Logger logger = Logger.getLogger(Demonstration.class.getName());

    public static void main(String[] args) {
        logger.info("Начало демонстрации работы\n");

        FileReader fileReader = new FileReader();

        GameStatistics gameStatistics = new GameStatistics();

        try {
            List<Game> games = fileReader.readGamesFromFile(path);

            logger.info("Жанр, игры в котором получили самый высокий средний балл:" +
                    gameStatistics.genreWithTheHighestAverageEstimation(games).toString());

            logger.info("В какой месяц Иннокентий потратил больше время времени на игры: "
                    + gameStatistics.monthWithTheHighestInnocentisGameActivity(games).toString());

            logger.info("Все игры, которые Иннокентий проходил больше 1 раза: " +
                    gameStatistics.gamesGamingMoreThanOnce(games).toString());

        } catch (Exception ex) {
            logger.severe("Перехвачено исключение: " + ex.getMessage());
        }
        logger.info("Конец демонстрации работы\n");
    }
}