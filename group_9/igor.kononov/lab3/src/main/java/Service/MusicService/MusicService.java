package Service.MusicService;

import Service.MusicService.Composition.Composition;
import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class MusicService {

    private Collection<User> users;
    private Collection<Composition> allCompositions;

    // по заданной композиции определите, сколько раз ее прослушали за последний месяц
    // для каждого пользователя составить подборку прослушанных композиций
    // для каждого пользователя составить подборку с композициями, которые он не слушал последние 3 месяца
    // найти самый "любимый" трек для каждого пользователя

    public long countListensInLastMonth(Composition composition) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        return users.stream()
                .flatMap(user -> user.getListenedTracks().stream())
                .filter(track -> track.equals(composition) && track.getDate().isAfter(oneMonthAgo))
                .count();
    }


    public List<Set<Composition>> getUniquePlaylists() {
        return users.stream()
                .map(user -> new HashSet<>(user.getListenedTracks()))
                .collect(Collectors.toList());
    }


    public List<List<Composition>> getUnlistenedCompositionsInLastThreeMonths() {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);

        return users.stream()
                .map(user -> allCompositions.stream()
                        .filter(composition -> user.getListenedTracks().contains(composition) && composition.getDate().isBefore(threeMonthsAgo))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public List<Composition> getMostFavoriteTracks() {
        return users.stream()
                .map(user -> user.getListenedTracks().stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(null))
                .collect(Collectors.toList());
    }

}
