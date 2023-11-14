import Furniture.Furniture;
import Furniture.Chair;
import Furniture.Table;

public class FurnitureDemo {
    public static void main(String[] args) {
        Chair chair = new Chair("Wooden Chair", 50.0, "Wood", "Brown");
        Table table = new Table("Dining Table", 150.0, 4);

        System.out.println(chair);
        chair.assemble();
        chair.changeColor("Red");
        System.out.println("Chair Material: " + chair.getMaterial());
        System.out.println("Chair Color: " + chair.getColor());
        chair.chairSpecificMethod();
        System.out.println("\n\n");
        System.out.println(table);
        table.assemble();
        System.out.println("Number of Legs: " + table.getNumberOfLegs());
        table.setNumberOfLegs(3);
        System.out.println("Updated Number of Legs: " + table.getNumberOfLegs());
        table.tableSpecificMethod();

        // Проверка instanceOf
        if (chair instanceof Furniture) {
            System.out.println("\nChair is an instance of Furniture.");
        }

        if (table instanceof Furniture) {
            System.out.println("Table is an instance of Furniture.");
        }
    }
}