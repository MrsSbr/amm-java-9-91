public class Queen extends Bee {

    public Queen(int age, double size) {
        super(age, size);
    }

    @Override
    public String getWorkDescription() {
        return "Taking care of the larvae";
    }

    @Override
    public String getStatus() {
        return "Queen";
    }

}
