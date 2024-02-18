package ru.denismandrusenko;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BoardGameTask {
    private final Collection<BoardGame> games;
    public BoardGameTask(Collection<BoardGame> games) {
        this.games = games;
    }

    // Список настольных игр, которые относятся к самому продаваемому жанру
    public List<BoardGame> getBestSellingGamesByGenre() {
        // Создаем список уникальных жанров игр
        List<Genre> genres = games.stream()
                .map(BoardGame::getGenre)
                .distinct()
                .collect(Collectors.toList());

        // Переменные для хранения максимального количества продаж и самого продаваемого жанра
        int maxSalesCount = 0;
        Genre bestSellingGenre = null;

        // Проходим по каждому жанру и подсчитываем количество продаж для каждого жанра
        for (Genre genre : genres) {
            int salesCount = (int) games.stream()
                    .filter(game -> game.getGenre() == genre)
                    .count();

            // Если количество продаж больше текущего максимума, обновляем максимальное количество продаж и сохраняем жанр
            if (salesCount > maxSalesCount) {
                maxSalesCount = salesCount;
                bestSellingGenre = genre;
            }
        }

        // Если самый продаваемый жанр определен, фильтруем игры по этому жанру и возвращаем результат
        if (bestSellingGenre != null) {
            Genre finalBestSellingGenre = bestSellingGenre;
            return games.stream()
                    .filter(game -> game.getGenre() == finalBestSellingGenre)
                    .collect(Collectors.toList());
        } else {
            // Если самый продаваемый жанр не определен, возвращаем пустой список
            return Collections.emptyList();
        }
    }

    // Месяц с наибольшей выручкой
    public Month getMonthWithHighestRevenue() {
        Optional<Month> monthWithHighestRevenue = games.stream()
                .collect(Collectors.groupingBy(
                        game -> game.getDate().getMonth(),
                        Collectors.summingDouble(BoardGame::getPrice)
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey);

        if (monthWithHighestRevenue.isPresent()) {
            return monthWithHighestRevenue.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    // Название игры, которая была продана хотя бы один раз, но не продавалась последние 3 месяца
    public String getGameNameWithSalesButNotRecently() {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);

        Optional<String> gameName = games.stream()
                .filter(game -> game.getDate().isBefore(threeMonthsAgo))
                .filter(game -> game.getPrice() > 0) // Игра должна быть продана хотя бы один раз
                .map(BoardGame::getTitle)
                .findFirst();

        if (gameName.isPresent()) {
            return gameName.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
