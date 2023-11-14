package Furniture;

public class Table extends AbstractFurniture { // Класс-наследник - стол
    private int numberOfLegs;
    public Table(String name, double price, int numberOfLegs) {
        super(name, price);
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a table: " + getName());
        commonAssemblySteps();
    }

    public void tableSpecificMethod() {
        System.out.println("This is a method specific to the Table class.");
    }
}
