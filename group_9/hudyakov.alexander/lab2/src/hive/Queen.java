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

    @Override
    public String getWorkDescription() {
        return "Laying eggs";
    }

    @Override
    public String getStatus() {
        return "Queen";
    }

    @Override
    public void work() {
        eggsLaid += 1;
    }
}
