import java.util.Objects;
abstract class MediaProduction {
    private final String title;
    private final int year;
    public MediaProduction(String title, int year) {
        this.title = title;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public abstract int getDuration();

    @Override
    public String toString() {
        return "\"" + title + "\" (" + year + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MediaProduction that = (MediaProduction) obj;
        return year == that.year &&
                title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}
