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

    private static final List<Pair<String, String>> LIST_OF_NAMES;

    static {
        LIST_OF_NAMES = List.of(
                new Pair<>("Believer", "Imagine Dragons"),
                new Pair<>("Cruel Summer", "Taylor Swift"),
                new Pair<>("My Love Mine All Mine", "Lady Gaga"),
                new Pair<>("Strangers", "Kenya Grace"),
                new Pair<>("Hey Driver", "Peso Pluma, Gabito Ballesteros & Junior H"),
                new Pair<>("All You Had To Do Was Stay (Taylor's Version)", "Taylor Swift"),
                new Pair<>("We Don't Fight Anymore", "Carly Pearce Featuring Chris Stapleton"),
                new Pair<>("Vampire", "Olivia Rodrigo"),
                new Pair<>("Bad Idea Right?", "Olivia Rodrigo"),
                new Pair<>("Shape Of You", "Ed Sheeran"),
                new Pair<>("Circles", "Post Malone"),
                new Pair<>("Tossin' And Turnin'", "Lil Nas X Featuring Billy Ray Cyrus"),
                new Pair<>("Call Me", "Mario"),
                new Pair<>("Old Town Road", "Lil Nas X Featuring Billy Ray Cyrus"),
                new Pair<>("Let Me Love You", "Mario"),
                new Pair<>("Endless Love", "Diana Ross & Lionel Richie"),
                new Pair<>("Physical", "Olivia Newton-John"),
                new Pair<>("I Want You Back", "The Jackson 5"),
                new Pair<>("Billie Jean", "Michael Jackson"),
                new Pair<>("Don't Stop Believin'", "Journey"),
                new Pair<>("Brown Eyed Girl", "Van Morrison"),
                new Pair<>("I Will Always Love You", "Whitney Houston"),
                new Pair<>("Someone Like You", "Adele"),
                new Pair<>("Imagine", "John Lennon"),
                new Pair<>("Happy", "Pharrell Williams"),
                new Pair<>("Bad Guy", "Billie Eilish"),
                new Pair<>("Blinding Lights", "The Weeknd"),
                new Pair<>("Sweet Child O' Mine", "Guns N' Roses"),
                new Pair<>("Hotel California", "Eagles")
        );
    }

    public Composition getComposition() {

        Random random = new Random();
        var randomDay = START_EPOCH + random.nextInt((int)(END_EPOCH - START_EPOCH));

        LocalDate date = LocalDate.ofEpochDay(randomDay);

        var composition = LIST_OF_NAMES.get(random.nextInt(LIST_OF_NAMES.size()));

        return new Composition(
                composition.getCompositionName()
                , composition.getGroupName()
                , date);
    }
}
