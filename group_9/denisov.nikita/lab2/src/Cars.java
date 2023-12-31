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

        String information = null;

        for (Automobile it : automobiles) {
            if (it instanceof GasolineCar gasolineCar) {
                information = (gasolineCar.getEnginePower() <= 1.1) ? "Малолитражная модель" : "Многолитражная модель";
            } else if (it instanceof ElectricCar electricCar) {
                information = (electricCar.getMaximumSpeed() > 100) ? "Машина подходит для быстрой езды" : "Машина подходит для спокойной езды по городу";
            }
            System.out.println(information);
            it.start();
            it.stop();
            System.out.println();
        }
    }
}