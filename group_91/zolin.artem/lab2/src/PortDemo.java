import ships.*;

import java.util.Random;

public class PortDemo {

    private static final Random rng = new Random();

    private static WarShip generateWarShip(String name, int displacement) {
        var warShip = new WarShip(name, displacement);
        warShip.loadMissiles(rng.nextInt(1, 8));
        return warShip;
    }

    private static Ship generateCargoShip(String name, int displacement) {
        var cargoShip = new CargoShip(name, displacement);
        cargoShip.addCargo(rng.nextInt(1, 10000));
        return cargoShip;
    }

    private static Ship generateFerry(String name, int displacement) {
        var ferry = new Ferry(name, displacement);
        ferry.addPassengers(rng.nextInt(1, 200));
        return ferry;
    }

    private static void simulation(Ship[] ships, WarShip attacker, Tugboat tugboat) throws InterruptedException {
        int delay = 800;
        System.out.println("Начало симуляции");
        while (attacker.getMissilesCount() != 0) {
            for (var ship : ships) {
                Thread.sleep(delay);
                ship.sail();
            }
            var target = ships[rng.nextInt(0, ships.length)];
            Thread.sleep(delay);
            if (attacker.attack(target)) {
                Thread.sleep(delay);
                tugboat.tug(target);
            }
        }
        System.out.println("У " + attacker.getName() + " закончились ракеты. Завершение симуляции");
    }

    public static void main(String[] args) throws InterruptedException {
        var attacker = generateWarShip("Михаил Кутузов", 18640);
        var tugboat = new Tugboat("Богатырь", 400);
        Ship[] ships = {
                generateCargoShip("Ever Given", 265876),
                generateCargoShip("MSC Irina", 233328),
                generateFerry("Победа", 2000),
                generateFerry("Непотопляемый", 2500),
                generateWarShip("Айова", 58000),
                generateWarShip("Ямато", 63200)
        };
        simulation(ships, attacker, tugboat);
    }

}
