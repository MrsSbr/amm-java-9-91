public class HiveTest {
    public static void main(String[] args) {
        Hive hive = new Hive();
        hive.addBee(new Queen(6, 5.5));
        hive.addBee(new Drone(2, 2));
        hive.addBee(new WorkerBee(4, 4));
        hive.watchBees();
    }
}