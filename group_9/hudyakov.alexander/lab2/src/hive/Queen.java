package hive;

public class Queen extends Bee {
    private int eggsLaid;
    public Queen(int age, double size) {
        super(age, size);
        this.eggsLaid = 0;
    }
    public Queen(int age, double size, int eggsLaid) {
        super(age, size);
        this.eggsLaid = eggsLaid;
    }
    public int getEggsLaid() {
        return eggsLaid;
    }
    public void setEggsLaid(int eggsLaid) {
        this.eggsLaid = eggsLaid;
    }
    @Override
    public String getStatus() {
        return "Queen";
    }
    public void layEgg() {
        eggsLaid++;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Queen queen = (Queen) object;

        return eggsLaid == queen.eggsLaid;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + eggsLaid;
        return result;
    }
    @Override
    public String toString() {
        return "Queen{" +
                "eggsLaid=" + eggsLaid +
                "} " + super.toString();
    }
}
