package Service.MusicService.Factory;

import Service.MusicService.Composition.Composition;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Data
public class RandomCompositionFactory {

    private static final long START_EPOCH = LocalDate.of(1970, 1, 1).toEpochDay();
    private static final long END_EPOCH = LocalDate.of(2023, 12, 31).toEpochDay();

    private static final List<GroupToComposition<String, String>> LIST_OF_NAMES;

    static {
        LIST_OF_NAMES = List.of(
                new GroupToComposition<>("Believer", "Imagine Dragons"),
                new GroupToComposition<>("Cruel Summer", "Taylor Swift"),
                new GroupToComposition<>("My Love Mine All Mine", "Lady Gaga"),
                new GroupToComposition<>("Strangers", "Kenya Grace"),
                new GroupToComposition<>("Hey Driver", "Peso Pluma, Gabito Ballesteros & Junior H"),
                new GroupToComposition<>("All You Had To Do Was Stay (Taylor's Version)", "Taylor Swift"),
                new GroupToComposition<>("We Don't Fight Anymore", "Carly Pearce Featuring Chris Stapleton"),
                new GroupToComposition<>("Vampire", "Olivia Rodrigo"),
                new GroupToComposition<>("Bad Idea Right?", "Olivia Rodrigo"),
                new GroupToComposition<>("Shape Of You", "Ed Sheeran"),
                new GroupToComposition<>("Circles", "Post Malone"),
                new GroupToComposition<>("Tossin' And Turnin'", "Lil Nas X Featuring Billy Ray Cyrus"),
                new GroupToComposition<>("Call Me", "Mario"),
                new GroupToComposition<>("Old Town Road", "Lil Nas X Featuring Billy Ray Cyrus"),
                new GroupToComposition<>("Let Me Love You", "Mario"),
                new GroupToComposition<>("Endless Love", "Diana Ross & Lionel Richie"),
                new GroupToComposition<>("Physical", "Olivia Newton-John"),
                new GroupToComposition<>("I Want You Back", "The Jackson 5"),
                new GroupToComposition<>("Billie Jean", "Michael Jackson"),
                new GroupToComposition<>("Don't Stop Believin'", "Journey"),
                new GroupToComposition<>("Brown Eyed Girl", "Van Morrison"),
                new GroupToComposition<>("I Will Always Love You", "Whitney Houston"),
                new GroupToComposition<>("Someone Like You", "Adele"),
                new GroupToComposition<>("Imagine", "John Lennon"),
                new GroupToComposition<>("Happy", "Pharrell Williams"),
                new GroupToComposition<>("Bad Guy", "Billie Eilish"),
                new GroupToComposition<>("Blinding Lights", "The Weeknd"),
                new GroupToComposition<>("Sweet Child O' Mine", "Guns N' Roses"),
                new GroupToComposition<>("Hotel California", "Eagles")
        );
    }

    public Composition getComposition() {

        Random random = new Random();
        var randomDay = START_EPOCH + random.nextInt((int)(END_EPOCH - START_EPOCH));

        LocalDate date = LocalDate.ofEpochDay(randomDay);

        var composition = LIST_OF_NAMES.get(random.nextInt(LIST_OF_NAMES.size()));

        return new Composition(
                composition.getCompositionName(),
                composition.getGroupName(),
                date);
    }
}
