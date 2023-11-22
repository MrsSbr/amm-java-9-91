package Service.MusicService;

import Service.MusicService.Composition.Composition;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MusicServiceTest {
    @Test
    void testCountListensInLastMonthTwo() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusDays(15)),
                new Composition("Song2", "Composer2", LocalDate.now().minusDays(35)),
                new Composition("Song3", "Composer3", LocalDate.now().minusDays(10))
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusDays(5)),
                new Composition("Song5", "Composer5", LocalDate.now().minusDays(25)),
                new Composition("Song6", "Composer6", LocalDate.now().minusDays(40))
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var targetComposition = new Composition("Song1", "Composer1");

        var listens = musicService.countListensInLastMonth(targetComposition);

        assertEquals(2, listens);
    }

    @Test
    void testCountListensInLastMonthZero() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusDays(15)),
                new Composition("Song2", "Composer2", LocalDate.now().minusDays(35)),
                new Composition("Song3", "Composer3", LocalDate.now().minusDays(10))
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusDays(5)),
                new Composition("Song5", "Composer5", LocalDate.now().minusDays(25)),
                new Composition("Song6", "Composer6", LocalDate.now().minusDays(40))
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var targetComposition = new Composition("Song7", "Composer7");

        var listens = musicService.countListensInLastMonth(targetComposition);

        assertEquals(0, listens);
    }


    @Test
    void testGetUniquePlaylistsUnique() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1"),
                new Composition("Song2", "Composer2"),
                new Composition("Song3", "Composer3")
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song4", "Composer4"),
                new Composition("Song5", "Composer5"),
                new Composition("Song6", "Composer6")
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var uniquePlaylists = musicService.getUniquePlaylists();

        assertEquals(2, uniquePlaylists.size());
        assertEquals(new HashSet<>(user1.getListenedTracks()), uniquePlaylists.get(0));
        assertEquals(new HashSet<>(user2.getListenedTracks()), uniquePlaylists.get(1));
    }

    @Test
    void testGetUniquePlaylistsNonUnique() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1"),
                new Composition("Song1", "Composer1"),
                new Composition("Song1", "Composer1")
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song2", "Composer2"),
                new Composition("Song2", "Composer2"),
                new Composition("Song2", "Composer2")
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var uniquePlaylists = musicService.getUniquePlaylists();

        var uniquePlaylistsUser1 = Set.of(new Composition("Song1", "Composer1"));
        var uniquePlaylistsUser2 = Set.of(new Composition("Song2", "Composer2"));

        assertEquals(2, uniquePlaylists.size());
        assertEquals(new HashSet<>(user1.getListenedTracks()), uniquePlaylistsUser1);
        assertEquals(new HashSet<>(user2.getListenedTracks()), uniquePlaylistsUser2);
    }


    @Test
    void testGetUnlistenedCompositionsInLastThreeMonths() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusMonths(4)),
                new Composition("Song2", "Composer2", LocalDate.now().minusMonths(4)),
                new Composition("Song3", "Composer3", LocalDate.now().minusMonths(1))
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song4", "Composer4", LocalDate.now().minusMonths(5)),
                new Composition("Song5", "Composer5", LocalDate.now().minusMonths(1)),
                new Composition("Song6", "Composer6", LocalDate.now().minusMonths(2))
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var unlistenedCompositions = musicService.getUnlistenedCompositionsInLastThreeMonths();


        assertEquals(2, unlistenedCompositions.size());

        assertTrue(unlistenedCompositions.get(0).contains(new Composition("Song1", "Composer1", LocalDate.now().minusMonths(4))));
        assertTrue(unlistenedCompositions.get(0).contains(new Composition("Song2", "Composer2", LocalDate.now().minusMonths(4))));

        assertTrue(unlistenedCompositions.get(1).contains(new Composition("Song4", "Composer4", LocalDate.now().minusMonths(5))));
    }

    @Test
    void testGetUnlistenedCompositionsInLastThreeMonthsEmpty() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1", LocalDate.now().minusMonths(3)),
                new Composition("Song2", "Composer2", LocalDate.now().minusMonths(2)),
                new Composition("Song3", "Composer3", LocalDate.now().minusMonths(1))
        ));
        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song4", "Composer4", LocalDate.now().minusMonths(1)),
                new Composition("Song5", "Composer5", LocalDate.now().minusMonths(1)),
                new Composition("Song6", "Composer6", LocalDate.now().minusMonths(2))
        ));

        var musicService = new MusicService(List.of(user1, user2));

        var unlistenedCompositions = musicService.getUnlistenedCompositionsInLastThreeMonths();


        assertEquals(2, unlistenedCompositions.size());

        assertTrue(unlistenedCompositions.get(0).isEmpty());
        assertTrue(unlistenedCompositions.get(1).isEmpty());
    }


    @Test
    void testGetMostFavoriteTracks() {

        var user1 = new User("John", "Doe", List.of(
                new Composition("Song1", "Composer1"),
                new Composition("Song2", "Composer2"),
                new Composition("Song3", "Composer3"),
                new Composition("Song1", "Composer1"),
                new Composition("Song1", "Composer1"),
                new Composition("Song2", "Composer2")
        ));

        var user2 = new User("Jane", "Doe", List.of(
                new Composition("Song4", "Composer4"),
                new Composition("Song5", "Composer5"),
                new Composition("Song6", "Composer6"),
                new Composition("Song4", "Composer4"),
                new Composition("Song5", "Composer5"),
                new Composition("Song6", "Composer6"),
                new Composition("Song6", "Composer6")
        ));
        var musicService = new MusicService(List.of(user1, user2));

        var mostFavoriteTracks = musicService.getMostFavoriteTracks();

        assertEquals(2, mostFavoriteTracks.size());
        assertTrue(mostFavoriteTracks.contains(new Composition("Song1", "Composer1")));
        assertTrue(mostFavoriteTracks.contains(new Composition("Song6", "Composer6")));
    }
}