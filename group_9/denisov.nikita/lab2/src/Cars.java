import Automobile.Automobile;
import Automobile.ElectricCar;
import Automobile.GasolineCar;

public class Cars {
    public static void main(String[] args) {
        Automobile[] automobiles = new Automobile[]{
                new GasolineCar("Toyota", "Camry", 2.5),
                new ElectricCar("Tesla", "Model S", 155),
                new GasolineCar("Honda", "Civic", 1.5),
                new ElectricCar("Nissan", "Leaf", 90)
        };

        for (Automobile it : automobiles) {
            if (it instanceof GasolineCar gasolineCar) {
                if (gasolineCar.getEnginePower() <= 1.1) {
                    System.out.println("Малолитражная модель");
                } else {
                    System.out.println("Многолитражная модель");
                }
            } else if (it instanceof ElectricCar electricCar) {
                if (electricCar.getMaximumSpeed() > 100) {
                    System.out.println("Машина подходит для быстрой езды");
                } else {
                    System.out.println("Машина подходит для спокойной езды по городу");
                }
            }
            it.start();
            it.stop();
            System.out.println();
        }
    }
}