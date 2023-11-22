package Service.MusicService;

import Service.MusicService.Composition.Composition;

import java.util.Date;

public class  CollectionPerformanceComparison {

    private final String DELIMETER = "-".repeat(200);
    private final MusicService musicService;
    private final String name;

    public CollectionPerformanceComparison(MusicService musicService, String name) {
        this.musicService = musicService;
        this.name = name;
    }


    public void testMethodsPerformance() {

        long collectionCreationTime = System.currentTimeMillis();
        System.out.println("Collection created at: " + new Date(collectionCreationTime));

        System.out.println(DELIMETER);
        System.out.println(name);

        long countListensTime = measureTime(() -> {
            Composition composition = new Composition("Believer", "Imagine Dragons");
            long result = musicService.countListensInLastMonth(composition);
        });

        long uniquePlaylistsTime = measureTime(musicService::getUniquePlaylists);

        long unlistenedCompositionsTime = measureTime(musicService::getUnlistenedCompositionsInLastThreeMonths);

        long mostFavoriteTracksTime = measureTime(musicService::getMostFavoriteTracks);

        System.out.println("Total time: " +
                (countListensTime + uniquePlaylistsTime + unlistenedCompositionsTime + mostFavoriteTracksTime) + " ms");
    }

    private long measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " ms");
        return elapsedTime;
    }
}

