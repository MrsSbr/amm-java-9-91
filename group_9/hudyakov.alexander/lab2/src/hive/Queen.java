package hive;

public class Queen extends Bee {

    private int eggsLaid;

    public void setEggsLaid(int eggsLaid) {
        this.eggsLaid = eggsLaid;
    }

    public int getEggsLaid() {
        return eggsLaid;
    }

    public Queen(int age, double size) {
        super(age, size);
        this.eggsLaid = 0;
    }

    public Queen(int age, double size, int eggsLaid) {
        super(age, size);
        this.eggsLaid = eggsLaid;
    }

    @Override
    public String toString() {
        return String.format("%s, eggsLaid = %d", super.toString(), eggsLaid);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Queen queen = (Queen) object;

        if (eggsLaid != queen.eggsLaid) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + eggsLaid;
        return result;
    }

    @Override
    public String getStatus() {
        return "Queen";
    }

    public void layEgg(){
        eggsLaid++;
    }
}
