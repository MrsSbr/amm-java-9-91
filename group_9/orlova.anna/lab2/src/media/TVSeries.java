package media;
import java.util.Objects;

public class TVSeries extends MediaProduction implements Overview {
    private String creator;
    private int numSeasons;
    private final Genre genre;
    private final String description;
    public TVSeries(String title, int year, int duration, String creator,
                    int numSeasons, Genre genre, String description) {
        super(title, year, duration * 6 * numSeasons);
        this.creator = creator;
        this.numSeasons = numSeasons;
        this.genre = genre;
        this.description = description;
    }
    @Override
    public String play() {
        return "Currently playing TV series: " + getTitle();
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        TVSeries series = (TVSeries) obj;
        return numSeasons == series.numSeasons && creator.equals(series.creator)
                && genre.equals(series.genre) && description.equals(series.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creator,
                numSeasons, genre, description);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGenre: " + genre +
                "\nCreator: " + creator +
                "\nSeasons: " + numSeasons +
                "\nDuration: " + getDuration() + " minutes" +
                "\nDescription: " + description;
    }
}
