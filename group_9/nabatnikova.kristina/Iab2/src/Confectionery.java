import bakery.Bun;
import bakery.Cupcake;
import bakery.Pastry;
import bakery.Pie;

public class Confectionery {
    public static void main(String[] args) {
        Pie pie = new Pie("Apple pie", 400, 199, "apple");
        Bun bun = new Bun("Almond croissant", 80, 59, "almond cream", "powdered sugar");
        Cupcake cupcake = new Cupcake("Chocolate cupcake", 65, 79, "chocolate glaze");
        Cupcake cupcake2 = new Cupcake("Chocolate cupcake", 65, 79, "chocolate glaze");
        Cupcake cupcake3 = new Cupcake("Orange cupcake", 65, 79, "powdered sugar");
        Pastry[] pastry = {pie, bun, cupcake};

        for (Pastry pas : pastry) {
            System.out.println(pas.toString());
        }

        System.out.println("cupcake = cupcake:");
        System.out.println(cupcake.equals(cupcake));
        System.out.println("cupcake = cupcake2:");
        System.out.println(cupcake.equals(cupcake2));
        System.out.println("cupcake = cupcake3:");
        System.out.println(cupcake.equals(cupcake3) + "\n");

        System.out.println("Client 1: Hello! I want a apple pie.");
        System.out.println("Seller: Hello!");
        pie.sale();
        System.out.println("Client 1: OK, thank you!\n");

        System.out.println("Client 2: Hello! What kind of filling is this bun?");
        System.out.println("Seller: Hello! The filling of the bun is " + bun.getFilling());
        System.out.println("Client 2: Great, I'll take.");
        System.out.println("Seller:");
        bun.sale();
        System.out.println("Client 2: Very sad.\n");

        System.out.println("Client 3: Hello! I want a pie.");
        System.out.println("Seller: Hello!");
        pie.sale();
        System.out.println("Client 3: OK, thank you!");
    }
}