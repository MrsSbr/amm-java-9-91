import dinosaurs.*;

public class Demonstration {

    public static void main(String[] args) {
        Tyrannosaurus predator = new Tyrannosaurus("Рекс", 1, 0);
        HerbivorousDinosaur[] prey = {
                new Ankylosaurus("Макс", 3, 30),
                new Brachiosaurus("Дэвид", 2, 8),
                new Triceratops("Джон", 6, 3)
        };

        for (HerbivorousDinosaur dinosaur : prey) {
            dinosaur.graze();
        }

        predator.hunt((Dinosaur)prey[1]);

        if (prey[0].equals(prey[2])) {
            System.out.println(prey[0].toString() + " и " + prey[2].toString() + " равны.");
        } else {
            System.out.println(prey[0].toString() + " и " + prey[2].toString() + " не равны.");
        }

        System.out.println("Упал метеорит и все динозавры умерли :(");
    }
}