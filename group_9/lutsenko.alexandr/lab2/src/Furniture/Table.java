package Furniture;

public class Table extends AbstractFurniture { // Класс-наследник - стол
    public Table(String name, double price) {
        super(name, price);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a table: " + getName());
        commonAssemblySteps();
    }
}
