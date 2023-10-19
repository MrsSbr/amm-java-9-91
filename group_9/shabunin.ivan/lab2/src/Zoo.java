import animals.ZooAnimal;
import animals.Chameleon;
import animals.Eagle;
import animals.Iguana;
import animals.Panda;
import animals.Peacock;
import animals.Tiger;

public final class Zoo {
    private Zoo(){
    }

    public static void main(String[] args) {
        ZooDemo();
    }

    public static void ZooDemo() {
        ZooAnimal[] animals = getZooAnimals();

        System.out.println("Добро пожаловать в зоопарк!");

        System.out.println();
        animalsFeeding(animals);

        System.out.println();
        animalsMovements(animals);

        System.out.println();
        animalsFreeTime(animals);

        System.out.println();
        animalsSleep(animals);
    }

    private static ZooAnimal[] getZooAnimals() {
        Chameleon chameleon = new Chameleon("Gogi", 5, ZooAnimal.Sex.Male, 40);
        Eagle eagle = new Eagle("Napoleon", 15, ZooAnimal.Sex.Male, 220);
        Iguana iguana = new Iguana("Inessa", 5, ZooAnimal.Sex.Female, 120);
        Panda panda = new Panda("Luna", 12, ZooAnimal.Sex.Female, 150, 120);
        Peacock peacock = new Peacock("Athanasius", 2, ZooAnimal.Sex.Male, 160);
        Tiger tiger = new Tiger("Shere Chan", 10, ZooAnimal.Sex.Male, 150, 250);

        return new ZooAnimal[] {chameleon, eagle, iguana, panda, peacock, tiger};
    }

    private static void animalsFeeding(ZooAnimal[] animals) {
        System.out.println("Кормежка животных:");
        for (ZooAnimal animal : animals) {
            animal.eat();
        }
    }

    private static void animalsMovements(ZooAnimal[] animals) {
        System.out.println("Активность животных:");
        for (ZooAnimal animal : animals) {
            animal.move();
        }
    }

    private static void animalsFreeTime(ZooAnimal[] animals) {
        System.out.println("Свободное время:");
        for (ZooAnimal animal : animals) {
            if (animal instanceof Chameleon) {
                ((Chameleon) animal).changeColor();
            } else if (animal instanceof Eagle) {
                ((Eagle) animal).sitProudly();
            } else if (animal instanceof Iguana) {
                ((Iguana) animal).bask();
            } else if (animal instanceof Panda) {
                ((Panda) animal).rollOnTheGround();
            } else if (animal instanceof Peacock) {
                ((Peacock) animal).spreadTail();
            } else if (animal instanceof Tiger) {
                ((Tiger) animal).roar();
            }
        }
    }

    private static void animalsSleep(ZooAnimal[] animals) {
        System.out.println("Сон:");
        for (ZooAnimal animal : animals) {
            animal.sleep();
        }
    }
}