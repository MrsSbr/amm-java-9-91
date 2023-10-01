import java.util.Objects;
class Movie extends MediaProduction implements Media {
    private String director;
    private final int duration;
    public Movie(String title, int year, String director, int duration) {
        super(title, year);
        this.director = director;
        this.duration = duration;
    }
    @Override
    public String play() {
        return "Currently playing movie: " + getTitle();
    }
    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDirector: " + director +
                "\nDuration: " + duration + " minutes";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Movie movie = (Movie) obj;
        return duration == movie.duration &&
                director.equals(movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), director, duration);
    }
}
