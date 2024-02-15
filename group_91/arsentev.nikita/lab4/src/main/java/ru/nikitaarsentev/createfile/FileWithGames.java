package ru.nikitaarsentev.createfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class FileWithGames {
    private static final int MAX_COUNT_GOALS = 2;
    private static final List<String> teams;

    static {
        teams = List.of(
                "Real Madrid", "Barcelona", "Manchester United", "Liverpool", "Bayern Munich",
                "Juventus", "Paris Saint-Germain", "Manchester City", "Chelsea", "Arsenal"
        );
    }

    public static void generateRandomGames(int countGame, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            Random random = new Random();
            for (int i = 0; i < countGame; i++) {
                String homeTeam = teams.get(random.nextInt(teams.size()));
                String awayTeam = teams.get(random.nextInt(teams.size()));
                while (awayTeam.equals(homeTeam)) {
                    awayTeam = teams.get(random.nextInt(teams.size()));
                }
                int homeScore = random.nextInt(MAX_COUNT_GOALS);
                int awayScore = random.nextInt(MAX_COUNT_GOALS);
                String game = homeTeam + ";" + awayTeam + ";" + homeScore + ":" + awayScore;
                System.out.println(game);
                writer.write(game + "\n");
            }
            System.out.println("Файл с результатами футбольных матчей успешно создан.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
