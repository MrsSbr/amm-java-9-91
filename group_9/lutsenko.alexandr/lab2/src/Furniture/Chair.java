package Furniture;

public class Chair extends AbstractFurniture { // Класс-наследник - стул
    public Chair(String name, double price) {
        super(name, price);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a chair: " + getName());
        commonAssemblySteps();
    }
}
