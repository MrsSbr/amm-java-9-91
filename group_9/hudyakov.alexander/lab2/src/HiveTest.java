import hive.Hive;
import hive.Queen;
import hive.WorkerBee;
import hive.Drone;
import hive.ExtraQueenException;

public class HiveTest {
    public static void main(String[] args) {
        Hive hive = new Hive();

        hive.addBee(new Queen(6, 5.5));
        hive.addBee(new Drone(2, 2));
        hive.addBee(new WorkerBee(4, 4));

        hive.watchBees();

        String honeyMessage = String.format("Honey before work: %f", hive.getTotalHoney());
        System.out.println(honeyMessage);

        hive.work();
        honeyMessage = String.format("Honey after work: %f", hive.getTotalHoney());
        System.out.println(honeyMessage);

        try {
            hive.addBee(new Queen(4, 6));
        } catch (ExtraQueenException e) {
            System.out.println(e.getMessage());
        }

        hive.addBee(new WorkerBee(4, 3));
        hive.work();
        honeyMessage = String.format("Honey after work of two bees: %f", hive.getTotalHoney());
        System.out.println(honeyMessage);
    }
}