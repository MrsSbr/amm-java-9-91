import Furniture.Furniture;
import Furniture.Chair;
import Furniture.Table;

public class FurnitureDemo {
    public static void main(String[] args) {
        Chair chair = new Chair("Wooden Chair", 50.0);
        Table table = new Table("Dining Table", 150.0);

        System.out.println(chair);
        chair.assemble();
        System.out.println(table);
        table.assemble();

        // Проверка instanceOf
        if (chair instanceof Furniture) {
            System.out.println("\nChair is an instance of Furniture.");
        }

        if (table instanceof Furniture) {
            System.out.println("Table is an instance of Furniture.");
        }
    }
}