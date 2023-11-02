package Laba2_rentCar;


import java.util.TreeMap;

public class RentCar {


    public static void main(String[] args) {
        Automobile[] automobiles = new Automobile[]{
                new Truck("Man", "TGX", "Yes", 20),
                new Car("Oka", "Odin", "No", 3),
                new Truck("MAZ", "NaKolenah", "Yes", 5),
                new Car("YAZ", "Byxanka", "No", 7)
        };

        for (Automobile it : automobiles) {
            it.classCar();
            System.out.println(it.toString());
            if (it instanceof Truck gasolineCar) {
                if (gasolineCar.getLoadCapacity() <= 7) {
                    System.out.println("Газель");
                } else {
                    System.out.println("Фура");
                }
            } else if (it instanceof Car electricCar) {
                if (electricCar.getCapacityPeople() <= 3) {
                    System.out.println("Машина подходит для семьи");
                } else {
                    System.out.println("Машина подходит не подходит для семьи");
                }
            }
            System.out.println();


        }
    }

}

