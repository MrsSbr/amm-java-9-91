package media;
public class Advertisement extends MediaProduction {
    public Advertisement(String title, int year, int duration) {
        super(title, year, duration);
    }
    @Override
    public String play() {
        return "Currently playing advertisement: " + getTitle();
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuration: " + getDuration() + " minutes";
    }
}
