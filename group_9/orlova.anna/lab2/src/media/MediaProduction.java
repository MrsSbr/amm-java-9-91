package media;
import java.util.Objects;
public abstract class MediaProduction {
    private final String title;
    private final int year;
    private final int duration;

    public MediaProduction(String title, int year, int duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public int getDuration() {
        return duration;
    }
    public abstract String play();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MediaProduction that = (MediaProduction) obj;
        return year == that.year && title.equals(that.title) && duration == that.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, duration);
    }
    @Override
    public String toString() {
        return "\"" + title + "\" (" + year + ")";
    }
}
