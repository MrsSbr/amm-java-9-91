package Service.MusicService;

import Service.MusicService.Composition.Composition;

import java.util.Date;

public class  CollectionPerformanceComparison {

    private static final String DELIMITER = "-".repeat(200);
    private static final int COUNT = 100;
    private final MusicService musicService;

    public CollectionPerformanceComparison(MusicService musicService) {
        this.musicService = musicService;
    }


    public void testMethodsPerformance() {

        long collectionCreationTime = System.currentTimeMillis();
        System.out.println("Collection created at: " + new Date(collectionCreationTime));

        System.out.println(DELIMITER);
        System.out.println(musicService.getUsers().getClass().getSimpleName());

        long countListensTime = measureTime(() -> {
            Composition composition = new Composition("Believer", "Imagine Dragons");
            musicService.countListensInLastMonth(composition);
        });

        long uniquePlaylistsTime = measureTime(musicService::getUniquePlaylists);

        long unlistenedCompositionsTime = measureTime(musicService::getUnlistenedCompositionsInLastThreeMonths);

        long mostFavoriteTracksTime = measureTime(musicService::getMostFavoriteTracks);

        System.out.println("Time taken for countListensInLastMonth: " + countListensTime + " ms");
        System.out.println("Time taken for getUniquePlaylists: " + uniquePlaylistsTime + " ms");
        System.out.println("Time taken for getUnlistenedCompositionsInLastThreeMonths: " + unlistenedCompositionsTime + " ms");
        System.out.println("Time taken for getMostFavoriteTracks: " + mostFavoriteTracksTime + " ms");

        System.out.println("Total time: " +
                (countListensTime + uniquePlaylistsTime + unlistenedCompositionsTime + mostFavoriteTracksTime) + " ms");
    }

    private long measureTime(Runnable task) {

        long workTime = 0;

        for (var i = 0; i < COUNT; i++) {

            long startTime = System.currentTimeMillis();
            task.run();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            workTime += elapsedTime;
        }

        return workTime;
    }
}

