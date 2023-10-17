package media;
import java.util.Objects;
public class Movie extends MediaProduction implements Overview {
    private final String director;
    private final Genre genre;
    private final String description;
    public Movie(String title, int year, String director, int duration,
                 Genre genre, String description) {
        super(title, year, duration);
        this.director = director;
        this.genre = genre;
        this.description = description;
    }
    @Override
    public String play() {
        return "Currently playing movie: " + getTitle();
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
        Movie movie = (Movie) obj;
        return director.equals(movie.director) && genre.equals(movie.genre)
                && description.equals(movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), director, genre, description);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGenre: " + genre +
                "\nDirector: " + director +
                "\nDuration: " + getDuration() + " minutes" +
                "\nDescription: " + description;
    }
}
