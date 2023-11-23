public class AmmunitionTask {
    public static void task() {
        Consumables bullet1 = new Bullet("9mm", 300, 9);
        Consumables grenade1 = new Grenade("Fragmentation", 50, "Explosive");
        Consumables bullet2 = new Bullet("17mm", 200, 10);
        Consumables grenade2 = new Grenade("Fragmentation", 70, "Explosive");

        Consumables[] ammunitionArray = {bullet1, bullet2, grenade1, grenade2};

        for (var amm : ammunitionArray) {
            System.out.println(amm.getClass().getName());
            System.out.println(amm);
            System.out.println(amm.getName());
            System.out.println(amm.getQuantity());
            System.out.println(amm.getAddInfo());
            amm.use();
        }
    }

    public static void main(String[] args) {
        task();
    }
}