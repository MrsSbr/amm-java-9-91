import java.util.Objects;

class TVSeries extends MediaProduction implements Media {
    private String creator;
    private int numSeasons;
    public TVSeries(String title, int year, String creator, int numSeasons) {
        super(title, year);
        this.creator = creator;
        this.numSeasons = numSeasons;
    }
    @Override
    public String play() {
        return "Currently playing TV series: " + getTitle();
    }
    @Override
    public int getDuration() {
        return numSeasons * 6 * 20; // в каждом сезоне 6 серий по 20 минут
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCreator: " + creator +
                "\nSeasons: " + numSeasons +
                "\nDuration: " + getDuration() + " minutes";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        TVSeries series = (TVSeries) obj;
        return numSeasons == series.numSeasons &&
                creator.equals(series.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creator, numSeasons);
    }
}
