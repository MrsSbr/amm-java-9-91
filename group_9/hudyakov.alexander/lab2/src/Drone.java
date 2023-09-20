public class Drone extends Bee{

    public Drone(int age, double size) {
        super(age, size);
    }

    @Override
    public String getWorkDescription() {
       return "Sleeping";
    }

    @Override
    public String getStatus() {
        return "Drone";
    }
    
}
